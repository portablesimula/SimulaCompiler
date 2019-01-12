/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.io.IOException;

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
	
	/**
	 * 
	 * The default values of the access modes are given in table 10.1, where "NA"
	 * means "not applicable" (i.e. ignored for this file kind) and "*" means that
	 * the value is implementation-defined. Files of kind
	 * 
	 * <pre>
	 *                       Files of kind
	 *  Mode:        In-        Out-        Direct-   Takes effect at
	 *  SHARED       shared     noshared    noshared     open
	 *  APPEND       NA         noappend    noappend     open
	 *  CREATE       NA         anycreate   nocreate     open
	 *  READWRITE    NA         NA          readwrite    open
	 *  BYTESIZE:x   *          *           *            open
	 *  REWIND       norewind   norewind    NA           open,close
	 *  PURGE        nopurge    nopurge     nopurge      close
	 * </pre>
	 */
	
	/**
	 * CREATE: Action is performed at 'open'
	 * <p>
	 * If the value is "create", the external file associated with FILENAME
	 * must not exist at "open" (if it does, "open" returns false); a new file is
	 * created by the environment. If the value is "nocreate", the associated file
	 * must exist at "open". The value "anycreate" implies that if the file does
	 * exist at "open" the file is opened, otherwise a new file is created.
	 */
	protected enum CreateAction$ {NA, noCreate, create, anyCreate};
	protected CreateAction$ CREATE$=CreateAction$.NA; // May be Redefined
	
	/**
	 * PURGE: Action is performed at 'close'
	 * <p>
	 * The value "purge" implies that the external file may be deleted by the
	 * environment when it is closed (in the sense that it becomes inaccessible to
	 * further program access). The value "nopurge" implies no such deletion.
	 */
	protected boolean PURGE$=false; // True:purge, False:noPurge
	
	//	protected boolean SHARED$;
//	protected boolean APPEND$;
//	protected boolean READWRITE$;
//	protected boolean BYTESIZE$;
//	protected boolean REWIND$;

	// Constructor
   public FILE$(RTObject$ staticLink,TXT$ FILENAME$) {
      super(staticLink);
      BBLK(); // Iff no prefix
 	  TRACE_BEGIN_DCL$("FILE$");
      this.FILENAME$ = FILENAME$;
      // Create Class Body
      CODE$=new ClassBody(CODE$,this,0) {
         public void STM$() {
       	    TRACE_BEGIN_STM$("FILE$",inner);
            if(FILENAME$==null) {
    			throw new RuntimeException("Illegal File Name");
            }
            if(inner!=null) inner.STM$();
            TRACE_END_STM$("FILE$");
            EBLK(); // Iff no prefix
      }};
   }
   // Class Statements
   public FILE$ STM$() { return((FILE$)CODE$.EXEC$()); }
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
//		System.out.println("FILE$(FILENAME$).setaccess: "+mode.edText());
		//RT.BREAK("FILE$(FILENAME$).setaccess: "+mode.edText());
		//RT.NOT_IMPLEMENTED("FILE$(FILENAME$).setaccess: "+mode.edText());
		String id=mode.edText().trim();
		boolean notImplemented=false;
		if(id.equalsIgnoreCase("CREATE")) CREATE$=CreateAction$.create; 
		else if(id.equalsIgnoreCase("NOCREATE")) CREATE$=CreateAction$.noCreate; 
		else if(id.equalsIgnoreCase("ANYCREATE")) CREATE$=CreateAction$.anyCreate; 
		else if(id.equalsIgnoreCase("PURGE")) PURGE$=true; 
		else if(id.equalsIgnoreCase("NOPURGE")) PURGE$=false; 
//		else if(id.equalsIgnoreCase(FileAccess.SHARED.name())) notImplemented=true; 
//		else if(id.equalsIgnoreCase(FileAccess.APPEND.name())) notImplemented=true; 
//		else if(id.equalsIgnoreCase(FileAccess.READWRITE.name())) notImplemented=true; 
//		else if(id.equalsIgnoreCase(FileAccess.BYTESIZE.name())) notImplemented=true; 
//		else if(id.equalsIgnoreCase(FileAccess.REWIND.name())) notImplemented=true; 
		else notImplemented=true;
		if(notImplemented) {
			RT.warning("FILE$("+FILENAME$.edText()+").setaccess("+id+") -- is undefined or not implemented: ");			
		}
		return (!notImplemented);
	}


	protected void doCreateAction() {
		try {
		File file = new File(FILENAME$.edText().trim());
//			  System.out.println("FILE$.doCreateAction: "+CREATE$+" on "+file);
//			  RT.BREAK("FILE$.doCreateAction: "+CREATE$+" on "+file);
			  switch(CREATE$) {
			      case NA: {
					  //System.out.println("FILE$.doCreateAction: NA on "+file);
			    	  //throw new RuntimeException("File access mode=NA - Can't open file");
			    	  break;
			      }
			      case noCreate:{
					  //System.out.println("FILE$.doCreateAction: noCreate on "+file);
			    	  // If the value is "nocreate", the associated file must exist at "open".
			    	  if(!file.exists()) throw new RuntimeException("File access mode=noCreate but File \""+file+"\" does not exist");
			    	  break;
			      }
			      case create:{
					  //System.out.println("FILE$.doCreateAction: Create on "+file);
			    	  // If the value is "create", the external file associated with FILENAME
			    	  // must not exist at "open" (if it does, "open" returns false);
			    	  // a new file is created by the environment.
			    	  if(!file.exists()) {
				    	  boolean success=file.createNewFile();
				    	  if(!success) throw new RuntimeException("File access mode=Create but couldn't create a new empty file: "+file);
			    	  }
			    	  break;
			      }
			      case anyCreate:{
					  //System.out.println("FILE$.doCreateAction: anyCreate on "+file);
			    	  // The value "anycreate" implies that if the file does exist
			    	  // at "open" the file is opened, otherwise a new file is created.
			    	  boolean success=file.createNewFile();
					  System.out.println("FILE$.doCreateAction: Create on "+file+", success="+success);
			    	  if(!success) throw new RuntimeException("File access mode=anyCreate but couldn't create a new empty file: "+file);
			    	  break;
			      }
			  }
		} catch (IOException e) {	}
	}

	protected void doPurgeAction() {
		try { File file = new File(FILENAME$.edText().trim());
//			  System.out.println("FILE$.doPURGEAction: "+PURGE$+" on "+file);
//			  RT.BREAK("FILE$.doPURGEAction: "+PURGE$+" on "+file);
			  if(PURGE$) file.delete();  
		} catch (Exception e) {	}
	}

}
