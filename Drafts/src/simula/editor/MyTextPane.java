package simula.editor;

import java.awt.Color;
import java.io.Reader;

import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MyTextPane {
	static Style styleRegular;
	static Style styleKeyword;
	static Style styleComment;
    
    private static void addStylesToDocument(StyledDocument doc) {
        //Initialize some styles.
        Style defaultStyle = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);
        
        Style regular = doc.addStyle("regular", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Courier New");
        
//        SimpleAttributeSet black = new SimpleAttributeSet();
//        StyleConstants.setForeground(black, Color.black);
//        StyleConstants.setFontFamily(black, "Courier");
//        StyleConstants.setFontSize(black, 11);
 
        Style s = doc.addStyle("comment", regular);
        StyleConstants.setItalic(s, true);
        StyleConstants.setForeground(s,Color.MAGENTA);  // MYH:

        s = doc.addStyle("keyword", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setForeground(s,Color.BLUE);  // MYH:
        
        styleRegular=doc.getStyle("regular");
        styleKeyword=doc.getStyle("keyword");
        styleComment=doc.getStyle("comment");
    }

    public static JTextPane fillTextPane(JTextPane textPane,Reader reader) {
        StyledDocument doc=new DefaultStyledDocument();
        addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
        PreScanner preScanner=new PreScanner(reader);
		try {
			Token token;
			while((token=preScanner.nextToken())!=null) {
//				Util.BREAK("ITEM:'" + item + "'");
				if(SimulaEditor.RENDER_LINE_NUMBERS && token.getKeyWord()==KeyWord.NEWLINE) {
				    Object lineNumber=token.getValue();
				    int line=(Integer)lineNumber;
				    String fill="";
				    if(line<10) fill="   ";
				    else if(line<100) fill="  ";
				    else if(line<1000) fill=" ";
				    String text=token.getText()+fill+line+": ";
				    doc.insertString(doc.getLength(), text, styleComment);
				} else {
					String text=token.getText();
					Style style=getStyle(token.getStyleCode());
					doc.insertString(doc.getLength(), text, style);
				}
				
			}
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert text into text pane.");
		}
		System.out.println("MyTextPane.createTextPane: END");
		textPane.setStyledDocument(doc);
		doc.addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				System.out.println("DocumentListener: insertUpdate'event="+e);				
			}
			public void removeUpdate(DocumentEvent e) {
				System.out.println("DocumentListener: removeUpdate'event="+e);				
			}
			public void changedUpdate(DocumentEvent e) {
				System.out.println("DocumentListener: changedUpdate'event="+e);				
			}});
        return(textPane);
    }
    
    private static Style getStyle(Token.StyleCode code) {
    	switch(code) {
    		case regular: return(styleRegular);
    		case keyword: return(styleKeyword);
    		case comment: return(styleComment);
    	}
    	return(null);
    }
    
    		

}
