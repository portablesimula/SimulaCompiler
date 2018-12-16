package simula.editor;

import java.io.IOException;
import java.io.Writer;

import simula.runtime.RT;

public class ConsoleWriter extends Writer {

    
    /**
     * Writes a portion of an array of characters.
     * 
     * @param cbuf Array of characters
     * @param off Offset from which to start writing characters
     * @param len Number of characters to write
     * @throws IndexOutOfBoundsException If off is negative, or len is negative, or off + len is negative or greater than the length of the given array
     * @throws IOException If an I/O error occurs
     */
	public void write(char[] cbuf, int off, int len) throws IOException {
		RT.console.write(new String(cbuf,off,len));
	}

	public void flush() throws IOException {
	}

	public void close() throws IOException {
	}

}
