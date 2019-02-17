package simula.compiler.editor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import simula.compiler.parsing.SimulaScanner;
import simula.compiler.utilities.Global;
import simula.compiler.utilities.Token;
import simula.compiler.utilities.Util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.StringTokenizer;

public class SourceTextPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextPane textPane;
	public File sourceFile;
	private boolean isEditable;
    public boolean RENDER_LINE_NUMBERS=true;
    public boolean AUTO_REFRESH=false;
 	
	private Style styleRegular;
	private Style styleKeyword;
	private Style styleComment;
	private Style styleConstant;
	private Style styleLineNumber;
	
    public boolean fileChanged = false;
    public boolean refreshNeeded = false;
    
    public String toString() {
    	String s="SourceTextPanel(";
        s=s+((sourceFile==null)?"unnamed":sourceFile.getName());
    	if(this.isEditable) s=s+",isEditable";
    	if(this.RENDER_LINE_NUMBERS) s=s+",RENDER_LINE_NUMBERS";
    	if(this.AUTO_REFRESH) s=s+",AUTO_REFRESH";
    	s=s+')';
    	return(s);
    }

    DocumentListener documentListener=new DocumentListener() {
		public void insertUpdate(DocumentEvent e) {
			//Util.println("DocumentListener: insertUpdate'event="+edDocumentEvent(e));	
			fileChanged=true; refreshNeeded=true;
		}
		public void removeUpdate(DocumentEvent e) {
			//Util.println("DocumentListener: removeUpdate'event="+edDocumentEvent(e));	
			fileChanged=true; refreshNeeded=true;
		}
		public void changedUpdate(DocumentEvent e) {
			//Util.println("DocumentListener: changedUpdate'event="+edDocumentEvent(e));	
	}};
	
//	private String edDocumentEvent(DocumentEvent e) {
//		return("DocumentEvent: "+e.getType()+'['+e.getOffset()+':'+e.getLength()+']');
//	}
	
    public SourceTextPanel(File sourceFile) {
    	this.sourceFile=sourceFile;
        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setLayout(new BorderLayout());
        this.add(scrollPane);
    }

    public boolean isEditable() {
    	return(isEditable);
    }

    public void setEditable(Boolean on) {
    	this.isEditable=on;
    	this.RENDER_LINE_NUMBERS= !on;
    	this.AUTO_REFRESH=on;
    	textPane.setEditable(on);
    	doRefresh();
    }
    
    public void updateEditable() {
		Util.println("SourceTextPanel.updateEditable: CurrentTextPanel="+this);
		boolean auto=this.AUTO_REFRESH;
		setEditable(isEditable);
    	this.AUTO_REFRESH=auto;
    }

    public JTextPane getTextPane() {
    	return(textPane); 
    }
    
    public String getPureText() {
       	String text=textPane.getText();
	    if(RENDER_LINE_NUMBERS) text=removeLineNumbers(text);
	    return(text);
    }
	
    void saveFile() {
		//Util.println("SourceTextPanel.saveFile: sourceFile="+sourceFile+", fileChanged="+fileChanged);
    	if(fileChanged)	try {
    		//simulaEditor.setTitle(sourceFile.getName() + " - " + "SimulaEditor");
    		//Util.println("SourceTextPanel.saveFile: DO IT - sourceFile="+sourceFile);
    		
    		//Writer writer = new FileWriter(outputFile);
    		Writer writer=new OutputStreamWriter(new FileOutputStream(sourceFile.getPath()),Global.CHARSET$);
    		BufferedWriter out = new BufferedWriter(writer);

    		String text=getPureText();
    		//Util.println(text);
    		out.write(text);
    		out.close();
    		fileChanged = false;
    	} catch (Exception ex) { // again, catch any exceptions and...
    		// ...write to the debug console
    		System.err.println(ex.getMessage());
    	}
    }

    
    public void newTextPane() {
        StyledDocument doc=new DefaultStyledDocument();
        addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
		//Util.println("SourceTextPanel.fillTextPane: Create Document: END");
		textPane.setStyledDocument(doc);
		doc.addDocumentListener(documentListener);
		setEditable(true);
    }

    public void fillTextPane(Reader reader) {
        StyledDocument doc=new DefaultStyledDocument();
        addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
        SimulaScanner preScanner=new SimulaScanner(reader,true);
		try {
			Token token;
			if(RENDER_LINE_NUMBERS) {
				int lineNumber=1;
				doc.insertString(doc.getLength(),edLineNumber(lineNumber++),styleLineNumber);
				Token next=preScanner.nextToken();
				LOOP:while((token=next)!=null) {
					next=preScanner.nextToken();
					String text=token.getText();
					Style style=getStyle(token.getStyleCode());
					if(next==null && text.equals("\n")) break LOOP;
					StringTokenizer tokenizer=new StringTokenizer(text,"\n",true);
					while(tokenizer.hasMoreTokens()) {
						String item=tokenizer.nextToken();
						if(item.equals("\n")) {
							String lineStart="\n"+edLineNumber(lineNumber++);
							doc.insertString(doc.getLength(),lineStart, styleLineNumber);
//							lastStringInserted=lineStart;
						} else {
							doc.insertString(doc.getLength(), item, style);
//							lastStringInserted=item;
						}
					}
				}
			} else {
			    while((token=preScanner.nextToken())!=null) {
				    String text=token.getText();
				    Style style=getStyle(token.getStyleCode());
				    //Util.println("SourceTextPanel.fillTextPane: INSERT: "+text);
				    doc.insertString(doc.getLength(), text, style);
			    }
			}
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert text into text pane.");
		}
		textPane.setStyledDocument(doc);
		doc.addDocumentListener(documentListener);
    }

    
    private String edLineNumber(int n) {
	    String fill="";
	    if(n<10) fill="   ";
	    else if(n<100) fill="  ";
	    else if(n<1000) fill=" ";
    	return(fill+n+": ");
    }

    
	void doRefresh() {
	    int pos=textPane.getCaretPosition();
	    String txt=textPane.getText();
	    txt=removeLineNumbers(txt);
	    fillTextPane(new StringReader(txt));
	    int count=countExtraControlCharacters(textPane.getText(),pos);
	    textPane.setCaretPosition(pos+count);
	}
	
	private int countExtraControlCharacters(String s,int pos) {
		int count=0;
		for(int i=0;i<pos;i++) {
//			if(s.charAt(i)=='\n') { count++; pos++; }
			if(s.charAt(i)=='\r') { count++; pos++; }
			if(s.charAt(i)<' ' && s.charAt(i)!='\n' && s.charAt(i)!='\r') Util.println("ControlCharacter: "+(int)s.charAt(i));
		}
		return(count);
	}

	
	private String removeLineNumbers(String txt) {
		StringBuilder result=new StringBuilder();
		LineNumberReader reader=new LineNumberReader(new StringReader(txt));
		//Util.println("SourceTextPanel.removeLineNumbers:");
		try {
			String nextLine=reader.readLine();
			String line;
			while( (line=nextLine)!=null) {
				nextLine=reader.readLine();			
				//Util.println("SourceTextPanel.removeLineNumbers: INPUT:  \""+line+'"');
				line=removeLineNumber(line);
				//Util.println("SourceTextPanel.removeLineNumbers: OUTPUT: \""+line+'"');
				if(nextLine!=null) result.append(line).append('\n');
				else if(line.trim().length()>0) result.append(line).append('\n');
			}
		} catch(IOException e) {}
		return(result.toString());
	}

	private String removeLineNumber(String line) {
		int lng = line.length();
		int pos = 0;
		int state = 0; // 0:init, 1:DigitSeen
		while (pos < lng) {
			char c = line.charAt(pos++);
			switch (state) {
			case 0: // Skipping Blanks
				if (c == ' ') break;
				if (c >= '0' && c <= '9') state = 1;
				else return (line); // No preceding line number
				break;
			case 1: // Skipping Digits
				if (c >= '0' && c <= '9') break;
				if (c != ':') return (line); // No preceding line number
				// Line number found - remove it
				return (line.substring(pos+1));
			}
		}
		return (line); // Unchanged
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
        
//        SimpleAttributeSet black = new SimpleAttributeSet();
//        StyleConstants.setForeground(black, Color.black);
//        StyleConstants.setFontFamily(black, "Courier");
//        StyleConstants.setFontSize(black, 11);
 
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

