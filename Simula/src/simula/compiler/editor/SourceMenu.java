package simula.compiler.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SourceMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public SourceMenu(SimulaEditor simulaEditor) {
		super("Source");

        // ****************************************************************
        // *** EditMenu: LineNumbers on/off
        // ****************************************************************
        JMenuItem findText = new JMenuItem("LineNumbers");
        findText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimulaEditor.RENDER_LINE_NUMBERS=!SimulaEditor.RENDER_LINE_NUMBERS;
        		simulaEditor.doRefresh();
			}});
        this.addSeparator();
        this.add(findText);
        
        JCheckBox showLines=new JCheckBox("ShowLineNumbers",true);
        showLines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("SourceMenu.showLines: isSelected="+showLines.isSelected());
				SimulaEditor.RENDER_LINE_NUMBERS=showLines.isSelected();
        		simulaEditor.doRefresh();
			}});
        this.add(showLines);
        
        JCheckBox autoRefresh=new JCheckBox("AutoRefresh",false);
        autoRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("SourceMenu.autoRefresh: isSelected="+autoRefresh.isSelected());
				SimulaEditor.AUTO_REFRESH=showLines.isSelected();
        		//simulaEditor.doRefresh();
			}});
        this.add(autoRefresh);

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
    
		
	}

}
