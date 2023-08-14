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
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * System class Directfile.
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
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Directfile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Directfile extends RTS_Imagefile {

	/**
	 * The variable LOC contains the current ordinal number. When the file is
	 * closed, the value of LOC is set to zero. The procedure "location" gives
	 * access to the current value of LOC.
	 */
	int _LOC;

	/**
	 * The variable MAXLOC indicates the maximum possible location on the external
	 * file. If this is not meaningful MAXLOC has the value of "maxint"-1. The
	 * procedure "maxloc" gives access to the current MAXLOC value.
	 */
	int _MAXLOC;

	/**
	 * The variable "LOCKED" indicates whether the file is currently locked by the
	 * executing program. The procedure "locked" returns the current value.
	 */
	boolean _LOCKED;

	/**
	 * The variable "RECORDSIZE" is the fixed size of all external images. It is set
	 * by "open" and subdivide the external file into series of external images,
	 * without any image separating characters.
	 */
	int _RECORDSIZE;


	/**
	 * The RandomAccessFile used.
	 */
	private RandomAccessFile randomAccessFile;
	
	/**
	 * The FileLock
	 */
	private FileLock fileLock;
	
	/**
	 * The initial value of LAST_LOC
	 */
	private int INITIAL_LAST_LOC;

	/**
	 * Create a new _Directbytefile.
	 * @param SL staticLink
	 * @param FN file name 
	 */
	public RTS_Directfile(final RTS_RTObject SL, final RTS_TXT FN) {
		super(SL, FN);
		_CREATE = _CreateAction.noCreate; // Default for Direct-type files
	}

	// Class Statements
	@Override
	public RTS_Directfile _STM() {
		EBLK();
		return (this);
	}

	/**
	 * The procedure "location" returns the current value of LOC.
	 * 
	 * @return the current read/write position.
	 */
	public int location() {
		return (_LOC);
	}

	/**
	 * The variable ENDFILE is true when the file is closed or when an image with
	 * location greater than "lastloc" has been input (through "inimage"). It is set
	 * after each "inimage" statement. The procedure "endfile" returns the current
	 * value.
	 * 
	 * @return the resulting boolean.
	 */
	public boolean endfile() {
		return (_ENDFILE);
	}

	/**
	 * Returns the value _LOCKED.
	 * @return the value _LOCKED.
	 */
	public boolean locked() {
		return (_LOCKED);
	}

	/**
	 * The procedure open.
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
	 * "image" must, at all "inimage" and "outimage" statements, be identical to the
	 * length of "image" at the "open" call. The value assigned to MAXLOC at "open"
	 * is either a maximum length determined from the external file, or it is
	 * "maxint"-1 if no such length exists.
	 * 
	 * @param IMAGE the file's image.
	 * @return true:ok, false:error
	 */
	public boolean open(final RTS_TXT IMAGE) {
		if (_OPEN)
			return (false);
		File file = doCreateAction();
		if (RTS_COMMON.Option.VERBOSE)
			TRACE_OPEN("Open Directfile: " + file);
		_LOC = 1;
		_MAXLOC = maxint - 1;
		image = IMAGE;
		_OPEN = true;
		_RECORDSIZE = RTS_TXT.length(image);
		setpos(1);
		try {
			String mode = "rws"; // mode is one of "r", "rw", "rws", or "rwd"
			if (_SYNCHRONOUS)
				mode = "rws";
			else
				mode = (_CANREAD & !_CANWRITE) ? "r" : "rw";
			randomAccessFile = new RandomAccessFile(file, mode);
			if (_APPEND)
				INITIAL_LAST_LOC = lastloc();
		} catch (IOException e) {
			if (RTS_COMMON.Option.VERBOSE)
				e.printStackTrace();
			return (false);
		}
		locate(1);
		return (true);
	}

	/**
	 * The procedure close.
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
	 * @return true:ok, false:error
	 */
	public boolean close() {
		if (!_OPEN)
			return (false);
		image = null;
		if (_LOCKED)
			unlock();
		_LOC = 0;
		_MAXLOC = 0;
		try {
			if (_PURGE) {
				randomAccessFile.setLength(0);
				randomAccessFile.close();
				File file = new File(FILE_NAME.edText().trim());
				file.deleteOnExit();
				if (file.exists()) {
					RTS_COMMON.printWarning("Purge " + this.getClass().getSimpleName() + " \"" + file.getName()
							+ "\" failed - the underlying OS was unable to perform the delete operation");
				}
			} else
				randomAccessFile.close();
			randomAccessFile = null;
		} catch (IOException e) {
			if (RTS_COMMON.Option.VERBOSE)
				e.printStackTrace();
			return (false);
		}
		_OPEN = false;
		_ENDFILE = true;
		return (true);
	}

	/**
	 * The procedure locate.
	 * <p>
	 * The procedure "locate" is used to assign a given value to the variable _LOC.
	 * A parameter value to "locate" which is less than one or greater than MAXLOC
	 * constitutes a run-time error.
	 * 
	 * <pre>
	 *  procedure locate(i); integer i;
	 *     if i&lt;1 or i>MAXLOC then error("..." ! Parameter out of range; )
	 *     else begin
	 *        LOC:= i;
	 *         ... ;
	 *  end locate;	 *
	 * </pre>
	 * <p>
	 * In this implementation we use the method seek(p) which sets the file-pointer
	 * offset, measured from the beginning of this file, at which the next read or
	 * write occurs. The offset may be set beyond the end of the file. Setting the
	 * offset beyond the end of the file does not change the file length. The file
	 * length will change only by writing after the offset has been set beyond the
	 * end of the file.
	 * <p>
	 * Parameters: pos - the offset position, measured in bytes from the beginning
	 * of the file, at which to set the file pointer.
	 * <p>
	 * Throws: IOException - if pos is less than 0 or if an I/O error occurs.
	 * 
	 * @param p desired location.
	 * @throws RTS_SimulaRuntimeError when unable to perform the operation.
	 */
	public void locate(final int p) {
		if (p < 1 | p > _MAXLOC)
			throw new RTS_SimulaRuntimeError("Locate: Parameter out of range");
		else
			try {
				randomAccessFile.seek((p - 1) * _RECORDSIZE);
			} catch (IOException e) {
				throw new RTS_SimulaRuntimeError("Locate failed", e);
			}
		_LOC = p;
	}

	/**
	 * The procedure lastloc.
	 * <pre>
	 * integer procedure lastloc;
	 *    if not OPEN then error("..." ! file closed; )
	 *    else lastloc := ...;
	 * </pre>
	 * 
	 * The procedure "lastloc" indicates the largest location of any written image.
	 * For a new file the value returned is zero.
	 * 
	 * @return The current last written location.
	 * @throws RTS_SimulaRuntimeError when unable to perform the operation.
	 */
	public int lastloc() {
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		try {
			// the length of this file, measured in bytes.
			long length = randomAccessFile.length();
			return ((int) length / _RECORDSIZE);
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("Lastloc failed", e);
		}
	}

	/**
	 * The procedure maxloc.
	 * <pre>
	 *  integer procedure maxloc;
	 *     if not OPEN then error("..." ! file closed; )
	 *     else  maxloc := MAXLOC;
	 * </pre>
	 * 
	 * The value assigned to MAXLOC at "open" is either a maximum length determined
	 * from the external file, or it is "maxint"-1 if no such length exists.
	 * 
	 * @return the value _MAXLOC.
	 * @throws RTS_SimulaRuntimeError if the file is not open.
	 */
	public int maxloc() {
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		return (_MAXLOC);
	}

	/**
	 * The Procedure Inimage.
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
	 * external image as currently identified by the variable LOC. If the file does
	 * not contain an image with an ordinal number equal to the value of LOC, the
	 * effect of the procedure "inimage" is as follows. If the location indicated is
	 * greater than "lastloc", then ENDFILE is set to true and the end of file text
	 * ("!25!") is assigned to "image". Otherwise, if the image is a non-written
	 * image but there exists at least one written image whose LOC is greater than
	 * current LOC, then the "image" is filled with NUL ('!0!') characters and the
	 * position indicator is set to "length"+1 (i.e. "more" becomes false). Finally
	 * the value of LOC is incremented by one through a "locate" call.
	 * 
	 * @throws RTS_SimulaRuntimeError when unable to perform the operation.
	 */
	@Override
	public void inimage() {
		if (!_CANREAD)
			throw new RTS_SimulaRuntimeError("Directfile: inimage failed - 'canread' is false");
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("File not opened");
		if (RTS_TXT.length(image) != _RECORDSIZE)
			throw new RTS_SimulaRuntimeError("Directfile image length changed");

		setpos(1); // For Filling
		int nextSetpos = 1;
		char fill = ' '; // Fill character

		if (_LOC > lastloc())
			RTS_TXT.putchar(image, (char) 25);
		// else if(external image does not exists) fill=(char)0;
		else
			try {
				while (RTS_TXT.more(image)) {
					int b = randomAccessFile.read();
					if (b < 0) {
						_LOC = lastloc() + 1; // ENDFILE = true;
						fill = (char) 0;
						nextSetpos = RTS_TXT.length(image) + 1;
						break;
					}
					RTS_TXT.putchar(image, (char) b);
				}
			} catch (IOException e) {
				throw new RTS_SimulaRuntimeError("Inimage failed", e);
			}
		_ENDFILE = _LOC > lastloc();
		locate(_LOC + 1);
		while (more())
			RTS_TXT.putchar(image, fill);
		setpos(nextSetpos);
	}

	/**
	 * The procedure outimage.
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
	 * The procedure "outimage" transfers a copy of the text value "image" to the
	 * external image, thereby storing in the file an external image whose ordinal
	 * number is equal to the current value of LOC. If the file contains another
	 * image with the same ordinal number, that image is overwritten. The value of
	 * LOC is then incremented by one through a "locate" call.
	 * 
	 * @throws RTS_SimulaRuntimeError when unable to perform the operation.
	 */
	@Override
	public void outimage() {
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		if (_LOC > _MAXLOC)
			throw new RTS_SimulaRuntimeError("file overflow");
		if (_LOC <= INITIAL_LAST_LOC)
			throw new RTS_SimulaRuntimeError("Directfile: outimage failed: location(" + _LOC + ") <= initial lastloc("
					+ INITIAL_LAST_LOC + ")" + " - The file " + FILE_NAME.edText() + " was opend with APPEND");
		if (!_CANWRITE)
			throw new RTS_SimulaRuntimeError("Directfile: outimage failed - 'canwrite' is false");
		try {
			randomAccessFile.write(image.edText().getBytes());
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("Outimage failed", e);
		}
		locate(_LOC + 1);
		_ASGTXT(image, null);
		setpos(1);
	}

	/**
	 * The procedure deleteimage.
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
	 * The Boolean procedure "deleteimage" makes the image identified by the current
	 * value of LOC effectively un-written. Irrespective of any physical differences
	 * on the external medium between never-written images and deleted ones, there
	 * is no difference from the program's point of view. Note that this means that
	 * "deleteimage" may decrement the value returned by "lastloc" (in case LOC was
	 * equal to "lastloc").
	 * <p>
	 * Note: Outputting a NUL-filled image at location "lastloc" in the file does
	 * not necessarily decrement the "lastloc" value; explicit writing (outimage) of
	 * such images should be avoided.
	 * 
	 * @return true:ok, false:error
	 * @throws RTS_SimulaRuntimeError when unable to perform the operation.
	 */
	public boolean deleteimage() {
		if (!_OPEN)
			return (false);
		if (_LOC <= INITIAL_LAST_LOC)
			throw new RTS_SimulaRuntimeError(
					"Directfile: deleteimage failed" + " - file opend with access-mode APPEND and location(" + _LOC
							+ ") <= initial lastloc(" + INITIAL_LAST_LOC + ")");
		if (!_CANWRITE)
			throw new RTS_SimulaRuntimeError("Directfile: deleteimage failed - 'canwrite' is false");
		try {
			for (int i = 0; i < _RECORDSIZE; i++)
				randomAccessFile.write(0);
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("deleteimage failed", e);
		}
		locate(_LOC + 1);
		return (true);

	}

	/**
	 * The procedure checkpoint.
	 * <p>
	 * All files producing output (sequential output or direct files) contain a
	 * Boolean procedure "checkpoint". The procedure causes the environment to
	 * attempt to secure the output produced so far. Depending on the nature of the
	 * associated external device, this causes completion of output transfer (i.e.
	 * intermediate buffer contents are transferred).
	 * <p>
	 * If this is not possible or meaningful, "checkpoint" is a dummy operation in
	 * which case the value false is returned.
	 * 
	 * @return true:ok, false:error
	 */
	public boolean checkpoint() {
		try {
			randomAccessFile.getChannel().force(true);
		} catch (IOException e) {
    		if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (false);
		}
		return (false);
	}

	/**
	 * The procedure lock.
	 * <p>
	 * Direct File Locking
	 * <p>
	 * Procedure "lock" enables the program to get exclusive access to all or part
	 * of the file. The effect of a "lock" call while the file is locked ("LOCKED"
	 * is true) is that the previous lock is immediately released (prior to the new
	 * locking attempt).
	 * <p>
	 * The parameter "timelimit" is the (clock) time in seconds that is the maximum
	 * waiting time for the resource. If "timelimit" is less than or equal to zero,
	 * the procedure returns immediately without performing any actions upon the
	 * file.
	 * <p>
	 * The parameters "loc1" and "loc2" identify the part of the file to be locked,
	 * by giving the ordinal numbers of two external images (bytes). The program is
	 * given exclusive access to a part of the file which includes the requested
	 * region. If the two parameters are both zero, this implies locking the whole
	 * file. Otherwise, the size of the part of the file that is actually locked, is
	 * implementation-dependent; it may even include the entire file.
	 * <p>
	 * A return value of zero indicates a successful "lock" operation. The value -1
	 * indicates that "timelimit" was exceeded (or was zero or negative). A negative
	 * value less than -1 indicates "lock" failure and its interpretation is
	 * implementation-defined.
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
	 * The procedures "lock" and "unlock" (see 10.2.2) provide locking mechanisms.
	 * The last two parameters of "lock" indicate the minimum range of (byte)
	 * locations to be locked (inclusive).
	 * <p>
	 * It is implemented using:
	 * 
	 * <pre>
	 * public abstract FileLock lock(long position,long size,boolean shared) throws IOException
	 * </pre>
	 * 
	 * With Parameters:
	 * <ul>
	 * <li>position - The position at which the locked region is to start; must be
	 * non-negative</li>
	 * <li>size - The size of the locked region; must be non-negative, and the sum
	 * position + size must be non-negative</li>
	 * <li>shared - true to request a shared lock, in which case this channel must
	 * be open for reading (and possibly writing); false to request an exclusive
	 * lock, in which case this channel must be open for writing (and possibly
	 * reading)</li>
	 * </ul>
	 * And Returns: A lock object representing the newly-acquired lock
	 * 
	 * 
	 * @param timelimit argument timelimit
	 * @param loc1 argument loc1
	 * @param loc2 argument loc2
	 * @return code, 0:OK otherwise error
	 */
	public int lock(final float timelimit, final int loc1, final int loc2) {
		if (timelimit <= 0.0f)
			return (-1);
		if (_LOCKED)
			unlock();
		// Check that operations are completed within 'timelimit'
		try {
			int size = loc2 - loc1 + 1;
			fileLock = randomAccessFile.getChannel().tryLock(loc1 - 1, size, true);
		} catch (IOException e) {
			if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (-2);
		}
		_LOCKED = fileLock != null;
		return (0);
	}

	/**
	 * The procedure unlock.
	 * <pre>
	 * Boolean procedure unlock;
	 * begin
	 *    unlock := checkpoint;
	 *    if LOCKED then begin !release file; LOCKED := false end
	 * end unlock;
	 * </pre>
	 * 
	 * @return the resulting boolean value
	 */
	public boolean unlock() {
		boolean result = checkpoint();
		if (_LOCKED)
			try {
				fileLock.release();
			} catch (IOException e) {
				if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
				result = false;
			}
		_LOCKED = false;
		return (result);
	}

}
