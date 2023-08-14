/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.editor;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AbstractDocument.LeafElement;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import simula.compiler.parsing.DefaultScanner;
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

/**
 * The Source text Panel.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/editor/SourceTextPanel.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
@SuppressWarnings("serial")
public class SourceTextPanel extends JPanel {
	/**
	 * DEBUG on/off
	 */
	private static final boolean DEBUG=false;//true;

	/**
	 * The line number side-panel.
	 */
	private JTextPane lineNumbers;
	
	/**
	 * The ScrollPane
	 */
	private JScrollPane styleScrollPane;
 	
	/** Style */ private Style styleRegular;
	/** Style */ private Style styleKeyword;
	/** Style */ private Style styleComment;
	/** Style */ private Style styleConstant;
	/** Style */ private Style styleLineNumber;
	
	/**
	 * The popup Menu.
	 */
	private JPopupMenu popupMenu;
	
	/**
	 * The StyledDocument.
	 */
	private StyledDocument doc;
	
	/**
	 * Editable text pane with undo/redo history.
	 */
	JTextPane editTextPane;
	
	/**
	 * Current language.
	 */
    SimulaEditor.Language lang;

	
	/**
	 * The source file.
	 */
	File sourceFile;
	
	/**
	 * Signals auto refresh.
	 */
    boolean AUTO_REFRESH=true;//false;

	/**
	 * The undo manager.
	 */
	private UndoManager undoManager = new UndoManager();
	
	/**
	 * Returns the undo manager.
	 * @return the undo manager
	 */
	UndoManager getUndoManager() { return(undoManager); }
	
    /**
     * Indicates that the source file has changed.
     */
    boolean fileChanged = false;
    
    /**
     * Indicates that refresh is needed.
     */
    boolean refreshNeeded = false;

	// ****************************************************************
	// *** UndoableEditListener
	// ****************************************************************
    /**
     * The UndoableEditListener.
     */
    private UndoableEditListener undoListener=new UndoableEditListener() {
		public void undoableEditHappened(UndoableEditEvent e) {
			UndoableEdit edit=e.getEdit();
			undoManager.addEdit(edit);
			fileChanged=true; refreshNeeded=true;
			SimulaEditor.menuBar.updateMenuItems();
		}
	};

	// ****************************************************************
	// *** MouseListener
	// ****************************************************************
	/**
	 * The MouseListener.
	 */
    MouseListener mouseListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {
    	    if(e.getButton()==3) popupMenu.show(editTextPane,e.getX(),e.getY());
    	}
    };

	// ****************************************************************
	// *** DocumentListener
	// ****************************************************************
    /**
     * The DocumentListener.
     */
	DocumentListener documentListener=new DocumentListener() {
		public void insertUpdate(DocumentEvent e)  { debugTrace("Insert",e); }
		public void removeUpdate(DocumentEvent e)  { debugTrace("Remove",e); }
		public void changedUpdate(DocumentEvent e) { debugTrace("Changed",e); }
		
		private void debugTrace(String id,DocumentEvent evt) {
			if(DEBUG) {
			    int ofst=evt.getOffset();
			    int lng=evt.getLength();
			    String styleName="UNKNOWN";
			    String lastText="UNKNOWN";
				try { // debugTrace
				    StyledDocument doc=(StyledDocument)editTextPane.getDocument();
				    if(id.equals("Insert")) lastText= doc.getText(ofst,lng);
				    if(id.equals("addition")) lastText= doc.getText(ofst,lng);
				    Element elt=doc.getCharacterElement(ofst);
				    if(elt instanceof LeafElement leaf) {
					    styleName=(String)leaf.getAttribute(StyleConstants.NameAttribute);
				    }
				    lastText=lastText.replace("\n","\\n");
				} catch (Exception ex) { Util.IERR("Impossible",ex); }			
				System.out.println("DocumentListener: "+id + '[' + ofst + ',' + lng + "]="+styleName+"\"" + lastText + '"');
			}
		}	
	};
	
	// ****************************************************************
	// *** Constructor
	// ****************************************************************
	/**
	 * Create a new SourceTextPanel.
	 * @param sourceFile the source file
	 * @param lang the language
	 * @param popupMenu the popupMenu
	 */
    SourceTextPanel(File sourceFile,SimulaEditor.Language lang,JPopupMenu popupMenu) {
    	this.sourceFile=sourceFile;
    	this.lang=lang;
    	this.popupMenu=popupMenu;
        editTextPane = new JTextPane(); editTextPane.setEditable(false);
        editTextPane.addMouseListener(mouseListener);
        
        lineNumbers = new JTextPane(); lineNumbers.setEditable(false);
        JPanel extra=new JPanel();
        
        doc=new DefaultStyledDocument(); addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
    	doc.addUndoableEditListener(undoListener);
    	doc.addDocumentListener(documentListener);
        editTextPane.setStyledDocument(doc);
        editTextPane.setEditable(true);
        
        extra.setLayout(new BorderLayout());
        extra.add(lineNumbers,BorderLayout.WEST);
        extra.add(editTextPane,BorderLayout.CENTER);
       
        styleScrollPane = new JScrollPane(extra);        
        styleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.setLayout(new BorderLayout());
        this.add(styleScrollPane,BorderLayout.CENTER);
    }

	// ****************************************************************
	// *** fillTextPane
	// ****************************************************************
    /**
     * Fill the text pane with text from the source file reader.
     * @param reader the source file reader
     * @param caretPosition argument
     */
    void fillTextPane(Reader reader,int caretPosition) {
    	switch(lang) {
			case Simula: fillTextPane(caretPosition,new SimulaScanner(reader,true)); break;
//			case Java:   fillTextPane(caretPosition,new DefaultScanner(reader)); break;
			default:     fillTextPane(caretPosition,new DefaultScanner(reader)); break;
    	}
    }
    
	// ****************************************************************
	// *** fillTextPane
	// ****************************************************************
    /**
     * Fill the text pane with text delivered from the scanner.
     * @param caretPosition the caretPosition after the operations
     * @param preScanner the scanner to use
     */
    private void fillTextPane(int caretPosition,DefaultScanner preScanner) {
		int lineNumber=1;
		StyledDocument lin=new DefaultStyledDocument(); addStylesToDocument(lin);
        editTextPane.setEditable(false);
    	doc.removeUndoableEditListener(undoListener);
		try {
			Token token;
			doc.remove(0, doc.getLength());
			lin.insertString(lin.getLength(),edLineNumber(lineNumber++),styleLineNumber);
			while((token=preScanner.nextToken())!=null) {
			    String text=token.getText();
			    Style style=getStyle(token.getStyleCode());
				StringTokenizer tokenizer=new StringTokenizer(text,"\n",true);
				while(tokenizer.hasMoreTokens()) {
					String item=tokenizer.nextToken();
					if(item.equals("\n"))
						lin.insertString(lin.getLength(),edLineNumber(lineNumber++), styleLineNumber);
					doc.insertString(doc.getLength(), item, style);
				}
		    }
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert text into text pane.");
		}
		if(lineNumber>500) this.AUTO_REFRESH=false;
		lineNumbers.setStyledDocument(lin);
    	doc.addUndoableEditListener(undoListener);
        editTextPane.setEditable(true);
	    editTextPane.setCaretPosition(caretPosition);
    }

	// ****************************************************************
	// *** doRefresh
	// ****************************************************************
    /**
     * Do refresh action.
     */
	void doRefresh() {
	    int pos=editTextPane.getCaretPosition();
	    String txt=editTextPane.getText();
	    if(!txt.endsWith("\n")) txt=txt+'\n';
	    int count=countExtraControlCharacters(txt,pos);
    	int maxCaret=txt.length()-1;
    	if(pos>maxCaret) pos=maxCaret;
    	if(pos<0) pos=0;
	    fillTextPane(new StringReader(txt),pos+count);
	}
    
	// ****************************************************************
	// *** Utilities
	// ****************************************************************
	/**
	 * Utility: Edit right justified line number string.
	 * 
	 * @param n the length of line number field
	 * @return the resulting line number string
	 */
    private String edLineNumber(int n) {
	    String fill="";
	    if(n<10) fill="   ";
	    else if(n<100) fill="  ";
	    else if(n<1000) fill=" ";
    	return(fill+n+": \n");
    }
	
    /**
     * Utility: Count extra control characters in the given string
     * @param s the given string
     * @param pos limitin position in s
     * @return the resulting number of control characters
     */
	private int countExtraControlCharacters(final String s,int pos) {
		int count=0;
		for(int i=0;i<pos;i++) {
			if(s.charAt(i)=='\r') { count++; pos++; }
		}
		return(count);
	}
    
	/**
	 * Utility: Get Style
	 * @param code style code
	 * @return the resuting Style
	 */
    private Style getStyle(final Token.StyleCode code) {
    	switch(code) {
    		case regular: return(styleRegular);
    		case keyword: return(styleKeyword);
    		case comment: return(styleComment);
    		case constant: return(styleConstant);
//    		case XlineNumber: return(styleLineNumber);
    	}
    	return(null);
    }
    
    /**
     * Add Styles to the document.
     * @param doc the document
     */
    private void addStylesToDocument(final StyledDocument doc) {
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
    
    @Override
    public String toString() {
    	String s="SourceTextPanel(";
        s=s+((sourceFile==null)?"unnamed":sourceFile.getName());
    	if(this.AUTO_REFRESH) s=s+",AUTO_REFRESH";
    	s=s+')';
    	return(s);
    }
 
}

