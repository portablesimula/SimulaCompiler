/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

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
public class OutbyteFile$ extends ByteFile$ {
	private OutputStream outputStream;

	// Constructor
    public OutbyteFile$(final RTObject$ staticLink,final TXT$ FILENAME) {
    	super(staticLink,FILENAME);
		//System.out.println("new OutbyteFile$: FILENAME$="+FILENAME$);
    }
    
    // Class Statements
    public OutbyteFile$ STM$() {
        if(FILENAME$==null)	throw new SimulaRuntimeError("Illegal File Name: null");
        EBLK();
        return(this);
    }

	public boolean open() {
		if (OPEN$) return (false);
		if (FILENAME$.edText().equalsIgnoreCase("sysout"))
			outputStream = System.out;
		else {
			//System.out.println("OutbyteFile$.open: FILENAME$="+FILENAME$);
			doCreateAction();
			try {
				outputStream = new FileOutputStream(FILENAME$.edText());
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				return (false);
			} catch (SimulaRuntimeError e) {
				//e.printStackTrace();
				return (false);
			}
		}
		OPEN$ = true;
		BYTESIZE$ =8;
		return (true);
	}

	public boolean close() {
		if (OPEN$) {
			OPEN$ = false;
			doPurgeAction();
			return (true);
		}
		return (false);
	}

	public void outbyte(final int b) {
		if (!OPEN$)	throw new SimulaRuntimeError("file closed");
		if (b < 0 || b >= (Math.pow(2,BYTESIZE$)))
			throw new SimulaRuntimeError("Illegal byte value");
		try {
			outputStream.write(b);
		} catch (IOException e) {
			throw new SimulaRuntimeError("Outbyte failed", e);
		}
	}

	public void out2byte(final int b) {
		if (!OPEN$)
			throw new SimulaRuntimeError("file closed");
		try {
			int hi=b>>8;
			int lo=b&0xFF;
//	    	System.out.println("out2byte: "+b+" ==> hi="+hi+", lo="+lo);
			outputStream.write(hi);
			outputStream.write(lo);
		} catch (IOException e) {
			throw new SimulaRuntimeError("Out2byte failed", e);
		}
	}

	public void outtext(final TXT$ t) {
		TXT$.setpos(t, 1);
		while (TXT$.more(t)) {
			outbyte((int) TXT$.getchar(t));
		}
	}

	public boolean checkpoint() {
		return (false);
	}
}
