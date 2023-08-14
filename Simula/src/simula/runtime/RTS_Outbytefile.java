/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * System class Outbytefile.
 * 
 * <pre>
 *  bytefile class outbytefile;
 *     begin
 *           Boolean procedure open;
 *           Boolean procedure close;
 *           procedure outbyte(x); short integer x;
 *           procedure outtext(t); text t;
 *           Boolean procedure checkpoint;
 * 
 *  end outbytefile;
 * </pre>
 * 
 * An object of the class "outbytefile" is used to represent a sequential output
 * file of bytes.
 * <p>
 * Link to GitHub: <a href=
 * "https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Outbytefile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Outbytefile extends RTS_Bytefile {
	
	/**
	 * The OutputStream used.
	 */
	private OutputStream outputStream;

	// Constructor
	/**
	 * Create a new _Outbytefile.
	 * @param SL staticLink
	 * @param FN file name
	 */
	public RTS_Outbytefile(final RTS_RTObject SL, final RTS_TXT FN) {
		super(SL, FN);
	}

	// Class Statements
	@Override
	public RTS_Outbytefile _STM() {
		if (FILE_NAME == null)
			throw new RTS_SimulaRuntimeError("Illegal File Name: null");
		EBLK();
		return (this);
	}

	/**
	 * The procedure open.
	 * <pre>
	 * Boolean procedure open;
	 *    if ... then begin ...
	 *       BYTESIZE := ... ! value of access mode BYTESIZE;
	 *       open     := OPEN := true;
	 * end open;
	 * </pre>
	 * 
	 * @return true:ok, false:error
	 */
	public boolean open() {
		if (RTS_COMMON.Option.VERBOSE)
			TRACE_OPEN("open Outbytefile");
		if (_OPEN)
			return (false);
		File file = doCreateAction();
		try {
			outputStream = new FileOutputStream(file, _APPEND);
		} catch (FileNotFoundException e) {
			if (RTS_COMMON.Option.VERBOSE)
				e.printStackTrace();
			return (false);
		}
		_OPEN = true;
		_BYTESIZE = _DEFAULT_BYTESIZE;
		return (true);
	}

	/**
	 * The procedure close.
	 * <pre>
	 * Boolean procedure close;
	 *    if OPEN then begin ...
	 *       OPEN   := false;
	 *       close  := true;
	 * end close;
	 * </pre>
	 * 
	 * @return true:ok, false:error
	 */
	public boolean close() {
		if (_OPEN) {
			_OPEN = false;
			doPurgeAction();
			return (true);
		}
		return (false);
	}

	/**
	 * Procedure outbyte.
	 * <p>
	 * The procedure "outbyte" outputs a byte corresponding to the parameter value.
	 * If the parameter value is less than zero or exceeds the maximum permitted value,
	 * as defined by BYTESIZE, a runtime error occurs.
	 * <p>
	 * If the file is not open, a run-time error occurs.
	 * @param b the byte to output
	 * @throws RTS_SimulaRuntimeError if the operations fail
	 */
	public void outbyte(final int b) {
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		if (b < 0 || b > _MAXBYTE)
			throw new RTS_SimulaRuntimeError("Illegal byte value");
		try {
			outputStream.write(b);
			if (_SYNCHRONOUS)
				outputStream.flush();
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("outbyte failed", e);
		}
	}

	/**
	 * Procedure out2byte.
	 * <p>
	 * The procedure "out2byte" outputs a byte corresponding to the parameter value.
	 * <p>
	 * If the file is not open, a run-time error occurs.
	 * @param b the integer to output
	 * @throws RTS_SimulaRuntimeError if the operations fail
	 */
	public void out2byte(final int b) {
		if (!_OPEN)
			throw new RTS_SimulaRuntimeError("file closed");
		try {
			int hi = b >> 8;
			int lo = b & 0xFF;
			outputStream.write(hi);
			outputStream.write(lo);
			if (_SYNCHRONOUS)
				outputStream.flush();
		} catch (IOException e) {
			throw new RTS_SimulaRuntimeError("out2byte failed", e);
		}
	}

	/**
	 * Procedure outtext. It outputs all characters in the parameter "t" as bytes.
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
			try {
				outputStream.write((int) RTS_TXT.getchar(t));
				if (_SYNCHRONOUS)
					outputStream.flush();
			} catch (IOException e) {
				throw new RTS_SimulaRuntimeError("outtext failed", e);
			}
		}
	}

	/**
	 * Procedure checkpoint.
	 * <p>
	 * All files producing output (sequential output or direct files) contain a Boolean procedure
	 * "checkpoint". The procedure causes the environment to attempt to secure the output produced so far.
	 * Depending on the nature of the associated external device, this causes completion of output
	 * transfer (i.e. intermediate buffer contents are transferred). If this is not possible or meaningful,
	 * "checkpoint" is a dummy operation in which case the value false is returned.
	 * 
	 * @return true:ok, false:error
	 */
	public boolean checkpoint() {
		try {
			outputStream.flush();
		} catch (IOException e) {
			if (RTS_COMMON.Option.VERBOSE)
				e.printStackTrace();
			return (false);
		}
		return (true);
	}
}
