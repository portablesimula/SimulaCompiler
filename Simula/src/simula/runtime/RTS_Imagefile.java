/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class Imagefile.
 * <p>
 * The (file) class "imagefile" defines the common attributes for all image-
 * oriented files.
 * <pre>
 *      file class imagefile;
 *           begin text image;
 *              procedure setpos(i);  integer i;  image.setpos(i);
 *              integer procedure pos;     pos    := image.pos;
 *              Boolean procedure more;    more   := image.more;
 *              integer procedure length;  length := image.length;
 *           end imagefile;
 * </pre>
 * <p>
 * The individual logical unit of an external file associated with an imagefile
 * is called an "external image". Each external image is an an ordered sequence
 * of characters.
 * <p>
 * The variable "image" is used to reference a text frame which acts as a
 * buffer, in the sense that it contains the external image currently being
 * processed.
 * <p>
 * The procedures "setpos", "pos", "more" and "length" are introduced for
 * reasons of convenience.
 * <p>
 * The three standard subclasses of imagefile are "infile" (sequential input
 * file), "outfile" (sequential output file) and "directfile" (bidirectional
 * direct file). In addition, "printfile", a standard subclass of class outfile,
 * is available. It represents a line printer oriented file.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Imagefile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Imagefile extends RTS_File {

	/**
	 * The image attribute of this _Imagefile.
	 */
	public RTS_TXT image;

	/**
	 * The variable ENDFILE. It is true when the file is closed or when an image with
	 * location greater than "lastloc" has been input (through "inimage"). It is set
	 * after each "inimage" statement. The procedure "endfile" returns the current
	 * value.
	 */
	protected boolean _ENDFILE = true;

	// Constructor
	/**
	 * Create a new _Imagefile.
	 * @param SL staticLink
	 * @param FN file name
	 */
	public RTS_Imagefile(final RTS_RTObject SL, final RTS_TXT FN) {
		super(SL, FN);
	}

	// Class Statements
	@Override
	public RTS_Imagefile _STM() {
		EBLK();
		return (this);
	}

	/**
	 * Set pos indikator in image.
	 * @param p new pos in image
	 */
	public void setpos(final int p) {
		RTS_TXT.setpos(image, p);
	}

	/**
	 * Returns the image's pos.
	 * @return the image's pos
	 */
	public int pos() {
		return (RTS_TXT.pos(image));
	}

	/**
	 * Returns the image's more.
	 * @return the image's more
	 */
	public boolean more() {
		return (RTS_TXT.more(image));
	}

	/**
	 * Returns the image's length.
	 * @return the image's length
	 */
	public int length() {
		return (RTS_TXT.length(image));
	}

	// ************************************************************************
	// *** Output Functions for Outfile, Printfile and Directfile
	// ************************************************************************

	/**
	 * Procedure outimage.
	 * <p>
	 * This method is virtual and may be redefined in subclasses.
	 * @throws RTS_SimulaRuntimeError if no redefinition is available
	 */
	public void outimage() { // Needs redefinition
		throw new RTS_SimulaRuntimeError("Internal Error");
	}

	/**
	 * Procedure outchar.
	 * <pre>
	 * procedure outchar(c); character c;
	 * begin
	 *    if not more then outimage;
	 *    image.putchar(c)
	 * end outchar;
	 * </pre>
	 * <p>
	 * The procedure "outchar" stores a character in the POS position of "image". If
	 * "more" is false, "outimage" is called first.
	 * 
	 * @param c the character to output
	 */
	public void outchar(final char c) {
		if (!more())
			outimage();
		RTS_TXT.putchar(image, c);
	}

	/**
	 * Utility procedure _FIELD.
	 * 
	 * <pre>
	 *  text procedure FIELD(w); integer w;
	 *      if w>length then error("..." ! Item too long; )
	 *      else begin
	 *         if pos+w-1 > length then outimage;
	 *         FIELD :- image.sub(pos,w);
	 *         setpos(pos+w)
	 *      end FIELD;
	 * </pre>
	 * See <b>{@link RTS_Imagefile#outint(int,int)}</b>
	 * 
	 * @param w the width of the field.
	 * @return the resulting text field
	 * @throws RTS_SimulaRuntimeError if Item is too long
	 */
	private RTS_TXT _FIELD(final int w) {
		if (w > length())
			throw new RTS_SimulaRuntimeError("Item too long in output operation");
		if (pos() + w - 1 > length())
			outimage();
		RTS_TXT result = RTS_TXT.sub(image, pos(), w);
		setpos(pos() + w);
		return (result);
	}

	/**
	 * Procedure outint.
	 * <p>
	 * The procedures "outint", "outfix", "outreal" and "outfrac" are defined in terms of the corresponding
	 * editing procedures of "image". They provide facilities for "item-oriented" output. Each item is
	 * edited into a "field" (subtext of "image") normally starting at the current accessible character. POS
	 * is advanced correspondingly. If the remainder of "image" is too short to contain the item,
	 * "outimage" is called implicitly prior to the editing operation. The field is space-filled before the
	 * editing operation.
	 * <p>
	 * A run-time error occurs if a field cannot be contained within the full length of "image".
	 * <p>
	 * Parameter "w" determines both the length of this field and the adjustment of the item within it, as follows.
	 * <pre>
	 *     w > 0 The field length is w, the item is right-adjusted.
	 * 
	 *     w &lt; 0 The field length is abs(w), the item is left-adjusted.
	 * 
	 *     w = 0 The field length is the exact number of characters needed to
	 *     contain the item (i.e. no leading or trailing spaces).
	 *     
	 *     
	 * procedure outint(i,w); integer i,w;
	 *     if      w = 0 then FIELD(...).putint(i)   ! see below;
	 *     else if w &lt; 0
	 *     then begin text f;
	 *            f :- FIELD(-w);
	 *            f := notext;
	 *            f.sub(1,...).putint(i) end
	 *     else FIELD(w).putint(i);
	 * </pre>
	 * 
	 * @param i the integer value to be edited and outputed
	 * @param w the width of editing field
	 * @throws RTS_SimulaRuntimeError if the Item is too long in output operation
	 * 
	 */
	public void outint(final int i, final int w) {
		if (w <= 0) {
			RTS_TXT T = blanks(20);
			RTS_TXT.putint(T, i);
			String S = T.edText().trim();
			if (w == 0)
				outtext(S);
			else
				_ASGSTR(_FIELD(-w), S);
		} else
			RTS_TXT.putint(_FIELD(w), i);
	}

	/**
	 * Procedure outfix.
	 * <p>
	 * See <b>{@link RTS_Imagefile#outint(int,int)}</b>
	 * 
	 * @param r the long real value to be edited and outputed
	 * @param n the number of digits after decimal sign
	 * @param w the width of editing field
	 * @throws RTS_SimulaRuntimeError if the Item is too long in output operation
	 */
	public void outfix(final float r, final int n, final int w) {
		outfix((double)r, n, w);
	}
	public void outfix(final double r, final int n, final int w) {
		if (w <= 0) {
			RTS_TXT T = blanks(n + 10);
			RTS_TXT.putfix(T, r, n);
			String S = T.edText().trim();
			if (w == 0)
				outtext(S);
			else
				_ASGSTR(_FIELD(-w), S);
		} else
			RTS_TXT.putfix(_FIELD(w), r, n);
	}

	/**
	 * Procedure outreal.
	 * <p>
	 * See <b>{@link RTS_Imagefile#outint(int,int)}</b>
	 * 
	 * @param r the long real value to be edited and outputed
	 * @param n the number of digits after decimal sign
	 * @param w the width of editing field
	 * @throws RTS_SimulaRuntimeError if the Item is too long in output operation
	 */
	public void outreal(final double r, final int n, final int w) {
		if (w <= 0) {
			RTS_TXT T = blanks(n + 10);
			RTS_TXT.putreal(T, r, n);
			String S = T.edText().trim();
			if (w == 0)
				outtext(S);
			else
				_ASGSTR(_FIELD(-w), S);
		} else
			RTS_TXT.putreal(_FIELD(w), r, n);
	}

	/**
	 * Procedure outreal.
	 * <p>
	 * See <b>{@link RTS_Imagefile#outint(int,int)}</b>
	 * 
	 * @param r the real value to be edited and outputed
	 * @param n the number of digits after decimal sign
	 * @param w the width of editing field
	 * @throws RTS_SimulaRuntimeError if the Item is too long in output operation
	 */
	public void outreal(final float r, final int n, final int w) {
		if (w <= 0) {
			RTS_TXT T = blanks(n + 10);
			RTS_TXT.putreal(T, r, n);
			String S = T.edText().trim();
			if (w == 0)
				outtext(S);
			else
				_ASGSTR(_FIELD(-w), S);
		} else
			RTS_TXT.putreal(_FIELD(w), r, n);
	}

	/**
	 * Procedure outfrac.
	 * <p>
	 * See <b>{@link RTS_Imagefile#outint(int,int)}</b>
	 * 
	 * @param i the integer value to be edited and outputed
	 * @param n the number of digits after decimal sign
	 * @param w the width of editing field
	 * @throws RTS_SimulaRuntimeError if the Item is too long in output operation
	 */
	public void outfrac(final int i, final int n, final int w) {
		if (w <= 0) {
			RTS_TXT T = blanks(n + 10);
			RTS_TXT.putfrac(T, i, n);
			String S = T.edText().trim();
			if (w == 0)
				outtext(S);
			else
				_ASGSTR(_FIELD(-w), S);
		} else
			RTS_TXT.putfrac(_FIELD(w), i, n);
	}

	/**
	 * Procedure outtext.
	 * <pre>
	 * procedure outtext(t); text t;
	 * begin
	 *    if pos>1 and then t.length>length-pos+1 then outimage;
	 *    t.setpos(1);
	 *    while t.more do outchar(t.getchar);
	 * end outtext;
	 * </pre>
	 * 
	 * @param s the String representation of the text
	 */
	public void outtext(final String s) {
		outtext(new RTS_TXT(s));
	}

	/**
	 * Procedure outtext.
	 * <p>
	 * See <b>{@link RTS_Imagefile#outtext(String)}</b>
	 * 
	 * @param t the _TXT representation of the text
	 */
	public void outtext(final RTS_TXT t) {
		if (t == null)
			return;
		if ((pos() > 1) && (RTS_TXT.length(t) > length() - pos() + 1))
			outimage();
		RTS_TXT.setpos(t, 1);
		while (RTS_TXT.more(t))
			outchar(RTS_TXT.getchar(t));
	}

	// ************************************************************************
	// *** Input Functions for Infile and Directfile
	// ************************************************************************

	/**
	 * Procedure inimage.
	 * <p>
	 * This method is virtual and may be redefined in subclasses.
	 * @throws RTS_SimulaRuntimeError if no redefinition is available
	 */
	public void inimage() { // Needs redefinition
		throw new RTS_SimulaRuntimeError("Internal Error");
	}

	/**
	 * Procedure inchar.
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
	 * @return the resulting character
	 */
	public char inchar() {
		while (!more())
			inimage();
		return (RTS_TXT.getchar(image));
	}

	/**
	 * Procedure intext.
	 * 
	 * <pre>
	 * text procedure intext(w); integer w;
	 *            begin text t;
	 *               intext :- t :- blanks(w);
	 *               while t.more do t.putchar(inchar)
	 *            end intext;
	 * </pre>
	 * <p>
	 * The expression "intext(w)" where "w" is a positive integer is a reference to
	 * a new alterable main frame of length w containing a copy of the next w
	 * characters of the file. POS is set to the following character. The expression
	 * "intext(0)" references notext. In contrast to the item-oriented procedures
	 * (see below), "intext" operates on a continuous stream of characters, reading
	 * several images if necessary.
	 * <p>
	 * Note: The result may be a reference to an "EOF-image" (cf. inimage/inrecord).
	 * 
	 * @param w the width of the input field.
	 * @return the resulting text
	 */
	public RTS_TXT intext(final int w) {
		RTS_TXT T = blanks(w);
		while (RTS_TXT.more(T))
			RTS_TXT.putchar(T, inchar());
		return (T);
	}

	/**
	 * Procedure lastintem.
	 * 
	 * <pre>
	 *  Boolean procedure lastitem;
	 *  begin character c;
	 *     c := ' ';
	 *     while not ENDFILE and then (c=' ' or else c='!9!')
	 *     do c := inchar;
	 *     lastitem := ENDFILE;
	 *     if c ne ' ' then setpos(pos-1)
	 * end lastitem;
	 * </pre>
	 * <p>
	 * The purpose of the procedure "lastitem" is to skip past all SP and HT
	 * characters (ISOrank 32 and 9 respectively). The process of scanning may
	 * involve the transfer of several successive external images. If the file
	 * contains no further non-space, non-tab characters the value true is returned.
	 * 
	 * @return the resulting boolean value
	 */
	public boolean lastitem() {
		char c = ' ';
		while (!_ENDFILE && (c == ' ' || c == '\t')) {
			c = inchar();
		}
		if (c != ' ')
			setpos(pos() - 1);
		return (_ENDFILE);
	}

	/**
	 * Starting at pos return the rest of image.
	 * @return the rest of image
	 */
	private RTS_TXT ImageRest() {
		if (lastitem())
			throw new RTS_SimulaRuntimeError("Attempt to read past EOF");
		return (RTS_TXT.sub(image, pos(), length() - pos() + 1));
	}

	/**
	 * Procedure inint.
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
	 * The procedures "inint" is defined in terms of the corresponding de-editing
	 * procedure of "image". This procedure, starting at the current "pos", skip
	 * spaces and tab's, and then scan past and convert a numeric item.
	 * 
	 * @return the value of an integer item.
	 */
	public int inint() {
		RTS_TXT T = ImageRest();
		int result = RTS_TXT.getint(T);
		setpos(pos() + RTS_TXT.pos(T) - 1);
		return (result);
	}

	/**
	 * Procedure inreal.
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
	 * The procedure "inreal" is defined in terms of the corresponding de-editing
	 * procedure of "image". This procedure, starting at the current "pos", skip
	 * spaces and tab's, and then scan past and convert a numeric item.
	 * 
	 * @return the value of an real item.
	 */
	public double inreal() {
		RTS_TXT T = ImageRest();
		double result = RTS_TXT.getreal(T);
		setpos(pos() + RTS_TXT.pos(T) - 1);
		return (result);
	}

	/**
	 * Procedure infrac.
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
	 * The procedure "infrac" is defined in terms of the corresponding de-editing
	 * procedure of "image". This procedure, starting at the current "pos", skip
	 * spaces and tab's, and then scan past and convert a numeric item.
	 * 
	 * 
	 * @return the value of a fractionated integer item.
	 */
	public int infrac() {
		RTS_TXT T = ImageRest();
		int result = RTS_TXT.getfrac(T);
		setpos(pos() + RTS_TXT.pos(T) - 1);
		return (result);
	}

}
