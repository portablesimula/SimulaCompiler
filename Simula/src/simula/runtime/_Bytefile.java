/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class Bytefile.
 * <p>
 * The class bytefile is the common prefix class for all byte-oriented files.
 * 
 * <pre>
 *     file class bytefile;
 *          begin short integer BYTESIZE;
 *             short integer procedure bytesize; bytesize := BYTESIZE;
 * 
 *          end bytefile;
 * </pre>
 * 
 * Bytefiles read and write files as continuous streams of bytes. The variable
 * BYTESIZE defines the range of the byte values transferred. Byte values are
 * integers in the range (0:2**BYTESIZE-1). The BYTESIZE value of the file
 * object is accessible through procedure "bytesize".
 * <p>
 * Note: "Bytesize" returns zero before first "open" of the bytefile.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/_ByteFile.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class _Bytefile extends _File {
	protected int _BYTESIZE;
	protected final int _MAXBYTE = 255;

	/**
	 * Returns the _BYTESIZE value.
	 * @return the _BYTESIZE value.
	 */
	public int bytesize() {
		return (_BYTESIZE);
	}

	// Constructor
	/**
	 * Create a new _ByteFile.
	 * @param staticLink static link
	 * @param FILENAME the file name.
	 */
	public _Bytefile(final _RTObject staticLink, final _TXT FILENAME) {
		super(staticLink, FILENAME);
	}

	// Class Statements
	public _Bytefile _STM() {
		if (FILE_NAME == null)
			throw new _SimulaRuntimeError("Illegal File Name");
		EBLK();
		return (this);
	}

}
