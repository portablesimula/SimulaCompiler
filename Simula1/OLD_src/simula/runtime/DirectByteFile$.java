/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * The class "directbytefile" defines a byte-oriented direct file.
 * <p>
 * 
 * <pre>
 *  bytefile class directbytefile;
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
 * end directbytefile;
 * </pre>
 * 
 * An object of the class "directbytefile" is used to represent an external file
 * in which the individual bytes are addressable by ordinal numbers.
 * <p>
 * The variable LOC is defined to represent such ordinal numbers. When the file
 * is closed, the value of LOC is zero.
 * <p>
 * In this implementation LOC is maintained by the underlying file system.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class DirectByteFile$ extends ByteFile$ {

	/**
	 * In this implementation LOC is maintained by the underlying file system.
	 */
	// int LOC$;

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
	
	private RandomAccessFile randomAccessFile;
	private FileLock fileLock;

	// Constructor
    public DirectByteFile$(final RTObject$ staticLink,final TXT$ FILENAME) {
      super(staticLink,FILENAME);
  	  CREATE$=CreateAction$.noCreate; // Default for Direct-type files
    }
    // Class Statements
    public DirectByteFile$ STM$() {
        EBLK();
        return(this);
    }

	/**
	 * The procedure "endfile" returns true whenever LOC indicates an address
	 * greater than "lastloc".
	 * 
	 * @return
	 */
	public boolean endfile() {
		return (location() > lastloc());
	}

	/**
	 * The procedure "location" returns the current value of LOC.
	 * <p>
	 * In this implementation file.getFilePointer() is used for this purpose.
	 * 
	 * @return the current read/write position.
	 */
	public int location() {
		try {
			long loc = randomAccessFile.getFilePointer();
			return ((int) loc);
		} catch (IOException e) {
			e.printStackTrace();
			return (-1);
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
		if (!OPEN$)
			throw new RuntimeException("file closed");
		return (MAXLOC$);
	}

	public boolean locked() {
		return (LOCKED$);
	}

	/**
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
	 * @return
	 */
	public boolean open() {
		if (OPEN$) return (false);
		doCreateAction();
		// LOC$ = 1; // LOC is maintained by the underlying file system.
		try {
			String mode = "rw"; // mode is one of "r", "rw", "rws", or "rwd"
			randomAccessFile = new RandomAccessFile(FILENAME$.edText(), mode);
		} catch (FileNotFoundException e) {
			return (false);
		}
		MAXLOC$ = maxint - 1;
		BYTESIZE$ = 8;
		OPEN$ = true;
		return (true);
	}

	/**
	 * <pre>
	 * Boolean procedure close;
	 *    if OPEN then begin ...
	 *       MAXLOC := 0;
	 *       OPEN   := false;
	 *       close  := true;
	 * end close;
	 * </pre>
	 * 
	 * @return
	 */
	public boolean close() {
		if (!OPEN$)	return (false);
		MAXLOC$ = 0;
		OPEN$ = false;
		try {
			randomAccessFile.close();
			randomAccessFile = null;
		} catch (IOException e) {
			throw new RuntimeException("I/O Error on file",e);
		}
		doPurgeAction();
		return (true);
	}

	/**
	 * The procedure "locate" is used to assign a given value to the variable
	 * LOC. A parameter value to "locate" which is less than one or greater
	 * than MAXLOC constitutes a run-time error.
	 * <p>
	 * 
	 * <pre>
	 *  procedure locate(p); integer p;
	 *     if p<1 or p>MAXLOC then error("..." ! Parameter out of range; )
	 *     else begin
	 *        LOC:= p;
	 *         ... ;
	 *  end locate;	 *
	 * </pre>
	 * 
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
			throw new RuntimeException("Parameter out of range");
		else
			try {
				randomAccessFile.seek(p);
			} catch (IOException e) {
				throw new RuntimeException("I/O Error on file",e);
			}
		// LOC is maintained by the underlying file system.
		// LOC$ = p;
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
		if (!OPEN$)
			throw new RuntimeException("file closed");
		try {
			// the length of this file, measured in bytes.
			long length = randomAccessFile.length();
			return ((int) length);
		} catch (IOException e) {
			throw new RuntimeException("I/O Error on file",e);
		}
	}

	/**
	 * The procedure "inbyte" reads one byte, returning its integer value. The
	 * result of "inbyte" from an unwritten LOC is zero.
	 * <p>
	 * In this implementation the file.read() read a byte starting at the file
	 * pointer and advance the file pointer past the bytes read. I.e. LOC is
	 * maintained by the underlying file system.
	 * 
	 * <pre>
	 * short integer procedure inbyte;
	 *    if not OPEN then error("..." !file closed; )
	 *    else if LOC <= lastloc
	 *    then begin
	 *       inbyte := ... ! next byte of size BYTESIZE;...;
	 *       LOC := LOC+1
	 * end inbyte;
	 * </pre>
	 * 
	 * @return
	 */
	public int inbyte() {
		if (!OPEN$)
			throw new RuntimeException("file closed");
		// LOC is maintained by the underlying file system.
		// if (LOC$ <= lastloc())

		try {
			return (randomAccessFile.read());
		} catch (EOFException e) {
			return (0);

		} catch (IOException e) {
			throw new RuntimeException("I/O Error on file",e);
		}
		// LOC is maintained by the underlying file system.
		// LOC$ = LOC$ + 1;
	}

	/**
	 * The procedure "outbyte" outputs a byte according to the given parameter
	 * value.
	 * <p>
	 * In this implementation the file.write() writes a byte starting at the
	 * file pointer and advance the file pointer past the byte written. I.e. LOC
	 * is maintained by the underlying file system.
	 * 
	 * <pre>
	 * procedure outbyte(x);  short integer x;
	 *    if not OPEN then error("..." !file closed; )
	 *    else if x < 0 or else x >= 2**BYTESIZE
	 *    then error("..." ! Outbyte, illegal byte value ;);
	 *    else if LOC > MAXLOC then error("..." !file overflow; )
	 *    else begin
	 *         ... ! output of x;
	 *         LOC := LOC + 1
	 * end outbyte;
	 * </pre>
	 * 
	 * @param x
	 */
	public void outbyte(final int x) {
		if (!OPEN$)
			throw new RuntimeException("file closed");
		if (x < 0 || x >= (2 ^ BYTESIZE$))
			throw new RuntimeException("Outbyte, illegal byte value");
		// else
		// LOC is maintained by the underlying file system.
		// if (LOC$ > MAXLOC$) error("file overflow");
		
			try {
				randomAccessFile.write(x);
			} catch (IOException e) {
				throw new RuntimeException("I/O Error on file",e);
			}
		// LOC is maintained by the underlying file system.
		// LOC$ = LOC$ + 1;
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
			e.printStackTrace();
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
		if (timelimit <= 0.0f) return (-1);
		if (LOCKED$) unlock();
		// TODO: Complete the implementation according
		// to Simula Standard Definition.
		// Check that operations are completed within 'timelimit'
		try {
			int size = loc2 - loc1 + 1;
			fileLock = randomAccessFile.getChannel().lock(loc1, size, true);
		} catch (IOException e) {
			e.printStackTrace();
			return (-2);
		}
		LOCKED$ = true;
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

	/**
	 * The procedure "intext" fills the frame of the parameter "t" with
	 * successive input bytes.
	 * <p>
	 * 
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
	 * @param t
	 * @return
	 */
	public TXT$ intext(final TXT$ t) {
		TXT$.setpos(t, 1);
		while (TXT$.more(t) & (!endfile())) {
			TXT$.putchar(t, (char) inbyte());
		}
		if (endfile()) {
			TXT$.setpos(t, TXT$.pos(t) - 1);
		}
		return (TXT$.sub(t, 1, TXT$.pos(t) - 1));
	}

	/**
	 * The procedure "outtext" outputs all characters in the parameter "t" as
	 * bytes.
	 * <p>
	 * 
	 * <pre>
	 * procedure outtext(t);   text t;
	 *    begin
	 *       t.setpos(1);
	 *       while t.more do outbyte(rank(t.getchar))
	 * end outtext;
	 * </pre>
	 * 
	 * @param t
	 */
	public void outtext(final TXT$ t) {
		TXT$.setpos(t, 1);
		while (TXT$.more(t)) {
			outbyte((int) TXT$.getchar(t));
		}
	}

}
