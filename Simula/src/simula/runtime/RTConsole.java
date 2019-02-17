package simula.runtime;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.*;

public final class RTConsole {
    private final JFrame frame;
    private final JTextArea textArea;
	private boolean reading;
	private Reader consoleReader;
        
    public RTConsole() {
    	frame=new JFrame();
        frame.setSize(800, 500); // Initial frame size
        frame.setTitle("Runtime Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    	JScrollPane scrollPane;
		textArea = new JTextArea();
		textArea.setEditable(false);
		int fontSize = 12;
		textArea.setFont(new Font("Courier New", Font.PLAIN, fontSize));
		textArea.setText("");
		scrollPane = new JScrollPane(textArea);
        textArea.addKeyListener(listener);
	
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

	public void write(String s) {
		textArea.append(s);
		textArea.setCaretPosition(textArea.getDocument().getLength());
//	    textArea.repaint();
		textArea.update(textArea.getGraphics());
	}
	
    public Writer getWriter() { return(new Writer() {
    	public void write(char[] cbuf, int off, int len) throws IOException {
    		RT.console.write(new String(cbuf,off,len));	}
    	public void flush() throws IOException {}
    	public void close() throws IOException {}
    });};

    /**
     * Reads characters into a portion of an array.
     * This method will block until some input is available, an I/O error occurs, or the end of the stream is reached.
     * 
     * @param cbuf Destination buffer
     * @param off Offset at which to start storing characters
     * @param len Maximum number of characters to read
     * @return The number of characters read, or -1 if the end of the stream has been reached
     * @throws IndexOutOfBoundsException If off is negative, or len is negative, or len is greater than cbuf.length - off
     * @throws IOException If an I/O error occurs
     */
	public int read(char[] cbuf, int off, int len) throws IOException {
		reading=true;
		int firstPos=textArea.getCaretPosition();
		textArea.setEditable(true);
		textArea.getCaret().setVisible(true);
		while(reading) Thread.yield();
		textArea.getCaret().setVisible(false);
		textArea.setEditable(false);
		String input=textArea.getText().substring(firstPos);
		int pos=0;
		for(char c:input.toCharArray()) cbuf[off+(pos++)]=c;
		return(pos);
	}

	public Reader getReader() {
		if (consoleReader == null) {
			consoleReader = new Reader() {
				public int read(char[] cbuf, int off, int len) throws IOException {
					return (RT.console.read(cbuf, off, len));
				}
				public void close() throws IOException {}
			};
		}
		return (consoleReader);
	};
    
    private KeyListener listener = new KeyListener() {
    	public void keyTyped(KeyEvent event) {}
    	public void keyPressed(KeyEvent event) {}
    	public void keyReleased(KeyEvent event) {
    	    if(reading) {
    	    	char c=event.getKeyChar();
       	    	if(c=='\n') reading=false;
    	    }
    	}
    };

    
}