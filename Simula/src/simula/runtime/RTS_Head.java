/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * 
 * System class Head.
 * <pre>
 *  linkage class head;
 *          begin
 *             ref (link) procedure first; first :- suc;
 *             ref (link) procedure last;   last :- pred;
 *             Boolean procedure empty;    empty := SUC == this linkage;
 * 
 *             integer procedure cardinal;
 *             begin integer i;
 *                ref (link) ptr;
 *                ptr :- first;
 *                while ptr =/= none do begin
 *                   i   := i+1;
 *                   ptr :- ptr.suc
 *                end while;
 *                cardinal := i
 *             end cardinal;
 * 
 *             procedure clear;  while first =/= none do first.out;
 * 
 *             SUC :- PRED :- this linkage
 *          end head;
 * </pre>
 * 
 * An object of the class "head", or a subclass of "head" is used to represent a
 * set. "head" objects may not acquire set membership. Thus, a unique "head" is
 * defined for each set.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Head.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_Head extends RTS_Linkage {
	/**
	 * Construct a new set(Head) with no members.
	 * <p>
	 * The references SUC and PRED initially point to the "head" itself, which
	 * thereby represents an empty set.
	 * 
	 * @param SL staticLink
	 */
	public RTS_Head(final RTS_RTObject SL) {
		super(SL);
		SUC = PRED = (RTS_Linkage) _CUR;
	}

	@Override
	public RTS_Head _STM() {
		// SUC=PRED=(_Linkage)_CUR; // Moved to Constructor
		EBLK(); // LINKAGE
		return (this);
	}

	/**
	 * The procedure "first" may be used to obtain a reference to the first member
	 * of the set.
	 * 
	 * @return The first member of the set(Head)
	 */
	public RTS_Link first() {
		return (suc());
	}

	/**
	 * The procedure "last" may be used to obtain a reference to the last member of
	 * the set.
	 * 
	 * @return The last member of the set(Head)
	 */
	public RTS_Link last() {
		return (pred());
	}

	/**
	 * The Boolean procedure "empty" gives the value true only if the set has no
	 * members.
	 * 
	 * @return true iff no members.
	 */
	public boolean empty() {
		return (SUC == this);
	}

	/**
	 * The integer procedure "cardinal" counts the number of members in a set.
	 * 
	 * @return the number of members in this set
	 */
	public int cardinal() {
		int i = 0;
		RTS_Link ptr = first();
		while (ptr != null) {
			i = i + 1;
			ptr = ptr.suc();
		}
		return (i);
	}

	/**
	 * The procedure "clear" removes all members from the set.
	 */
	public void clear() {
		for (RTS_Link x = first(); x != null; x = first())
			x.out();

	}
}
