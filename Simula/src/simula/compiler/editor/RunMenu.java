package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringReader;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

public class RunMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final SimulaEditor simulaEditor;

	public RunMenu(SimulaEditor simulaEditor) {
		super("Run");
		this.simulaEditor=simulaEditor;

        // ****************************************************************
        // *** RunMenu: Run Simula Compiler and Execute
        // ****************************************************************
        JMenuItem run = new JMenuItem("Run");
        run.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Util.println("menuRun.actionPerformed: e="+e);
        		doRun();
		}});
        this.add(run);

        // ****************************************************************
        // *** RunMenu: Debug Simula Program
        // ****************************************************************
        JMenuItem debug = new JMenuItem("Debug");
        debug.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Util.println("menuDebug.actionPerformed: e="+e);
        		doRun();
		}});
        debug.setEnabled(false);
        this.add(debug);
        //runMenu.addSeparator();
		
	}
	

	private void doRun() {
//		if(!simulaEditor.fileMenu.maybeSaveCurrentFile()) return;
		simulaEditor.fileMenu.maybeSaveCurrentFile();
       	File file=simulaEditor.getCurrentSourceFile();
		if(file==null) {
			file=new File(Global.getTempFileDir("simula/tmp/")+"unnamed.sim");
			file.getParentFile().mkdirs();
		}

		// Start compiler ....
      	String text=simulaEditor.getCurrentTextPanel().getPureText();
//      Util.println("SimulaEditor.doRun: text="+text);
       	if(text==null || text.trim().length()==0) {
       		Util.error("No Source Text to Compile, Please Open a File");
       		return;
       	}
       	StringReader reader=new StringReader(text);
       	String name=(file!=null)?file.getPath():Global.tempJavaFileDir+"/unnamed.sim";

//       	Global.console.clear();
//        Global.console.write("Simula Compiler Console:\n");
//        Global.console.write("Compiling: "+name+"\n");
//        Global.console.write("Runtime System directory:     "+Global.simulaRtsLib+"\n");
//        Global.console.write("Intermediate .java directory: "+Option.keepJava+"\n");
//        Global.console.write("Java version:                 "+System.getProperty("java.version")+"\n");

//       	new SimulaCompiler(name,reader).doCompile();
       	new Thread(new Runnable() {
			public void run() {
		       	new SimulaCompiler(name,reader).doCompile();
		}}).start();
	}

}