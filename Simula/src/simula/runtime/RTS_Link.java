/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class Link.
 * <pre>
 *  linkage class link;
 *          begin
 *             procedure out;
 *             if SUC=/=none then begin
 *                SUC.PRED :- PRED;
 *                PRED.SUC :- SUC;
 *                SUC      :- PRED :- none
 *             end out;
 * 
 *             procedure follow(ptr); ref (linkage) ptr;
 *             begin  out;
 *                if ptr=/=none and then ptr.SUC=/=none then begin
 *                   PRED     :- ptr;
 *                   SUC      :- ptr.SUC;
 *                   SUC.PRED :- ptr.SUC :- this linkage  end
 *             end follow;
 * 
 *             procedure precede(ptr); ref (linkage) ptr;
 *             begin  out;
 *                if ptr=/=none and then ptr.SUC=/=none then begin
 *                   SUC      :- ptr;
 *                   PRED     :- ptr.PRED;
 *                   PRED.SUC :- ptr.PRED :- this linkage end if
 *             end precede;
 * 
 *             procedure into(S); ref (head) S;  precede(S);
 * 
 *          end link;
 * </pre>
 * 
 * Objects belonging to subclasses of the class "link" may acquire set
 * membership. An object may only be a member of one set at a given instant.
 * <p>
 * In addition to the procedures "suc" and "pred", there are four procedures
 * associated with each "link" object: "out", "follow", "precede" and "into".
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Link.java"><b>Source File</b></a>.
 * 
 * 
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Link extends RTS_Linkage {

	// Constructor
	/**
	 * Create a new _Link.
	 * @param SL staticLink
	 */
	public RTS_Link(final RTS_RTObject SL) {
		super(SL);
	}

	@Override
	public RTS_Link _STM() {
		EBLK();
		return (this);
	}

	/**
	 * Procedure out.
	 * <p>
	 * The procedure "out" removes the object from the set (if any) of which it is a
	 * member. The procedure call has no effect if the object has no set membership.
	 */
	public void out() {
		if (SUC != null) {
			SUC.PRED = PRED;
			PRED.SUC = SUC;
			SUC = PRED = ((RTS_Linkage) (null));
		}
	}

	/**
	 * Procedure follow.
	 * <p>
	 * The procedure "follow" remove the object from the set (if any)
	 * of which it is a member and insert it in a set at a given position. The set
	 * and the position are indicated by a parameter which is inner to "linkage".
	 * The procedure call has the same effect as "out" (except for possible side
	 * effects from evaluation of the parameter) if the parameter is none or if it
	 * has no set membership and is not a set head. Otherwise the object is inserted
	 * immediately after the "linkage" object
	 * designated by the parameter.
	 * 
	 * @param x argument x
	 */
	public void follow(final RTS_Linkage x) {
		out();
		if (x != null) {
			if (x.SUC != null) {
				PRED = x;
				SUC = x.SUC;
				SUC.PRED = x.SUC = (RTS_Linkage) this;
			}
		}
	}

	/**
	 * Procedure precede.
	 * <p>
	 * The procedure "precede" remove the object from the set (if any)
	 * of which it is a member and insert it in a set at a given position. The set
	 * and the position are indicated by a parameter which is inner to "linkage".
	 * The procedure call has the same effect as "out" (except for possible side
	 * effects from evaluation of the parameter) if the parameter is none or if it
	 * has no set membership and is not a set head. Otherwise the object is inserted
	 * immediately before the "linkage" object
	 * designated by the parameter.
	 * 
	 * @param x argument x
	 */
	public void precede(final RTS_Linkage x) {
		out();
		if (x != null) {
			if (x.SUC != null) {
				SUC = x;
				PRED = x.PRED;
				PRED.SUC = x.PRED = (RTS_Linkage) this;
			}
		}
	}

	/**
	 * Procedure into.
	 * <p>
	 * The procedure "into" removes the object from the set (if any) of which it is
	 * a member and inserts it as the last member of the set designated by the
	 * parameter. The procedure call has the same effect as "out" if the parameter
	 * has the value none (except for possible side effects from evaluating the
	 * actual parameter).
	 * 
	 * @param S The set(Head) to receive this Link.
	 */
	public void into(final RTS_Head S) {
		precede(S);
	}
}
