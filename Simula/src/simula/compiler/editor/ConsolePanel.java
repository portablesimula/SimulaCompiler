/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.editor;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import simula.compiler.utilities.Util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class ConsolePanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private static JTextPane textPane;

    private StyledDocument doc;
    private Style styleRegular;
    private Style styleWarning;
    private Style styleError;
    private JPopupMenu popupMenu;
    private JMenuItem clearItem;
	private JMenuItem copyItem;
	private boolean reading; // Used by KeyListener and read()
	private char keyin;      // Used by KeyListener and read()


	public char read() {
		textPane.requestFocus();
		reading=true; // Enables KeyListener (see below)
		while(reading) Thread.yield();
		return(keyin);
	}

	public void write(final String s) { write(s,styleRegular); }
	public void writeError(final String s) { write(s,styleError); }
	public void writeWarning(final String s) { write(s,styleWarning);	}

	private void write(final String s,final Style style) {
		try {
			doc.insertString(doc.getLength(), s, style);
		} catch (BadLocationException e) {
			Util.INTERNAL_ERROR("Impossible",e);
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
        //Util.BREAK("ConsolePanel.write: done s="+s);
//	    textPane.repaint();
//		textPane.update(textPane.getGraphics());
	}

	public void clear() {
		try {
			doc.remove(0, doc.getLength());
		} catch (BadLocationException e) {
			Util.INTERNAL_ERROR("Impossible",e);
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
        //Util.BREAK("ConsolePanel.write: done s="+s);
//	    textPane.repaint();
		textPane.update(textPane.getGraphics());
		write("Simula Compiler Console:\n");
	}

	public ConsolePanel() {
    	super(new BorderLayout());
    	JScrollPane scrollPane;
    	textPane = new JTextPane();
        textPane.addMouseListener(mouseListener);
    	scrollPane = new JScrollPane(textPane);
    	doc=new DefaultStyledDocument();
    	addStylesToDocument(doc);
    	doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
    	textPane.setStyledDocument(doc);
    	textPane.addKeyListener(listener);
//    	doc.addDocumentListener(docListener);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //JPanel panel = new JPanel(new BorderLayout());
        //panel.add(scrollPane);
        popupMenu=new JPopupMenu();
        clearItem = new JMenuItem("Clear Console");
        //clearItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
        popupMenu.add(clearItem); clearItem.addActionListener(actionListener);
        copyItem = new JMenuItem("Copy to Clipboard");
		copyItem.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
        popupMenu.add(copyItem); copyItem.addActionListener(actionListener);
        this.add(scrollPane);
    }

    
    private void addStylesToDocument(final StyledDocument doc) {
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        
        Style regular = doc.addStyle("regular", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Courier New");
 
        Style s = doc.addStyle("warning", regular);
        StyleConstants.setItalic(s, true);
        StyleConstants.setForeground(s,new Color(255,153,0));

        s = doc.addStyle("error", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setForeground(s,Color.RED);
        
        styleRegular=doc.getStyle("regular");
        styleWarning=doc.getStyle("warning");
        styleError=doc.getStyle("error");
    }
    

	// ****************************************************************
	// *** MouseListener
	// ****************************************************************
    MouseListener mouseListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
    	    if(e.getButton()==3) popupMenu.show(textPane,e.getX(),e.getY());
    	}
    };

    
	// ****************************************************************
	// *** ActionListener
	// ****************************************************************
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item=e.getSource();
			//System.out.println("ConsolePanel.ActionListener: "+item);
			if(item==clearItem) clear();
			else if(item==copyItem) {
				String text=textPane.getSelectedText();
				//System.out.println("ConsolePanel.ActionListener: SelectedText=\""+text+"\"");
				if(text==null) text=textPane.getText();
				//System.out.println("ConsolePanel.ActionListener: Text=\""+text+"\"");
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		}
	};
    
	// ****************************************************************
	// *** KeyListener
	// ****************************************************************
    private KeyListener listener = new KeyListener() {
    	public void keyTyped(KeyEvent event) {}
    	public void keyPressed(KeyEvent event) {}
    	public void keyReleased(KeyEvent event) {
    	    if(reading) {
    	    	keyin=event.getKeyChar();
       	    	reading=false;
    	    }
    	}
    };

}