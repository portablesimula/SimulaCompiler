/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * The Class "linkage".
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
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class _Linkage extends _SIMULA_BLOCK {
	protected _Linkage SUC = null;
	protected _Linkage PRED = null;

	// Constructor
	public _Linkage(final _RTObject staticLink) {
		super(staticLink);
		BBLK(); // Iff no prefix
	}

	@Override
	public _Linkage _STM() {
		EBLK();
		return (this);
	}

	public _Link suc() {
		return ((SUC instanceof _Link suc) ? suc : null);
	}

	public _Link pred() {
		return ((PRED instanceof _Link pred) ? pred : null);
	}

	public _Linkage prev() {
		return (PRED);
	}
}
