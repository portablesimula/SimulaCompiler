/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * The class file.
 * <p>
 * 
 * <pre>
 *    class file(FILENAME);  value FILENAME;  text FILENAME;
 *    begin Boolean OPEN;
 *       text procedure filename;  filename :- copy(FILENAME);
 *       Boolean procedure isopen; isopen := OPEN;
 *       Boolean procedure setaccess(mode);  text mode; ... 10.1.1;
 * 
 *       if FILENAME = notext then error("...");
 *    end file;
 * </pre>
 * <p>
 * "File" is the common prefix class for all input/output classes.
 * <p>
 * A file is either open or inaccessible as indicated by the variable "OPEN".
 * The procedure "isopen" returns the current value of "OPEN". A file is
 * initially inaccessible (e.g. closed).
 * <p>
 * Each file object has a text attribute FILENAME. This text value must at
 * "open" identify an external file which, through an implementation-defined
 * mechanism, becomes associated with the file object. If the parameter value is
 * notext, a run-time error occurs.
 * <p>
 * The procedure "filename" retrieves the value of FILENAME.
 * 
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class FILE$ extends CLASS$ {
	// Declare parameters as attributes
	public TXT$ FILENAME$;
	// Declare locals as attributes
	public TXT$ image;
	protected boolean OPEN$;

	// Constructor
   public FILE$(RTObject$ staticLink,TXT$ FILENAME$) {
      super(staticLink);
      BBLK(); // Iff no prefix
 	  TRACE_BEGIN_DCL$("FILE$");
      this.FILENAME$ = FILENAME$;
      // Create Class Body
      CODE$=new ClassBody(CODE$,this,0) {
         public void STM() {
       	    TRACE_BEGIN_STM$("FILE$",inner);
            if(FILENAME$==null) {
    			throw new RuntimeException("Illegal File Name");
            }
            if(inner!=null) inner.STM();
            TRACE_END_STM$("FILE$");
            EBLK(); // Iff no prefix
      }};
   }
   // Class Statements
   public FILE$ STM() { return((FILE$)CODE$.EXEC$()); }
   public FILE$ START() { START(this); return(this); }

	public TXT$ filename() {
		return (copy(FILENAME$));
	}

	public boolean isopen() {
		//RT.BREAK("ISOPEN: "+FILENAME$.edText()+", Returns "+OPEN$);
		return (OPEN$);
	}

	/**
	 * External file access control.
	 * <p>
	 * Certain attributes (not specified in the file outline) control the access
	 * to the external file. The values of these attributes are set when the
	 * file object is opened or closed, from a set of default values possibly
	 * modified by successive calls to the procedure "setaccess".
	 * <p>
	 * The standard attribute modes are SHARED, APPEND, CREATE, READWRITE,
	 * BYTESIZE, REWIND and PURGE.
	 * <p>
	 * The parameter "mode" to procedure "setaccess" contains one of the
	 * standard values as given above, namely "shared", "noshared", "append",
	 * "noappend", "create", "nocreate", "anycreate", "readonly", "writeonly",
	 * "readwrite", "bytesize:X" (where X is a positive integer), "rewind",
	 * "norewind", "purge" and "nopurge".
	 * <p>
	 * It is recommended that implementation-defined parameter values have the
	 * percent character % as the first character of the text.
	 * <p>
	 * Unrecognized modes are ignored and "setaccess" then returns the value
	 * false. The value is true otherwise.
	 * <p>
	 * See <a href="http://simula67.at.ifi.uio.no/Standard-86/">Simula
	 * Standard</a> Chapter 10, INPUT-OUTPUT.
	 * 
	 * @param mode
	 * @return
	 */
	public boolean setaccess(TXT$ mode) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		RT.warning("FILE$("+FILENAME$.edText()+").setaccess("+mode.edText()+") -- is not implemented: ");
		//RT.NOT_IMPLEMENTED("FILE$(FILENAME$).setaccess: "+mode.edText());
		return (false);
	}

}
