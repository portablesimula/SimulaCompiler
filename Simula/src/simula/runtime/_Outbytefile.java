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
 * The class "outbytefile".
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
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class _Outbytefile extends _ByteFile {
	private OutputStream outputStream;

	// Constructor
	public _Outbytefile(final _RTObject staticLink, final _TXT FILENAME) {
		super(staticLink, FILENAME);
	}

	// Class Statements
	@Override
	public _Outbytefile _STM() {
		if (FILE_NAME == null)
			throw new _SimulaRuntimeError("Illegal File Name: null");
		EBLK();
		return (this);
	}

	public boolean open() {
		if (_RT.Option.VERBOSE)
			TRACE_OPEN("open Outbytefile");
		if (_OPEN)
			return (false);
		File file = doCreateAction();
		try {
			outputStream = new FileOutputStream(file, _APPEND);
		} catch (FileNotFoundException e) {
			if (_RT.Option.VERBOSE)
				e.printStackTrace();
			return (false);
		}
		_OPEN = true;
		_BYTESIZE = _DEFAULT_BYTESIZE;
		return (true);
	}

	public boolean close() {
		if (_OPEN) {
			_OPEN = false;
			doPurgeAction();
			return (true);
		}
		return (false);
	}

	public void outbyte(final int b) {
		if (!_OPEN)
			throw new _SimulaRuntimeError("file closed");
		if (b < 0 || b > _MAXBYTE)
			throw new _SimulaRuntimeError("Illegal byte value");
		try {
			outputStream.write(b);
			if (_SYNCHRONOUS)
				outputStream.flush();
		} catch (IOException e) {
			throw new _SimulaRuntimeError("outbyte failed", e);
		}
	}

	public void out2byte(final int b) {
		if (!_OPEN)
			throw new _SimulaRuntimeError("file closed");
		try {
			int hi = b >> 8;
			int lo = b & 0xFF;
			outputStream.write(hi);
			outputStream.write(lo);
			if (_SYNCHRONOUS)
				outputStream.flush();
		} catch (IOException e) {
			throw new _SimulaRuntimeError("out2byte failed", e);
		}
	}

	public void outtext(final _TXT t) {
		_TXT.setpos(t, 1);
		while (_TXT.more(t)) {
			try {
				outputStream.write((int) _TXT.getchar(t));
				if (_SYNCHRONOUS)
					outputStream.flush();
			} catch (IOException e) {
				throw new _SimulaRuntimeError("outtext failed", e);
			}
		}
	}

	public boolean checkpoint() {
		return (false);
	}
}
