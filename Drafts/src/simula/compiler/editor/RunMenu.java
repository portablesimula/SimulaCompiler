package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringReader;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import simula.compiler.SimulaCompiler;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

public class RunMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final SimulaEditor simulaEditor;
    JMenuItem run = new JMenuItem("Run");
    JMenuItem debug = new JMenuItem("Debug");
    
    JMenuItem run2 = new JMenuItem("Run");
    JMenuItem debug2 = new JMenuItem("Debug");

	// ****************************************************************
	// *** RunMenu: Constructor
	// ****************************************************************
	public RunMenu(SimulaEditor simulaEditor) {
		super("Run");
		this.simulaEditor=simulaEditor;
        this.add(run); run.addActionListener(actionListener);
        this.add(debug); debug.addActionListener(actionListener);
        debug.setEnabled(false);
        this.add(debug);
	}

	// ****************************************************************
	// *** RunMenu: addPopupMenuItems
	// ****************************************************************
	public void addPopupMenuItems(JPopupMenu popupMenu) {
        popupMenu.add(run2); run2.addActionListener(actionListener);
        popupMenu.add(debug2); debug2.addActionListener(actionListener);
        debug2.setEnabled(false); 
        popupMenu.addSeparator();
	}
	
	// ****************************************************************
	// *** RunMenu: ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			//System.out.println("EditMenu.ActionListener: "+item);
			SourceTextPanel current=simulaEditor.getCurrentTextPanel();
			if(current!=null) {
				if(item==run   || item==run2) doRunAction();
				if(item==debug || item==debug2) doRunAction();
			}
		}
	};
	
	// ****************************************************************
	// *** doRunAction
	// ****************************************************************
	private void doRunAction() {
		simulaEditor.menuBar.fileMenu.maybeSaveCurrentFile();
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

}
