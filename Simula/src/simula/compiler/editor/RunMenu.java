package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringReader;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
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
        		System.out.println("menuRun.actionPerformed: e="+e);
        		doRun();
		}});
        this.add(run);

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
        this.add(debug);
        //runMenu.addSeparator();
		
	}
	

	private void doRun() {
		if(!simulaEditor.fileMenu.maybeSaveCurrentFile()) return;
       	File file=simulaEditor.getCurrentSourceFile();
		if(file==null) return;
		String userDir=System.getProperty("user.dir");

//??		Global.simulaRtsLib=userDir+"/bin/";         // AD'HOC
//??		Global.simulaRtsLib=userDir+"/rts/";         // AD'HOC

//		Option.keepJava=userDir+"/src/testing";
////		Option.outputDir=userDir+"/bin/";
//		Option.outputDir=userDir+"/src/testing/bin/";

		//Option.keepJava=userDir;
		
//		Option.outputDir=userDir+"/bin/";
//		Option.outputDir=userDir+"/src/"+Global.packetName+"/bin/";
//		Option.outputDir=userDir+"/bin/"+Global.packetName+'/';

		// Start compiler ....
      	String text=simulaEditor.getCurrentTextPanel().getPureText();
//      System.out.println("SimulaEditor.doRun: text="+text);
       	if(text==null || text.trim().length()==0) {
       		Util.error("No Source Text to Compile, Please Open a File");
       		return;
       	}
       	StringReader reader=new StringReader(text);
       	String name=file.getPath();
       	
       	Global.console.clear();
        Global.console.write("Simula Compiler Console:\n");
        Global.console.write("Compiling: "+name+"\n");
        Global.console.write("Intermediate .java directory: "+Option.keepJava+"\n");

//       	new SimulaCompiler(name,reader).doCompile();
       	new Thread(new Runnable() {
			public void run() {
		       	new SimulaCompiler(name,reader).doCompile();
		}}).start();
	}

}
