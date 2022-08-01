/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.editor;

import javax.swing.*;

import simula.compiler.utilities.Global;
import simula.compiler.utilities.Util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int labWidth = 80;
    private static final int labHeight = 20;
    private final JTextField textField = new JTextField(30);
    private final JTextField replaceText = new JTextField(30);
    private JTextPane textPane;
    private int startIndex=0;
    private int selectStart=-1;

    public Search() {
        this.textPane = SimulaEditor.current.editTextPane;
        setLayout(null);
        
        // ********************************************************
        // *** Find <text-field>
        // ********************************************************
        JLabel lab1 = new JLabel("Find:");
        lab1.setBounds(10,10, labWidth, labHeight);
        textField.setBounds(10+labWidth, 10, 120, 20);
        add(lab1); add(textField);
        
        // ********************************************************
        // *** Replace <text-field>
        // ********************************************************
        JLabel lab2 = new JLabel("Replace:");
        lab2.setBounds(10, 10+labHeight+10, labWidth, labHeight);
        replaceText.setBounds(10+labWidth, 10+labHeight+10, 120, 20);
        add(lab2); add(replaceText);

        // ********************************************************
        // *** Find Button
        // ********************************************************
        JButton findBtn = new JButton("Find");
        findBtn.setBounds(225, 6, 115, 20);
        add(findBtn);
        findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}});

        // ********************************************************
        // *** FindNext Button
        // ********************************************************
        JButton findNext = new JButton("Find Next");
        findNext.setBounds(225, 28, 115, 20);
        add(findNext);
        findNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findNext();
			}});

        // ********************************************************
        // *** Replace Button
        // ********************************************************
        JButton replace = new JButton("Replace");
        replace.setBounds(225, 50, 115, 20);
        add(replace);
        replace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replace();
			}});

        // ********************************************************
        // *** ReplaceAll Button
        // ********************************************************
        JButton replaceAll = new JButton("Replace All");
        replaceAll.setBounds(225, 72, 115, 20);
        add(replaceAll);
        replaceAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				replaceAll();
			}});

        // ********************************************************
        // *** Cancel Button
        // ********************************************************
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(225, 94, 115, 20);
        add(cancel);
        cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.this.setVisible(false);
			}});

        try { setIconImage(Global.simulaIcon.getImage()); } 
        catch (Exception e) { Util.INTERNAL_ERROR("Impossible",e); }

        // Set the width and height of the window
        setSize(360,160);

        // center the frame on the frame
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


	public void find() {
		selectStart = textPane.getText().toLowerCase().indexOf(textField.getText().toLowerCase());
		if (selectStart == -1) {
			startIndex = 0;
			JOptionPane.showMessageDialog(this, "Could not find \"" + textField.getText() + "\"!");
			return;
		}
		if (selectStart == textPane.getText().toLowerCase().lastIndexOf(textField.getText().toLowerCase())) {
			startIndex = 0;
		}
		int selectEnd = selectStart + textField.getText().length();
		textPane.select(selectStart, selectEnd);		
	}
	
	public void findNext() {
		String selection = textPane.getSelectedText();
		try {
			selection.equals("");
		} catch (NullPointerException e) {
			selection = textField.getText();
			try {
				selection.equals("");
			} catch (NullPointerException e2) {
				selection = JOptionPane.showInputDialog("Find:");
				textField.setText(selection);
			}
		}
		try {
			int selectStart = textPane.getText().toLowerCase().indexOf(selection.toLowerCase(), startIndex);
			int selectEnd = selectStart + selection.length();
			textPane.select(selectStart, selectEnd);
			startIndex = selectEnd + 1;

			if (selectStart == textPane.getText().toLowerCase().lastIndexOf(selection.toLowerCase())) {
				startIndex = 0;
			}
		} catch (NullPointerException e) {}
	}

	public void replace() {
		try {
			find();
			if (selectStart != -1)
				textPane.replaceSelection(replaceText.getText());
		} catch (NullPointerException e) {
			System.out.print("Null Pointer Exception: " + e);
		}
	}

    public void replaceAll() {
        textPane.setText(textPane.getText().toLowerCase().replaceAll(textField.getText().toLowerCase(), replaceText.getText()));
    }

}