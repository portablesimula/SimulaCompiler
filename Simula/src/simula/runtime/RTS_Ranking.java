/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import static simula.runtime.RTS_COMMON.*;

/**
 * Utility class Ranking.
 * <p>
 * This is an implementation of a balanced tree used to support the sequencing set in class Simulation.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_Ranking.java"><b>Source File</b></a>.
 *
 * @author Øystein Myhre Andersen
 */
public class RTS_Ranking {
	
	/**
	 * Back link.
	 */
	RTS_Ranking bl;
	
	/**
	 * Left link.
	 */
	RTS_Ranking ll;
	
	/**
	 * Right link.
	 */
	RTS_Ranking rl;
	
	/**
	 * The ranking value.
	 */
	double rnk;

	/**
	 * Default Constructor.
	 */
	RTS_Ranking() {}

	/**
	 * Returns the predecessor of the given instance.
	 * @param ins the given instance
	 * @return pred the predecessor of the given instance.
	 */
	static RTS_Ranking PRED(RTS_Ranking ins) {
		RTS_Ranking prd = null; // Return value
		if (ins.rl == ins) {
			prd = null;
		} else if (ins.rl != null) {
			prd = ins.rl;
		} else if (ins.ll != null) {
			prd = ins.ll;
			if (prd.rl == prd) {
				prd = null;
			}
		} else if (ins.bl == null) {
			prd = null;
		} else {
			prd = ins;
			while (prd.bl.ll == prd) {
				prd = prd.bl;
			}
			prd = prd.bl.ll;
		}
		return (prd);
	}

	/**
	 * Returns the successor of the given instance.
	 * @param ins the given instance
	 * @return suc the successor of the given instance.
	 */
	static RTS_Ranking SUC(RTS_Ranking ins) {
		RTS_Ranking suc = null; // Return value
		if (ins.bl == null) {
			suc = null;
		} else if (ins.bl.rl == ins.bl) {
			suc = null;
		} else {
			suc = ins.bl;
			if ((suc.rl != ins) && (suc.rl != null)) {
				suc = suc.rl;
				while (suc.ll != null) {
					suc = suc.ll;
				}
			}
		}
		return (suc);
	}

	/**
	 * Clear the Ranking tree.
	 * @param head the head of the tree
	 */
	static void CLEAR(RTS_Ranking head) {
		RTS_Ranking ins = null;
		RTS_Ranking temp = null;
		if (head.rl != head) {
			IERR("RANK_CLEAR");
		}
		if (head.bl != head) {
			ins = head.bl;
			ins.ll = null;
			head.ll.bl = null;
			head.ll = head;
			head.bl = head;
			while (ins.bl != null) {
				REPEAT134: while (true) {
					temp = ins.bl;
					ins.bl = null;
					ins = temp;
					if (!((ins.rl == null) && (ins.bl != null)))
						break REPEAT134;
					ins.ll = null;
				}
				ins.ll = ins.rl;
				ins.rl = null;
				REPEAT141: while (true) {
					while (ins.ll != null) {
						ins = ins.ll;
					}
					if (!(ins.rl != null))
						break REPEAT141;
					ins.ll = ins.rl;
					ins.rl = null;
				}
			}
		}
	}

	/**
	 * Check if the Ranking tree is empty.
	 * @param head the head of the tree
	 * @return true if the Ranking tree is empty, otherwise false
	 */
	static boolean EMPTY(RTS_Ranking head) {
		boolean empty = false; // Return value
		if (head.rl != head) {
			IERR("RANK_EMPTY");
		}
		empty = (head.bl == head);
		return (empty);
	}

	/**
	 * Returns the first element of the ranking tree.
	 * @param head the head of the tree
	 * @return the first element of the ranking tree
	 */
	static RTS_Ranking FIRST(RTS_Ranking head) {
		RTS_Ranking first = null; // Return value
		if (head.rl != head) {
			IERR("RANK_FIRST");
		}
		first = head.bl;
		if (first == head) {
			first = null;
		}
		return (first);
	}

	/**
	 * Returns the last element of the ranking tree.
	 * @param head the head of the tree
	 * @return the last element of the ranking tree
	 */
	static RTS_Ranking LAST(RTS_Ranking head) {
		RTS_Ranking last = null; // Return value
		if (head.rl != head) {
			IERR("RANK_LAST");
		}
		last = head.ll;
		if (last == head) {
			last = null;
		}
		return (last);
	}

	/**
	 * Insert 'ins' following 'prd'.
	 * @param ins argument
	 * @param prd argument
	 */
	static void FOLLOW(RTS_Ranking ins, RTS_Ranking prd) {
		if (ins.rl == ins) {
			IERR("RANK_FOLLOW");
		}
		if (ins.bl != null) {
			OUT(ins);
		}
		if (prd != null) {
			if (prd.bl != null) {
				ins.rnk = prd.rnk;
				if (prd == prd.bl.ll) {
					prd.bl.ll = ins;
				} else {
					prd.bl.rl = ins;
				}
				ins.ll = prd;
				ins.bl = prd.bl;
				prd.bl = ins;
			}
		}
	}

	/**
	 * Remove 'ins' from the ranking tree.
	 * @param ins argument
	 */
	static void OUT(RTS_Ranking ins) {
		RTS_Ranking suc = null;
		RTS_Ranking bl = null;
		RTS_Ranking ll = null;
		RTS_Ranking rl = null;
		if (ins.rl == ins) {
			IERR("RANK_OUT");
		}
		if (ins.bl != null) {
			bl = ins.bl;
			ll = ins.ll;
			rl = ins.rl;
			if (ll == null) {
				if (bl.ll == ins) {
					bl.ll = bl.rl;
				}
				bl.rl = null;
			} else if (ll.rl == ll) {
				if (bl == ll) {
					ll.ll = ll;
					ll.bl = ll;
				} else {
					bl.ll = bl.rl;
					bl.rl = null;
					suc = bl;
					while (suc.ll != null) {
						suc = suc.ll;
					}
					ll.bl = suc;
					suc.ll = ll;
				}
			} else if (rl == null) {
				if (bl.ll == ins) {
					bl.ll = ll;
				} else {
					bl.rl = ll;
				}
				ll.bl = bl;
			} else {
				if (bl.ll == ins) {
					bl.ll = rl;
				} else {
					bl.rl = rl;
				}
				rl.bl = bl;
				suc = rl;
				while (suc.ll != null) {
					suc = suc.ll;
				}
				ll.bl = suc;
				suc.ll = ll;
			}
			ins.bl = null;
			ins.ll = null;
			ins.rl = null;
		}
	}

	/**
	 * Insert 'ins' intp the ranking tree acording to the ranking value.
	 * @param ins argument
	 * @param head the head of the tree
	 * @param rnk the ranking value
	 */
	static void INTO(RTS_Ranking ins, RTS_Ranking head, double rnk) {
		if (ins.rl == ins)
			IERR("RANK_INTO-1");
		if (ins.bl != null)
			OUT(ins);
		if (head != null) {
			if (head.rl != head)
				IERR("RANK_INTO-2");
			ins.rnk = rnk;
			if (rnk >= head.ll.rnk) {
				ins.bl = head;
				ins.ll = head.ll;
				head.ll.bl = ins;
				head.ll = ins;
			} else if (rnk < head.bl.rnk) {
				ins.ll = head;
				ins.bl = head.bl;
				head.bl.ll = ins;
				head.bl = ins;
			} else {
				RTS_Ranking e = head.ll;

				LOOP: while (true) {
					if (e.ll == null) {
						e.ll = ins;
					} else if (rnk < e.ll.rnk) {
						e = e.ll;
						continue LOOP; // _GOTO(L1);
					} else if (e.rl == null) {
						e.rl = ins;
					} else if (rnk < e.rl.rnk) {
						e = e.rl;
						continue LOOP; // _GOTO(L2);
					} else {
						ins.ll = e.rl;
						e.rl.bl = ins;
						e.rl = ins;
					}
					break LOOP;
				}
				ins.bl = e;
			}
		}
	}

	/**
	 * Insert 'ins' preceding 'suc'.
	 * @param ins argument
	 * @param suc argument
	 */
	static void PRECEDE(RTS_Ranking ins, RTS_Ranking suc) {
		if (ins.rl == ins)
			IERR("RANK_PRECEDE-1");
		if (ins.bl != null)
			OUT(ins);
		if (suc != null) {
			if (suc.rl == suc)
				IERR("RANK_PRECEDE-2");
			if (suc.bl != null) {
				ins.rnk = suc.rnk;
				ins.bl = suc;
				ins.ll = suc.ll;
				ins.rl = suc.rl;
				suc.ll = ins;
				suc.rl = null;
				if (ins.ll != null) {
					ins.ll.bl = ins;
					if (ins.rl != null)
						ins.rl.bl = ins;
				}
			}
		}
	}

	/**
	 * Insert 'ins' into the ranking tree acording to the ranking value with priority.
	 * @param ins argument
	 * @param head the head of the tree
	 * @param rnk the ranking value
	 */
	static void INTO_PRIOR(RTS_Ranking ins, RTS_Ranking head, double rnk) {
		if (ins.rl == ins)
			IERR("RANK_PRIOR-1");
		if (ins.bl != null)
			OUT(ins);
		if (head != null) {
			if (head.rl != head)
				IERR("RANK_PRIOR-2");
			ins.rnk = rnk;
			if (rnk > head.ll.rnk) {
				ins.bl = head;
				ins.ll = head.ll;
				head.ll.bl = ins;
				head.ll = ins;
			} else if (rnk <= head.bl.rnk) {
				ins.ll = head;
				ins.bl = head.bl;
				head.bl.ll = ins;
				head.bl = ins;
			} else {
				RTS_Ranking e = head.ll;

				LOOP: while (true) {
					if (e.ll == null) {
						e.ll = ins;
					} else if (rnk <= e.ll.rnk) {
						e = e.ll;
						continue LOOP; // _GOTO(L1);
					} else if (e.rl == null) {
						e.rl = ins;
					} else if (rnk <= e.rl.rnk) {
						e = e.rl;
						continue LOOP; // _GOTO(L2);
					} else {
						ins.ll = e.rl;
						e.rl.bl = ins;
						e.rl = ins;
					}
					break LOOP;
				}

				ins.bl = e;
			}
		}
	}

}
