/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * The class "directfile"
 * <p>
 * 
 * <pre>
 *  imagefile class directfile;
 *     begin integer LOC, MAXLOC; Boolean ENDFILE, LOCKED;
 *        integer procedure location; location:= LOC;
 *        Boolean procedure endfile; endfile := ENDFILE;
 *        Boolean procedure locked; locked  := LOCKED;
 *        Boolean procedure open(fileimage); text fileimage;
 *        Boolean procedure close;
 *        integer procedure lastloc;
 *        integer procedure maxloc;
 *        procedure locate(i); integer i; 
 *        procedure inimage; 
 *        procedure outimage; 
 *        Boolean procedure deleteimage; 
 *        character procedure inchar; 
 *        integer procedure lock(t,i,j); real t; integer i,j; 
 *        Boolean procedure unlock; 
 *        Boolean procedure checkpoint; 
 *        Boolean procedure lastitem; 
 *        text procedure intext; 
 *        integer procedure inint; 
 *        long real procedure inreal; 
 *        integer procedure infrac; 
 *        procedure outchar(c); character c; 
 *        procedure outtext(t); text t; 
 *        text procedure FIELD(w); integer w;
 *        procedure outint(i,w); integer i,w; 
 *        procedure outfix(r,n,w); long real r; integer n,w; 
 *        procedure outreal(r,n,w); long real r; integer n,w; 
 *        procedure outfrac(i,n,w); integer i,n,w; 
 * 
 *        ENDFILE:= true
 *        ...
 *  end directfile;
 * </pre>
 * 
 * An object of the class "directfile" is used to represent an image-oriented
 * direct file in which the individual images are addressable by ordinal
 * numbers.
 * <p>
 * The variable LOC is defined to represent such ordinal numbers. When the file
 * is closed, the value of LOC is zero.
 * <p>
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class DirectFile$ extends ImageFile$ {

	/**
	 * The variable LOC contains the current ordinal number. When the file is
	 * closed, the value of LOC is set to zero. The procedure "location" gives
	 * access to the current value of LOC.
	 */
	int LOC$;

	/**
	 * The variable MAXLOC indicates the maximum possible location on the
	 * external file. If this is not meaningful MAXLOC has the value of
	 * "maxint"-1. The procedure "maxloc" gives access to the current MAXLOC
	 * value.
	 */
	int MAXLOC$;

	/**
	 * The variable "LOCKED" indicates whether the file is currently locked by
	 * the executing program. The procedure "locked" returns the current value.
	 */
	boolean LOCKED$;

	/**
	 * The variable "RECORDSIZE" is the fixed size of all external images. It is
	 * set by "open" and subdivide the external file into series of external
	 * images, without any image separating characters.
	 */
	int RECORDSIZE$;
	
	private RandomAccessFile randomAccessFile;
	private FileLock fileLock;

	// Constructor
    public DirectFile$(final RTObject$ staticLink,final TXT$ FILENAME) {
    	super(staticLink,FILENAME);
  	    CREATE$=CreateAction$.noCreate; // Default for Direct-type files
    }
    
    // Class Statements
    public DirectFile$ STM$() {
        EBLK();
        return(this);
    }

	/**
	 * The procedure "location" returns the current value of LOC.
	 * 
	 * @return the current read/write position.
	 */
	public int location() {
		return (LOC$);
	}

	/**
	 * The variable ENDFILE is true when the file is closed or when an image
	 * with location greater than "lastloc" has been input (through "inimage").
	 * It is set after each "inimage" statement. The procedure "endfile" returns
	 * the current value.
	 * 
	 * @return
	 */
	public boolean endfile() {
		return(ENDFILE$);
	}

	public boolean locked() {
		return (LOCKED$);
	}

	/**
	 * <pre>
	 *  Boolean procedure open(fileimage);  text fileimage;
	 *     if ... then begin ...  ! see 10.1.2;
	 *        MAXLOC := ... ; ! See below;
	 *        image  :- fileimage;
	 *        setpos(1);
	 *        locate(1);
	 *        open   := OPEN := true;
	 *        end open;
	 * </pre>
	 * 
	 * The procedure "open" locates the first image of the file. The length of
	 * "image" must, at all "inimage" and "outimage" statements, be identical to
	 * the length of "image" at the "open" call. The value assigned to MAXLOC at
	 * "open" is either a maximum length determined from the external file, or
	 * it is "maxint"-1 if no such length exists.
	 * 
	 * @return
	 */
	public boolean open(final TXT$ IMAGE$) {
		if (OPEN$) return (false);
		doCreateAction();
		LOC$ = 1;
		MAXLOC$ = maxint - 1;
		image = IMAGE$;
		OPEN$ = true;
		RECORDSIZE$ = TXT$.length(image);
		setpos(1);
		try {
			String mode = "rws"; // mode is one of "r", "rw", "rws", or "rwd"
			randomAccessFile = new RandomAccessFile(FILENAME$.edText(), mode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return (false);
		}
		locate(1);
		return (true);
	}

	/**
	 * <pre>
	 * Boolean procedure close;
	 *    if OPEN then begin ...
	 *       image :- notext;
	 *       if LOCKED then unlock;
	 *       LOC   := MAXLOC := 0;
	 *       ... ;
	 *       OPEN  := false;
	 *       close := ENDFILE := true;
	 * end close;
	 * </pre>
	 * 
	 * @return
	 */
	public boolean close() {
		if (!OPEN$)	return (false);
		image = null;
		if (LOCKED$) unlock();
		LOC$ = 0;
		MAXLOC$ = 0;
		try {
			randomAccessFile.close();
			randomAccessFile = null;
		} catch (IOException e) {
			return (false);
		}
		OPEN$ = false;
		ENDFILE$=true;
		doPurgeAction();
		return (true);
	}

	/**
	 * The procedure "locate" is used to assign a given value to the variable
	 * LOC$. A parameter value to "locate" which is less than one or greater
	 * than MAXLOC constitutes a run-time error.
	 * 
	 * <pre>
	 *  procedure locate(i); integer i;
	 *     if i<1 or i>MAXLOC then error("..." ! Parameter out of range; )
	 *     else begin
	 *        LOC:= i;
	 *         ... ;
	 *  end locate;	 *
	 * </pre>
	 * <p>
	 * In this implementation we use the method seek(p) which sets the
	 * file-pointer offset, measured from the beginning of this file, at which
	 * the next read or write occurs. The offset may be set beyond the end of
	 * the file. Setting the offset beyond the end of the file does not change
	 * the file length. The file length will change only by writing after the
	 * offset has been set beyond the end of the file.
	 * <p>
	 * Parameters: pos - the offset position, measured in bytes from the
	 * beginning of the file, at which to set the file pointer.
	 * <p>
	 * Throws: IOException - if pos is less than 0 or if an I/O error occurs.
	 * 
	 * @param p
	 */
	public void locate(final int p) {
		if (p < 1 | p > MAXLOC$)
			throw new RuntimeException("Locate: Parameter out of range");
		else
			try {
				randomAccessFile.seek((p - 1) * RECORDSIZE$);
			} catch (IOException e) {
				throw new RuntimeException("Locate failed", e);
			}
		LOC$ = p;
	}

	/**
	 * <pre>
	 * integer procedure lastloc;
	 *    if not OPEN then error("..." ! file closed; )
	 *    else lastloc := ...;
	 * </pre>
	 * 
	 * The procedure "lastloc" indicates the largest location of any written
	 * image. For a new file the value returned is zero.
	 * 
	 * @return The current last written location.
	 */
	public int lastloc() {
		if (!OPEN$)	throw new RuntimeException("file closed");
		try {
			// the length of this file, measured in bytes.
			long length = randomAccessFile.length();
			return ((int) length/RECORDSIZE$);
		} catch (IOException e) {
			throw new RuntimeException("Lastloc failed", e);
		}
	}

	/**
	 * <pre>
	 *  integer procedure maxloc;
	 *     if not OPEN then error("..." ! file closed; )
	 *     else  maxloc := MAXLOC;
	 * </pre>
	 * 
	 * The value assigned to MAXLOC at "open" is either a maximum length
	 * determined from the external file, or it is "maxint"-1 if no such length
	 * exists.
	 * 
	 * @return
	 */
	public int maxloc() {
		if (!OPEN$)	throw new RuntimeException("file closed");
		return (MAXLOC$);
	}

	/**
	 * The Procedure Inimage.
	 * 
	 * <pre>
	 * procedure inimage;
	 *    if not OPEN then error("..." !file closed; )
	 *    else begin
	 *       setpos(1);
	 *       ENDFILE:= LOC > lastloc;
	 *       if ENDFILE then image:= "!25!" else
	 *       if ... ! external written image at LOC exists ; then
	 *          ... ! transfer to "image";...
	 *       else begin
	 *          while more do image.putchar('!0!')
	 *          ! Note: now pos = length+1;
	 *       end not written;
	 *       locate(LOC+1)   ! Location for *next* image;
	 * end inimage;
	 * </pre>
	 * 
	 * The procedure "inimage" transfers into the text "image" a copy of the
	 * external image as currently identified by the variable LOC. If the file
	 * does not contain an image with an ordinal number equal to the value of
	 * LOC, the effect of the procedure "inimage" is as follows. If the location
	 * indicated is greater than "lastloc", then ENDFILE is set to true and the
	 * end of file text ("!25!") is assigned to "image". Otherwise, if the image
	 * is a non-written image but there exists at least one written image whose
	 * LOC is greater than current LOC, then the "image" is filled with NUL
	 * ('!0!') characters and the position indicator is set to "length"+1 (i.e.
	 * "more" becomes false). Finally the value of LOC is incremented by one
	 * through a "locate" call.
	 * 
	 */
	public void inimage() {
		char fill = ' '; // Fill character
		if (!OPEN$)	throw new RuntimeException("File not opened");
		if (TXT$.length(image) != RECORDSIZE$)
			throw new RuntimeException("DirectFile image length changed");
		
		setpos(1); // For Filling
		int nextSetpos=1;
		
		if (LOC$ > lastloc()) TXT$.putchar(image, (char) 25);
		// else if(external image does not exists) fill=(char)0;
		else
			try {
				while (TXT$.more(image)) {
					int b = randomAccessFile.read();
					if (b < 0) {
						LOC$ = lastloc() + 1; // ENDFILE = true;
						fill = (char) 0;
						nextSetpos=TXT$.length(image)+1;
						break;
					}
					TXT$.putchar(image, (char) b);
				}
			} catch (IOException e) {
				throw new RuntimeException("Inimage failed", e);
		}
		ENDFILE$= LOC$ > lastloc();
		locate(LOC$ + 1);
		while (more())	TXT$.putchar(image, fill);
		setpos(nextSetpos);
	}

	/**
	 * <pre>
	 * procedure outimage;
	 *    if      not OPEN     then error("..." !file closed; )
	 *    else if LOC > MAXLOC then error("..." ! file overflow; );
	 *    else begin
	 *        ... ; ! output "image" to external image at LOC;
	 *       locate(LOC+1);
	 *       image := notext;
	 *       setpos(1)
	 * end outimage;
	 * </pre>
	 * 
	 * The procedure "outimage" transfers a copy of the text value "image" to
	 * the external image, thereby storing in the file an external image whose
	 * ordinal number is equal to the current value of LOC. If the file contains
	 * another image with the same ordinal number, that image is overwritten.
	 * The value of LOC is then incremented by one through a "locate" call.
	 */
	public void outimage() {
		if (!OPEN$)
			throw new RuntimeException("file closed");
		if (LOC$ > MAXLOC$)
			throw new RuntimeException("file overflow");
		try {
			randomAccessFile.write(image.edText().getBytes());
		} catch (IOException e) {
			throw new RuntimeException("Outimage failed", e);
		}
		locate(LOC$ + 1);
		ASGTXT$(image,null);
		setpos(1);
	}

	/**
	 * <pre>
	 * Boolean procedure deleteimage;
	 *            if OPEN and then ... ! image LOC was written;
	 *            then begin
	 *               ... ; ! attempt to delete image;
	 *               if ... ! delete operation successful;
	 *               then begin
	 *                  deleteimage := true;
	 *                  locate(LOC+1);
	 *               end successful
	 *            end deleteimage;
	 * </pre>
	 * 
	 * The Boolean procedure "deleteimage" makes the image identified by the
	 * current value of LOC effectively un-written. Irrespective of any physical
	 * differences on the external medium between never-written images and
	 * deleted ones, there is no difference from the program's point of view.
	 * Note that this means that "deleteimage" may decrement the value returned
	 * by "lastloc" (in case LOC was equal to "lastloc").
	 * <p>
	 * Note: Outputting a NUL-filled image at location "lastloc" in the file
	 * does not necessarily decrement the "lastloc" value; explicit writing
	 * (outimage) of such images should be avoided.
	 * 
	 * @return
	 */
	public boolean deleteimage() {
		if (!OPEN$)
			return (false);
		try {
			// TODO: Complete the implementation according
			// to Simula Standard Definition.
			for (int i = 0; i < RECORDSIZE$; i++)
				randomAccessFile.write(0);
		} catch (IOException e) {
			throw new RuntimeException("Outimage failed", e);
		}
		locate(LOC$ + 1);
		return (true);

	}

	/**
	 * All files producing output (sequential output or direct files) contain a
	 * Boolean procedure "checkpoint". The procedure causes the environment to
	 * attempt to secure the output produced so far. Depending on the nature of
	 * the associated external device, this causes completion of output transfer
	 * (i.e. intermediate buffer contents are transferred).
	 * <p>
	 * If this is not possible or meaningful, "checkpoint" is a dummy operation
	 * in which case the value false is returned.
	 * 
	 * @return
	 */
	public boolean checkpoint() {
		try {
			randomAccessFile.getChannel().force(true);
		} catch (IOException e) {
			return (false);
		}
		return (false);
	}

	/**
	 * Direct File Locking
	 * <p>
	 * Procedure "lock" enables the program to get exclusive access to all or
	 * part of the file. The effect of a "lock" call while the file is locked
	 * ("LOCKED" is true) is that the previous lock is immediately released
	 * (prior to the new locking attempt).
	 * <p>
	 * The parameter "timelimit" is the (clock) time in seconds that is the
	 * maximum waiting time for the resource. If "timelimit" is less than or
	 * equal to zero, the procedure returns immediately without performing any
	 * actions upon the file.
	 * <p>
	 * The parameters "loc1" and "loc2" identify the part of the file to be
	 * locked, by giving the ordinal numbers of two external images (bytes). The
	 * program is given exclusive access to a part of the file which includes
	 * the requested region. If the two parameters are both zero, this implies
	 * locking the whole file. Otherwise, the size of the part of the file that
	 * is actually locked, is implementation-dependent; it may even include the
	 * entire file.
	 * <p>
	 * A return value of zero indicates a successful "lock" operation. The value
	 * -1 indicates that "timelimit" was exceeded (or was zero or negative). A
	 * negative value less than -1 indicates "lock" failure and its
	 * interpretation is implementation-defined.
	 * 
	 * 
	 * <pre>
	 * integer procedure lock(timelimit,loc1,loc2);
	 *                     real timelimit; integer loc1,loc2;
	 *            begin
	 *               lock := -1;
	 *               if timelimit>0.0 then begin
	 *                  if LOCKED then unlock;
	 *                  ... ! try to lock indicated part of file, see below;
	 *                  if !success; then begin LOCKED := true; lock := 0 end
	 *               end
	 *            end lock;
	 * </pre>
	 * 
	 * The procedures "lock" and "unlock" (see 10.2.2) provide locking
	 * mechanisms. The last two parameters of "lock" indicate the minimum range
	 * of (byte) locations to be locked (inclusive).
	 * <p>
	 * It is implemented using:
	 * 
	 * <pre>
	 * public abstract FileLock lock(long position,long size,boolean shared) throws IOException
	 * </pre>
	 * 
	 * With Parameters:
	 * <ul>
	 * <li>position - The position at which the locked region is to start; must
	 * be non-negative</li>
	 * <li>size - The size of the locked region; must be non-negative, and the
	 * sum position + size must be non-negative</li>
	 * <li>shared - true to request a shared lock, in which case this channel
	 * must be open for reading (and possibly writing); false to request an
	 * exclusive lock, in which case this channel must be open for writing (and
	 * possibly reading)</li>
	 * </ul>
	 * And Returns: A lock object representing the newly-acquired lock
	 * 
	 * 
	 * @param timelimit
	 * @param loc1
	 * @param loc2
	 * @return
	 */
	public int lock(final float timelimit,final int loc1,final int loc2) {
		if (timelimit <= 0.0f)
			return (-1);
		if (LOCKED$)
			unlock();
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		// Check that operations are completed within 'timelimit'
		try {
			int size = loc2 - loc1 + 1;
			//fileLock = randomAccessFile.getChannel().lock(loc1, size, true);
			fileLock = randomAccessFile.getChannel().tryLock(loc1-1, size, true);
		} catch (IOException e) {
			e.printStackTrace();
			return (-2);
		}
		LOCKED$ = fileLock!=null;
		return (0);
	}

	/**
	 * <pre>
	 * Boolean procedure unlock;
	 * begin
	 *    unlock := checkpoint;
	 *    if LOCKED then begin !release file; LOCKED := false end
	 * end unlock;
	 * </pre>
	 * 
	 * @return
	 */
	public boolean unlock() {
		boolean result = checkpoint();
		if (LOCKED$)
			try {
				fileLock.release();
			} catch (IOException e) {
				e.printStackTrace();
				result = false;
			}
		LOCKED$ = false;
		return (result);
	}

}
