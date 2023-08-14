/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * System class Inbytefile.
 * 
 * <pre>
 *  bytefile class inbytefile; begin
 *      Boolean ENDFILE;
 *      Boolean procedure endfile;  endfile:= ENDFILE;
 *      Boolean procedure open;
 *      Boolean procedure close; 
 *      short integer procedure inbyte; 
 *      text procedure intext(t);   text t;
 * 
 *      ENDFILE:= true;
 *      ...
 * end inbytefile;
 * </pre>
 * 
 * An object of the class "inbytefile" is used to represent a byte-oriented
 * sequential input file.
 * <p>
 * Variable "ENDFILE" is true if there are no more bytes to read. The procedure
 * "endfile" returns the value of ENDFILE.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Inbytefile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Inbytefile extends RTS_Bytefile {
	
	/**
	 * The InputStream used.
	 */
	private InputStream inputStream;
	
	/**
	 * The variable ENDFILE.
	 */
	protected boolean _ENDFILE = true;

	// Constructor
	/**
	 * Create a new _Inbytefile.
	 * @param SL staticLink
	 * @param FN file name
	 */
	public RTS_Inbytefile(final RTS_RTObject SL, final RTS_TXT FN) {
		super(SL, FN);
	}

	// Class Statements
	@Override
	public RTS_Inbytefile _STM() {
		EBLK();
		return (this);
	}

	/**
	 * Procedure endfile.
	 * <pre>
	 * Boolean procedure endfile;  endfile:= ENDFILE;
	 * </pre>
	 * @return true if there are no more bytes to read.
	 */
	public boolean endfile() {
		return (_ENDFILE);
	}

	/**
	 * Procedure open.
	 * <pre>
	 * Boolean procedure open;
	 *    if ... then begin ...  
	 *       ENDFILE  := false;
	 *       BYTESIZE := ... ! value of access mode BYTESIZE;
	 *       open     := OPEN := true;
	 * end open;
	 * </pre>
	 * 
	 * @return true if the file was successfully opened, otherwise false
	 */
	public boolean open() {
		if (RTS_COMMON.Option.VERBOSE)
			TRACE_OPEN("Open InByteFile");
		if (_OPEN)
			return (false);
		File file = doCreateAction();
		if (!file.exists()) {
			// File selected=popupFileSelector("Can't Open "+file+", select another");
			File selected = trySelectFile(file.toString());
			if (selected != null)
				file = selected;
		}
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			_OPEN = false;
			// _RT.BREAK("INBYTEFILE.OPEN: "+FILE_NAME.edText()+", Returns "+_OPEN);
    		if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (false);
		}
		_OPEN = true;
		_ENDFILE = false;
		_BYTESIZE = _DEFAULT_BYTESIZE;
		// _RT.BREAK("INBYTEFILE.OPEN: "+FILE_NAME.edText()+", Returns "+_OPEN);
		return (true);
	}

	/**
	 * Procedure close.
	 * <pre>
	 * Boolean procedure close;
	 *    if OPEN then begin ... ! see 10.1.2;
	 *       ... ;
	 *       OPEN  := false;
	 *       close := ENDFILE := true;
	 * end close;
	 * </pre>
	 * 
	 * @return false if the file is not open.
	 */
	public boolean close() {
		if (_OPEN) {
			_OPEN = false;
			_ENDFILE = true;
			doPurgeAction();
			return (true);
		}
		return (false);
	}

	/**
	 * Procedure inbyte
	 * <pre>
	 * short integer procedure inbyte;
	 *    if ENDFILE then error("..." ! End of file ;)
	 *    else if ... ! no more bytes to read;
	 *    then ENDFILE := true  ! inbyte returns zero;
	 *    else inbyte  := ...! next byte of size BYTESIZE;
	 * </pre>
	 * 
	 * The procedure "inbyte" returns the short integer value corresponding to the
	 * input byte. If there are no more bytes to read, a zero result is returned. If
	 * prior to an "inbyte" call ENDFILE is true, a run-time error occurs.
	 * 
	 * @return the resulting integer value
	 * @throws RTS_SimulaRuntimeError if inbyte fail
	 */
	public int inbyte() {
		if (_ENDFILE)
			throw new RTS_SimulaRuntimeError(FILE_NAME.edText() + ": File not opened or attempt to read past EOF");
		try {
			// read a single byte
			int b = inputStream.read();
			// _RT.TRACE("InbyteFile.inbyte: read byte: +" + b);
			if (b == -1) {
				_ENDFILE = true;
				return (0);
			}
			return (b);
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("Inbyte failed", e);
		}
	}

	/**
	 * Procedure in2byte.
	 * @return the resulting integer value
	 * @throws RTS_SimulaRuntimeError if intext fail
	 */
	public int in2byte() {
		int b1 = inbyte();
		int b2 = inbyte();
		int res = ((b1 << 8) | b2);
		return (res);
	}

	/**
	 * Procedure intext.
	 * <pre>
	 * text procedure intext(t);   text t;
	 * begin
	 *       t.setpos(1);
	 *       while t.more and not ENDFILE do t.putchar(char(inbyte));
	 *       if ENDFILE then t.setpos(t.pos-1);
	 *       intext:- t.sub(1,t.pos-1)
	 * end intext;
	 * </pre>
	 * 
	 * The procedure "intext" fills the frame of the parameter "t" with successive
	 * input bytes.
	 * 
	 * @param t the text frame to fill
	 * @return the text frame
	 */
	public RTS_TXT intext(final RTS_TXT t) {
		RTS_TXT.setpos(t, 1);
		while (RTS_TXT.more(t) & (!_ENDFILE)) {
			RTS_TXT.putchar(t, (char) inbyte());
		}
		if (_ENDFILE) {
			RTS_TXT.setpos(t, RTS_TXT.pos(t) - 1);
		}
		return (RTS_TXT.sub(t, 1, RTS_TXT.pos(t) - 1));
	}

}
