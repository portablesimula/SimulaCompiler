/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

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
public class InbyteFile$ extends ByteFile$ {
	boolean ENDFILE$;
	InputStream inputStream;
	// Constructor
    public InbyteFile$(RTObject$ staticLink,TXT$ FILENAME) {
      super(staticLink,FILENAME);
 	  TRACE_BEGIN_DCL$("InbyteFile$");
      CODE$=new ClassBody(CODE$,this,2) {
         public void STM() {
       	    TRACE_BEGIN_STM$("InbyteFile$",inner);
            ENDFILE$=true;
            if(inner!=null) inner.STM();
            TRACE_END_STM$("InbyteFile$");
      }};
    }
    // Class Statements
    public InbyteFile$ STM() { return((InbyteFile$)CODE$.EXEC$()); }
    public InbyteFile$ START() { START(this); return(this); }

	/**
	 * 
	 * @return true if there are no more bytes to read.
	 */
	public boolean endfile() {
		return (ENDFILE$);
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
		if (OPEN$)
			return (false);
		try {
			inputStream = new FileInputStream(FILENAME$.edText());
		} catch (FileNotFoundException e) {
			OPEN$=false;
			//Util.BREAK("INBYTEFILE.OPEN: "+FILENAME$.edText()+", Returns "+OPEN$);
			return (false);
		}
		OPEN$ = true;
		BYTESIZE$ = (short) 8;
		ENDFILE$ = false;
		//Util.BREAK("INBYTEFILE.OPEN: "+FILENAME$.edText()+", Returns "+OPEN$);
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
		if (OPEN$) {
			OPEN$ = false;
			ENDFILE$ = true;
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
	public short inbyte() {
		if (ENDFILE$)
			throw new RuntimeException(
					"File not opened or attempt to read past EOF");
		try {
			// read a single byte
			int b = inputStream.read();
			//Util.TRACE("InbyteFile.inbyte: read byte: +" + b);
			if (b == -1) {
				ENDFILE$ = true;
				return (0);
			}
			return ((short) b);
		} catch (IOException e) {
			throw new RuntimeException("Inbyte failed", e);
		}
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
	public TXT$ intext(TXT$ t) {
		t.setpos(1);
		while (t.more() & (!ENDFILE$)) {
			t.putchar((char) inbyte());
		}
		if (ENDFILE$) {
			t.setpos(t.pos() - 1);
		}
		return (t.sub(1, t.pos() - 1));
	}

}
