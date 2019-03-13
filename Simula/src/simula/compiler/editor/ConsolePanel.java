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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class ConsolePanel extends JPanel {
	private static final long serialVersionUID = 1L;
//	private static final boolean USE_TEXT_PANE=true;
//    private JTextArea textArea;
    private static JTextPane textPane;

    private StyledDocument doc;
    private Style styleRegular;
    private Style styleWarning;
    private Style styleError;

	public void write(String s) { write(s,styleRegular); }
	public void writeError(String s) { write(s,styleError); }
	public void writeWarning(String s) { write(s,styleWarning);	}

	private void write(String s,Style style) {
		try {
			doc.insertString(doc.getLength(), s, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
        //Util.BREAK("ConsolePanel.write: done s="+s);
//	    textPane.repaint();
		textPane.update(textPane.getGraphics());
	}

    public ConsolePanel() {
    	super(new BorderLayout());
    	JScrollPane scrollPane;
    	textPane = new JTextPane();
    	scrollPane = new JScrollPane(textPane);
    	doc=new DefaultStyledDocument();
    	addStylesToDocument(doc);
    	doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
    	textPane.setStyledDocument(doc);
    	textPane.addKeyListener(listener);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //JPanel panel = new JPanel(new BorderLayout());
        //panel.add(scrollPane);
        this.add(scrollPane);
    }

    
    private void addStylesToDocument(StyledDocument doc) {
        Style defaultStyle = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);
        
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

    KeyListener listener = new KeyListener() {
    	public void keyPressed(KeyEvent event) {
    	    //printEventInfo("Key Pressed", event);
    	}

    	public void keyReleased(KeyEvent event) {
    	    //printEventInfo("Key Released", event);
    	}

    	public void keyTyped(KeyEvent event) {
    	    //printEventInfo("Key Typed", event);
    	}

//    	private void printEventInfo(String str, KeyEvent e) {
//    	    System.out.println(str);
//    	    int code = e.getKeyCode();
//    	    System.out.println("   Code: " + KeyEvent.getKeyText(code));
//    	    System.out.println("   Char: " + e.getKeyChar());
//    	    int mods = e.getModifiersEx();
//    	    System.out.println("    Mods: "	+ KeyEvent.getModifiersExText(mods));
//    	    System.out.println("    Location: "	+ keyboardLocation(e.getKeyLocation()));
//    	    System.out.println("    Action? " + e.isActionKey());
//    	}

//    	private String keyboardLocation(int keybrd) {
//    	    switch (keybrd) {
//    	        case KeyEvent.KEY_LOCATION_RIGHT:	return "Right";
//    	        case KeyEvent.KEY_LOCATION_LEFT: 	return "Left";
//    	        case KeyEvent.KEY_LOCATION_NUMPAD:return "NumPad";
//    	        case KeyEvent.KEY_LOCATION_STANDARD:return "Standard";
//    	        case KeyEvent.KEY_LOCATION_UNKNOWN:
//    	        default:return "Unknown";
//    	    }
//    	}
    };

}