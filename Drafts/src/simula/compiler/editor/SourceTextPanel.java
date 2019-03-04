package simula.compiler.editor;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;

import simula.compiler.parsing.SimulaScanner;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SourceTextPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	JTextPane editTextPane;  // Editable text pane with undo/redo history
	private JTextPane lineNumbers;
	private JScrollPane styleScrollPane;
	public File sourceFile;
    public boolean AUTO_REFRESH=true;//false;
 	
	private Style styleRegular;
	private Style styleKeyword;
	private Style styleComment;
	private Style styleConstant;
	private Style styleLineNumber;
	private JPopupMenu popupMenu;
	private StyledDocument doc;
//	private StyledDocument lin;
	
    public boolean fileChanged = false;
    public boolean refreshNeeded = false;
	private UndoManager undoManager = new UndoManager();
	public UndoManager getUndoManager() { return(undoManager); }
    
    private UndoableEditListener undoListener=new UndoableEditListener() {
		public void undoableEditHappened(UndoableEditEvent e) {
//			System.out.println("UndoableEditListener: "+e);
//			System.out.println("UndoableEditListener: edit="+e.getEdit());  // SimulaScanner.newToken
			undoManager.addEdit(e.getEdit());
//			EditMenu.enableUndoItems(SourceTextPanel.this);
//			SimulaEditor.menuBar.editMenu.updateMenuItems(SourceTextPanel.this);
			SimulaEditor.menuBar.updateMenuItems(SourceTextPanel.this);
			fileChanged=true; refreshNeeded=true;
		}
	};
    
    public String toString() {
    	String s="SourceTextPanel(";
        s=s+((sourceFile==null)?"unnamed":sourceFile.getName());
//    	if(this.isEditable) s=s+",isEditable";
//    	if(this.RENDER_LINE_NUMBERS) s=s+",RENDER_LINE_NUMBERS";
    	if(this.AUTO_REFRESH) s=s+",AUTO_REFRESH";
    	s=s+')';
    	return(s);
    }

    MouseListener mouseListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
    	    if(e.getButton()==3) popupMenu.show(editTextPane,e.getX(),e.getY());
    	}
    };
	
    public SourceTextPanel(File sourceFile,JPopupMenu popupMenu) {
    	this.sourceFile=sourceFile;
    	this.popupMenu=popupMenu;
        editTextPane = new JTextPane(); editTextPane.setEditable(false);
        editTextPane.addMouseListener(mouseListener);
        

        lineNumbers = new JTextPane(); lineNumbers.setEditable(false);
        JPanel extra=new JPanel();
        
        doc=new DefaultStyledDocument(); addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
    	doc.addUndoableEditListener(undoListener);
        editTextPane.setStyledDocument(doc);
        editTextPane.setEditable(true);
        
        extra.setLayout(new BorderLayout());
        extra.add(lineNumbers,BorderLayout.WEST);
        extra.add(editTextPane,BorderLayout.CENTER);
       
        
        //styleScrollPane = new JScrollPane(editTextPane);        
        styleScrollPane = new JScrollPane(extra);        
        styleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.setLayout(new BorderLayout());
        this.add(styleScrollPane,BorderLayout.CENTER);
    }

    public void fillTextPane(Reader reader,int caretPosition) {
		StyledDocument lin=new DefaultStyledDocument(); addStylesToDocument(lin);
        SimulaScanner preScanner=new SimulaScanner(reader,true);
        editTextPane.setEditable(false);
    	doc.removeUndoableEditListener(undoListener);
		try {
			Token token;
			doc.remove(0, doc.getLength());
			int lineNumber=1;
			lin.insertString(lin.getLength(),edLineNumber(lineNumber++),styleLineNumber);
			
//			Token next=preScanner.nextToken();
//			LOOP:while((token=next)!=null) {
//				next=preScanner.nextToken();
//				String text=token.getText();
//				Style style=getStyle(token.getStyleCode());
//				if(next==null && text.equals("\n")) break LOOP;
//				StringTokenizer tokenizer=new StringTokenizer(text,"\n",true);
//				while(tokenizer.hasMoreTokens()) {
//					String item=tokenizer.nextToken();
//					if(item.equals("\n"))
//						lin.insertString(lin.getLength(),edLineNumber(lineNumber++), styleLineNumber);
//					doc.insertString(doc.getLength(), item, style);
//				}
//			}
			
			while((token=preScanner.nextToken())!=null) {
			    String text=token.getText();
			    Style style=getStyle(token.getStyleCode());
			    //Util.println("SourceTextPanel.fillTextPane: INSERT: "+token+", text=\""+text+'\"');
			    
//			    //if(token.getKeyWord()==KeyWord.NEWLINE)
//				if(text.contains("\n"))
//					lin.insertString(lin.getLength(),edLineNumber(lineNumber++), styleLineNumber);
//			    doc.insertString(doc.getLength(), text, style);
			    
				StringTokenizer tokenizer=new StringTokenizer(text,"\n",true);
				while(tokenizer.hasMoreTokens()) {
					String item=tokenizer.nextToken();
					if(item.equals("\n"))
						lin.insertString(lin.getLength(),edLineNumber(lineNumber++), styleLineNumber);
				    //Util.println("SourceTextPanel.fillTextPane: DOC INSERT: "+item);
					doc.insertString(doc.getLength(), item, style);
				}
			    
		    }
			
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert text into text pane.");
		}
//		editTextPane.setStyledDocument(doc);
		lineNumbers.setStyledDocument(lin);
//		doc.addDocumentListener(documentListener);
    	doc.addUndoableEditListener(undoListener);
        editTextPane.setEditable(true);
	    editTextPane.setCaretPosition(caretPosition);
    }

    
    private String edLineNumber(int n) {
	    String fill="";
	    if(n<10) fill="   ";
	    else if(n<100) fill="  ";
	    else if(n<1000) fill=" ";
    	return(fill+n+": \n");
    }

    
	void doRefresh() {
	    int pos=editTextPane.getCaretPosition();
	    String txt=editTextPane.getText();
	    if(!txt.endsWith("\n")) txt=txt+'\n';
	    int count=countExtraControlCharacters(txt,pos);
    	int maxCaret=txt.length()-1;
    	if(pos>maxCaret) pos=maxCaret;
    	if(pos<0) pos=0;

		Util.println("SourceTextPanel.doRefresh: lng="+txt.length()+", txt=\""+txt+"\"");
		Util.println("SourceTextPanel.doRefresh: sourceFile="+sourceFile+", pos="+pos+", count="+count);
	    fillTextPane(new StringReader(txt),pos+count);
//	    int count=countExtraControlCharacters(txt,pos);
//	    editTextPane.setCaretPosition(pos+count);
	}
	
	private int countExtraControlCharacters(String s,int pos) {
		int count=0;
		for(int i=0;i<pos;i++) {
			if(s.charAt(i)=='\r') { count++; pos++; }
			if(s.charAt(i)<' ' && s.charAt(i)!='\n' && s.charAt(i)!='\r') Util.println("ControlCharacter: "+(int)s.charAt(i));
		}
		return(count);
	}
    
    private Style getStyle(Token.StyleCode code) {
    	switch(code) {
    		case regular: return(styleRegular);
    		case keyword: return(styleKeyword);
    		case comment: return(styleComment);
    		case constant: return(styleConstant);
    		case lineNumber: return(styleLineNumber);
    	}
    	return(null);
    }
    
    private void addStylesToDocument(StyledDocument doc) {
        //Initialize some styles.
        Style defaultStyle = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);
        
        Style regular = doc.addStyle("regular", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Courier New");
 
        Style s = doc.addStyle("comment", regular);
        StyleConstants.setItalic(s, true);
        StyleConstants.setForeground(s,new Color(0,153,153));

        s = doc.addStyle("keyword", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setForeground(s,new Color(153,0,51));

        s = doc.addStyle("constant", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setForeground(s,new Color(204,153,0));

        s = doc.addStyle("lineNumber", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setForeground(s,new Color(204,204,255));
        
        styleRegular=doc.getStyle("regular");
        styleKeyword=doc.getStyle("keyword");
        styleComment=doc.getStyle("comment");
        styleConstant=doc.getStyle("constant");
        styleLineNumber=doc.getStyle("lineNumber");
    }
 
}

