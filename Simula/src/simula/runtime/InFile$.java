/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The Class Infile.
 * <p>
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
 * 
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class InFile$ extends ImageFile$ {
	boolean ENDFILE$ = true;
	BufferedReader lineReader;

	// Constructor
   public InFile$(RTObject$ staticLink,TXT$ FILENAME) {
      super(staticLink,FILENAME);
      CODE$=new ClassBody(CODE$,this) {
         public void STM() {
            ENDFILE$=true;
            if(inner!=null) inner.STM();
      }};
   }
   // Class Statements
   public InFile$ STM() { return((InFile$)CODE$.EXEC$()); }
   public InFile$ START() { START(this); return(this); }

	/**
	 * <p>
	 * Open Infile.
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
	 * opening actions on the external file. If the external file is closed, it
	 * is opened.
	 * <p>
	 * If successful, "open" returns true and sets ENDFILE false. In addition,
	 * "image" references the parameter "fileimage" which is space-filled.
	 * 
	 * @param IMAGE_
	 * @return true if successful, otherwise false.
	 */
	public boolean open(TXT$ IMAGE_) {
		// Util.BREAK("InFile.open("+IMAGE_+')');
		if (OPEN$)
			return (false);
		OPEN$ = true;
		image = IMAGE_;
		ENDFILE$ = false;
//		image.ASGTXT$(null); // image := NOTEXT;
		ASGTXT$(image,null); // image := NOTEXT;
		setpos(length() + 1);

		InputStream inputStream;
		//Util.BREAK("InFile.open: Filename=" + FILENAME$);
		if (FILENAME$.edText().equalsIgnoreCase("sysin"))
			inputStream = System.in;
		else {
			try {
				inputStream = new FileInputStream(FILENAME$.edText());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return (false);
			}
		}
		InputStreamReader reader = new InputStreamReader(inputStream);
		lineReader = new BufferedReader(reader);
		return (true);
	}

	/**
	 * Close Infile.
	 * <p>
	 * 
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
	 * Procedure "close" causes closing actions on the external file, as
	 * specified by the access modes. In addition, the association between the
	 * file object and the external file is dissolved. If possible, the external
	 * file is closed.
	 * <p>
	 * If successful, "close" returns true. In addition, OPEN is false, ENDFILE
	 * is true and "image" references notext.
	 * 
	 * @return true if successful, otherwise false.
	 */
	public boolean close() {
		if (!OPEN$)
			return (false);
		try {
			if (lineReader != null)
				lineReader.close();
		} catch (IOException e) {
			return (false);
		}
		image = null; // image :- NOTEXT;
		OPEN$ = false;
		ENDFILE$ = true;
		return (true);
	}

	public boolean endfile() {
		return (ENDFILE$);
	}

	/**
	 * The Procedure Inimage.
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
	 * The procedure "inimage" performs the transfer of an external file image
	 * into "image". A run-time error occurs if "image" is notext or too short
	 * to contain the external image. If it is longer than the external image,
	 * the latter is left-adjusted within "image" and the remainder of the text
	 * is filled with spaces. The position indicator is set to one.
	 * <p>
	 * Note: If an "end of file" is encountered, EM ('!25!') is generated as a
	 * single character external image, and the variable ENDFILE is given the
	 * value true. A call on "inimage" or "inrecord" when ENDFILE already has
	 * the value true constitutes a run-time error.
	 */
	public void inimage() {
		if (!OPEN$ || ENDFILE$)
			throw new RuntimeException(
					"File not opened or attempt to read past EOF");
		try {
			String line = lineReader.readLine();
			if (line != null) {
				if (line.length() > image.length())
					throw new RuntimeException("image too short");
				ASGSTR$(image,line);
			} else
				ASGSTR$(image,"" + (char) 25);
		} catch (IOException e) {
			throw new RuntimeException("Inimage failed",e);
		}
		while (more())
			image.putchar(' ');
		setpos(1);
	}

	/**
	 * The Procedure Inrecord
	 * <p>
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
	 * image is less than "length", the rest of "image" is left unchanged. The
	 * part of the "image" that was changed is from pos 1 upto (but not
	 * including) the resulting value of POS. Moreover, if the external image is
	 * too long, only the "length" first characters are input. The value
	 * returned by the procedure is true and the remaining characters may be
	 * input through subsequent "inrecord" (or possibly "inimage") statements.
	 * Otherwise, if the input of the external image was completed, the value
	 * false is returned.
	 * <p>
	 * Note: If an "end of file" is encountered, EM ('!25!') is generated as a
	 * single character external image, and the variable ENDFILE is given the
	 * value true. A call on "inimage" or "inrecord" when ENDFILE already has
	 * the value true constitutes a run-time error.
	 *
	 * @return
	 */
	private String rest = null;

	public boolean inrecord() {
		if (!OPEN$ || ENDFILE$)
			throw new RuntimeException("File not opened or attempt to read past EOF");
		try {
			image.setpos(1);
			String line = (rest != null) ? rest : lineReader.readLine();
			rest = null;
			if (line != null) {
				if (line.length() > image.length()) { // Return partial image
					rest = line.substring(image.length());
					line = line.substring(0, image.length() - 1);
				}
				TXT$ LINE = new TXT$(line);
				while (LINE.more())
					image.putchar(LINE.getchar());
			} else {
				image.putchar((char) 25);
				ENDFILE$ = true;
			}
		} catch (IOException e) {
			throw new RuntimeException("Inrecord failed",e);
		}
		return (rest != null);
	}

	/**
	 * Inchar.
	 * <p>
	 * 
	 * <pre>
	 * character procedure inchar;
	 * begin
	 *    if not more then inimage;
	 *    inchar:= image.getchar
	 * end inchar;
	 * </pre>
	 * <p>
	 * The procedure "inchar" gives access to and scans past the next character.
	 * Note: The result may be the "EOF-character" EM (ISOrank 25).
	 * 
	 * @return
	 */
	public char inchar() {
		if (!more()) {
			inimage();
		}
		return (image.getchar());
	}

	/**
	 * Intext.
	 * <p>
	 * 
	 * <pre>
	 * text procedure intext(w); integer w;
	 *            begin text t;
	 *               intext :- t :- blanks(w);
	 *               while t.more do t.putchar(inchar)
	 *            end intext;
	 * </pre>
	 * <p>
	 * The expression "intext(w)" where "w" is a positive integer is a reference
	 * to a new alterable main frame of length w containing a copy of the next w
	 * characters of the file. POS is set to the following character. The
	 * expression "intext(0)" references notext. In contrast to the
	 * item-oriented procedures (see below), "intext" operates on a continuous
	 * stream of characters, reading several images if necessary.
	 * <p>
	 * Note: The result may be a reference to an "EOF-image" (cf.
	 * inimage/inrecord).
	 * 
	 * @param w
	 * @return
	 */
	public TXT$ intext(int w) {
		TXT$ T = blanks(w);
		while (T.more())
			T.putchar(inchar());
		return (T);
	}

	/**
	 * Lastintem.
	 * <p>
	 * 
	 * <pre>
	 *  Boolean procedure lastitem;
	 *  begin character c;
	 *     c := ' ';
	 *     while not ENDFILE and then (c=' ' or else c='!9!')
	 *     do c := inchar;
	 *     lastitem := ENDFILE;
	 *     if c <> ' ' then setpos(pos-1)
	 * end lastitem;
	 * </pre>
	 * <p>
	 * The purpose of the procedure "lastitem" is to skip past all SP and HT
	 * characters (ISOrank 32 and 9 respectively). The process of scanning may
	 * involve the transfer of several successive external images. If the file
	 * contains no further non-space, non-tab characters the value true is
	 * returned.
	 * 
	 * @return
	 */
	public boolean lastitem() {
		char c = ' ';
		while (!ENDFILE$ && (c == ' ' || c == '\t'))
			c = inchar();
		if (c != ' ')
			setpos(pos() - 1);
		return (ENDFILE$);
	}

	/**
	 * Inint.
	 * <p>
	 * 
	 * <pre>
	 * integer procedure inint;
	 * if lastitem then error("..." ! Inint: End of file ;)
	 * else begin text t;
	 *         t:- image.sub(pos,length-pos+1);
	 *         inint := t.getint;
	 *         setpos(pos+t.pos-1)
	 * end inint;
	 * </pre>
	 * <p>
	 * The procedures "inint" is defined in terms of the corresponding
	 * de-editing procedure of "image". This procedure, starting at the current
	 * "pos", skip spaces and tab's, and then scan past and convert a numeric
	 * item.
	 * 
	 * @return the value of an integer item.
	 */
	public int inint() {
		if (lastitem())
			throw new RuntimeException("Attempt to read past EOF");
		TXT$ T = image.sub(pos(), length() - pos() + 1);
		int result = T.getint();
		setpos(pos() + T.pos() - 1);
		return (result);
	}

	/**
	 * Inreal.
	 * <p>
	 * 
	 * <pre>
	 * long real procedure inreal;
	 * if lastitem then error("..." ! Inreal: End of file; )
	 * else begin text t;
	 *    t :- image.sub(pos,length-pos+1);
	 *    inreal := t.getreal;
	 *    setpos(pos+t.pos-1)
	 * end inreal;
	 * </pre>
	 * <p>
	 * The procedure "inreal" is defined in terms of the corresponding
	 * de-editing procedure of "image". This procedure, starting at the current
	 * "pos", skip spaces and tab's, and then scan past and convert a numeric
	 * item.
	 * 
	 * @return
	 */
	public float inreal() {
		if (lastitem())
			throw new RuntimeException("Attempt to read past EOF");
		TXT$ T = image.sub(pos(), length() - pos() + 1);
		float result = ((float) (T.getreal()));
		setpos(pos() + T.pos() - 1);
		return (result);
	}

	/**
	 * <p>
	 * 
	 * <pre>
	 * integer procedure infrac;
	 * if lastitem then error("..." ! Infrac: End of file; )
	 * else begin text t;
	 *    t :- image.sub(pos,length-pos+1);
	 *    infrac := t.getfrac;
	 *    setpos(pos+t.pos-1)
	 * end infrac;
	 * </pre>
	 * <p>
	 * The procedure "infrac" is defined in terms of the corresponding
	 * de-editing procedure of "image". This procedure, starting at the current
	 * "pos", skip spaces and tab's, and then scan past and convert a numeric
	 * item.
	 * 
	 * 
	 * @return
	 */
	public int infrac() {
		if (lastitem())
			throw new RuntimeException("Attempt to read past EOF");
		TXT$ T = image.sub(pos(), length() - pos() + 1);
		int result = T.getfrac();
		setpos(pos() + T.pos() - 1);
		return (result);
	}
}
