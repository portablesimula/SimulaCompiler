package simula.compiler.editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Option;
import simula.compiler.utilities.RTOption;
import simula.compiler.utilities.Util;

public class SettingsMenu extends JMenu {
	private static final long serialVersionUID = 1L;
    JMenuItem workSpaces = new JMenuItem("Remove WorkSpaces");
    JMenuItem compilerOption = new JMenuItem("Compiler Options");
    JMenuItem runtimeOption = new JMenuItem("Runtime Options");

    JMenuItem workSpaces2 = new JMenuItem("Remove WorkSpaces");
    JMenuItem compilerOption2 = new JMenuItem("Compiler Options");
    JMenuItem runtimeOption2 = new JMenuItem("Runtime Options");

	// ****************************************************************
	// *** SettingsMenu: ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			//System.out.println("EditMenu.ActionListener: "+item);
			if(item==workSpaces || item==workSpaces2) removeWorkspacesAction();
			else if(item==compilerOption || item==compilerOption) Option.selectCompilerOptions();
			else if(item==runtimeOption  || item==runtimeOption) RTOption.selectRuntimeOptions();			
		}
	};
	
	// ****************************************************************
	// *** SettingsMenu: Constructor
	// ****************************************************************
	public SettingsMenu() {
		super("Settings");
        this.add(workSpaces); workSpaces.addActionListener(actionListener);
        this.add(compilerOption); compilerOption.addActionListener(actionListener);
        this.add(runtimeOption); runtimeOption.addActionListener(actionListener);
    }

	
	// ****************************************************************
	// *** SettingsMenu: addPopupMenuItems
	// ****************************************************************
	public void addPopupMenuItems(JPopupMenu popupMenu) {
        popupMenu.add(workSpaces2); workSpaces2.addActionListener(actionListener);
        popupMenu.add(compilerOption2); compilerOption2.addActionListener(actionListener);
        popupMenu.add(runtimeOption2); runtimeOption2.addActionListener(actionListener);
        popupMenu.addSeparator();
	}
    
	// ****************************************************************
	// *** removeWorkspacesAction
	// ****************************************************************
    private void removeWorkspacesAction() {
    	JPanel panel=new JPanel();
    	panel.setBackground(Color.white);
    	JLabel label=new JLabel("Check Workspaces to be removed:");
    	panel.add(label);
    	ArrayList<JCheckBox> list=new ArrayList<JCheckBox>();
    	for(String workspace:Global.workspaces) {
        	JCheckBox checkbox=new JCheckBox(workspace); 
        	checkbox.setBackground(Color.white);
        	list.add(checkbox); panel.add(checkbox);  
    	}
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int res=Util.optionDialog(panel,"Remove Workspaces (no changes to the file system)"
				,JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,"Update","Cancel");
		//Util.println("SettingsMenu.removeWorkspaces: res="+res);
		if(res==JOptionPane.OK_OPTION) {
			//Util.println("SettingsMenu.removeWorkspaces: OK res="+res);
			for(JCheckBox box:list) {
				//Util.println("SettingsMenu.removeWorkspaces: box="+box.isSelected()+", text="+box.getText());
				if(box.isSelected()) Global.workspaces.remove(box.getText());
			}
	    	Global.updateWorkspaceList();
		}
    }

}
