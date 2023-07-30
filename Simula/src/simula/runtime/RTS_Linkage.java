/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class Linkage.
 * <pre>
 *          class linkage;
 *          begin ref (linkage) SUC, PRED;
 *             ref (link) procedure suc;
 *                        suc:- if SUC in link then SUC else none;
 *             ref (link) procedure pred;
 *                       pred:- if PRED in link then PRED else none;
 *             ref (linkage) procedure prev;   prev:- PRED;
 * 
 *          end linkage;
 * </pre>
 * 
 * The class "linkage" is the common denominator for set heads and set members.
 * <p>
 * SUC is a reference to the successor of this linkage object in the set, PRED
 * is a reference to the predecessor.
 * <p>
 * The value of SUC and PRED may be obtained through the procedures "suc" and
 * "pred". These procedures give the value none if the designated object is not
 * a set member, i.e. of class "link" or a subclass of "link".
 * <p>
 * The attributes SUC and PRED may only be modified through the use of
 * procedures defined within "link" and "head". This protects the user against
 * certain kinds of programming errors.
 * <p>
 * The procedure "prev" enables a user to access a set head from its first
 * member.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Linkage.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Linkage extends RTS_CLASS {
	
	/**
	 * The variable SUC.
	 */
	protected RTS_Linkage SUC = null;
	/**
	 * The variable PRED.
	 */
	protected RTS_Linkage PRED = null;

	// Constructor
	/**
	 * Create a new _Linkage.
	 * @param SL staticLink
	 */
	public RTS_Linkage(final RTS_RTObject SL) {
		super(SL);
		BBLK(); // Iff no prefix
	}

	@Override
	public RTS_Linkage _STM() {
		EBLK();
		return (this);
	}

	/**
	 * Returns the successor link.
	 * @return the successor link
	 */
	public RTS_Link suc() {
		return ((SUC instanceof RTS_Link suc) ? suc : null);
	}

	/**
	 * Returns the predecessor link.
	 * @return the predecessor link
	 */
	public RTS_Link pred() {
		return ((PRED instanceof RTS_Link pred) ? pred : null);
	}

	/**
	 * Return the previous linkage.
	 * @return the previous linkage
	 */
	public RTS_Linkage prev() {
		return (PRED);
	}
}
