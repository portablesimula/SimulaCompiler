/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * System class Infile.
 * 
 * <pre>
 * imagefile class infile;
 *     begin Boolean ENDFILE;
 *        Boolean procedure endfile;  endfile:= ENDFILE;
 *        Boolean procedure open(fileimage); text fileimage;
 *        Boolean procedure close;
 *        procedure inimage; 
 *        Boolean procedure inrecord; 
 *        character procedure inchar; 
 *        Boolean procedure lastitem; 
 *        text procedure intext(w); integer w; 
 *        integer procedure inint; 
 *        long real procedure inreal;
 *        integer procedure infrac;
 * 
 *        ENDFILE:= true
 *        ...
 *     end infile;
 * </pre>
 * <p>
 * An object of the class "infile" is used to represent an image-oriented
 * sequential input file.
 * <p>
 * The variable ENDFILE is true whenever the file object is closed or the
 * external file is exhausted (i.e. "end of file" has been encountered). The
 * procedure "endfile" gives access to the value of ENDFILE.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Infile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Infile extends RTS_Imagefile {
	
	/**
	 * The BufferedReader used.
	 */
	private BufferedReader lineReader;

	// Constructor
	/**
	 * Create a new _Infile.
	 * @param SL staticLink
	 * @param FN FILENAME
	 */
	public RTS_Infile(RTS_RTObject SL, RTS_TXT FN) {
		super(SL, FN);
		_ENDFILE = true;
	}

	// Class Statements
	@Override
	public RTS_Infile _STM() {
		EBLK();
		return (this);
	}

	/**
	 * <p>
	 * Procedure open.
	 * 
	 * <pre>
	 *  Boolean procedure open(fileimage);  text fileimage;
	 *      if ... then begin ...  ! see 10.1.2;
	 *         ENDFILE := false;
	 *         image   :- fileimage;
	 *         image   := notext;
	 *         setpos(length+1);
	 *         open    := OPEN := true;
	 *      end open;
	 * </pre>
	 * <p>
	 * Procedure "open" establishes the association with an external file (as
	 * identified by FILENAME), checks the access modes and causes corresponding
	 * opening actions on the external file. If the external file is closed, it is
	 * opened.
	 * <p>
	 * If successful, "open" returns true and sets ENDFILE false. In addition,
	 * "image" references the parameter "fileimage" which is space-filled.
	 * 
	 * @param image the givent image
	 * @return true if successful, otherwise false.
	 */
	public boolean open(final RTS_TXT image) {
		if (RTS_COMMON.Option.VERBOSE)
			TRACE_OPEN("Open InFile");
		if (_OPEN)
			return (false);
		this.image = image;
		_ENDFILE = false;
		_ASGTXT(image, null); // image := NOTEXT;
		setpos(length() + 1);

		Reader reader;
		if (FILE_NAME.edText().equalsIgnoreCase("#sysin")) {
			if (RTS_COMMON.console != null)
				reader = RTS_COMMON.console.getReader();
			else
				reader = new InputStreamReader(System.in, _CHARSET);
		} else {
			File file = doCreateAction();
			if (!file.exists()) {
				File selected = trySelectFile(file.getAbsoluteFile().toString());
				if (selected != null)
					file = selected;
			}
			try {
				reader = new FileReader(file, _CHARSET);
			} catch (IOException e) {
				if (RTS_COMMON.Option.VERBOSE)
					e.printStackTrace();
				_OPEN = false;
				return (false);
			}
		}
		lineReader = new BufferedReader(reader);
		_OPEN = true;
		return (true);
	}

	/**
	 * Procedure close.
	 * <pre>
	 * Boolean procedure close;
	 *      if OPEN then
	 *      begin ... ; ! perform closing actions ...;
	 *         image :- notext;
	 *         OPEN  := false;
	 *         close := ENDFILE := true
	 * end close;
	 * </pre>
	 * <p>
	 * Procedure "close" causes closing actions on the external file, as specified
	 * by the access modes. In addition, the association between the file object and
	 * the external file is dissolved. If possible, the external file is closed.
	 * <p>
	 * If successful, "close" returns true. In addition, OPEN is false, ENDFILE is
	 * true and "image" references notext.
	 * 
	 * @return true if successful, otherwise false.
	 */
	public boolean close() {
		if (!_OPEN)
			return (false);
		if (!FILE_NAME.edText().equalsIgnoreCase("#sysin"))
			try {
				if (lineReader != null)
					lineReader.close();
			} catch (IOException e) {
				if (RTS_COMMON.Option.VERBOSE)
					e.printStackTrace();
				return (false);
			}
		image = null; // image :- NOTEXT;
		_OPEN = false;
		_ENDFILE = true;
		doPurgeAction();
		return (true);
	}

	/**
	 * Procedure endfile.
	 * <p>
	 * Returns true whenever the file object is closed or the external file is exhausted
	 * (i.e. "end of file" has been encountered).
	 * @return the resulting boolean value
	 */
	public boolean endfile() {
		return (_ENDFILE);
	}

	/**
	 * Procedure Inimage.
	 * 
	 * <pre>
	 * procedure inimage;
	 *   if ENDFILE then error("...")
	 *   else begin
	 *      ... ; ! attempt to transfer external image to "image";
	 *      if ... ! "image" too short; then error("...")
	 *      else if ... ! there was no more to read;
	 *      then begin
	 *             ENDFILE := true;
	 *             image   :- "!25!" end
	 *      else  ... ; ! pad "image" with space(s);
	 *      setpos(1)
	 * end inimage;
	 * </pre>
	 * <p>
	 * The procedure "inimage" performs the transfer of an external file image into
	 * "image". A run-time error occurs if "image" is notext or too short to contain
	 * the external image. If it is longer than the external image, the latter is
	 * left-adjusted within "image" and the remainder of the text is filled with
	 * spaces. The position indicator is set to one.
	 * <p>
	 * Note: If an "end of file" is encountered, EM ('!25!') is generated as a
	 * single character external image, and the variable ENDFILE is given the value
	 * true. A call on "inimage" or "inrecord" when ENDFILE already has the value
	 * true constitutes a run-time error.
	 * 
	 * @throws RTS_SimulaRuntimeError if inimage fail
	 */
	@Override
	public void inimage() {
		if (!_OPEN || _ENDFILE)
			throw new RTS_SimulaRuntimeError(FILE_NAME.edText() + ": File not opened or attempt to read past EOF");
		try {
			String line = (rest != null) ? rest : lineReader.readLine();
			rest = null;
			if (line != null) {
				if (line.length() > RTS_TXT.length(image))
					throw new RTS_SimulaRuntimeError(FILE_NAME.edText() + ": Image too short: input.length="
							+ line.length() + ", image.length=" + RTS_TXT.length(image));
				_ASGSTR(image, line);
			} else {
				_ASGSTR(image, "" + (char) 25);
				_ENDFILE = true;
			}
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("Inimage failed", e);
		}
		setpos(1);
	}

	/**
	 * Procedure inrecord.
	 * 
	 * <pre>
	 *  Boolean procedure inrecord;
	 *     if not OPEN or ENDFILE then error("...")
	 *     else begin
	 *        ... ; ! transfer external image to "image" (no space-filling);
	 *        if ... ! no more to read;
	 *        then begin
	 *           ENDFILE        := true;
	 *           setpos(1);
	 *           image.putchar('!25!') end  Note - POS = 2 now
	 *        else begin
	 *           setpos(... !number of characters transferred + 1; );
	 *           inrecord:= not ...! whole external image received?;
	 *        end if
	 *  end inrecord;
	 * </pre>
	 * <p>
	 * The procedure "inrecord" is similar to "inimage" with the following
	 * exceptions. Whenever the number of characters accessible in the external
	 * image is less than "length", the rest of "image" is left unchanged. The part
	 * of the "image" that was changed is from pos 1 upto (but not including) the
	 * resulting value of POS. Moreover, if the external image is too long, only the
	 * "length" first characters are input. The value returned by the procedure is
	 * true and the remaining characters may be input through subsequent "inrecord"
	 * (or possibly "inimage") statements. Otherwise, if the input of the external
	 * image was completed, the value false is returned.
	 * <p>
	 * Note: If an "end of file" is encountered, EM ('!25!') is generated as a
	 * single character external image, and the variable ENDFILE is given the value
	 * true. A call on "inimage" or "inrecord" when ENDFILE already has the value
	 * true constitutes a run-time error.
	 *
	 * @return true if a partial record is read, otherwise false
	 * @throws RTS_SimulaRuntimeError if inrecord fail
	 */
	public boolean inrecord() {
		if (!_OPEN || _ENDFILE)
			throw new RTS_SimulaRuntimeError(FILE_NAME.edText() + ": File not opened or attempt to read past EOF");
		try {
			RTS_TXT.setpos(image, 1);
			String line = (rest != null) ? rest : lineReader.readLine();
			rest = null;
			if (line != null) {
				if (line.length() > RTS_TXT.length(image)) { // Return partial image
					rest = line.substring(RTS_TXT.length(image));
					line = line.substring(0, RTS_TXT.length(image));
				}
				RTS_TXT LINE = new RTS_TXT(line);
				while (RTS_TXT.more(LINE))
					RTS_TXT.putchar(image, RTS_TXT.getchar(LINE));
			} else {
				RTS_TXT.putchar(image, (char) 25);
				_ENDFILE = true;
			}
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("Inrecord failed", e);
		}
		return (rest != null);
	}
	
	/**
	 * Utility variable
	 */
	private String rest = null;


}
