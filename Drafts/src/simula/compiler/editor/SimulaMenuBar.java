package simula.compiler.editor;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.RTOption;
import simula.compiler.utilities.Util;

public class SimulaMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private final SimulaEditor simulaEditor;
    
	//FileMenu fileMenu;
    JMenu fileMenu=new JMenu("File");
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem saveAs = new JMenuItem("Save As...");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem closeAll = new JMenuItem("Close All");
    JMenuItem exit = new JMenuItem("Exit");
    
    //EditMenu editMenu;
    JMenu editMenu=new JMenu("Edit");
	private JCheckBox autoRefresh=new JCheckBox("AutoRefresh");
	JMenuItem refresh=new JMenuItem("Refresh");
	private JMenuItem cut=new JMenuItem(new DefaultEditorKit.CutAction());
	private JMenuItem copy=new JMenuItem(new DefaultEditorKit.CopyAction());
	private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
	private JMenuItem search=new JMenuItem("Search");
	private static JMenuItem undo=new JMenuItem("Undo");
	private static JMenuItem redo=new JMenuItem("Redo");
    
    //RunMenu runMenu;
    JMenu runMenu=new JMenu("Run");
    JMenuItem run = new JMenuItem("Run");
    JMenuItem debug = new JMenuItem("Debug");
    
    //SettingsMenu settings;
    JMenu settings=new JMenu("Settings");
    JMenuItem workSpaces = new JMenuItem("Remove WorkSpaces");
    JMenuItem compilerOption = new JMenuItem("Compiler Options");
    JMenuItem runtimeOption = new JMenuItem("Runtime Options");

    //HelpMenu helpMenu;
    JMenu helpMenu=new JMenu("Help");
    JMenuItem about = new JMenuItem("About Simula");
    JMenuItem more = new JMenuItem("More Info");
    
    JPopupMenu popupMenu;
    JMenuItem newFile2 = new JMenuItem("New");
    JMenuItem openFile2 = new JMenuItem("Open");
    JMenuItem saveFile2 = new JMenuItem("Save");
    JMenuItem saveAs2 = new JMenuItem("Save As...");
    JMenuItem close2 = new JMenuItem("Close");
    JMenuItem closeAll2 = new JMenuItem("Close All");
    JMenuItem exit2 = new JMenuItem("Exit");
	private JCheckBox autoRefresh2=new JCheckBox("AutoRefresh");
	private JMenuItem refresh2=new JMenuItem("Refresh");
	private JMenuItem cut2=new JMenuItem(new DefaultEditorKit.CutAction());
	private JMenuItem copy2=new JMenuItem(new DefaultEditorKit.CopyAction());
	private JMenuItem paste2=new JMenuItem(new DefaultEditorKit.PasteAction());
	private JMenuItem search2=new JMenuItem("Search");
	private static JMenuItem undo2=new JMenuItem("Undo");
	private static JMenuItem redo2=new JMenuItem("Redo");
    JMenuItem run2 = new JMenuItem("Run");
    JMenuItem debug2 = new JMenuItem("Debug");
    JMenuItem workSpaces2 = new JMenuItem("Remove WorkSpaces");
    JMenuItem compilerOption2 = new JMenuItem("Compiler Options");
    JMenuItem runtimeOption2 = new JMenuItem("Runtime Options");
    JMenuItem about2 = new JMenuItem("About Simula");
    JMenuItem more2 = new JMenuItem("More Info");

	
	public SimulaMenuBar(SimulaEditor simulaEditor) {
		this.simulaEditor=simulaEditor;
		//fileMenu=new FileMenu(simulaEditor);
		//editMenu=new EditMenu(simulaEditor);
		//runMenu=new RunMenu(simulaEditor);
		//settings=new SettingsMenu();
		//helpMenu=new HelpMenu();
		createFileMenu();
		createEditMenu();
		createRunMenu();
		createSettingsMenu();
		createHelpMenu();
		this.add(fileMenu);
		this.add(editMenu);
		this.add(runMenu);
		this.add(settings);
		this.add(helpMenu);
		
	    popupMenu=new JPopupMenu();
	    //fileMenu.addPopupMenuItems(popupMenu);
	    //editMenu.addPopupMenuItems(popupMenu);
	    //runMenu.addPopupMenuItems(popupMenu);
	    //settings.addPopupMenuItems(popupMenu);
	    //helpMenu.addPopupMenuItems(popupMenu);
	    addPopupMenuItems(popupMenu);
	}
	
	// ****************************************************************
	// *** FileMenu: Constructor
	// ****************************************************************
    public void createFileMenu() {
    	fileMenu.add(newFile); newFile.addActionListener(actionListener);
    	fileMenu.add(openFile); openFile.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(saveFile); saveFile.addActionListener(actionListener);
    	fileMenu.add(saveAs); saveAs.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(close); close.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(closeAll); closeAll.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(exit); exit.addActionListener(actionListener);
    }
	
	// ****************************************************************
	// *** EditMenu: Constructor
	// ****************************************************************
	public void createEditMenu() {
		editMenu.add(autoRefresh); autoRefresh.addActionListener(actionListener);
		editMenu.addSeparator();
		editMenu.add(undo); undo.setEnabled(false); undo.addActionListener(actionListener);
		editMenu.add(redo); redo.setEnabled(false); redo.addActionListener(actionListener);
		editMenu.addSeparator();
        cut.setText("Cut");     editMenu.add(cut);
        copy.setText("Copy");   editMenu.add(copy);
        paste.setText("Paste"); editMenu.add(paste);
        editMenu.addSeparator();
        editMenu.add(search); search.addActionListener(actionListener);
        editMenu.addSeparator();
        editMenu.add(refresh); refresh.addActionListener(actionListener);
	}

	// ****************************************************************
	// *** RunMenu: Constructor
	// ****************************************************************
	public void createRunMenu() {
		runMenu.add(run); run.addActionListener(actionListener);
		runMenu.add(debug); debug.addActionListener(actionListener); debug.setEnabled(false);
	}
	
	// ****************************************************************
	// *** SettingsMenu: Constructor
	// ****************************************************************
	public void createSettingsMenu() {
        settings.add(workSpaces); workSpaces.addActionListener(actionListener);
        settings.add(compilerOption); compilerOption.addActionListener(actionListener);
        settings.add(runtimeOption); runtimeOption.addActionListener(actionListener);
    }

	// ****************************************************************
	// *** HelpMenu: Constructor
	// ****************************************************************
	public void createHelpMenu() {
		helpMenu.add(about); about.addActionListener(actionListener);
		helpMenu.add(more); more.addActionListener(actionListener);
	}

	// ****************************************************************
	// *** HelpMenu: addPopupMenuItems
	// ****************************************************************
	public void addPopupMenuItems(JPopupMenu popupMenu) {
        popupMenu.add(newFile2); newFile2.addActionListener(actionListener);
		popupMenu.add(openFile2); openFile2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(saveFile2); saveFile2.addActionListener(actionListener);
        popupMenu.add(saveAs2); saveAs2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(close2); close2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(closeAll2); closeAll2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(exit2); exit2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(autoRefresh2); autoRefresh2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(undo2); undo2.setEnabled(false); undo2.addActionListener(actionListener);
        popupMenu.add(redo2); redo2.setEnabled(false); redo2.addActionListener(actionListener);
        popupMenu.addSeparator();
        cut2.setText("Cut");     popupMenu.add(cut2);
        copy2.setText("Copy");   popupMenu.add(copy2);
        paste2.setText("Paste"); popupMenu.add(paste2);
        popupMenu.addSeparator();
        popupMenu.add(search2); search2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(refresh2); refresh2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(run2); run2.addActionListener(actionListener);
        popupMenu.add(debug2); debug2.addActionListener(actionListener);
        debug2.setEnabled(false); 
        popupMenu.addSeparator();
        popupMenu.add(workSpaces2); workSpaces2.addActionListener(actionListener);
        popupMenu.add(compilerOption2); compilerOption2.addActionListener(actionListener);
        popupMenu.add(runtimeOption2); runtimeOption2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(about2); about2.addActionListener(actionListener);
        popupMenu.add(more2); more2.addActionListener(actionListener);
        //popupMenu.addSeparator();
	}
	
	// ****************************************************************
	// *** EditMenu: UpdateMenuItems
	// ****************************************************************
	public void updateMenuItems(SourceTextPanel sourceTextPanel) {
		Util.println("EditMenu.updateMenuItems: sourceTextPanel="+sourceTextPanel);
		autoRefresh.setSelected(sourceTextPanel.AUTO_REFRESH);
		autoRefresh2.setSelected(sourceTextPanel.AUTO_REFRESH);
		UndoManager undoManager = sourceTextPanel.getUndoManager();
		boolean canUndo=undoManager.canUndo();
		boolean canRedo=undoManager.canRedo();
		undo.setEnabled(canUndo); undo2.setEnabled(canUndo);
		redo.setEnabled(canRedo); redo2.setEnabled(canRedo);
	}	
	
	// ****************************************************************
	// *** HelpMenu: ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			SourceTextPanel current=simulaEditor.getCurrentTextPanel();
			//System.out.println("EditMenu.ActionListener: "+item);
			if(item==newFile || item==newFile2) simulaEditor.doNewTabbedPanel(null);
			else if(item==openFile || item==openFile2) doOpenFileAction();
			else if(item==saveFile || item==saveFile2) doSaveCurrentFile(false);
			else if(item==saveAs   || item==saveAs2) doSaveCurrentFile(true);
			else if(item==close    || item==close2) doCloseCurrentFileAction();
			else if(item==closeAll || item==closeAll2) doCloseAllAction();
			else if(item==exit     || item==exit2) doExitAction();
			else if(item==autoRefresh) current.AUTO_REFRESH=autoRefresh.isSelected();
			else if(item==autoRefresh2) current.AUTO_REFRESH=autoRefresh2.isSelected();
			else if(item==undo || item==undo2) {
				UndoManager undoManager = current.getUndoManager();
				undoManager.undo();	updateMenuItems(current);
			}
			else if(item==redo || item==redo2) {
				UndoManager undoManager = current.getUndoManager();
				undoManager.redo();	updateMenuItems(current);
			}
			else if(item==search || item==search2) new Search(simulaEditor.getCurrentTextPane());					
			else if(item==refresh || item==refresh2) current.doRefresh();
			else if(item==run   || item==run2) doRunAction();
			else if(item==debug || item==debug2) doRunAction();
			else if(item==workSpaces || item==workSpaces2) removeWorkspacesAction();
			else if(item==compilerOption || item==compilerOption) Option.selectCompilerOptions();
			else if(item==runtimeOption  || item==runtimeOption) RTOption.selectRuntimeOptions();			
			else if(item==about || item==about2) doAboutAction();
			else if(item==more || item==more2) doMoreAction();
		}
	};
	
    // ****************************************************************
    // *** doOpenFileAction
    // ****************************************************************
	public void doOpenFileAction() {
        JFileChooser fileChooser = new JFileChooser(Global.currentWorkspace);
        if (fileChooser.showOpenDialog(simulaEditor)==JFileChooser.APPROVE_OPTION) {
        	File file=fileChooser.getSelectedFile();
    		if(!file.exists()) { Util.popUpError("Can't open file\n"+file); return; }
    		if(file.getName().toLowerCase().endsWith(".jar")) simulaEditor.doRunJarFile(file);
    		else simulaEditor.doNewTabbedPanel(file);
        	Global.updateCurrentWorkspace(fileChooser.getCurrentDirectory().toString());
        }
	}
	
    // ****************************************************************
    // *** doSaveCurrentFile
    // ****************************************************************
	void doSaveCurrentFile(boolean saveAs) {
		SourceTextPanel current=simulaEditor.getCurrentTextPanel();
		if(saveAs || current.sourceFile==null) {
	        JFileChooser fileChooser = new JFileChooser(Global.currentWorkspace);
	        if (fileChooser.showSaveDialog(simulaEditor)!=JFileChooser.APPROVE_OPTION) return; // Do Nothing
	        File file=fileChooser.getSelectedFile();
	        Util.println("saveAs.APPROVED: "+fileChooser.getSelectedFile());
	        Global.updateCurrentWorkspace(fileChooser.getCurrentDirectory().toString());
	        if(file.exists() && overwriteDialog(file)!=JOptionPane.YES_OPTION) return; // Do Nothing
	        if(!file.getName().toLowerCase().endsWith(".sim")) {
	        	if(noSimTypeDialog(file)!=JOptionPane.OK_OPTION) return; // Do Nothing
	        }
	        current.sourceFile=file;
	        simulaEditor.setSelectedTabTitle(file.getName());
	        current.fileChanged=true;
		}
		//Util.println("SourceTextPanel.saveFile: sourceFile="+sourceFile+", fileChanged="+fileChanged);
    	if(current.fileChanged)	try {
    		Writer writer=new OutputStreamWriter(new FileOutputStream(current.sourceFile.getPath()),Global.CHARSET$);
    		BufferedWriter out = new BufferedWriter(writer);
    		String text=current.editTextPane.getText();
    		out.write(text); out.close();
    		current.fileChanged = false;
    	} catch (Exception e) { Util.error("Internal Error: "+e.getMessage()); }
    }
	
    // ****************************************************************
    // *** doCloseCurrentFileAction
    // ****************************************************************
	public void doCloseCurrentFileAction() {
			maybeSaveCurrentFile();
			simulaEditor.removeSelectedTab();
	}
	
    // ****************************************************************
    // *** doCloseAllAction
    // ****************************************************************
	void doCloseAllAction() {
		while(simulaEditor.tabbedPane.getSelectedIndex()>=0)
		    doCloseCurrentFileAction();
	}
	
    // ****************************************************************
    // *** doExitAction
    // ****************************************************************
	void doExitAction() {
		doCloseAllAction();
		System.exit(0);
	}

    // ****************************************************************
    // *** maybeSaveCurrentFile
    // ****************************************************************
	// Also used by RunMeny[Run]
	void maybeSaveCurrentFile() {
		SourceTextPanel current=simulaEditor.getCurrentTextPanel();
		if(current==null) return; if(!current.fileChanged) return;
		if(saveDialog(current.sourceFile)==JOptionPane.YES_OPTION) doSaveCurrentFile(false);
	}

	private int overwriteDialog(File file) {
 		String msg="The file: \n"+file+"\nAlready exists - Do you want to overwrite it ?";
 		return(Util.optionDialog(msg,"Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,"Yes","No"));
	}

	private int noSimTypeDialog(File file) {
        String msg="The file name\n"+file+"\nDoes not end with the recomended \".sim\"";
		return(Util.optionDialog(msg,"Warning",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,"Ok","Cancel"));
	}
	
	private int saveDialog(File file) {
		String msg=(file==null)?"The source text has unsaved changes.\nDo you want to save it in a file ?"
		                       :"The file: \n"+file+"\nHas changed - do you want to save it ?";
		return(Util.optionDialog(msg,"Question",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,"Yes","No"));
	}
	
	// ****************************************************************
	// *** doRunAction
	// ****************************************************************
	private void doRunAction() {
		maybeSaveCurrentFile();
       	File file=simulaEditor.getCurrentSourceFile();
		if(file==null) {
			file=new File(Global.getTempFileDir("simula/tmp/")+"unnamed.sim");
			file.getParentFile().mkdirs();
		}

		try {
			// Start compiler ....
		
			String text=null;
			SourceTextPanel current=simulaEditor.getCurrentTextPanel();
			if(current!=null) text=current.editTextPane.getText();
// 		     Util.println("SimulaEditor.doRun: text="+text);
			if(text==null || text.trim().length()==0) {
				Util.popUpError("No Source Text to Compile, Please Open a File");
				return;
			}
			StringReader reader=new StringReader(text);
			String name=(file!=null)?file.getPath():Global.tempJavaFileDir+"/unnamed.sim";
			new Thread(new Runnable() {
				public void run() {
					new SimulaCompiler(name,reader).doCompile();
				}}).start();
		} catch(Exception e) { Util.popUpError("Can't run: "+e);}
	}
    
	// ****************************************************************
	// *** removeWorkspacesAction
	// ****************************************************************
    private void removeWorkspacesAction() {
    	JPanel panel=new JPanel();
    	panel.setBackground(Color.white);
    	JLabel label=new JLabel("Check Workspaces to be removed:");
    	panel.add(label);
    	ArrayList<JCheckBox> list=new ArrayList<JCheckBox>();
    	for(String workspace:Global.workspaces) {
        	JCheckBox checkbox=new JCheckBox(workspace); 
        	checkbox.setBackground(Color.white);
        	list.add(checkbox); panel.add(checkbox);  
    	}
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int res=Util.optionDialog(panel,"Remove Workspaces (no changes to the file system)"
				,JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Update","Cancel");
		//Util.println("SettingsMenu.removeWorkspaces: res="+res);
		if(res==JOptionPane.OK_OPTION) {
			//Util.println("SettingsMenu.removeWorkspaces: OK res="+res);
			for(JCheckBox box:list) {
				//Util.println("SettingsMenu.removeWorkspaces: box="+box.isSelected()+", text="+box.getText());
				if(box.isSelected()) Global.workspaces.remove(box.getText());
			}
	    	Global.updateWorkspaceList();
		}
    }
	
	// ****************************************************************
	// *** doAboutAction
	// ****************************************************************
	private void doAboutAction() {
		JTextArea msg=new JTextArea(
			"   This is a new Simula System created by the\n\n"
	      + "   Open Source Project 'Portable Simula Revisited'.\n\n"

		  + "   The project was initiated as a response to the lecture\n"
		  + "   held by James Gosling at the 50th anniversary of Simula\n"
		  + "   in Oslo on 27th September, 2017.\n\n"

  	      + "   This Simula System is written in Java and compiles to\n"
  	      + "   Java code with one exception; the Goto Statement need\n"
  	      + "   to be corrected in the byte code.\n\n");
		Util.optionDialog(msg,"About Portable Simula",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,"Ok");
	}
	
	// ****************************************************************
	// *** doMoreAction
	// ****************************************************************
	private void doMoreAction() {
		if(Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try { desktop.browse(new URI("https://portablesimula.github.io/github.io/"));
			} catch (Exception ex) {}
		}
	}

	
}
