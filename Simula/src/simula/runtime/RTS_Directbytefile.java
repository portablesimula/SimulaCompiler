/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * System class Directbytefile.
 * This class defines a byte-oriented direct file.
 * <pre>
 *  bytefile class Directbytefile;
 *        begin integer LOC, MAXLOC; Boolean LOCKED;
 *        Boolean procedure endfile; endfile:=OPEN and then LOC>lastloc;
 *        integer procedure location; location := LOC;
 *        integer procedure maxloc; maxloc := MAXLOC;
 *        Boolean procedure locked; locked := LOCKED;
 *        Boolean procedure open;
 *        Boolean procedure close;
 *        integer procedure lastloc;
 *        procedure locate(i); integer i;
 *        short integer procedure inbyte;
 *        procedure outbyte(x); short integer x; 
 *        Boolean procedure checkpoint; 
 *        integer procedure lock(t,i,j); real t; integer i,j;
 *        Boolean procedure unlock;
 *        procedure intext(t); text t;
 *        procedure outtext(t); text t; 
 *           ...
 * end Directbytefile;
 * </pre>
 * 
 * An object of the class "Directbytefile" is used to represent an external file
 * in which the individual bytes are addressable by ordinal numbers.
 * <p>
 * The variable LOC is defined to represent such ordinal numbers. When the file
 * is closed, the value of LOC is zero.
 * <p>
 * In this implementation LOC is maintained by the underlying file system.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Directbytefile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Directbytefile extends RTS_Bytefile {

	/**
	 * In this implementation LOC is maintained by the underlying file system.
	 */
	// int _LOC;

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
	public RTS_Directbytefile(final RTS_RTObject SL, final RTS_TXT FN) {
		super(SL, FN);
		_CREATE = _CreateAction.noCreate; // Default for Direct-type files
	}

	// Class Statements
	public RTS_Directbytefile _STM() {
		EBLK();
		return (this);
	}

	/**
	 * The procedure endfile.
	 * <p>
	 * It returns true whenever LOC indicates an address
	 * greater than "lastloc".
	 * <pre>
	 * 		Boolean procedure endfile; endfile:=OPEN and then LOC>lastloc;
	 * </pre>
	 * 
	 * @return the resulting boolean.
	 */
	public boolean endfile() {
		return (_OPEN && (location() > lastloc()));
	}

	/**
	 * The procedure location.
	 * <p>
	 * It returns the current value of LOC.
	 * <p>
	 * In this implementation file.getFilePointer() is used for this purpose.
	 * 
	 * @return the current read/write position.
	 */
	public int location() {
		if (!_OPEN)
			return (0);
		try {
			long loc = randomAccessFile.getFilePointer();
			return ((int) loc + 1);
		} catch (IOException e) {
			if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (-1);
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
	 */
	public int maxloc() {
		return (_MAXLOC);
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
	 * Boolean procedure open;
	 *    if ... then begin ...
	 *       LOC      := 1;
	 *       MAXLOC   := ...; ! fixed size, or maxint-1;
	 *       BYTESIZE := ... ! value of access mode BYTESIZE;
	 *       open     := OPEN := true;
	 * end open;
	 * </pre>
	 * 
	 * @return true:ok, false:error
	 */
	public boolean open() {
		if (RTS_COMMON.Option.VERBOSE)
			TRACE_OPEN("Open Directbytefile");
		if (_OPEN)
			return (false);
		// _LOC = 1; // LOC is maintained by the underlying file system.
		_MAXLOC = maxint - 1;
		_OPEN = true;
		_BYTESIZE = _DEFAULT_BYTESIZE;
		File file = doCreateAction();
		try {
			String mode; // mode is one of "r", "rw", "rws", or "rwd"
			if (_SYNCHRONOUS)
				mode = "rws";
			else
				mode = (_CANREAD & !_CANWRITE) ? "r" : "rw";
			randomAccessFile = new RandomAccessFile(file, mode);
			INITIAL_LAST_LOC = (_APPEND) ? lastloc() : -1;
		} catch (IOException e) {
			if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (false);
		}
		return (true);
	}

	/**
	 * The procedure close.
	 * <pre>
	 * Boolean procedure close;
	 *    if OPEN then begin ...
	 *       MAXLOC := 0;
	 *       OPEN   := false;
	 *       close  := true;
	 * end close;
	 * </pre>
	 * 
	 * @return true:ok, false:error
	 */
	public boolean close() {
		if (!_OPEN)
			return (false);
		_MAXLOC = 0;
		_OPEN = false;
		try {
			if (_PURGE) {
				randomAccessFile.setLength(0);
				randomAccessFile.close();
				File file = new File(FILE_NAME.edText().trim());
				if (file.exists()) {
					RTS_COMMON.printWarning("Purge " + this.getClass().getSimpleName() + " \"" + file.getName()
							+ "\" failed - the underlying OS was unable to perform the delete operation");
				}
			} else
				randomAccessFile.close();
			randomAccessFile = null;
		} catch (IOException e) {
    		if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (false);
		}
		_OPEN = false;
		return (true);
	}

	/**
	 * The procedure locate.
	 * <p>
	 * It is used to assign a given value to the variable LOC. A
	 * parameter value to "locate" which is less than one or greater than MAXLOC
	 * constitutes a run-time error.
	 * <pre>
	 *  procedure locate(p); integer p;
	 *     if p&lt;1 or p>MAXLOC then error("..." ! Parameter out of range; )
	 *     else begin
	 *        LOC:= p;
	 *         ... ;
	 *  end locate;	 *
	 * </pre>
	 * 
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
	 */
	public void locate(final int p) {
		if (p < 1 | p > _MAXLOC)
			throw new RTS_SimulaRuntimeError("Parameter out of range");
		else
			try {
				randomAccessFile.seek(p - 1);
			} catch (IOException e) {
				throw new RTS_SimulaRuntimeError("I/O Error on file", e);
			}
		// LOC is maintained by the underlying file system.
		// _LOC = p;
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
	 */
	public int lastloc() {
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		try {
			// the length of this file, measured in bytes.
			long length = randomAccessFile.length();
			return ((int) length);
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("I/O Error on file", e);
		}
	}

	/**
	 * The procedure inbyte.
	 * <p>
	 * It reads one byte, returning its integer value. The
	 * result of "inbyte" from an unwritten LOC is zero.
	 * <p>
	 * In this implementation the file.read() read a byte starting at the file
	 * pointer and advance the file pointer past the bytes read. I.e. LOC is
	 * maintained by the underlying file system.
	 * 
	 * <pre>
	 * short integer procedure inbyte;
	 *    if not OPEN then error("..." !file closed; )
	 *    else if LOC &lt;= lastloc
	 *    then begin
	 *       inbyte := ... ! next byte of size BYTESIZE;...;
	 *       LOC := LOC+1
	 * end inbyte;
	 * </pre>
	 * 
	 * @return the byte value read.
	 */
	public int inbyte() {
		if (!_CANREAD)
			throw new RTS_SimulaRuntimeError("Directbytefile: inbyte failed - 'canread' is false");
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		// LOC is maintained by the underlying file system.
		// if (_LOC <= lastloc())

		try {
			int b = randomAccessFile.read();
			return (b == -1) ? 0 : b;
		} catch (EOFException e) {
			return (0);

		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("I/O Error on file", e);
		}
		// LOC is maintained by the underlying file system.
		// _LOC = _LOC + 1;
	}

	/**
	 * The procedure outbyte.
	 * <p>
	 * It outputs a byte according to the given parameter
	 * value.
	 * <p>
	 * In this implementation the file.write() writes a byte starting at the file
	 * pointer and advance the file pointer past the byte written. I.e. LOC is
	 * maintained by the underlying file system.
	 * 
	 * <pre>
	 * procedure outbyte(x);  short integer x;
	 *    if not OPEN then error("..." !file closed; )
	 *    else if x &lt; 0 or else x >= 2**BYTESIZE
	 *    then error("..." ! Outbyte, illegal byte value ;);
	 *    else if LOC > MAXLOC then error("..." !file overflow; )
	 *    else begin
	 *         ... ! output of x;
	 *         LOC := LOC + 1
	 * end outbyte;
	 * </pre>
	 * 
	 * @param b the byte value to be written.
	 */
	public void outbyte(final int b) {
		if (!_CANWRITE)
			throw new RTS_SimulaRuntimeError("Directbytefile: outbyte failed - 'canwrite' is false");
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		if (location() <= INITIAL_LAST_LOC)
			throw new RTS_SimulaRuntimeError(
					"Directbytefile: outbyte failed: location(" + location() + ") <= initial lastloc("
							+ INITIAL_LAST_LOC + ")" + " - The file " + FILE_NAME.edText() + " was opend with APPEND");
		if (b < 0 || b > _MAXBYTE)
			throw new RTS_SimulaRuntimeError("Outbyte, illegal byte value: " + b);
		// else
		// LOC is maintained by the underlying file system.
		// if (_LOC > _MAXLOC) error("file overflow");
		try {
			randomAccessFile.write(b);
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("I/O Error on file", e);
		}
		// LOC is maintained by the underlying file system.
		// _LOC = _LOC + 1;
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
		return (true);
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
			fileLock = randomAccessFile.getChannel().lock(loc1, size, true);
		} catch (IOException e) {
			if(RTS_COMMON.Option.VERBOSE) e.printStackTrace();
			return (-2);
		}
		_LOCKED = true;
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

	/**
	 * The procedure intext.
	 * <p>
	 * It fills the frame of the parameter "t" with successive
	 * input bytes.
	 * <pre>
	 * text procedure intext(t);   text t;
	 *    begin
	 *       t.setpos(1);
	 *       while t.more and not ENDFILE do t.putchar(char(inbyte));
	 *       if ENDFILE then t.setpos(t.pos-1);
	 *       intext:- t.sub(1,t.pos-1)
	 * end intext;
	 * </pre>
	 * 
	 * @param t the argument text
	 * @return the resulting text
	 */
	public RTS_TXT intext(final RTS_TXT t) {
		RTS_TXT.setpos(t, 1);
		while (RTS_TXT.more(t) & (!endfile())) {
			RTS_TXT.putchar(t, (char) inbyte());
		}
		if (endfile()) {
			RTS_TXT.setpos(t, RTS_TXT.pos(t) - 1);
		}
		return (RTS_TXT.sub(t, 1, RTS_TXT.pos(t) - 1));
	}

	/**
	 * The procedure outtext. It outputs all characters in the parameter "t" as bytes.
	 * <pre>
	 * procedure outtext(t);   text t;
	 *    begin
	 *       t.setpos(1);
	 *       while t.more do outbyte(rank(t.getchar))
	 * end outtext;
	 * </pre>
	 * 
	 * @param t the argument text
	 */
	public void outtext(final RTS_TXT t) {
		RTS_TXT.setpos(t, 1);
		while (RTS_TXT.more(t)) {
			outbyte((int) RTS_TXT.getchar(t));
		}
	}

}
