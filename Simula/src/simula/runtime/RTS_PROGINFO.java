/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Utility class PROGINFO.
 * <p>
 * This class is used to hold a mapping of source line numbers and java lines.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_PROGINFO.java"><b>Source File</b></a>.
 * 
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_PROGINFO {
	
	/**
	 * Simula Source File - e.g. program.sim
	 */
	final String file;
	
	/**
	 * Program ident.
	 */
	final String ident;
	
	/**
	 * The line-map.
	 */
	final int[] LINEMAP_;

	/**
	 * Create a new _PROGINFO.
	 * 
	 * @param file source file name
	 * @param ident program ident
	 * @param lineMap a line map
	 */
	public RTS_PROGINFO(final String file, final String ident, final int... lineMap) {
		this.file = file;
		this.ident = ident;
		this.LINEMAP_ = lineMap;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(file).append(':').append(ident);
		int x = 0;
		while (x < LINEMAP_.length) {
			sb.append("<j").append(LINEMAP_[x++]).append(":s").append(LINEMAP_[x++]).append('>');
		}
		return (sb.toString());
	}
}
