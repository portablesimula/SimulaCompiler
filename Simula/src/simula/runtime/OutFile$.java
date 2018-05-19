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
import java.io.OutputStreamWriter;

import simula.compiler.utilities.Util;

/**
 * The Class OutFile.
 * <p>
 * 
 * <pre>
 *  file class outfile;
 *       begin
 *          Boolean procedure open(fileimage); text fileimage;
 *          Boolean procedure close;
 *          procedure outimage;
 *          procedure outrecord;
 *          procedure breakoutimage;
 *          Boolean procedure checkpoint;
 *          procedure outchar(c); character c;
 *          procedure outtext(t); text t;
 *          text procedure FIELD(w); integer w;
 *          procedure outint(i,w); integer i,w;
 *          procedure outfix(r,n,w); long real r; integer n,w;
 *          procedure outreal(r,n,w); long real r; integer n,w;
 *          procedure outfrac(i,n,w); integer i,n,w;
 * 
 *         ... ;
 *      end outfile;
 * </pre>
 * <p>
 * An object of the class "outfile" is used to represent an image-oriented
 * sequential output file.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class OutFile$ extends ImageFile$ {
	protected OutputStreamWriter writer;

	// Constructor
   public OutFile$(RTObject$ staticLink,TXT$ FILENAME) {
      super(staticLink,FILENAME);
      // Create Class Body
      CODE$=new ClassBody(CODE$,this) {
         public void STM() {
            if(inner!=null) inner.STM();
      }};
   }
   // Class Statements
   public OutFile$ STM() { return((OutFile$)CODE$.EXEC$()); }
   public OutFile$ START() { START(this); return(this); }

	/**
	 * <pre>
	 * Boolean procedure open(fileimage);  text fileimage;
	 * if ... then
	 * begin ... 
	 *    image :- fileimage;
	 *    setpos(1);
	 *    open  := OPEN := true;
	 * end open;
	 * </pre>
	 * <p>
	 * Procedure "open" establishes the association with an external file (as
	 * identified by FILENAME), checks the access modes and causes corresponding
	 * opening actions on the external file. If the external file is closed, it
	 * is opened. *
	 * 
	 * @param IMAGE_
	 * @return true if successful, otherwise false.
	 */
	public boolean open(TXT$ IMAGE_) {
		if (OPEN$)
			return (false); // File already opened
		// TODO: Access mode actions ...
		OPEN$ = true;
		image = IMAGE_;
		setpos(1);
		OutputStream outputStream;
		//Util.BREAK("OutFile.open: Filename=" + FILENAME$);
		if (FILENAME$.edText().equalsIgnoreCase("sysout"))
			outputStream = System.out;
		else {
			try {
				outputStream = new FileOutputStream(FILENAME$.edText());
			} catch (FileNotFoundException e) {
				return (false);
			}
		}
		writer = new OutputStreamWriter(outputStream);
		return (true);
	}

	/**
	 * <pre>
	 * Boolean procedure close;
	 * if OPEN then
	 * begin ... ! 
	 *    if pos <> 1 then outimage;
	 *    image :- notext;
	 *    ... ; ! perform closing actions on external file;
	 *    OPEN  := false;
	 *    close := true;
	 * end close;
	 * </pre>
	 * <p>
	 * Procedure "close" causes closing actions on the external file, as
	 * specified by the access modes. In addition, the association between the
	 * file object and the external file is dissolved. If possible, the external
	 * file is closed.
	 * <p>
	 * The procedure "close" calls "outimage" if the position indicator is not
	 * equal to 1.
	 * <p>
	 * If successful, "close" returns true. In addition, OPEN is false and
	 * "image" references notext.
	 * 
	 * @return true if successful, otherwise false.
	 */
	public boolean close() {
		if (!OPEN$)
			return (false); // File not opened
		// TODO: Access mode actions ...
		if (pos() != 1)
			outimage();
		image = null; // image :- NOTEXT;
		try {
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			return (false);
		}
		OPEN$ = false;
		return (true);
	}

	/**
	 * <pre>
	 * procedure outimage;
	 *            if not OPEN then error("..." ! file closed; )
	 *            else begin
	 *               ... ; ! transfer "image" to external image;
	 *               image := notext;
	 *               setpos(1)
	 *            end outimage;
	 * </pre>
	 * <p>
	 * The transfer of an image from the text "image" to the file is performed
	 * by the procedure "outimage". The procedure reacts in an
	 * implementation-defined way if the "image" length is not appropriate for
	 * the external file. (Depending on file type and host system, the external
	 * file does not necessarily record trailing blanks from the "image".)
	 * <p>
	 * This implementation will strip the "image" before output operations.
	 * <p>
	 * After the transfer, "image" is cleared to blanks and the position
	 * indicator is set to 1.
	 */
	public void outimage() {
		Util.BREAK("OutFile.outimage(), image=" + image);
		if (!OPEN$)
			throw new RuntimeException("File not opened");
		try {
			writer.write(image.strip().edText() + '\n');
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("Outimage failed",e);
		}
		ASGTXT$(image,null); // image:=NOTEXT;
		setpos(1);
	}

	/**
	 * <pre>
	 * procedure outrecord;
	 * if not OPEN then  error("..." ! file closed; )
	 * else begin
	 *        ... ; ! transfer image.sub(1,pos-1);
	 *              ! Note: no blanking of "image";
	 *        setpos(1)
	 * end outrecord;
	 * </pre>
	 * <p>
	 * The procedure "outrecord" transfers to the file only that part of "image"
	 * which precedes POS. The contents are not blanked after the transfer,
	 * although POS is set to one.
	 */
	public void outrecord() {
		if (!OPEN$)
			throw new RuntimeException("File not opened");
		try {
			// TODO: Without line-feed \n ???
			writer.write(image.edTextToPos()+'\n');
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("Outrecord failed", e);
		}
		setpos(1);
	}

	/**
	 * <pre>
	 *  procedure breakoutimage;
	 *            if not OPEN then error("..." ! file closed; )
	 *            else begin
	 *               ... ; ! output image.sub(1,pos-1);
	 *               image := notext;
	 *               setpos(1)
	 *            end breakoutimage;
	 * </pre>
	 * <p>
	 * The procedure "breakoutimage" outputs the part of "image" that precedes
	 * POS. The output is performed as a partial output of an external image, in
	 * the sense that implicit line terminators are suppressed. On some external
	 * files this operation is not possible. It then has an effect identical to
	 * "outrecord".
	 * <p>
	 * After transfer the "image" is blanked and POS is set to one.
	 * <p>
	 * One use of "breakoutimage" is to allow input from a terminal display on
	 * the same line as one on which output (e.g. a prompt) has already been
	 * written.
	 */
	public void breakoutimage() {
		if ((!OPEN$))
			throw new RuntimeException("File not opened");
		try {
			writer.write(image.edTextToPos());
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("Breakoutimage failed", e);
		}
		ASGTXT$(image,null);
		setpos(1);
	}

	/**
	 * All files producing output (sequential output or direct files) contain a
	 * Boolean procedure "checkpoint". The procedure causes the environment to
	 * attempt to secure the output produced so far. Depending on the nature of
	 * the associated external device, this causes completion of output transfer
	 * (i.e. intermediate buffer contents are transferred). If this is not
	 * possible or meaningful, "checkpoint" is a dummy operation in which case
	 * the value false is returned.
	 * <p>
	 * 
	 * @return true if successful, otherwise false.
	 */
	public boolean checkpoint() {
		try {
			writer.flush();
		} catch (IOException e) {
			return (false);
		}
		return (true);
	}

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
		if (!more())
			outimage();
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
	public TXT$ FIELD_(int w) {
//		 Util.BREAK("BEGIN OutFile.FIELD("+w+") image="+image);
		if (w > length())
			throw new RuntimeException("Item too long in output operation");
		if (pos() + w - 1 > length())
			outimage();
		TXT$ result = image.sub(pos(), w);
		setpos(pos() + w);
//		 Util.BREAK("END OutFile.FIELD("+w+") image="+image);
//		 Util.BREAK("END OutFile.FIELD("+w+") result="+result);
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
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		if(w==0) outtext(new TXT$(""+i));
		else FIELD_(Math.abs(w)).putint(i);
	}

	public void outfix(double r, int n, int w) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		if(w==0) outtext(new TXT$(""+r));
		else FIELD_(Math.abs(w)).putfix(r, n);
	}

	public void outreal(double r, int n, int w) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		if(w==0) outtext(new TXT$(""+r));
		else FIELD_(Math.abs(w)).putreal(r, n);
	}

	public void outreal(float r, int n, int w) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		if(w==0) outtext(new TXT$(""+r));
		else FIELD_(Math.abs(w)).putreal(r, n);
	}

	public void outfrac(int i, int n, int w) {
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		if(w==0) outtext(new TXT$(""+i));
		else FIELD_(Math.abs(w)).putfrac(i, n);
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
	public void outtext(TXT$ t) {
		//Util.BREAK("OutFile$.outtext(t): t="+t);
		if ((pos() > 1) && (t.length() > length() - pos() + 1))	outimage();
		t.setpos(1);
		while (t.more()) outchar(t.getchar());
		//Util.BREAK("END OutFile$.outtext(t): t="+t);
	}

}