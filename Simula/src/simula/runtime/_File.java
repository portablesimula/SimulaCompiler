/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.awt.Font;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.swing.JFileChooser;
import java.util.StringTokenizer;

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
public class _File extends _CLASS {
	protected final _TXT FILE_NAME;
	protected boolean _OPEN;
	
	/**
	 * 
	 * The default values of the access modes are given in table 10.1, where "NA"
	 * means "not applicable" (i.e. ignored for this file kind) and "*" means that
	 * the value is implementation-defined.
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
	protected enum _CreateAction {NA, noCreate, create, anyCreate};
	protected _CreateAction _CREATE=_CreateAction.NA; // May be Redefined
	
	/**
	 * PURGE: Action is performed at 'close'
	 * <p>
	 * The value "purge" implies that the external file may be deleted by the
	 * environment when it is closed (in the sense that it becomes inaccessible to
	 * further program access). The value "nopurge" implies no such deletion.
	 */
	protected boolean _PURGE=false; // True:purge, False:noPurge
	
	/**
	 * READWRITE: If the value is "readonly", output operations cannot be performed.
	 * If the value is "writeonly", input operations cannot be performed. The value
	 * "readwrite" enables both input and output. This mode is relevant only for
	 * direct files.
	 */
	protected boolean _CANREAD=true;
	protected boolean _CANWRITE=true;
	
	protected boolean _APPEND=false;
	protected Charset _CHARSET=Charset.defaultCharset();
	
	protected boolean _SYNCHRONOUS;

	// Constructor
   public _File(final _RTObject staticLink,final _TXT FILE_NAME) {
	   super(staticLink);
	   BBLK(); // Iff no prefix
	   if(FILE_NAME==null) throw new _SimulaRuntimeError("Illegal File Name: null");
	   this.FILE_NAME = FILE_NAME;
   }
   
   // Class Statements
   public _File _STM() {
       EBLK();
       return(this);
   }

	public _TXT filename() {
		return (copy(FILE_NAME));
	}

	public boolean isopen() {
		//_RT.BREAK("ISOPEN: "+FILE_NAME.edText()+", Returns "+_OPEN);
		return (_OPEN);
	}
	
	// trySelectFile
	protected File trySelectFile(final String fileName) {
		File file=new File(fileName);
		if(!file.isAbsolute()) {
			File dir=new File(System.getProperty("user.dir",null));
			File tryFile=new File(dir,fileName);
			if(tryFile.exists()) return(tryFile);
			
			File javaClassPath=new File(System.getProperty("java.class.path"));
			if(javaClassPath.exists()) try {
				dir=javaClassPath.getParentFile().getParentFile();
				tryFile=new File(dir,fileName);
				if(tryFile.exists()) return(tryFile);
			} catch(Throwable e) {}
		}
		JFileChooser fileChooser = new JFileChooser(file.getParent());
		fileChooser.setDialogTitle("Can't Open "+fileName+", select another");
        int answer = fileChooser.showOpenDialog(null);
        if(answer==JFileChooser.APPROVE_OPTION) {
        	return(fileChooser.getSelectedFile());
        }
        return(null);
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
	 * @return true if mode is recognized, otherwise false.
	 */
	public boolean setaccess(final _TXT mode) {
		//System.out.println(this.getClass().getSimpleName()+"("+FILE_NAME.edText()+").setaccess: "+mode.edText());
		//_RT.BREAK("FILE(FILE_NAME).setaccess: "+mode.edText());
		//_RT.NOT_IMPLEMENTED("FILE(FILE_NAME).setaccess: "+mode.edText());
		String id=mode.edText().trim();
		String ID=id.toUpperCase();
		boolean unrecognized=false;
//		else if(ID.equals("SHARED")) notImplemented=true; 
//		else if(ID.equals("NOSHARED")) notImplemented=true; 
		if(ID.equals("APPEND")) _APPEND=true; 
		else if(ID.equals("NOAPPEND")) _APPEND=false; 
		else if(ID.equalsIgnoreCase("CREATE")) _CREATE=_CreateAction.create; 
		else if(ID.equals("NOCREATE")) _CREATE=_CreateAction.noCreate; 
		else if(ID.equals("ANYCREATE")) _CREATE=_CreateAction.anyCreate; 
		else if(ID.equals("READONLY"))  { _CANWRITE=false; _CANREAD=true; }
		else if(ID.equals("WRITEONLY")) { _CANWRITE=true; _CANREAD=false; }
		else if(ID.equals("READWRITE")) { _CANWRITE=true; _CANREAD=true; }
//		else if(ID.equals("BYTESIZE:X")) notImplemented=true; 
//		else if(ID.equals("REWIND")) notImplemented=true; 
//		else if(ID.equals("NOREWIND")) notImplemented=true; 
		else if(ID.equals("PURGE")) _PURGE=true; 
		else if(ID.equals("NOPURGE")) _PURGE=false; 
		
		else if(ID.startsWith("%NOBUFFER")) ; // S-PORT: Ignore
		else if(ID.startsWith("CHARSET")) setCharset(ID);
		else if(ID.startsWith("SYNCHRONOUS")) _SYNCHRONOUS=true;
		else if(ID.startsWith("FONT")) setFont(id);
		else if(ID.startsWith("MARGINS")) setMargins(id);
		else unrecognized=true;
		if(unrecognized) {
			_RT.warning("FILE("+FILE_NAME.edText()+").setaccess("+id+") -- is not recognized.");			
		}
		return (!unrecognized);
	}
	
	protected boolean setCharset(String id) {
		String charset=id.substring(7).trim();
		//_RT.println("CHARSET: defaultCharset="+Charset.defaultCharset());
		if(charset.startsWith(":")) {
			charset=charset.substring(1).trim();
			if(Charset.isSupported(charset)) {
				if(_RT.Option.VERBOSE) _RT.warning("FILE("+FILE_NAME.edText()+").CHARSET Changed from "+_CHARSET+" to "+charset);
				_CHARSET=Charset.forName(charset);
				return(true); 
			} else {
				_RT.warning("FILE("+FILE_NAME.edText()+").setaccess: The Charset \""+charset+"\" is not supported");
				return(false);
			}
		}
		_RT.println("CHARSET: _CHARSET="+_CHARSET);
		return(false);
	}
	
	protected Font _FONT=null;//new Font(Font.MONOSPACED, Font.PLAIN, 12);
	protected int _ORIENTATION=PageFormat.PORTRAIT;
	protected boolean _ASK_PAPER=false;
	protected double _LEFT_MARGIN=0, _RIGHT_MARGIN=0, _TOP_MARGIN=0, _BOT_MARGIN=0;

	
	protected boolean setFont(String id) {
		String fld=id.substring(4).trim();
//		System.out.println("FONT: "+id);
		if(fld.startsWith(":")) {
			fld=fld.substring(1).trim();
			
			StringTokenizer st = new StringTokenizer(fld);
			String fontName=st.nextToken();
			int style=Font.PLAIN;
			int size=12;
			while (st.hasMoreTokens()) {
		         String token=st.nextToken();
//		         System.out.println(token);
		         if(token.equalsIgnoreCase("PLAIN")) style=Font.PLAIN;
		         else if(token.equalsIgnoreCase("ITALIC")) style=Font.ITALIC;
		         else if(token.equalsIgnoreCase("BOLD")) style=style|Font.BOLD;
		         else if(token.equalsIgnoreCase("PORTRAIT")) _ORIENTATION=PageFormat.PORTRAIT;
		         else if(token.equalsIgnoreCase("LANDSCAPE")) _ORIENTATION=PageFormat.LANDSCAPE;
		         else if(token.equalsIgnoreCase("ASK")) _ASK_PAPER=true;
		         //else if(token.equalsIgnoreCase("REVERSE_LANDSCAPE")) _ORIENTATION=PageFormat.REVERSE_LANDSCAPE;
		         else try { size=Integer.decode(token); } catch(Exception e) {}
			}
			
			if(fontName.equalsIgnoreCase("Dialog,")) fontName=Font.DIALOG;
			else if(fontName.equalsIgnoreCase("DialogInput.")) fontName=Font.DIALOG_INPUT;
			else if(fontName.equalsIgnoreCase("Monospaced,")) fontName=Font.MONOSPACED;
			else if(fontName.equalsIgnoreCase("Serif,")) fontName=Font.SERIF;
			else if(fontName.equalsIgnoreCase("SansSerif,")) fontName=Font.SANS_SERIF;
			
			_FONT=new Font(fontName,style,size);
		}
//		System.out.println("FONT: "+_FONT+"  "+edit(_ORIENTATION));
		return(false);
	}
	
	protected boolean setMargins(String id) {
		String fld=id.substring(7).trim();
//		System.out.println("FONT: "+id);
		if(fld.startsWith(":")) {
			fld=fld.substring(1).trim();
			
			StringTokenizer st = new StringTokenizer(fld," ");
			try {
				_TOP_MARGIN=Double.parseDouble(st.nextToken());
				_LEFT_MARGIN=Double.parseDouble(st.nextToken());
				_BOT_MARGIN=Double.parseDouble(st.nextToken());
				_RIGHT_MARGIN=Double.parseDouble(st.nextToken());
			} catch(Exception e) {}
		}
//		System.out.println("MARGINS: "+_LEFT_MARGIN+" "+_RIGHT_MARGIN+" "+_TOP_MARGIN+" "+_BOT_MARGIN);
		return(false);
	}

	protected File doCreateAction() {
		File file=new File(FILE_NAME.edText());
		try {
			if(!file.isAbsolute() && _RT.Option.RUNTIME_USER_DIR.length()>0) {
				file=new File(_RT.Option.RUNTIME_USER_DIR+'/'+FILE_NAME.edText());
			}
			//System.out.println("FILE.doCreateAction: "+_CREATE+" on "+file);
			switch(_CREATE) {
			      case NA -> {
					  //System.out.println("FILE.doCreateAction: NA on "+file);
			    	  //throw new RuntimeError("File access mode=NA - Can't open file");
			      }
			      case noCreate -> {
					  //System.out.println("FILE.doCreateAction: noCreate on "+file);
			    	  // If the value is "nocreate", the associated file must exist at "open".
			    	  if(!file.exists()) throw new _SimulaRuntimeError("File access mode=noCreate but File \""+file+"\" does not exist");
			      }
			      case create -> {
					  //System.out.println("FILE.doCreateAction: Create on "+file);
			    	  // If the value is "create", the external file associated with FILENAME
			    	  // must not exist at "open" (if it does, "open" returns false);
			    	  // a new file is created by the environment.
			    	  if(!file.exists()) {
				    	  boolean success=file.createNewFile();
				    	  if(!success) throw new _SimulaRuntimeError("File access mode=Create but couldn't create a new empty file: "+file);
			    	  }
			      }
			      case anyCreate -> {
					  //System.out.println("FILE.doCreateAction: anyCreate on "+file+", "+file.getAbsolutePath());
			    	  // The value "anycreate" implies that if the file does exist
			    	  // at "open" the file is opened, otherwise a new file is created.
			    	  if(!file.exists()) {					  
			    		  boolean success=file.createNewFile();
			    		  //System.out.println("FILE.doCreateAction: Create on "+file+", success="+success);
			    		  if(!success) throw new _SimulaRuntimeError("File access mode=anyCreate but couldn't create a new empty file: "+file);
			    	  }
			      }
			}
		} catch (IOException e) {	}
		return(file);
	}

	protected void doPurgeAction() {
		try { File file = new File(FILE_NAME.edText().trim());
//			  System.out.println("FILE.doPURGEAction: "+_PURGE+" on "+file);
//			  _RT.BREAK("FILE.doPURGEAction: "+_PURGE+" on "+file);
			  if(_PURGE) {
				  if (!file.delete()) {
					  _RT.warning("Purge "+this.getClass().getSimpleName()+" \""+file.getName()+"\" failed - the underlying OS was unable to perform the delete operation");
				  }
			  }
		} catch (Exception e) {	}
	}

	protected void TRACE_OPEN(String mss) {
		System.out.println(mss+": "+FILE_NAME.edText());
		//printStaticChain();
	}
}
