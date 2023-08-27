/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.editor;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.Util;

/**
 * The editor's menues.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/editor/EditorMenues.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
@SuppressWarnings("serial")
public class EditorMenues extends JMenuBar {
	
	/**
	 * Define a Menu item with toolTip.
	 * @param ident item identifier
	 * @param toolTipText the tooltip text
	 * @return the resulting MenuItem
	 */
	private JMenuItem defJMenuItem(String ident,String toolTipText) {
		JMenuItem item = new JMenuItem(ident);
		if(toolTipText!=null) item.setToolTipText(toolTipText);
		return(item);
	}
    
    /** Menu */ private JMenu fileMenu=new JMenu("File");
    /** Menu item */ private JMenuItem newFile = defJMenuItem("New","Will open a new Simula file for editing");
    /** Menu item */ private JMenuItem openFile = new JMenuItem("Open");
    /** Menu item */ private JMenuItem saveFile = new JMenuItem("Save");
    /** Menu item */ private JMenuItem saveAs = new JMenuItem("Save As...");
    /** Menu item */ private JMenuItem close = new JMenuItem("Close");
    /** Menu item */ private JMenuItem closeAll = new JMenuItem("Close All");
    /** Menu item */ private JMenuItem exit = new JMenuItem("Exit");
    
    /** Menu */ private JMenu editMenu=new JMenu("Edit");
    
    /**
     * Refresh item.
     */
	JMenuItem refresh=new JMenuItem("Refresh");
	/** Menu item */ private JMenuItem cut=new JMenuItem(new DefaultEditorKit.CutAction());
	/** Menu item */ private JMenuItem copy=new JMenuItem(new DefaultEditorKit.CopyAction());
	/** Menu item */ private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
	/** Menu item */ private JMenuItem undo=new JMenuItem("Undo");
	///** Menu item */ private JMenuItem redo=new JMenuItem("Redo");
    
    /** Menu */ private JMenu runMenu=new JMenu("Run");
    /** Menu item */ private JMenuItem run = new JMenuItem("Run");
    /** Menu item */ private JMenuItem debug = new JMenuItem("Debug");
    
    /** Menu */ private JMenu settings=new JMenu("Settings");
	/** CheckBox */ private JCheckBox autoRefresh=new JCheckBox("AutoRefresh");
    /** Menu item */ private JMenuItem setWorkSpace = new JMenuItem("Select WorkSpace");
    /** Menu item */ private JMenuItem setJavaDir = defJMenuItem("Select Java Dir.","Specify where to place generated .java files. \r\n"
    											+ "Default: Temp directory which is deleted upon exit");
    /** Menu item */ private JMenuItem setOutputDir = defJMenuItem("Select Output Dir.","Specify where to place generated .jar file. \r\n"
    											+ "Default: Current workspace/bin");
    /** Menu item */ private JMenuItem setExtLibDir = defJMenuItem("Select ExtLib Dir.","Specify where to search for precompiled classes and \r\n"
    																+ "procedures. If not found, output directory is also searched. ");
    /** Menu item */ private JMenuItem workSpaces = new JMenuItem("Remove WorkSpaces");
    /** Menu item */ private JMenuItem compilerOption = new JMenuItem("Compiler Options");
    /** Menu item */ private JMenuItem runtimeOption = new JMenuItem("Runtime Options");

    /** Menu */ private JMenu helpMenu=new JMenu("Help");
    /** Menu item */ private JMenuItem about = new JMenuItem("About Simula");
    /** Menu item */ private JMenuItem more = new JMenuItem("More Info");
    
    /**
     * The popup menu.
     */
    JPopupMenu popupMenu;
    /** Popup Menu item */ private JMenuItem newFile2 = new JMenuItem("New");
    /** Popup Menu item */ private JMenuItem openFile2 = new JMenuItem("Open");
    /** Popup Menu item */ private JMenuItem saveFile2 = new JMenuItem("Save");
    /** Popup Menu item */ private JMenuItem saveAs2 = new JMenuItem("Save As...");
    /** Popup Menu item */ private JMenuItem close2 = new JMenuItem("Close");
    /** Popup Menu item */ private JMenuItem closeAll2 = new JMenuItem("Close All");
    /** Popup Menu item */ private JMenuItem exit2 = new JMenuItem("Exit");
	/** Popup Menu item */ private JMenuItem refresh2=new JMenuItem("Refresh");
	/** Popup Menu item */ private JMenuItem cut2=new JMenuItem(new DefaultEditorKit.CutAction());
	/** Popup Menu item */ private JMenuItem copy2=new JMenuItem(new DefaultEditorKit.CopyAction());
	/** Popup Menu item */ private JMenuItem paste2=new JMenuItem(new DefaultEditorKit.PasteAction());
	/** Popup Menu item */ private JMenuItem undo2=new JMenuItem("Undo");
	///** Popup Menu item */ private JMenuItem redo2=new JMenuItem("Redo");
    /** Popup Menu item */ private JMenuItem run2 = new JMenuItem("Run");
    /** Popup Menu item */ private JMenuItem debug2 = new JMenuItem("Debug");
	/** Popup Menu item */ private JCheckBox autoRefresh2=new JCheckBox("AutoRefresh");
    /** Popup Menu item */ private JMenuItem setWorkSpace2 = new JMenuItem("Select WorkSpace");
    /** Popup Menu item */ private JMenuItem setJavaDir2 = new JMenuItem("Select Java Dir.");
    /** Popup Menu item */ private JMenuItem setOutputDir2 = new JMenuItem("Select Output Dir.");
    /** Popup Menu item */ private JMenuItem setExtLibDir2 = new JMenuItem("Select ExtLib Dir.");
    /** Popup Menu item */ private JMenuItem workSpaces2 = new JMenuItem("Remove WorkSpaces");
    /** Popup Menu item */ private JMenuItem compilerOption2 = new JMenuItem("Compiler Options");
    /** Popup Menu item */ private JMenuItem runtimeOption2 = new JMenuItem("Runtime Options");
    /** Popup Menu item */ private JMenuItem about2 = new JMenuItem("About Simula");
    /** Popup Menu item */ private JMenuItem more2 = new JMenuItem("More Info");

	
	// ****************************************************************
	// *** Constructor
	// ****************************************************************
    /**
     * Create a new instance of EditorMenues.
     */
	EditorMenues() {
    	fileMenu.add(newFile); newFile.addActionListener(actionListener);
    	fileMenu.add(openFile); openFile.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(saveFile); saveFile.setEnabled(false); saveFile.addActionListener(actionListener);
    	fileMenu.add(saveAs); saveAs.setEnabled(false); saveAs.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(close); close.setEnabled(false); close.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(closeAll); closeAll.setEnabled(false); closeAll.addActionListener(actionListener);
    	fileMenu.addSeparator();
    	fileMenu.add(exit); exit.addActionListener(actionListener);
		this.add(fileMenu);
		editMenu.add(undo); undo.setEnabled(false); undo.addActionListener(actionListener);
		//editMenu.add(redo); redo.setEnabled(false); redo.addActionListener(actionListener);
		editMenu.addSeparator();
		editMenu.add(cut); cut.setEnabled(false); cut.setText("Cut");     
		editMenu.add(copy); copy.setEnabled(false); copy.setText("Copy");   
		editMenu.add(paste); paste.setEnabled(false); paste.setText("Paste"); 
        editMenu.addSeparator();
        editMenu.add(refresh); refresh.setEnabled(false); refresh.addActionListener(actionListener);
		this.add(editMenu);
		runMenu.add(run); run.setEnabled(false); run.addActionListener(actionListener);
		runMenu.add(debug); debug.setEnabled(false); debug.addActionListener(actionListener);
		this.add(runMenu);
		settings.add(autoRefresh); autoRefresh.setEnabled(false); autoRefresh.addActionListener(actionListener);
        settings.add(setWorkSpace); setWorkSpace.addActionListener(actionListener);
        settings.add(setJavaDir); setJavaDir.addActionListener(actionListener);
        settings.add(setOutputDir); setOutputDir.addActionListener(actionListener);
        settings.add(setExtLibDir); setExtLibDir.addActionListener(actionListener);
        settings.add(workSpaces); workSpaces.addActionListener(actionListener);
        settings.add(compilerOption); compilerOption.addActionListener(actionListener);
        settings.add(runtimeOption); runtimeOption.addActionListener(actionListener);
		this.add(settings);
		helpMenu.add(about); about.addActionListener(actionListener);
		helpMenu.add(more); more.addActionListener(actionListener);
		this.add(helpMenu);
		
	    addPopupMenuItems();
	    setAccelerators();
	}

	// ****************************************************************
	// *** HelpMenu: setAccelerators
	// ****************************************************************
	/**
	 * HelpMenu: setAccelerators
	 */
	private void setAccelerators() {
		newFile.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
	    openFile.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		saveFile.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
	    close.setAccelerator(KeyStroke.getKeyStroke('W', InputEvent.CTRL_DOWN_MASK));
		//closeAll.setAccelerator(KeyStroke.getKeyStroke('W', (InputEvent.CTRL_DOWN_MASK)|InputEvent.SHIFT_DOWN_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK));
		refresh.setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_DOWN_MASK));
		undo.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
		//redo.setAccelerator(KeyStroke.getKeyStroke('Y', InputEvent.CTRL_DOWN_MASK));
	    run.setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK));
	    about.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK));
		newFile2.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
	    openFile2.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
		saveFile2.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
	    close2.setAccelerator(KeyStroke.getKeyStroke('W', InputEvent.CTRL_DOWN_MASK));
		//closeAll2.setAccelerator(KeyStroke.getKeyStroke('W', (InputEvent.CTRL_DOWN_MASK)|InputEvent.SHIFT_DOWN_MASK));
		cut2.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
		copy2.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
		paste2.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK));
		refresh2.setAccelerator(KeyStroke.getKeyStroke('R', InputEvent.CTRL_DOWN_MASK));
		undo2.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
		//redo2.setAccelerator(KeyStroke.getKeyStroke('Y', InputEvent.CTRL_DOWN_MASK));
	    run2.setAccelerator(KeyStroke.getKeyStroke('B', InputEvent.CTRL_DOWN_MASK));
	    about2.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK));
	}
	
	// ****************************************************************
	// *** HelpMenu: addPopupMenuItems
	// ****************************************************************
	/**
	 * Add popup menu items,
	 */
	private void addPopupMenuItems() {
	    popupMenu=new JPopupMenu();
        popupMenu.add(newFile2); newFile2.addActionListener(actionListener);
		popupMenu.add(openFile2); openFile2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(run2); run2.setEnabled(false); run2.addActionListener(actionListener);
        popupMenu.add(debug2); debug2.setEnabled(false); debug2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(saveFile2); saveFile2.setEnabled(false); saveFile2.addActionListener(actionListener);
        popupMenu.add(saveAs2); saveAs2.setEnabled(false); saveAs2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(close2); close2.setEnabled(false); close2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(closeAll2); closeAll2.setEnabled(false); closeAll2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(exit2); exit2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(undo2); undo2.setEnabled(false); undo2.addActionListener(actionListener);
        //popupMenu.add(redo2); redo2.setEnabled(false); redo2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(cut2); cut2.setEnabled(false); cut2.setText("Cut");
        popupMenu.add(copy2); copy2.setEnabled(false); copy2.setText("Copy");
        popupMenu.add(paste2); paste2.setEnabled(false); paste2.setText("Paste");
        popupMenu.addSeparator();
        popupMenu.add(refresh2); refresh2.setEnabled(false); refresh2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(autoRefresh2); autoRefresh2.setEnabled(false); autoRefresh2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(setWorkSpace2); setWorkSpace2.addActionListener(actionListener);
        popupMenu.add(setJavaDir2); setJavaDir2.addActionListener(actionListener);
        popupMenu.add(setOutputDir2); setOutputDir2.addActionListener(actionListener);
        popupMenu.add(setExtLibDir2); setExtLibDir2.addActionListener(actionListener);
        popupMenu.add(workSpaces2); workSpaces2.addActionListener(actionListener);
        popupMenu.add(compilerOption2); compilerOption2.addActionListener(actionListener);
        popupMenu.add(runtimeOption2); runtimeOption2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(about2); about2.addActionListener(actionListener);
        popupMenu.add(more2); more2.addActionListener(actionListener);
	}
	
	// ****************************************************************
	// *** EditMenu: UpdateMenuItems
	// ****************************************************************
	/**
	 * Update menu items.
	 */
	void updateMenuItems() {
		SourceTextPanel current=SimulaEditor.current;
		boolean source=false;
		boolean text=false;
		boolean mayRun=false;
		boolean fileChanged=false;
		boolean auto=false;
		boolean canUndo=false;
//		boolean canRedo=false;
		if(current!=null) {
			source=true;
			String editText=current.editTextPane.getText();
			if(editText!=null && editText.trim().length()!=0) text=true; 
			if(current.lang==SimulaEditor.Language.Simula && text) mayRun=true;
			if(current.lang==SimulaEditor.Language.Simula && editText!=null && editText.trim().length()!=0) text=true; 
			fileChanged=current.fileChanged;
			auto=source && current.AUTO_REFRESH;
			UndoManager undoManager = current.getUndoManager();
			canUndo=undoManager.canUndo();
//			canRedo=undoManager.canRedo();
		}
		//Util.println("EditMenu.updateMenuItems: src="+source+", chg="+fileChanged+", text="+text+", lang="+current.lang);
		saveFile.setEnabled(fileChanged); saveFile2.setEnabled(fileChanged);
		saveAs.setEnabled(mayRun);        saveAs2.setEnabled(mayRun);
		close.setEnabled(source);         close2.setEnabled(source);
		closeAll.setEnabled(source);      closeAll2.setEnabled(source);
		cut.setEnabled(text);             cut2.setEnabled(text);
		copy.setEnabled(text);            copy2.setEnabled(text); 
		paste.setEnabled(source);         paste2.setEnabled(source);
//		search.setEnabled(text);          search2.setEnabled(text);
		refresh.setEnabled(text);         refresh2.setEnabled(text);
		run.setEnabled(mayRun);           run2.setEnabled(mayRun);
		debug.setEnabled(mayRun);         debug2.setEnabled(mayRun);
		autoRefresh.setSelected(auto);    autoRefresh2.setSelected(auto);
		autoRefresh.setEnabled(source);   autoRefresh2.setEnabled(source);
		undo.setEnabled(canUndo);         undo2.setEnabled(canUndo);
//		redo.setEnabled(canRedo);         redo2.setEnabled(canRedo);
		SimulaEditor.autoRefresher.reset();
	}	
	
	// ****************************************************************
	// *** HelpMenu: ActionListener
	// ****************************************************************
	/**
	 * the ActionListener
	 */
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			SourceTextPanel current=SimulaEditor.current;
			if(item==newFile || item==newFile2) SimulaEditor.doNewTabbedPanel(null,SimulaEditor.Language.Simula);
			else if(item==openFile || item==openFile2) doOpenFileAction();
			else if(item==saveFile || item==saveFile2) doSaveCurrentFile(false);
			else if(item==saveAs   || item==saveAs2) doSaveCurrentFile(true);
			else if(item==close    || item==close2) doCloseCurrentFileAction();
			else if(item==closeAll || item==closeAll2) doCloseAllAction();
			else if(item==exit     || item==exit2) doExitAction();
			else if(item==undo || item==undo2) undoAction();
//			else if(item==redo || item==redo2) redoAction();
			else if(item==refresh || item==refresh2) current.doRefresh();
			else if(item==run   || item==run2) doRunAction();
			else if(item==debug || item==debug2) doDebugAction();
			else if(item==autoRefresh) current.AUTO_REFRESH=autoRefresh.isSelected();
			else if(item==autoRefresh2) current.AUTO_REFRESH=autoRefresh2.isSelected();
			else if(item==setWorkSpace || item==setWorkSpace2) selectWorkspaceAction();
			else if(item==setJavaDir || item==setJavaDir2) selectJavaDirAction();
			else if(item==setOutputDir || item==setOutputDir2) selectOutputDirAction();
			else if(item==setExtLibDir || item==setExtLibDir2) selectExtLibDirAction();
			else if(item==workSpaces || item==workSpaces2) removeWorkspacesAction();
			else if(item==compilerOption || item==compilerOption2) Option.selectCompilerOptions();
			else if(item==runtimeOption  || item==runtimeOption2) RTOption.selectRuntimeOptions();			
			else if(item==about || item==about2) doAboutAction();
			else if(item==more || item==more2) doMoreAction();
		}
	};
	
    // ****************************************************************
    // *** doOpenFileAction
    // ****************************************************************
	/**
	 * Open file acation
	 */
	private void doOpenFileAction() {
        JFileChooser fileChooser = new JFileChooser(Global.currentWorkspace);
        if (fileChooser.showOpenDialog(SimulaEditor.tabbedPane)==JFileChooser.APPROVE_OPTION) {
        	File file=fileChooser.getSelectedFile();
    		if(!file.exists()) { Util.popUpError("Can't open file\n"+file); return; }
    		String lowName=file.getName().toLowerCase();
    		if(lowName.endsWith(".sim")) {
    			SimulaEditor.doNewTabbedPanel(file,SimulaEditor.Language.Simula);
            	Global.setCurrentWorkspace(fileChooser.getCurrentDirectory());
    		}
    		else if(lowName.endsWith(".jar")) SimulaEditor.doNewTabbedPanel(file,SimulaEditor.Language.Jar);
    		else if(isTextFile(lowName)) SimulaEditor.doNewTabbedPanel(file,SimulaEditor.Language.Text);
    		else SimulaEditor.doNewTabbedPanel(file,SimulaEditor.Language.Other);
    		
        }
	}
	
	/**
	 * Test if a file is a text file
	 * @param lowName the ident after .
	 * @return true if it is a text file
	 */
	private boolean isTextFile(String lowName) {
		String[] kind= {".java", ".txt", ".bat", ".sh", ".md", ".html", ".xml" }; // TODO: More ?
		for(String k:kind) if(lowName.endsWith(k)) return(true);
		return(false);
	}
	
    // ****************************************************************
    // *** doSaveCurrentFile
    // ****************************************************************
	/**
	 * Do save current source file.
	 * @param saveAs true if a file chooser is wanted
	 */
	void doSaveCurrentFile(boolean saveAs) {
		SourceTextPanel current=SimulaEditor.current;
		if(saveAs || current.sourceFile==null) {
	        JFileChooser fileChooser = new JFileChooser(Global.currentWorkspace);
	        if (fileChooser.showSaveDialog(SimulaEditor.tabbedPane)!=JFileChooser.APPROVE_OPTION) return; // Do Nothing
	        File file=fileChooser.getSelectedFile();
	        Global.setCurrentWorkspace(fileChooser.getCurrentDirectory());
	        if(file.exists() && overwriteDialog(file)!=JOptionPane.YES_OPTION) return; // Do Nothing
	        if(!file.getName().toLowerCase().endsWith(".sim")) {
	        	if(noSimTypeDialog(file)!=JOptionPane.OK_OPTION) return; // Do Nothing
	        }
	        current.sourceFile=file;
	        SimulaEditor.setSelectedTabTitle(file.getName());
	        current.fileChanged=true;
		}
    	if(current.fileChanged)	try {
    		Writer writer=new OutputStreamWriter(new FileOutputStream(current.sourceFile.getPath()),Global._CHARSET);
    		BufferedWriter out = new BufferedWriter(writer);
    		String text=current.editTextPane.getText();
    		out.write(text); out.close();
    		current.fileChanged = false;
    	} catch (Exception e) { Util.error("Internal Error: "+e.getMessage()); }
    }
	
    // ****************************************************************
    // *** doCloseCurrentFileAction
    // ****************************************************************
	/**
	 * Close current file acation.
	 */
	private void doCloseCurrentFileAction() {
			maybeSaveCurrentFile();
			SimulaEditor.removeSelectedTab();
	}
	
    // ****************************************************************
    // *** doCloseAllAction
    // ****************************************************************
	/**
	 * Close action.
	 */
	void doCloseAllAction() {
		while(SimulaEditor.tabbedPane.getSelectedIndex()>=0)
		    doCloseCurrentFileAction();
	}
	
    // ****************************************************************
    // *** doExitAction
    // ****************************************************************
	/**
	 * Exit action.
	 */
	void doExitAction() {
		doCloseAllAction();
		System.exit(0);
	}

    // ****************************************************************
    // *** maybeSaveCurrentFile
    // ****************************************************************
	/**
	 * Maybe save current source file.
	 * <p>
	 * Also used by RunMeny[Run]
	 */
	void maybeSaveCurrentFile() {
		SourceTextPanel current=SimulaEditor.current;
		if(current==null) return; if(!current.fileChanged) return;
		if(saveDialog(current.sourceFile)==JOptionPane.YES_OPTION) doSaveCurrentFile(false);
	}

	/**
	 * Popup a warning: The file: 'name' Already exists - Do you want to overwrite it ?
	 * @param file the file
	 * @return an integer indicating the option chosen by the user, or CLOSED_OPTION if the user closed the dialog
	 */
	private int overwriteDialog(File file) {
 		String msg="The file: \n"+file+"\nAlready exists - Do you want to overwrite it ?";
 		return(Util.optionDialog(msg,"Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,"Yes","No"));
	}

	/**
	 * Popup a warning: The file 'name' Does not end with the recomended .sim
	 * @param file the file
	 * @return an integer indicating the option chosen by the user, or CLOSED_OPTION if the user closed the dialog
	 */
	private int noSimTypeDialog(File file) {
        String msg="The file name\n"+file+"\nDoes not end with the recomended \".sim\"";
		return(Util.optionDialog(msg,"Warning",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,"Ok","Cancel"));
	}
	
	/**
	 * Save file dialog
	 * @param file the file
	 * @return an integer indicating the option chosen by the user, or CLOSED_OPTION if the user closed the dialog
	 */
	private int saveDialog(File file) {
		String msg=(file==null)?"The source text has unsaved changes.\nDo you want to save it in a file ?"
		                       :"The file: \n"+file+"\nHas changed - do you want to save it ?";
		return(Util.optionDialog(msg,"Question",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,"Yes","No"));
	}
	
	// ****************************************************************
	// *** undoAction
	// ****************************************************************
	/**
	 * The undo action
	 */
	private void undoAction() {
		SourceTextPanel current=SimulaEditor.current;
		current.getUndoManager().undo();
		current.fileChanged=true; current.refreshNeeded=true;
		updateMenuItems();
	}
	
//	// ****************************************************************
//	// *** redoAction
//	// ****************************************************************
//	private void redoAction() {
//		SourceTextPanel current=SimulaEditor.current;
//		current.getUndoManager().redo();
//		current.fileChanged=true; current.refreshNeeded=true;
//		updateMenuItems();
//	}
	
	// ****************************************************************
	// *** doRunAction
	// ****************************************************************
	/**
	 * The run action
	 */
	private void doRunAction() {
		Option.DEBUGGING=false;
//		RTOption.DEBUGGING=false;
		doStartRunning();
	}
	
	// ****************************************************************
	// *** doDebugAction
	// ****************************************************************
	/**
	 * The debug action
	 */
	private void doDebugAction() {
		Option.DEBUGGING=true;
//		RTOption.DEBUGGING=true;
		RTOption.VERBOSE=true;
		RTOption.selectRuntimeOptions();
		doStartRunning();
	}
	
	// ****************************************************************
	// *** doStartRunning
	// ****************************************************************
	/**
	 * Utility: Start running current Simula program.
	 */
	private void doStartRunning() {
		maybeSaveCurrentFile();
       	File file=SimulaEditor.current.sourceFile;
		if(file==null) {
			file=new File(Global.getTempFileDir("simula/tmp/"),"unnamed.sim");
			file.getParentFile().mkdirs();
		} else if(file.getName().toLowerCase().endsWith(".jar")) {
			SimulaEditor.doRunJarFile(file);
			return;
		}
		try {
			// Start compiler ....
			Util.ASSERT(SimulaEditor.current!=null,"EditorMenues.doRunAction: Invariant-1");
			String text=SimulaEditor.current.editTextPane.getText();
			StringReader reader=new StringReader(text);
			String name=(file!=null)?file.getPath():Global.tempJavaFileDir+"/unnamed.sim";
			if(file!=null) Option.RUNTIME_USER_DIR=Global.currentWorkspace.toString();
			new Thread(new Runnable() {
				public void run() {
					try { new SimulaCompiler(name,reader).doCompile(); }
					catch (IOException e) { Util.IERR("Compiler Error: ", e); }

				}}).start();
		} catch(Exception e) { Util.popUpError("Can't run: "+e);}
	}
    
	// ****************************************************************
	// *** selectWorkspaceAction
	// ****************************************************************
	/**
	 * Select Workspace action.
	 */
    private void selectWorkspaceAction() {
    	SimulaEditor.doSelectWorkspace();
    }	
    
	// ****************************************************************
	// *** selectJavaDirAction
	// ****************************************************************
	/**
	 * Select Java directory action.
	 */
    private void selectJavaDirAction() {
    	SimulaEditor.doSelectJavaDir();
    }	
    
	// ****************************************************************
	// *** selectOutputDirAction
	// ****************************************************************
	/**
	 * Select output directory action.
	 */
    private void selectOutputDirAction() {
    	SimulaEditor.doSelectOutputDir();
    }	
    
	// ****************************************************************
	// *** selectExtLibDirAction
	// ****************************************************************
	/**
	 * Select ExtLibDir action.
	 */
    private void selectExtLibDirAction() {
    	SimulaEditor.doSelectExtLibDir();
    	Global.storeWorkspaceProperties();
    }	

	// ****************************************************************
	// *** removeWorkspacesAction
	// ****************************************************************
	/**
	 * Remove Workspace action.
	 */
    private void removeWorkspacesAction() {
    	JPanel panel=new JPanel();
    	panel.setBackground(Color.white);
    	JLabel label=new JLabel("Check Workspaces to be removed:");
    	panel.add(label);
    	ArrayList<JCheckBox> list=new ArrayList<JCheckBox>();
    	for(File workspace:Global.workspaces) {
        	JCheckBox checkbox=new JCheckBox(workspace.toString()); 
        	checkbox.setBackground(Color.white);
        	list.add(checkbox); panel.add(checkbox);  
    	}
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int res=Util.optionDialog(panel,"Remove Workspaces (no changes to the file system)"
				,JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Update","Cancel");
		if(res==JOptionPane.OK_OPTION) {
			for(JCheckBox box:list) {
				if(box.isSelected()) Global.workspaces.remove(new File(box.getText()));
			}
	    	Global.storeWorkspaceProperties();
		}
    }
	
	// ****************************************************************
	// *** doAboutAction
	// ****************************************************************
    /**
     * About action
     */
	private void doAboutAction() {
		JTextArea msg=new JTextArea(
			"   This is a new Simula System created by the\n\n"
	      + "   Open Source Project 'Portable Simula Revisited'.\n\n"

		  + "   The project was initiated as a response to the lecture\n"
		  + "   held by James Gosling at the 50th anniversary of Simula\n"
		  + "   in Oslo on 27th September, 2017.\n\n"

		  + "   This Simula System is written in Java and compiles to pure\n" 
		  + "   Java code with one exception; the Goto Statement need to\n" 
		  + "   be corrected in the byte code, which is done automatically.\n\n");
		Util.optionDialog(msg,"About Portable Simula",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,"Ok");
	}
	
	// ****************************************************************
	// *** doMoreAction
	// ****************************************************************
	/**
	 * More action
	 */
	private void doMoreAction() {
		if(Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try { desktop.browse(new URI("https://portablesimula.github.io/github.io/"));
			} catch (Exception ex) {}
		}
	}

}
