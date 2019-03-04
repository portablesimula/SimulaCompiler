package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

public class FileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final SimulaEditor simulaEditor;
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem saveAs = new JMenuItem("Save As...");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem closeAll = new JMenuItem("Close All");
    JMenuItem exit = new JMenuItem("Exit");
	
    JMenuItem newFile2 = new JMenuItem("New");
    JMenuItem openFile2 = new JMenuItem("Open");
    JMenuItem saveFile2 = new JMenuItem("Save");
    JMenuItem saveAs2 = new JMenuItem("Save As...");
    JMenuItem close2 = new JMenuItem("Close");
    JMenuItem closeAll2 = new JMenuItem("Close All");
    JMenuItem exit2 = new JMenuItem("Exit");
	
	// ****************************************************************
	// *** EditMenu: ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			if(item==newFile || item==newFile2) simulaEditor.doNewTabbedPanel(null);
			else if(item==openFile || item==openFile2) doOpenFileAction();
			else if(item==saveFile || item==saveFile2) doSaveCurrentFile(false);
			else if(item==saveAs   || item==saveAs2) doSaveCurrentFile(true);
			else if(item==close    || item==close2) doCloseCurrentFileAction();
			else if(item==closeAll || item==closeAll2) doCloseAllAction();
			else if(item==exit     || item==exit2) doExitAction();
		}
	};	
		
	// ****************************************************************
	// *** FileMenu: Constructor
	// ****************************************************************
	public FileMenu(SimulaEditor simulaEditor) {
		super("File");
		this.simulaEditor=simulaEditor;
		this.add(newFile); newFile.addActionListener(actionListener);
		this.add(openFile); openFile.addActionListener(actionListener);
        this.addSeparator();
        this.add(saveFile); saveFile.addActionListener(actionListener);
        this.add(saveAs); saveAs.addActionListener(actionListener);
        this.addSeparator();
        this.add(close); close.addActionListener(actionListener);
        this.addSeparator();
        this.add(closeAll); closeAll.addActionListener(actionListener);
        this.addSeparator();
        this.add(exit); exit.addActionListener(actionListener);
	}
	
	// ****************************************************************
	// *** EditMenu: addPopupMenuItems
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
	}
	
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
	

}
