package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;

public class EditMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public EditMenu(SimulaEditor simulaEditor) {
		super("Edit");

        // ****************************************************************
        // *** EditMenu: Cut Text
        // ****************************************************************
        JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText("Cut");
        this.add(cut);

        // ****************************************************************
        // *** EditMenu: Copy Text
        // ****************************************************************
        JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        this.add(copy);

        // ****************************************************************
        // *** EditMenu: Paste Text
        // ****************************************************************
        JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        this.add(paste);

        // ****************************************************************
        // *** EditMenu: Find Dialog
        // ****************************************************************
        JMenuItem findText = new JMenuItem("Find");
        findText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        new Search(simulaEditor.getCurrentTextPane());
			}});
        this.addSeparator();
        this.add(findText);
    
		
	}

}
