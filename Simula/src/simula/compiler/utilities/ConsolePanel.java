/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.compiler.utilities;

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

/**
 * a Console panel.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/compiler/utilities/ConsolePanel.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 */
@SuppressWarnings("serial")
public final class ConsolePanel extends JPanel {

	/**
	 * The text pane.
	 */
	private static JTextPane textPane;

	/**
	 * the StyledDocument showed in this panel
	 */
	private StyledDocument doc;

	/**
	 * Regular style
	 */
	private Style styleRegular;

	/**
	 * Warning style
	 */
	private Style styleWarning;

	/**
	 * Error style
	 */
	private Style styleError;

	/**
	 * the Popup Menu
	 */
	private JPopupMenu popupMenu;

	/**
	 * Menu item clear
	 */
	private JMenuItem clearItem;

	/**
	 * Menu item copy
	 */
	private JMenuItem copyItem;

	/**
	 * Used by KeyListener and read()
	 */
	private boolean reading;

	/**
	 * Used by KeyListener and read()
	 */
	private char keyin;

//	private Reader consoleReader;

	/**
	 * Reads a single character.
	 * 
	 * @return The character read
	 */
	char read() {
		textPane.requestFocus();
		reading = true; // Enables KeyListener (see below)
		while (reading)
			Thread.yield();
		return (keyin);
	}

//	/**
//	 * Get a reader suitable for reading from this panel
//	 * @return a reader
//	 */
//	private Reader getReader() {
//		if (consoleReader == null) {
//			consoleReader = new Reader() {
//				public int read(final char[] cbuf,final int off,final int len) throws IOException {
//					int firstPos=textPane.getCaretPosition();
//					textPane.setEditable(true);
//					while(ConsolePanel.this.read() != '\n');
//					textPane.setEditable(false);
//					String input=textPane.getText().substring(firstPos);
//					int pos=0;
//					for(char c:input.toCharArray()) cbuf[off+(pos++)]=c;
//					return(pos);
//				}
//				@Override
//				public void close() throws IOException {}
//			};
//		}
//		return (consoleReader);
//	}
	
	/**
	 * Get a OutputStream suitable for writing on this panel
	 * 
	 * @return a OutputStream
	 */
	public OutputStream getOutputStream() {
		return (new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				String s = "" + (char) b;
				ConsolePanel.this.write(s, styleRegular);
			}
		});
	}

//	/**
//	 * Get a writer suitable for writing on this panel
//	 * @return a writer
//	 */
//	private Writer getWriter() {
//		return(new Writer() {
//			@Override
//			public void write(String s) {
//				ConsolePanel.this.write(s);		
//			}
//			public void write(char[] cbuf, int off, int len) throws IOException {
//				ConsolePanel.this.write(new String(cbuf,off,len));
//			}
//			public void flush() throws IOException {}
//			public void close() throws IOException {}
//		});
//	}

	/**
	 * Get a OutputStream suitable for writing errors on this panel
	 * 
	 * @return a OutputStream
	 */
	public OutputStream getErrorStream() {
		return (new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				String s = "" + (char) b;
				ConsolePanel.this.write(s, styleError);
			}
		});
	}

	/**
	 * Write a string on this panel using styleRegular.
	 * 
	 * @param s a string to write
	 */
	public void write(final String s) {
		write(s, styleRegular);
	}

	/**
	 * Write a string on this panel using styleError.
	 * 
	 * @param s a string to write
	 */
	void writeError(final String s) {
		write(s, styleError);
	}

	/**
	 * Write a string on this panel using styleWarning.
	 * 
	 * @param s a string to write
	 */
	void writeWarning(final String s) {
		write(s, styleWarning);
	}

	/**
	 * Write a string onto this Console.
	 * 
	 * @param s     the string to write
	 * @param style the style
	 */
	private void write(final String s, final Style style) {
		try {
			doc.insertString(doc.getLength(), s, style);
		} catch (BadLocationException e) {
			IERR("Impossible", e);
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	/**
	 * Clear the Console.
	 */
	private void clear() {
		try {
			doc.remove(0, doc.getLength());
		} catch (BadLocationException e) {
			IERR("Impossible", e);
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
		textPane.update(textPane.getGraphics());
	}

	/**
	 * Utility method IERR
	 * 
	 * @param msg error message
	 * @param e   the underlying cause
	 */
	private static void IERR(final String msg, final Throwable e) {
		System.out.println("IERR: " + msg + "  " + e);
		e.printStackTrace();
	}

	/**
	 * Create a new ConsolePanel.
	 */
	public ConsolePanel() {
		super(new BorderLayout());
		JScrollPane scrollPane;
		textPane = new JTextPane();
		textPane.addMouseListener(mouseListener);
		scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		doc = new DefaultStyledDocument();
		addStylesToDocument(doc);
		doc.putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
		textPane.setStyledDocument(doc);
		textPane.addKeyListener(listener);
		textPane.setEditable(false);
		popupMenu = new JPopupMenu();
		clearItem = new JMenuItem("Clear Console");
		// clearItem.setAccelerator(KeyStroke.getKeyStroke('X',
		// InputEvent.CTRL_DOWN_MASK));
		popupMenu.add(clearItem);
		clearItem.addActionListener(actionListener);
		copyItem = new JMenuItem("Copy to Clipboard");
		copyItem.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
		popupMenu.add(copyItem);
		copyItem.addActionListener(actionListener);
		this.add(scrollPane);
	}

	/**
	 * popup this Console Panel
	 */
	public void popup() {
		JFrame frame = new JFrame();
		frame.setSize(950, 500); // Initial frame size
		frame.setTitle("Runtime Console");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(this);
		frame.setVisible(true);
	}

	/**
	 * Utility to add styles to the document
	 * 
	 * @param doc the document
	 */
	private void addStylesToDocument(final StyledDocument doc) {
		Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

		Style regular = doc.addStyle("regular", defaultStyle);
		StyleConstants.setFontFamily(defaultStyle, "Courier New");

		Style s = doc.addStyle("warning", regular);
		StyleConstants.setItalic(s, true);
		StyleConstants.setForeground(s, new Color(255, 153, 0));

		s = doc.addStyle("error", regular);
		StyleConstants.setBold(s, true);
		StyleConstants.setForeground(s, Color.RED);

		styleRegular = doc.getStyle("regular");
		styleWarning = doc.getStyle("warning");
		styleError = doc.getStyle("error");
	}

	// ****************************************************************
	// *** MouseListener
	// ****************************************************************
	/**
	 * the MouseListener
	 */
	MouseListener mouseListener = new MouseListener() {
		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == 3)
				popupMenu.show(textPane, e.getX(), e.getY());
		}
	};

	// ****************************************************************
	// *** ActionListener
	// ****************************************************************
	/**
	 * the ActionListener
	 */
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object item = e.getSource();
			if (item == clearItem)
				clear();
			else if (item == copyItem) {
				String text = textPane.getSelectedText();
				if (text == null)
					text = textPane.getText();
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		}
	};

	// ****************************************************************
	// *** KeyListener
	// ****************************************************************
	/**
	 * the KeyListener
	 */
	private KeyListener listener = new KeyListener() {
		public void keyPressed(KeyEvent event) {
		}

		public void keyReleased(KeyEvent event) {
		}

		public void keyTyped(KeyEvent event) {
			if (reading) {
				keyin = event.getKeyChar();
				reading = false;
			}
		}
	};

}