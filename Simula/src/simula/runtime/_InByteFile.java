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
 * The class "inbytefile"
 * 
 * <pre>
 *  bytefile class inbytefile;
 *           begin Boolean ENDFILE;
 *           Boolean procedure endfile;  endfile:= ENDFILE;
 *           Boolean procedure open;
 *           Boolean procedure close; 
 *           short integer procedure inbyte; 
 *           text procedure intext(t);   text t;
 * 
 *           ENDFILE:= true;
 *           ...
 *        end inbytefile;
 * </pre>
 * 
 * An object of the class "inbytefile" is used to represent a byte-oriented
 * sequential input file.
 * <p>
 * Variable "ENDFILE" is true if there are no more bytes to read. The procedure
 * "endfile" returns the value of ENDFILE.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class _InByteFile extends _ByteFile {
	protected boolean _ENDFILE=true;
	private InputStream inputStream;
	
	// Constructor
    public _InByteFile(final _RTObject staticLink,final _TXT FILENAME) {
    	super(staticLink,FILENAME);
    }
    
    // Class Statements
    public _InByteFile _STM() {
        EBLK();
        return(this);
    }

    /**
	 * 
	 * @return true if there are no more bytes to read.
	 */
	public boolean endfile() {
		return (_ENDFILE);
	}

	/**
	 * <pre>
	 * Boolean procedure open;
	 *    if ... then begin ...  
	 *       ENDFILE  := false;
	 *       BYTESIZE := ... ! value of access mode BYTESIZE;
	 *       open     := OPEN := true;
	 * end open;
	 * </pre>
	 * 
	 * @return
	 */
	public boolean open() {
		if(_RT.DEBUGGING) TRACE_OPEN("Open InByteFile");
		if (_OPEN) return (false);
		File file=doCreateAction(new File(FILE_NAME.edText()));
		if(!file.exists()) {
			//File selected=popupFileSelector("Can't Open "+file+", select another");
			File selected=trySelectFile(file.toString());
			if(selected!=null) file=selected;				
		}
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			_OPEN=false;
			//_RT.BREAK("INBYTEFILE.OPEN: "+FILE_NAME.edText()+", Returns "+_OPEN);
			return (false);
		}
		_OPEN = true;
		_BYTESIZE = 8;
		_ENDFILE = false;
		//_RT.BREAK("INBYTEFILE.OPEN: "+FILE_NAME.edText()+", Returns "+_OPEN);
		return (true);
	}

	/**
	 * <pre>
	 * Boolean procedure close;
	 *    if OPEN then begin ... ! see 10.1.2;
	 *       ... ;
	 *       OPEN  := false;
	 *       close := ENDFILE := true;
	 * end close;
	 * </pre>
	 * 
	 * @return
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
	 * <pre>
	 * short integer procedure inbyte;
	 *    if ENDFILE then error("..." ! End of file ;)
	 *    else if ... ! no more bytes to read;
	 *    then ENDFILE := true  ! inbyte returns zero;
	 *    else inbyte  := ...! next byte of size BYTESIZE;
	 * </pre>
	 * 
	 * The procedure "inbyte" returns the short integer value corresponding to
	 * the input byte. If there are no more bytes to read, a zero result is
	 * returned. If prior to an "inbyte" call ENDFILE is true, a run-time error
	 * occurs.
	 * 
	 * @return
	 */
	public int inbyte() {
		if (_ENDFILE)
			throw new _SimulaRuntimeError(FILE_NAME.edText()+": File not opened or attempt to read past EOF");
		try {
			// read a single byte
			int b = inputStream.read();
			//_RT.TRACE("InbyteFile.inbyte: read byte: +" + b);
			if (b == -1) {
				_ENDFILE = true;
				return (0);
			}
			return(b);
		} catch (IOException e) {
			throw new _SimulaRuntimeError("Inbyte failed", e);
		}
	}
	
    
    public int in2byte() {
    	//_RT.NOT_IMPLEMENTED("in2byte"); // TODO: Implement it
    	int b1=inbyte();
    	int b2=inbyte();
    	int res=((b1<<8) | b2);
//    	System.out.println("in2byte: b1="+b1+", b2="+b2+" ==> "+res);
    	return(res);
    }


	/**
	 * <pre>
	 * text procedure intext(t);   text t;
	 *            begin
	 *               t.setpos(1);
	 *               while t.more and not ENDFILE do t.putchar(char(inbyte));
	 *               if ENDFILE then t.setpos(t.pos-1);
	 *               intext:- t.sub(1,t.pos-1)
	 *            end intext;
	 * </pre>
	 * 
	 * The procedure "intext" fills the frame of the parameter "t" with
	 * successive input bytes.
	 * 
	 * @param t
	 * @return
	 */
	public _TXT intext(final _TXT t) {
		_TXT.setpos(t, 1);
		while (_TXT.more(t) & (!_ENDFILE)) {
			_TXT.putchar(t, (char) inbyte());
		}
		if (_ENDFILE) {
			_TXT.setpos(t, _TXT.pos(t) - 1);
		}
		return (_TXT.sub(t, 1, _TXT.pos(t) - 1));
	}

}
