package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

import simula.compiler.utilities.Util;

public class EditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private SimulaEditor simulaEditor;

	private JCheckBox autoRefresh=new JCheckBox("AutoRefresh");
	JMenuItem refresh=new JMenuItem("Refresh");
	private JMenuItem cut=new JMenuItem(new DefaultEditorKit.CutAction());
	private JMenuItem copy=new JMenuItem(new DefaultEditorKit.CopyAction());
	private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
	private JMenuItem search=new JMenuItem("Search");
	private static JMenuItem undo=new JMenuItem("Undo");
	private static JMenuItem redo=new JMenuItem("Redo");

	
	private JCheckBox autoRefresh2=new JCheckBox("AutoRefresh");
	private JMenuItem refresh2=new JMenuItem("Refresh");
	private JMenuItem cut2=new JMenuItem(new DefaultEditorKit.CutAction());
	private JMenuItem copy2=new JMenuItem(new DefaultEditorKit.CopyAction());
	private JMenuItem paste2=new JMenuItem(new DefaultEditorKit.PasteAction());
	private JMenuItem search2=new JMenuItem("Search");
	private static JMenuItem undo2=new JMenuItem("Undo");
	private static JMenuItem redo2=new JMenuItem("Redo");
	
	// ****************************************************************
	// *** EditMenu: Constructor
	// ****************************************************************
	public EditMenu(SimulaEditor simulaEditor) {
		super("Edit");
		this.simulaEditor=simulaEditor;
        this.add(autoRefresh); autoRefresh.addActionListener(actionListener);
        this.addSeparator();
        this.add(undo); undo.setEnabled(false); undo.addActionListener(actionListener);
        this.add(redo); redo.setEnabled(false); redo.addActionListener(actionListener);
        this.addSeparator();
        cut.setText("Cut");     this.add(cut);
        copy.setText("Copy");   this.add(copy);
        paste.setText("Paste"); this.add(paste);
        this.addSeparator();
        this.add(search); search.addActionListener(actionListener);
        this.addSeparator();
        this.add(refresh); refresh.addActionListener(actionListener);
	}

	
	// ****************************************************************
	// *** EditMenu: addPopupMenuItems
	// ****************************************************************
	public void addPopupMenuItems(JPopupMenu popupMenu) {
        popupMenu.add(autoRefresh2); autoRefresh2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(undo2); undo2.setEnabled(false); undo2.addActionListener(actionListener);
        popupMenu.add(redo2); redo2.setEnabled(false); redo2.addActionListener(actionListener);
        popupMenu.addSeparator();
        cut2.setText("Cut");     popupMenu.add(cut2);
        copy2.setText("Copy");   popupMenu.add(copy2);
        paste2.setText("Paste"); popupMenu.add(paste2);
        popupMenu.addSeparator();
        popupMenu.add(search2); search2.addActionListener(actionListener);
        popupMenu.addSeparator();
        popupMenu.add(refresh2); refresh2.addActionListener(actionListener);
        popupMenu.addSeparator();
	}
	
	// ****************************************************************
	// *** EditMenu: UpdateMenuItems
	// ****************************************************************
	public void updateMenuItems(SourceTextPanel sourceTextPanel) {
		Util.println("EditMenu.updateMenuItems: sourceTextPanel="+sourceTextPanel);
		autoRefresh.setSelected(sourceTextPanel.AUTO_REFRESH);
		autoRefresh2.setSelected(sourceTextPanel.AUTO_REFRESH);
		UndoManager undoManager = sourceTextPanel.getUndoManager();
		boolean canUndo=undoManager.canUndo();
		boolean canRedo=undoManager.canRedo();
		undo.setEnabled(canUndo); undo2.setEnabled(canUndo);
		redo.setEnabled(canRedo); redo2.setEnabled(canRedo);
	}	
	
	// ****************************************************************
	// *** EditMenu: ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			//System.out.println("EditMenu.ActionListener: "+item);
			SourceTextPanel current=simulaEditor.getCurrentTextPanel();
			if(current!=null) {
				if(item==autoRefresh) current.AUTO_REFRESH=autoRefresh.isSelected();
				else if(item==autoRefresh2) current.AUTO_REFRESH=autoRefresh2.isSelected();
				else if(item==undo || item==undo2) {
					UndoManager undoManager = current.getUndoManager();
					undoManager.undo();	updateMenuItems(current);
				}
				else if(item==redo || item==redo2) {
					UndoManager undoManager = current.getUndoManager();
					undoManager.redo();	updateMenuItems(current);
				}
				else if(item==search || item==search2) {
					new Search(simulaEditor.getCurrentTextPane());					
				}
				else if(item==refresh || item==refresh2) {
					current.doRefresh();
				}
			}
		}
	};
	

}
