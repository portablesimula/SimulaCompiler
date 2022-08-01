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
import java.io.Writer;

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
	protected Writer writer;

	// Constructor
	public OutFile$(final RTObject$ staticLink,final TXT$ FILENAME) {
		super(staticLink,FILENAME);
	}

	// Class Statements
	public OutFile$ STM$() {
		EBLK();
		return(this);
	}

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
	public boolean open(final TXT$ IMAGE_) {
		if (OPEN$) return (false); // File already opened
		doCreateAction();
		OPEN$ = true;
		image = IMAGE_;
		setpos(1);
		OutputStream outputStream;
		if (FILENAME$.edText().equalsIgnoreCase("sysout"))
			outputStream = System.out;
		else {
			try {
				outputStream = new FileOutputStream(FILENAME$.edText());
			} catch (FileNotFoundException e) {
				return (false);
			}
		}
		writer = new OutputStreamWriter(outputStream,CHARSET$);
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
		} //else console.close();
		OPEN$ = false;
		doPurgeAction();
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
		if (!OPEN$)
			throw new RuntimeException("File not opened");
		try {
			String s=(image==null)?"\n":(image.edStripedText()+'\n');
			writer.write(s);
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
			String s=(image==null)?"\n":(image.edTextToPos()+'\n');
			writer.write(s);
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
			String s=(image==null)?"":(image.edTextToPos());
		    writer.write(s);
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
}