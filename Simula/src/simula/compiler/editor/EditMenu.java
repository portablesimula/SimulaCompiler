package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;

public class EditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private JCheckBox enable;
	private JCheckBox autoRefresh;
	private JMenuItem cut;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem findText;
	
	private void enableMenuItems(boolean on) {
		cut.setEnabled(on);
		copy.setEnabled(on);
		paste.setEnabled(on);
		findText.setEnabled(on);
//	    this.validate();
	}
	
	public void update(SourceTextPanel sourceTextPanel) {
		System.out.println("EditMenu.update: sourceTextPanel="+sourceTextPanel);
		enable.setSelected(sourceTextPanel.isEditable());
		autoRefresh.setSelected(sourceTextPanel.AUTO_REFRESH);
		enableMenuItems(sourceTextPanel.isEditable());
	}
	
	public EditMenu(SimulaEditor simulaEditor) {
		super("Edit");

        // ****************************************************************
        // *** EditMenu: Enable Editing on/off
        // ****************************************************************
        enable=new JCheckBox("Enable Editing",false);
        enable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SourceTextPanel current=simulaEditor.getCurrentTextPanel();
				if(current!=null) {
//					boolean editable=!current.isEditable();					
					boolean editable=enable.isSelected();					
					current.setEditable(editable);
					autoRefresh.setSelected(editable);
					enableMenuItems(editable);
				}
			}});
        this.add(enable);
        
        // ****************************************************************
        // *** EditMenu: Auto Refresh on/off
        // ****************************************************************
        autoRefresh=new JCheckBox("AutoRefresh",false);
        autoRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SourceTextPanel current=simulaEditor.getCurrentTextPanel();
				if(current!=null) {
					current.AUTO_REFRESH=autoRefresh.isSelected();
					//simulaEditor.doRefresh();
				}
			}});
        this.add(autoRefresh);
        this.addSeparator();


        // ****************************************************************
        // *** EditMenu: Cut Text
        // ****************************************************************
        cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText("Cut");
        this.add(cut);

        // ****************************************************************
        // *** EditMenu: Copy Text
        // ****************************************************************
        copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        this.add(copy);

        // ****************************************************************
        // *** EditMenu: Paste Text
        // ****************************************************************
        paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        this.add(paste);

        // ****************************************************************
        // *** EditMenu: Find Dialog
        // ****************************************************************
        findText = new JMenuItem("Find");
        findText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        new Search(simulaEditor.getCurrentTextPane());
			}});
        this.addSeparator();
        this.add(findText);

        // ****************************************************************
        // *** EditMenu: Refresh Source
        // ****************************************************************
        JMenuItem refresh = new JMenuItem("Refresh");
        refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//System.out.println("menuRefresh.actionPerformed: e="+e);
        		simulaEditor.doRefresh();
		}});
        this.addSeparator();
        this.add(refresh);
    
        enableMenuItems(false);
	}

}
