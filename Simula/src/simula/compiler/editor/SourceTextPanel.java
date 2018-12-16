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
import simula.compiler.utilities.KeyWord;
import simula.compiler.utilities.Token;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SourceTextPanel extends JPanel {
	private static final long serialVersionUID = 1L;
    private static final int EOF_MARK= 25;    // ISO EM(EndMedia) character used to denote end-of-input

	private JTextPane textPane;
	public File sourceFile;
	
	private Style styleRegular;
	private Style styleKeyword;
	private Style styleComment;
	private Style styleConstant;
	private Style styleLineNumber;
	
    public boolean fileChanged = false;
    public boolean refreshNeeded = false;

    DocumentListener documentListener=new DocumentListener() {
		public void insertUpdate(DocumentEvent e) {
			System.out.println("DocumentListener: insertUpdate'event="+e);	
			fileChanged=true; refreshNeeded=true;
		}
		public void removeUpdate(DocumentEvent e) {
			System.out.println("DocumentListener: removeUpdate'event="+e);	
			fileChanged=true; refreshNeeded=true;
		}
		public void changedUpdate(DocumentEvent e) {
			System.out.println("DocumentListener: changedUpdate'event="+e);				
	}};
	
    public SourceTextPanel(File sourceFile) {
    	this.sourceFile=sourceFile;
        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setLayout(new BorderLayout());
        this.add(scrollPane);
    }

    public JTextPane getTextPane() {
    	return(textPane); 
    }
    
    public String getPureText() {
       	String text=textPane.getText();
	    if(SimulaEditor.RENDER_LINE_NUMBERS) text=removeLineNumbers(text);
	    return(text);
    }
	
    void saveFile() {
		System.out.println("SourceTextPanel.saveFile: sourceFile="+sourceFile+", fileChanged="+fileChanged);
    	if(fileChanged)	try {
    		//simulaEditor.setTitle(sourceFile.getName() + " - " + "SimulaEditor");
    		System.out.println("SourceTextPanel.saveFile: DO IT - sourceFile="+sourceFile);
    		BufferedWriter out = new BufferedWriter(new FileWriter(sourceFile.getPath()));
    		String text=getPureText();
    		//System.out.println(text);
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
		//System.out.println("SourceTextPanel.fillTextPane: Create Document: END");
		textPane.setStyledDocument(doc);
		doc.addDocumentListener(documentListener);
    }

    public void fillTextPane(Reader reader) {
        StyledDocument doc=new DefaultStyledDocument();
        addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
        SimulaScanner preScanner=new SimulaScanner(reader,true);
        
//        String lastStringInserted="";
//        Token lastToken=null;
        
		try {
			Token token;
			if(SimulaEditor.RENDER_LINE_NUMBERS) {
				int lineNumber=1;
				doc.insertString(doc.getLength(),edLineNumber(lineNumber++),styleLineNumber);
//				while((token=preScanner.nextToken())!=null) {
				Token next=preScanner.nextToken();
				LOOP:while((token=next)!=null) {
//					lastToken=token;
					next=preScanner.nextToken();
					String text=token.getText();
					Style style=getStyle(token.getStyleCode());
					if(token.getKeyWord()==KeyWord.END) {
						String[] split=splitEndComment(text);
						doc.insertString(doc.getLength(), split[0], style);
						text=split[1]; style=styleComment;
					}
					//System.out.println("SourceTextPanel.fillTextPane: NEXT="+next+" TEXT=\""+text+'"');
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
				    //System.out.println("SourceTextPanel.fillTextPane: INSERT: "+text);
				    doc.insertString(doc.getLength(), text, style);
			    }
			}
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert text into text pane.");
		}
		
//		System.out.println("SourceTextPanel.fillTextPane: LAST TOKEN READ=\""+lastToken+'"');
//		System.out.println("SourceTextPanel.fillTextPane: LAST STRING INSERTED=\""+lastStringInserted+'"');
		
		//System.out.println("SourceTextPanel.fillTextPane: Create Document: END");
		textPane.setStyledDocument(doc);
//		doc.addDocumentListener(new DocumentListener() {
//			public void insertUpdate(DocumentEvent e) {
//				System.out.println("DocumentListener: insertUpdate'event="+e);	
//				fileChanged=true; refreshNeeded=true;
//			}
//			public void removeUpdate(DocumentEvent e) {
//				System.out.println("DocumentListener: removeUpdate'event="+e);	
//				fileChanged=true; refreshNeeded=true;
//			}
//			public void changedUpdate(DocumentEvent e) {
//				System.out.println("DocumentListener: changedUpdate'event="+e);				
//			}});
		doc.addDocumentListener(documentListener);
    }
   
    private String[] splitEndComment(String text) {
    	String[] res=new String[2];
    	for(int i=0;i<text.length();i++) {
    		//System.out.println("SimulaEditor.splitEndComment: i="+i);
    		//System.out.println("SimulaEditor.splitEndComment: text.substring(i,i+3)="+text.substring(i,i+3));
    		if(text.substring(i,i+3).equalsIgnoreCase("end")) {
    			res[0]=text.substring(0, i+3);
    			res[1]=text.substring(i+3);
    			res[1]=res[1].replaceAll(""+(char)EOF_MARK,"");
    			
    			return(res);
    		}
    	}
    	res[0]=text; res[1]="";
    	return(res);
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
	    int count=countNewlines(textPane.getText(),pos);
	    textPane.setCaretPosition(pos+count);
	}

	
	private String removeLineNumbers(String txt) {
		StringBuilder result=new StringBuilder();
		LineNumberReader reader=new LineNumberReader(new StringReader(txt));
		System.out.println("SourceTextPanel.removeLineNumbers:");
		try {
			String nextLine=reader.readLine();
			String line;
			while( (line=nextLine)!=null) {
				nextLine=reader.readLine();			
				//System.out.println("SourceTextPanel.removeLineNumbers: INPUT:  \""+line+'"');
				line=removeLineNumber(line);
				//System.out.println("SourceTextPanel.removeLineNumbers: OUTPUT: \""+line+'"');
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
	
	private int countNewlines(String s,int pos) {
		int count=0;
//		for(int i=0;i<s.length();i++) if(s.charAt(i)=='\n') count++;
		for(int i=0;i<pos;i++) {
//			if(s.charAt(i)=='\n') { count++; pos++; }
			if(s.charAt(i)=='\r') { count++; pos++; }
			if(s.charAt(i)<' ' && s.charAt(i)!='\n' && s.charAt(i)!='\r') System.out.println("ControlCharacter: "+(int)s.charAt(i));
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

