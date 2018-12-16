package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import simula.compiler.utilities.Global;

public class FileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final SimulaEditor simulaEditor;
	
	public FileMenu(SimulaEditor simulaEditor) {
		super("File");
		this.simulaEditor=simulaEditor;
		
        // ****************************************************************
        // *** FileMenu: New File
        // ****************************************************************
        JMenuItem newFile = new JMenuItem("New");
        newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//maybeSaveCurrentFile();
	        	simulaEditor.doNewFile();
			}});
        this.add(newFile);

        // ****************************************************************
        // *** FileMenu: Open File
        // ****************************************************************
        JMenuItem openFile = new JMenuItem("Open");
        openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//maybeSaveCurrentFile();
				
//		        String userDir = System.getProperty("user.home");
//		        System.out.println("OpenFileAction - User Home="+userDir);
//		        JFileChooser fileChooser = new JFileChooser(userDir +"/SimulaSource");

//				System.out.println("FileMenu.openFile: dir="+Global.sampleSourceDir);
		        JFileChooser fileChooser = new JFileChooser(Global.sampleSourceDir);
		        int answer = fileChooser.showOpenDialog(simulaEditor);
		        if (answer == JFileChooser.APPROVE_OPTION) {
		        	simulaEditor.doOpenFile(fileChooser.getSelectedFile());
		        }
		}});
        this.add(openFile);

        // ****************************************************************
        // *** FileMenu: Save File
        // ****************************************************************
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSaveCurrentFile();
		}});
        this.addSeparator();
        this.add(saveFile);        

        // ****************************************************************
        // *** FileMenu: Save As...
        // ****************************************************************
        JMenuItem saveAs = new JMenuItem("Save As...");
        saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { doSaveAs(); }});
        this.add(saveAs);        

        // ****************************************************************
        // *** FileMenu: Close File
        // ****************************************************************
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maybeSaveCurrentFile()) simulaEditor.removeSelectedTab();
				
		}});
        this.addSeparator();
        this.add(close);

        // ****************************************************************
        // *** FileMenu: Close All Files
        // ****************************************************************
        JMenuItem closeAll = new JMenuItem("Close All");
        closeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doCloseAll();
		}});
        this.addSeparator();
        this.add(closeAll);

        // ****************************************************************
        // *** FileMenu: Exit Editor
        // ****************************************************************
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doExit();
		}});
        this.addSeparator();
        this.add(exit);

	}
	
	void doCloseAll() {
		// CloseAll
		while(simulaEditor.tabbedPane.getSelectedIndex()>=0)
			if(maybeSaveCurrentFile()) simulaEditor.removeSelectedTab();
		
	}
	
	void doExit() {
		doCloseAll();
		System.exit(0);
	}

	
	// Returns 'false' if 'cancel' was selected
	boolean maybeSaveCurrentFile() {
		SourceTextPanel current=simulaEditor.getCurrentTextPanel();
		if(current==null) return(true);
		if(!current.fileChanged) return(true);
		switch(saveDialog(current.sourceFile)) {
		   case JOptionPane.YES_OPTION:	doSaveCurrentFile();     // Save file
		   case JOptionPane.NO_OPTION:  return(true);
		   case JOptionPane.CANCEL_OPTION: return(false);
		   default: return(false); // Do nothing
		}
	}
	
	void doSaveCurrentFile() {
		SourceTextPanel current=simulaEditor.getCurrentTextPanel();
		if(current.sourceFile==null) doSaveAs();
		else current.saveFile();
	}

	public void doSaveAs() {
    	System.out.println("saveAs.CLICKED:");
    	
//        String userDir = System.getProperty("user.home");
//        JFileChooser fileChooser = new JFileChooser(userDir +"/SimulaSource"); ?

        JFileChooser fileChooser = new JFileChooser(Global.sampleSourceDir);
        
        int answer = fileChooser.showSaveDialog(simulaEditor);
        if (answer == JFileChooser.APPROVE_OPTION) {
        	//simulaEditor.doOpenFile(fileChooser.getSelectedFile());
        	File file=fileChooser.getSelectedFile();
        	System.out.println("saveAs.APPROVED: "+fileChooser.getSelectedFile());
        	if(file.exists()) {
	            int resp=overwriteDialog(file);
	        	System.out.println("saveAs.NO_END: response="+resp);
	        	if(resp==JOptionPane.CANCEL_OPTION) return; // Do Nothing
        		
        	}
        	
        	
        	String name=file.getName().toLowerCase();
        	System.out.println("saveAs.NAME: "+name);
        	if(!name.endsWith(".sim")) {
	        	System.out.println("saveAs.NO_END .sim: ");
	            //JOptionPane.showMessageDialog(null,"infoMessage", "InfoBox: ", JOptionPane.WARNING_MESSAGE);
	            int resp=noSimTypeDialog(file);
	        	System.out.println("saveAs.NO_END: response="+resp);
	        	if(resp==JOptionPane.OK_OPTION) System.out.println("saveAs.NO_END: response=OK");
	        	if(resp==JOptionPane.CANCEL_OPTION) System.out.println("saveAs.NO_END: response=CANCEL");
	        	
	        	if(resp==JOptionPane.CANCEL_OPTION) return; // Do Nothing
        	}
        	simulaEditor.getCurrentTextPanel().sourceFile=file;
	        simulaEditor.setSelectedTabTitle(file.getName());
	        simulaEditor.getCurrentTextPanel().fileChanged=true;
			simulaEditor.getCurrentTextPanel().saveFile();
        }
	}

	private int overwriteDialog(File file) {
        int resp=JOptionPane.showOptionDialog(null,
        		"The file: \n"+file+"\nAlready exists - Do you want to overwrite it ?"
        		,"Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
        return(resp);
	}

	private int noSimTypeDialog(File file) {
        int resp=JOptionPane.showOptionDialog(null,
        		"The file name\n"+file+"\nDoes not end with the recomended \".sim\""
        		,"Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
        return(resp);
	}
	
	private int saveDialog(File file) {
		String msg=(file==null)?"The source text has unsaved changes.\nDo you want to save it in a file ?"
		                       :"The file: \n"+file+"\nHas changed - do you want to save it ?";
		int answer = JOptionPane.showOptionDialog(null,msg,"Question",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		System.out.println("doClose.saveDialog: answer="+answer);
		return(answer);
	}
	

}
