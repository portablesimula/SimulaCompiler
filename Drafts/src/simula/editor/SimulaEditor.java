package simula.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.text.DefaultEditorKit;


public class SimulaEditor extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final boolean RENDER_LINE_NUMBERS=true;//false;//true;
//  ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
//  ImageIcon simulaIcon = new ImageIcon("icons/sim.jpg");
    public static final ImageIcon simulaIcon = new ImageIcon("icons/sim2.png");
    
    private JTextPane textPane;
    private boolean edit = false;
    private File currentFile;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	SimulaEditor edit=new SimulaEditor();
    	edit.setVisible(true);
    }


    public SimulaEditor() {
        try { setIconImage(simulaIcon.getImage()); } 
        catch (Exception e) { e.printStackTrace(); }
        
        // Set the initial size of the window
        setSize(800, 500);

        // Set the title of the window
        setTitle("Untitled - " + "SimulaEditor");

        // Set the default close operation (exit when it gets closed)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // center the frame on the monitor
//        setLocationRelativeTo(null);
        this.setLocationByPlatform(true);

        textPane = new JTextPane();

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane);
        getContentPane().add(panel);

        // Set the Menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu runMenu = new JMenu("Run");
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(runMenu);
       
        this.setJMenuBar(menuBar);

        // ****************************************************************
        // *** FileMenu: New File
        // ****************************************************************
        JMenuItem newFile = new JMenuItem("New");
        newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(edit) doSave();
//				textArea.setText("");
			}});
        fileMenu.add(newFile);

        // ****************************************************************
        // *** FileMenu: Open File
        // ****************************************************************
        JMenuItem openFile = new JMenuItem("Open");
        openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String userDir = System.getProperty("user.home");
		        System.out.println("OpenFileAction - User Home="+userDir);
		        JFileChooser fileChooser = new JFileChooser(userDir +"/SimulaSource");
		        int answer = fileChooser.showOpenDialog(SimulaEditor.this);
		        if (answer == JFileChooser.APPROVE_OPTION) {
		        	doOpenFile(fileChooser.getSelectedFile());
		        }
		}});
        fileMenu.add(openFile);

        // ****************************************************************
        // *** FileMenu: Save File
        // ****************************************************************
        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
		}});
        fileMenu.add(saveFile);

        // ****************************************************************
        // *** FileMenu: Close Editor
        // ****************************************************************
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doClose();
		}});
        fileMenu.addSeparator();
        fileMenu.add(close);

        // ****************************************************************
        // *** EditMenu: Cut Text
        // ****************************************************************
        JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText("Cut");
        editMenu.add(cut);

        // ****************************************************************
        // *** EditMenu: Copy Text
        // ****************************************************************
        JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        editMenu.add(copy);

        // ****************************************************************
        // *** EditMenu: Paste Text
        // ****************************************************************
        JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        editMenu.add(paste);

        // ****************************************************************
        // *** EditMenu: Find Dialog
        // ****************************************************************
        JMenuItem findText = new JMenuItem("Find");
        findText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//		        new Find(textArea);
		        new Find(textPane);
			}});
        editMenu.addSeparator();
        editMenu.add(findText);

        // ****************************************************************
        // *** EditMenu: Refresh Source
        // ****************************************************************
        JMenuItem refresh = new JMenuItem("Refresh");
        refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("menuRefresh.actionPerformed: e="+e);
        		doUpdate();
		}});
        editMenu.addSeparator();
        editMenu.add(refresh);
    

        // ****************************************************************
        // *** RunMenu: Run Simula Compiler and Execute
        // ****************************************************************
        JMenuItem run = new JMenuItem("Run");
        run.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("menuRun.actionPerformed: e="+e);
        		doRun();
		}});
        runMenu.add(run);

        // ****************************************************************
        // *** RunMenu: Debug Simula Program
        // ****************************************************************
        JMenuItem debug = new JMenuItem("Debug");
        debug.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("menuDebug.actionPerformed: e="+e);
        		doRun();
		}});
        debug.setEnabled(false);
        runMenu.add(debug);
        //runMenu.addSeparator();
    }
    
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	System.out.println("WINDOW CLOSING EVENT");
           doClose(); 
        }
    }
    
	private void doClose() {
		edit=true;
		if (edit) {
			switch(saveDialog()) {
				case 0:	saveFile();     // Save file and Exit
				case 1:	System.exit(0); // No Save and Exit
				default: // Do nothing
			}
		} else System.exit(0);
	}
    
	private int saveDialog() {
		Object[] buttons = { "Save", "No Save", "Return" };
		int answer = JOptionPane.showOptionDialog(this, "Do you want to save the current file ?", "Question",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
		System.out.println("doClose.saveDialog: answer="+answer);
		return(answer);
	}
	
	private void doSave() {
		switch(saveDialog()) {
		   case 0:	saveFile();     // Save file
		   default: // Do nothing
		}
	}


	private void doOpenFile(File file) {
		currentFile=file;
		try { MyTextPane.fillTextPane(textPane,new FileReader(file)); }
		catch(IOException e) { e.printStackTrace(); }
	}

	private void doUpdate() {
	    int pos=textPane.getCaretPosition();
	    String txt=textPane.getText();
	    if(RENDER_LINE_NUMBERS) txt=removeLineNumbers(txt);
//	    MyTextPane.fillTextPane(textPane,new StringReader(textPane.getText()));
	    MyTextPane.fillTextPane(textPane,new StringReader(txt));
	    int count=countNewlines(textPane.getText(),pos);
	    textPane.setCaretPosition(pos+count);
	}
	
	private String removeLineNumbers(String txt) {
		StringBuilder result=new StringBuilder();
		StringReader reader=new StringReader(txt);
		try {
			boolean EOF=false;
			LOOP:while(!EOF) {
				// Skip Line Number:
				int c; while((c=reader.read())!=':'); // System.out.println("Skip N-Char: "+(char)c);
				reader.read();
				// Read until NewLine
				while((c=reader.read())!='\n') {
					if(c<0) break LOOP;
					result.append((char)c);
				}
				result.append('\n');
				// Check for EOF
				c=reader.read(); if(c<0) EOF=true;
				//Util.BREAK("removeLineNumbers: EOF="+EOF);
			}
		} catch(IOException e) {}
		return(result.toString());
	}
	
	private int countNewlines(String s,int pos) {
		int count=0;
//		for(int i=0;i<s.length();i++) if(s.charAt(i)=='\n') count++;
		for(int i=0;i<pos;i++) {
//			if(s.charAt(i)=='\n') { count++; pos++; }
			if(s.charAt(i)=='\r') { count++; pos++; }
			if(s.charAt(i)<' ' && s.charAt(i)!='\n' && s.charAt(i)!='\r') System.out.println("ControlCharacter: "+(int)s.charAt(i));
		}
		return(count);
	}

	private void doRun() {

		// Set options and tracing.
		Option.verbose = true;// false;
		Option.WARNINGS=true;

		// Overall TRACING Options
		Option.TRACING=true;//false;//true;
		Option.BREAKING=true;//false; //true; 

		// Scanner Trace Options
		Option.TRACE_PREPROCESSOR=false;//true;
		Option.TRACE_SCAN=false;//true;
		Option.TRACE_COMMENTS=false;//true;

		// Parser Trace Options
		Option.TRACE_PARSE=false;//true;

		// Checker Trace Options
		Option.TRACE_CHECKER=false;//true;
		Option.TRACE_CHECKER_OUTPUT=false;//true;

		// Coder Trace Options
		Option.TRACE_CODING=true;

		// Java Compiler and Jar-tool Trace Options
		Option.TRACE_JAVAC=false;//true;
		Option.TRACE_JAVAC_OUTPUT=false;//true;
		Option.TRACE_JARING=true;//false;//true;

//	Option.keepJava="C:/WorkSpaces/SimulaCompiler/Simula/src/testing";
//	Option.outputDir="C:/WorkSpaces/SimulaCompiler/Simula/bin/";
//	String fileName = "C:/WorkSpaces/SimulaCompiler/Simula/src/" + name;
		String userDir=System.getProperty("user.dir");
		Global.simulaRtsLib=userDir+"/bin/";         // AD'HOC

		Option.keepJava=userDir+"/src/testing";
//		Option.outputDir=userDir+"/bin/";
		Option.outputDir=userDir+"/src/testing/bin/";
        Global.console=new Console();
		// Start compiler ....
		//new SimulaCompiler(currentFile.getPath()).doCompile();
	}
	
    private void saveFile() {
        String userDir = System.getProperty("user.home");
        JFileChooser fileChooser = new JFileChooser(userDir +"/SimulaSource");
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File openFile = fileChooser.getSelectedFile();
                setTitle(openFile.getName() + " - " + "SimulaEditor");

                BufferedWriter out = new BufferedWriter(new FileWriter(openFile.getPath()));
               	String text=textPane.getText();
        	    if(RENDER_LINE_NUMBERS) text=removeLineNumbers(text);
                //System.out.println(text);
                out.write(text);
                out.close();

                //enableAutoComplete(openFile);
                edit = false;
            } catch (Exception ex) { // again, catch any exceptions and...
                // ...write to the debug console
                System.err.println(ex.getMessage());
            }
        }
    }

}