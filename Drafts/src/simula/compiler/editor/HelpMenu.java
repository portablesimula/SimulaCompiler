package simula.compiler.editor;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import simula.compiler.utilities.Util;

public class HelpMenu extends JMenu {
	private static final long serialVersionUID = 1L;
    JMenuItem about = new JMenuItem("About Simula");
    JMenuItem more = new JMenuItem("More Info");
    
    JMenuItem about2 = new JMenuItem("About Simula");
    JMenuItem more2 = new JMenuItem("More Info");

	// ****************************************************************
	// *** HelpMenu: Constructor
	// ****************************************************************
	public HelpMenu() {
		super("Help");
        this.add(about); about.addActionListener(actionListener);
        this.add(more); more.addActionListener(actionListener);
	}

	// ****************************************************************
	// *** HelpMenu: addPopupMenuItems
	// ****************************************************************
	public void addPopupMenuItems(JPopupMenu popupMenu) {
        popupMenu.add(about2); about2.addActionListener(actionListener);
        popupMenu.add(more2); more2.addActionListener(actionListener);
        //popupMenu.addSeparator();
	}
	
	// ****************************************************************
	// *** HelpMenu: ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			//System.out.println("EditMenu.ActionListener: "+item);
			if(item==about || item==about2) doAboutAction();
			else if(item==more || item==more2) doMoreAction();
		}
	};
	
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
