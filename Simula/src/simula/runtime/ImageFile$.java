/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Image-Oriented Files.
 * <p>
 * The (file) class "imagefile" defines the common attributes for all image-
 * oriented files.
 * <p>
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
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class ImageFile$ extends FILE$ {
	
	/**
	 * 
	 */
	public TXT$ image;
	
	/**
	 * The variable ENDFILE is true when the file is closed or when an image with
	 * location greater than "lastloc" has been input (through "inimage"). It is set
	 * after each "inimage" statement. The procedure "endfile" returns the current
	 * value.
	 */
	protected boolean ENDFILE$ = true;

	public void setpos(int i) {
		image.setpos(i);
	}

	public int pos() {
		return (image.pos());
	}

	public boolean more() {
		return (image.more());
	}

	public int length() {
		return (image.length());
	}

	// Constructor
   public ImageFile$(RTObject$ staticLink,TXT$ FILENAME) {
      super(staticLink,FILENAME);
 	  TRACE_BEGIN_DCL$();
      CODE$=new ClassBody(CODE$,this) {
         public void STM() {
        	 TRACE_BEGIN_STM$(inner);
             if(inner!=null) inner.STM();
             TRACE_END_STM$();
      }};
   }
   // Class Statements
   public ImageFile$ STM() { return((ImageFile$)CODE$.EXEC$()); }
   public ImageFile$ START() { START(this); return(this); }
   
   
   // ************************************************************************
   // *** Output Functions for Outfile, PrintFile and DirectFile
   // ************************************************************************

   public void outimage() // Needs redefinition
   { throw new RuntimeException("Internal Error"); }

	/**
	 * <pre>
	 * procedure outchar(c); character c;
	 * begin
	 *    if not more then outimage;
	 *    image.putchar(c)
	 * end outchar;
	 * </pre>
	 * <p>
	 * The procedure "outchar" stores a character in the POS position of
	 * "image". If "more" is false, "outimage" is called first.
	 * 
	 * @param c
	 */
	public void outchar(char c) {
		if (!more()) outimage();
		image.putchar(c);
	}

	/**
	 * Item-oriented output.
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
	 * <p>
	 * The procedures "outint", "outfix", "outreal" and "outfrac" are defined in
	 * terms of the corresponding editing procedures of "image". They provide
	 * facilities for "item-oriented" output. Each item is edited into a "field"
	 * (subtext of "image") normally starting at the current accessible
	 * character. POS is advanced correspondingly. If the remainder of "image"
	 * is too short to contain the item, "outimage" is called implicitly prior
	 * to the editing operation. The field is space-filled before the editing
	 * operation.
	 * <p>
	 * A run-time error occurs if a field cannot be contained within the full
	 * length of "image".
	 * <p>
	 * Parameter "w" determines both the length of this field and the adjustment
	 * of the item within it, as follows.
	 * <p>
	 * 
	 * <pre>
	 *     w > 0 The field length is w, the item is right-adjusted.
	 * 
	 *     w < 0 The field length is abs(w), the item is left-adjusted.
	 * 
	 *     w = 0 The field length is the exact number of characters needed to
	 *     contain the item (i.e. no leading or trailing spaces).
	 * </pre>
	 * 
	 * @param w
	 * @return
	 */
	public TXT$ FIELD$(int w) {
		if (w > length())
			throw new RuntimeException("Item too long in output operation");
		if (pos() + w - 1 > length())
			outimage();
		TXT$ result = image.sub(pos(), w);
		setpos(pos() + w);
		return (result);
	}

	/**
	 * <pre>
	 * procedure outint(i,w); integer i,w;
	 *     if      w = 0 then FIELD(...).putint(i)   ! see below;
	 *     else if w < 0
	 *     then begin text f;
	 *            f :- FIELD(-w);
	 *            f := notext;
	 *            f.sub(1,...).putint(i) end
	 *     else FIELD(w).putint(i);
	 * </pre>
	 * 
	 * @param i
	 *            The integer value to be edited and outputed.
	 * @param w
	 *            <pre>
	 *     w > 0 The field length is w, the item is right-adjusted.
	 * 
	 *     w < 0 The field length is abs(w), the item is left-adjusted.
	 * 
	 *     w = 0 The field length is the exact number of characters needed to
	 *     contain the item (i.e. no leading or trailing spaces).
	 * </pre>
	 */
	public void outint(int i, int w) {
		if(w<=0)
		{ TXT$ T=blanks(20); T.putint(i);
		  String S=T.edText().trim();
		  if(w==0) outtext(S); else ASGSTR$(FIELD$(-w),S);
		} else FIELD$(w).putint(i);
	}

	public void outfix(double r, int n, int w) {
		if(w<=0)
		{ TXT$ T=blanks(n+10); T.putfix(r, n);
		  String S=T.edText().trim();
		  if(w==0) outtext(S); else ASGSTR$(FIELD$(-w),S);
		} else FIELD$(w).putfix(r, n);
	}

	public void outreal(double r, int n, int w) {
		if(w<=0)
		{ TXT$ T=blanks(n+10); T.putreal(r, n);
		  String S=T.edText().trim();
		  if(w==0) outtext(S); else ASGSTR$(FIELD$(-w),S);
		} else FIELD$(w).putreal(r, n);
	}

	public void outreal(float r, int n, int w) {
		if(w<=0)
		{ TXT$ T=blanks(n+10); T.putreal(r, n);
		  String S=T.edText().trim();
		  if(w==0) outtext(S); else ASGSTR$(FIELD$(-w),S);
		} else FIELD$(w).putreal(r, n);
	}

	public void outfrac(int i, int n, int w) {
		if(w<=0)
		{ TXT$ T=blanks(n+10); T.putfrac(i, n);
		  String S=T.edText().trim();
		  if(w==0) outtext(S); else ASGSTR$(FIELD$(-w),S);
		} else FIELD$(w).putfrac(i, n);
	}

	/**
	 * <pre>
	 * procedure outtext(t); text t;
	 * begin
	 *    if pos>1 and then t.length>length-pos+1 then outimage;
	 *    t.setpos(1);
	 *    while t.more do outchar(t.getchar);
	 * end outtext;
	 * </pre>
	 * 
	 * @param T
	 */
	public void outtext(String s) { outtext(new TXT$(s)); }
	public void outtext(TXT$ t) {
		if ((pos() > 1) && (t.length() > length() - pos() + 1))	outimage();
		t.setpos(1);
		while (t.more()) outchar(t.getchar());
	}

	   
	   // ************************************************************************
	   // *** Input Functions for Infile and DirectFile
	   // ************************************************************************

	   public void inimage() // Needs redefinition
	   { throw new RuntimeException("Internal Error"); }

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
//		if (!more()) inimage();  // From Infile
		while (!more())	inimage(); // From Directfile (Skip never-written-images ???)
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
		while (T.more()) T.putchar(inchar());
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
		while (!ENDFILE$ && (c == ' ' || c == '\t')) c = inchar();
		if (c != ' ') setpos(pos() - 1);
		return (ENDFILE$);
	}
	private TXT$ nextItem() {
		if (lastitem())	throw new RuntimeException("Attempt to read past EOF");
		return(image.sub(pos(), length() - pos() + 1));
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
		TXT$ T = nextItem();
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
	public double inreal() {
		TXT$ T = nextItem();
		double result = T.getreal();
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
		TXT$ T = nextItem();
		int result = T.getfrac();
		setpos(pos() + T.pos() - 1);
		return (result);
	}

}
