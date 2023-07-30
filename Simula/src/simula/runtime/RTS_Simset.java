/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class Simset.
 * <p>
 * The class "simset" contains facilities for the manipulation of circular
 * two-way lists, called "sets".
 * 
 * <pre>
 *          class simset;
 *          begin
 *                     class linkage;
 *             linkage class link; 
 *             linkage class head; 
 *          end simset;
 * </pre>
 * 
 * The reference variables and procedures necessary for set handling are
 * introduced in standard classes declared within the class "simset". Using
 * these classes as prefixes, their relevant data and other properties are made
 * parts of the object themselves.
 * <p>
 * Both sets and objects which may acquire set membership have references to a
 * successor and a predecessor. Consequently they are made subclasses of the
 * "linkage" class.
 * <p>
 * The sets are represented by objects belonging to a subclass "head" of
 * "linkage". Objects which may be set members belong to subclasses of "link"
 * which is itself another subclass of "linkage".
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Simset.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Simset extends RTS_CLASS {

	// Constructor
	/**
	 * Create a new _Simset.
	 * @param SL staticLink
	 */
	public RTS_Simset(final RTS_RTObject SL) {
		super(SL);
		BBLK();
	}

	@Override
	public RTS_Simset _STM() {
		EBLK();
		return (this);
	}

}
