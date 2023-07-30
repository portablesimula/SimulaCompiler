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
 * System class File.
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
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_File.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_File extends RTS_CLASS {
	
	/**
	 * The file name.
	 */
	protected final RTS_TXT FILE_NAME;
	
	/**
	 * The OPEN indicator.
	 */
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
	 * If the value is "create", the external file associated with FILENAME must not
	 * exist at "open" (if it does, "open" returns false); a new file is created by
	 * the environment. If the value is "nocreate", the associated file must exist
	 * at "open". The value "anycreate" implies that if the file does exist at
	 * "open" the file is opened, otherwise a new file is created.
	 */
	protected enum _CreateAction {
		/**
		 * not applicable
		 */
		NA,
		/**
		 * the associated file must exist at "open"
		 */
		noCreate,
		/**
		 * the external file associated with FILENAME must not exist at "open"
		 */
		create,
		/**
		 * if the file does exist at "open" the file is opened,
		 * otherwise a new file is created
		 */
		anyCreate
	};

	/**
	 * CREATE: Action is performed as 'open'
	 */
	protected _CreateAction _CREATE = _CreateAction.NA; // May be Redefined

	/**
	 * PURGE: Action is performed at 'close'
	 * <p>
	 * The value "purge" implies that the external file may be deleted by the
	 * environment when it is closed (in the sense that it becomes inaccessible to
	 * further program access). The value "nopurge" implies no such deletion.
	 */
	protected boolean _PURGE = false; // True:purge, False:noPurge

	/**
	 * If the value is true, input operations can be performed.
	 * <p>
	 * This mode is relevant only for direct files.
	 */
	protected boolean _CANREAD = true;
	
	/**
	 * If the value is true, output operations can be performed.
	 * <p>
	 * This mode is relevant only for direct files.
	 */
	protected boolean _CANWRITE = true;

	/**
	 * The output to the file is added to
	 * the existing contents of the file.
	 * <p>
	 * If the value is true, output to the file is added to the existing
	 * contents of the file. The value false implies
	 * for a sequential file that, after "close", the external file will
	 * contain only the output produced while the file was open.
	 * <p>
	 * The mode is not relevant for in(byte)files.
	 */
	protected boolean _APPEND = false;
	
	/**
	 * The current character set when encode/decode files.
	 */
	protected Charset _CHARSET = Charset.defaultCharset();

	/**
	 * The default BYTESIXE is 8 in this implementation.
	 */
	protected final int _DEFAULT_BYTESIZE = 8;
	
	/**
	 * The access mode SYNCHRONOUS.
	 * <p>
	 * It is available for Out- files and Direct- files.
	 * For Outfile/OutBytefile, each write operation will be followed by a flush to ensure that the
	 * underlying storage device is updated. For Directfile/DirectBytefile the underlaying Java
	 * RandomAccessFile will be created open for reading and writing, and also require that every
	 * update to the file's content or metadata be written synchronously to the underlying storage device.
	 */
	protected boolean _SYNCHRONOUS;

	/**
	 * Create a new _File.
	 * @param SL staticLink
	 * @param FN file name
	 */
	public RTS_File(final RTS_RTObject SL, final RTS_TXT FN) {
		super(SL);
		BBLK(); // Iff no prefix
		if (FN == null)
			throw new RTS_SimulaRuntimeError("Illegal File Name: null");
		this.FILE_NAME = FN;
	}

	// Class Statements
	@Override
	public RTS_File _STM() {
		EBLK();
		return (this);
	}

	/**
	 * Returns the filename.
	 * @return the filename
	 */
	public RTS_TXT filename() {
		return (copy(FILE_NAME));
	}

	/**
	 * Returns true when this file is open.
	 * @return true when this file is open
	 */
	public boolean isopen() {
		return (_OPEN);
	}

	// trySelectFile
	/**
	 * Try to select a file named 'fileName'.
	 * <p>
	 * If no file exists with that fileName it will try several possibilities:
	 * <ul>
	 * <li>First it will search the Option.RUNTIME_USER_DIR</li>
	 * <li>Second, system properties "user.dir" and "java.class.path".parent</li>
	 * <li>Finally, a JFileChooser dialog is opened to let the user select the file</li>
	 * </ul>
	 * @param fileName the given fale name
	 * @return the resulting file or null
	 */
	protected File trySelectFile(final String fileName) {
		File file = new File(fileName);
		if (file.exists())
			return (file);
		if (!file.isAbsolute()) {
			File tryFile = new File(RTS_COMMON.Option.RUNTIME_USER_DIR, fileName);
			if (tryFile.exists())
				return (tryFile);
			File dir = new File(System.getProperty("user.dir", null));
			tryFile = new File(dir, fileName);
			if (tryFile.exists())
				return (tryFile);

			File javaClassPath = new File(System.getProperty("java.class.path"));
			if (javaClassPath.exists())
				try {
					dir = javaClassPath.getParentFile().getParentFile();
					tryFile = new File(dir, fileName);
					if (tryFile.exists())
						return (tryFile);
				} catch (Throwable e) {
		    		if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
				}
		}
		JFileChooser fileChooser = new JFileChooser(file.getParent());
		fileChooser.setDialogTitle("Can't Open " + fileName + ", select another");
		int answer = fileChooser.showOpenDialog(null);
		if (answer == JFileChooser.APPROVE_OPTION) {
			return (fileChooser.getSelectedFile());
		}
		return (null);
	}

	/**
	 * External file access control.
	 * <p>
	 * Certain attributes (not specified in the file outline) control the access to
	 * the external file. The values of these attributes are set when the file
	 * object is opened or closed, from a set of default values possibly modified by
	 * successive calls to the procedure "setaccess".
	 * <p>
	 * The standard attribute modes are SHARED, APPEND, CREATE, READWRITE, BYTESIZE,
	 * REWIND and PURGE.
	 * <p>
	 * The parameter "mode" to procedure "setaccess" contains one of the standard
	 * values as given above, namely "shared", "noshared", "append", "noappend",
	 * "create", "nocreate", "anycreate", "readonly", "writeonly", "readwrite",
	 * "bytesize:X" (where X is a positive integer), "rewind", "norewind", "purge"
	 * and "nopurge".
	 * <p>
	 * It is recommended that implementation-defined parameter values have the
	 * percent character % as the first character of the text.
	 * <p>
	 * Unrecognized modes are ignored and "setaccess" then returns the value false.
	 * The value is true otherwise.
	 * <p>
	 * See <a href="http://simula67.at.ifi.uio.no/Standard-86/">Simula Standard</a>
	 * Chapter 10, INPUT-OUTPUT.
	 * 
	 * @param mode the access mode text
	 * @return true if mode is recognized, otherwise false.
	 */
	public boolean setaccess(final RTS_TXT mode) {
		String id = mode.edText().trim();
		String ID = id.toUpperCase();
		boolean unrecognized = false;
//		else if(ID.equals("SHARED")) notImplemented=true; 
//		else if(ID.equals("NOSHARED")) notImplemented=true; 
		if (ID.equals("APPEND"))
			_APPEND = true;
		else if (ID.equals("NOAPPEND"))
			_APPEND = false;
		else if (ID.equalsIgnoreCase("CREATE"))
			_CREATE = _CreateAction.create;
		else if (ID.equals("NOCREATE"))
			_CREATE = _CreateAction.noCreate;
		else if (ID.equals("ANYCREATE"))
			_CREATE = _CreateAction.anyCreate;
		else if (ID.equals("READONLY")) {
			_CANWRITE = false;
			_CANREAD = true;
		} else if (ID.equals("WRITEONLY")) {
			_CANWRITE = true;
			_CANREAD = false;
		} else if (ID.equals("READWRITE")) {
			_CANWRITE = true;
			_CANREAD = true;
		}
//		else if(ID.equals("BYTESIZE:X")) notImplemented=true; 
//		else if(ID.equals("REWIND")) notImplemented=true; 
//		else if(ID.equals("NOREWIND")) notImplemented=true; 
		else if (ID.equals("PURGE"))
			_PURGE = true;
		else if (ID.equals("NOPURGE"))
			_PURGE = false;

		else if (ID.startsWith("%NOBUFFER"))
			; // S-PORT: Ignore
		else if (ID.startsWith("CHARSET"))
			setCharset(ID);
		else if (ID.startsWith("SYNCHRONOUS"))
			_SYNCHRONOUS = true;
		else if (ID.startsWith("FONT"))
			setFont(id);
		else if (ID.startsWith("MARGINS"))
			setMargins(id);
		else
			unrecognized = true;
		if (unrecognized) {
			RTS_COMMON.printWarning("FILE(" + FILE_NAME.edText() + ").setaccess(" + id + ") -- is not recognized.");
		}
		return (!unrecognized);
	}

	/**
	 * Set new Charset.
	 * @param id charset identifier
	 * @return true if the operation was successful, otherwise false
	 */
	protected boolean setCharset(String id) {
		String charset = id.substring(7).trim();
		if (charset.startsWith(":")) {
			charset = charset.substring(1).trim();
			if (Charset.isSupported(charset)) {
				if (RTS_COMMON.Option.VERBOSE)
					RTS_COMMON.printWarning("FILE(" + FILE_NAME.edText() + ").CHARSET Changed from " + _CHARSET + " to " + charset);
				_CHARSET = Charset.forName(charset);
				return (true);
			} else {
				RTS_COMMON.printWarning(
						"FILE(" + FILE_NAME.edText() + ").setaccess: The Charset \"" + charset + "\" is not supported");
				return (false);
			}
		}
		RTS_COMMON.println("CHARSET: _CHARSET=" + _CHARSET);
		return (false);
	}

	/**
	 * The current Font.
	 */
	protected Font _FONT = null;// new Font(Font.MONOSPACED, Font.PLAIN, 12);
	
	/**
	 * The current paper orientation.
	 */
	protected int _ORIENTATION = PageFormat.PORTRAIT;
	
	/**
	 * Indicator to decide whether to ask, by a dialog, for the paper and orientation.
	 */
	protected boolean _ASK_PAPER = false;
	
	/**
	 * The papar's current left margin
	 */
	protected double _LEFT_MARGIN = 0;
	
	/**
	 * The papar's current right margin
	 */
	protected double _RIGHT_MARGIN = 0;
	
	/**
	 * The papar's current top margin
	 */
	protected double _TOP_MARGIN = 0;
	
	/**
	 * The papar's current bottom margin
	 */
	protected double _BOT_MARGIN = 0;

	/**
	 * Set new Font.
	 * @param id font identifier
	 * @return true if the operation was successful, otherwise false
	 */
	protected boolean setFont(String id) {
		String fld = id.substring(4).trim();
		if (fld.startsWith(":")) {
			fld = fld.substring(1).trim();

			StringTokenizer st = new StringTokenizer(fld);
			String fontName = st.nextToken();
			int style = Font.PLAIN;
			int size = 12;
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (token.equalsIgnoreCase("PLAIN"))
					style = Font.PLAIN;
				else if (token.equalsIgnoreCase("ITALIC"))
					style = Font.ITALIC;
				else if (token.equalsIgnoreCase("BOLD"))
					style = style | Font.BOLD;
				else if (token.equalsIgnoreCase("PORTRAIT"))
					_ORIENTATION = PageFormat.PORTRAIT;
				else if (token.equalsIgnoreCase("LANDSCAPE"))
					_ORIENTATION = PageFormat.LANDSCAPE;
				else if (token.equalsIgnoreCase("ASK"))
					_ASK_PAPER = true;
				// else if(token.equalsIgnoreCase("REVERSE_LANDSCAPE"))
				// _ORIENTATION=PageFormat.REVERSE_LANDSCAPE;
				else
					try {
						size = Integer.decode(token);
					} catch (Exception e) {
					}
			}

			if (fontName.equalsIgnoreCase("Dialog,"))
				fontName = Font.DIALOG;
			else if (fontName.equalsIgnoreCase("DialogInput."))
				fontName = Font.DIALOG_INPUT;
			else if (fontName.equalsIgnoreCase("Monospaced,"))
				fontName = Font.MONOSPACED;
			else if (fontName.equalsIgnoreCase("Serif,"))
				fontName = Font.SERIF;
			else if (fontName.equalsIgnoreCase("SansSerif,"))
				fontName = Font.SANS_SERIF;

			_FONT = new Font(fontName, style, size);
		}
		return (false);
	}

	/**
	 * Utility: Set paper margins.
	 * @param id an margin string "top:left:bottom:right"
	 * @return true if the operation was successful, otherwise false
	 */
	protected boolean setMargins(String id) {
		String fld = id.substring(7).trim();
		if (fld.startsWith(":")) {
			fld = fld.substring(1).trim();

			StringTokenizer st = new StringTokenizer(fld, " ");
			try {
				_TOP_MARGIN = Double.parseDouble(st.nextToken());
				_LEFT_MARGIN = Double.parseDouble(st.nextToken());
				_BOT_MARGIN = Double.parseDouble(st.nextToken());
				_RIGHT_MARGIN = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
			}
		}
		return (false);
	}

	/**
	 * Do the Create action.
	 * @return the File 
	 */
	protected File doCreateAction() {
		File file = new File(FILE_NAME.edText());
		try {
			if (!file.isAbsolute() && RTS_COMMON.Option.RUNTIME_USER_DIR.length() > 0) {
				file = new File(RTS_COMMON.Option.RUNTIME_USER_DIR + '/' + FILE_NAME.edText());
			}
			switch (_CREATE) {
			case NA -> {
			}
			case noCreate -> {
				// If the value is "nocreate", the associated file must exist at "open".
				if (!file.exists())
					throw new RTS_SimulaRuntimeError("File access mode=noCreate but File \"" + file + "\" does not exist");
			}
			case create -> {
				// If the value is "create", the external file associated with FILENAME
				// must not exist at "open" (if it does, "open" returns false);
				// a new file is created by the environment.
				if (!file.exists()) {
					boolean success = file.createNewFile();
					if (!success)
						throw new RTS_SimulaRuntimeError(
								"File access mode=Create but couldn't create a new empty file: " + file);
				}
			}
			case anyCreate -> {
				// The value "anycreate" implies that if the file does exist
				// at "open" the file is opened, otherwise a new file is created.
				if (!file.exists()) {
					boolean success = file.createNewFile();
					// System.out.println("FILE.doCreateAction: Create on "+file+",
					// success="+success);
					if (!success)
						throw new RTS_SimulaRuntimeError(
								"File access mode=anyCreate but couldn't create a new empty file: " + file);
				}
			}
			}
		} catch (IOException e) {
    		if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
		}
		return (file);
	}

	/**
	 * Do the Purge action
	 */
	protected void doPurgeAction() {
		try {
			File file = new File(FILE_NAME.edText().trim());
			if (_PURGE) {
				if (!file.delete()) {
					RTS_COMMON.printWarning("Purge " + this.getClass().getSimpleName() + " \"" + file.getName()
							+ "\" failed - the underlying OS was unable to perform the delete operation");
				}
			}
		} catch (Exception e) {
    		if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
		}
	}

	/**
	 * Utility: Trace file open.
	 * @param mss a trace message
	 */
	protected void TRACE_OPEN(String mss) {
		System.out.println(mss + ": " + FILE_NAME.edText());
	}
}
