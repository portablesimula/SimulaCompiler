/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * The class "outbytefile".
 * 
 * <pre>
 *  bytefile class outbytefile;
 *     begin
 *           Boolean procedure open;
 *           Boolean procedure close;
 *           procedure outbyte(x); short integer x;
 *           procedure outtext(t); text t;
 *           Boolean procedure checkpoint;
 * 
 *  end outbytefile;
 * </pre>
 * 
 * An object of the class "outbytefile" is used to represent a sequential output
 * file of bytes.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class _OutByteFile extends _ByteFile {
	private OutputStream outputStream;

	// Constructor
    public _OutByteFile(final _RTObject staticLink,final _TXT FILENAME) {
    	super(staticLink,FILENAME);
		//System.out.println("new _OutbyteFile: FILE_NAME="+FILE_NAME);
    }
    
    // Class Statements
    public _OutByteFile _STM() {
        if(FILE_NAME==null)	throw new _SimulaRuntimeError("Illegal File Name: null");
        EBLK();
        return(this);
    }

	public boolean open() {
		if(_RT.DEBUGGING) TRACE_OPEN("Open OutByteFile");
		if (_OPEN) return (false);
		if (FILE_NAME.edText().equalsIgnoreCase("sysout"))
			outputStream = System.out;
		else {
			//System.out.println("_OutbyteFile.open: FILE_NAME="+FILE_NAME);
			File file=doCreateAction(new File(FILE_NAME.edText()));
			try {
				outputStream = new FileOutputStream(file);
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				return (false);
			} catch (_SimulaRuntimeError e) {
				//e.printStackTrace();
				return (false);
			}
		}
		_OPEN = true;
		_BYTESIZE =8;
		return (true);
	}

	public boolean close() {
		if (_OPEN) {
			_OPEN = false;
			doPurgeAction();
			return (true);
		}
		return (false);
	}

	public void outbyte(final int b) {
//		TRC("outbyte",""+b);
		if (!_OPEN)	throw new _SimulaRuntimeError("file closed");
		if (b < 0 || b >= (Math.pow(2,_BYTESIZE)))
			throw new _SimulaRuntimeError("Illegal byte value");
		try {
			outputStream.write(b);
		} catch (IOException e) {
			throw new _SimulaRuntimeError("Outbyte failed", e);
		}
	}

	public void out2byte(final int b) {
//		TRC("out2byte",""+b);
		if (!_OPEN)
			throw new _SimulaRuntimeError("file closed");
		try {
			int hi=b>>8;
			int lo=b&0xFF;
//	    	System.out.println("out2byte: "+b+" ==> hi="+hi+", lo="+lo);
			outputStream.write(hi);
			outputStream.write(lo);
		} catch (IOException e) {
			throw new _SimulaRuntimeError("Out2byte failed", e);
		}
	}

	public void outtext(final _TXT t) {
//		TRC("outtext",""+t.edText());
		_TXT.setpos(t, 1);
		while (_TXT.more(t)) {
			outbyte((int) _TXT.getchar(t));
		}
	}
	
    private void TRC(String m, String v) {
    	//if(Option.TRACE_CODING > 1) {
    	String name=new File(FILE_NAME.edText()).getName();
    	System.out.println(name+"   "+m+":  "+v);
    	Thread.dumpStack();
    }

	public boolean checkpoint() {
		return (false);
	}
}
