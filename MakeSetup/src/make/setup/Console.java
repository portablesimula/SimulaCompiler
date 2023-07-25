/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package make.setup;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

//import simula.compiler.utilities.Global;
//import simula.compiler.utilities.Util;

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
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

/**
 * A Console panel.
 *
 */
public final class Console extends JPanel {
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

	private Reader consoleReader;

//	public static void main(String[] args) {
//		ConsolePanel console=new ConsolePanel();
//		console.popup();
//		console.write("Dette er en tekst\n");
//		Writer writer=console.getWriter();
//		try {
//			writer.write("Her er mere ...\n");
//			writer.flush();
//			Reader reader=console.getReader();
//			int c=reader.read();
//			writer.write("Read: c="+c+", char="+(char)c);
//		} catch (IOException e) { e.printStackTrace(); }
//	}
	
	public char read() {
		//System.out.println("Try Read");
		textPane.requestFocus();
		reading=true; // Enables KeyListener (see below)
		while(reading) Thread.yield();
		//System.out.println("Read: code="+(int)keyin+", CHAR='"+keyin+"'");
		return(keyin);
	}

	public Reader getReader() {
		if (consoleReader == null) {
			consoleReader = new Reader() {
				public int read(final char[] cbuf,final int off,final int len) throws IOException {
					//reading=true;
					int firstPos=textPane.getCaretPosition();
					textPane.setEditable(true);
					//textPane.getCaret().setVisible(true);
					
					//while(reading) Thread.yield();
					while(Console.this.read() != '\n');
					
					//textPane.getCaret().setVisible(false);
					textPane.setEditable(false);
					String input=textPane.getText().substring(firstPos);
					int pos=0;
					for(char c:input.toCharArray()) cbuf[off+(pos++)]=c;
					return(pos);
				}
				@Override
				public void close() throws IOException {}
			};
		}
		return (consoleReader);
	}
	
	public OutputStream getOutputStream() {
		return(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				String s=""+(char)b;
				Console.this.write(s,styleRegular);
			}});
	}
	
	public PrintStream getPrintStream() {
		return(new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				String s=""+(char)b;
				Console.this.write(s,styleRegular);
			}}));
	}

	public Writer getWriter() {
		return(new Writer() {
			public void write(String s) {
				Console.this.write(s);		
			}
			public void write(char[] cbuf, int off, int len) throws IOException {
				Console.this.write(new String(cbuf,off,len));
			}
			public void flush() throws IOException {}
			public void close() throws IOException {}
		});
	}

	public OutputStream getErrorStream() {
		return(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				String s=""+(char)b;
				Console.this.write(s,styleError);
			}});
	}
	
	public void write(final String s) { write(s,styleRegular); }
	public void writeError(final String s) { write(s,styleError); }
	public void writeWarning(final String s) { write(s,styleWarning);	}

	private void write(final String s,final Style style) {
		try {
			doc.insertString(doc.getLength(), s, style);
		} catch (BadLocationException e) {
			Util.IERR("Impossible: "+e);
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
        //Util.BREAK("ConsolePanel.write: done s="+s);
//        System.out.println("ConsolePanel.write: done s=\""+s+"\"");
//	    textPane.repaint();
//		textPane.update(textPane.getGraphics());
	}

	public void clear() {
		try {
			doc.remove(0, doc.getLength());
		} catch (BadLocationException e) {
			Util.IERR("Impossible: "+e);
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
        //Util.BREAK("ConsolePanel.write: done s="+s);
//	    textPane.repaint();
		textPane.update(textPane.getGraphics());
//      Global.console.write(Global.simulaVersion+"\n");
//		write("Simula Compiler Console:\n");
	}

	public Console() {
    	super(new BorderLayout());
    	JScrollPane scrollPane;
    	textPane = new JTextPane();
        textPane.addMouseListener(mouseListener);
    	scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	doc=new DefaultStyledDocument();
    	addStylesToDocument(doc);
    	doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
    	textPane.setStyledDocument(doc);
    	textPane.addKeyListener(listener);
		textPane.setEditable(false);

//    	doc.addDocumentListener(docListener);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
	
	public void popup() {
    	JFrame frame=new JFrame();
//        frame.setSize(800, 500); // Initial frame size
        frame.setSize(950, 500); // Initial frame size
        frame.setTitle("Runtime Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(this);
        frame.setVisible(true);
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
    	public void keyPressed(KeyEvent event) {}
    	public void keyReleased(KeyEvent event) {}
        public void keyTyped(KeyEvent event) {
    	    if(reading) {
    	    	keyin=event.getKeyChar();
       	    	reading=false;
    	    }
    	}
    };


}