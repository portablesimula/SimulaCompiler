package simula.editor;

import java.io.IOException;
import java.io.Reader;

import simula.runtime.RT;

public class ConsoleReader extends Reader {

    
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
		return(RT.console.read(cbuf,off,len));
	}

	public void close() throws IOException {
	}

}
