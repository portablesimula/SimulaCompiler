/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
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
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class ByteFile$ extends FILE$ {
	protected int BYTESIZE$;

	public int bytesize() {	return (BYTESIZE$);	}

	// Constructor
    public ByteFile$(final RTObject$ staticLink,final TXT$ FILENAME) {
      super(staticLink,FILENAME);
    }
    
    // Class Statements
    public ByteFile$ STM$() {
        if(FILENAME$==null)
        	throw new RuntimeException("Illegal File Name");
        EBLK();
        return(this);
    }

}
