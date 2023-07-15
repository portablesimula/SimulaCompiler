/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * Utility class _Ranking.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/_Ranking.java"><b>Source File</b></a>.
 *
 * @author Øystein Myhre Andersen
 */
public class _Ranking {
	_Ranking bl, ll, rl;
	double rnk;

	/* packet */ final String name;

	_Ranking(String name) {
		this.name = name;
	}

	/* packet */ _Ranking() {
		this.name = null;
	}

	/* packet */ static _Ranking RANK_PRED(_Ranking ins) {
		_Ranking prd = null; // Return value
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

	/* packet */ static _Ranking RANK_SUC(_Ranking ins) {
		_Ranking suc = null; // Return value
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

	/* packet */ static void RANK_CLEAR(_Ranking head) {
		_Ranking ins = null;
		_Ranking temp = null;
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

	/* packet */ static boolean RANK_EMPTY(_Ranking head) {
		boolean empty = false; // Return value
		if (head.rl != head) {
			IERR("RANK_EMPTY");
		}
		empty = (head.bl == head);
		return (empty);
	}

	/* packet */ static _Ranking RANK_FIRST(_Ranking head) {
		_Ranking first = null; // Return value
		if (head.rl != head) {
			IERR("RANK_FIRST");
		}
		first = head.bl;
		if (first == head) {
			first = null;
		}
		return (first);
	}

	/* packet */ static _Ranking RANK_LAST(_Ranking head) {
		_Ranking last = null; // Return value
		if (head.rl != head) {
			IERR("RANK_LAST");
		}
		last = head.ll;
		if (last == head) {
			last = null;
		}
		return (last);
	}

	/* packet */ static void RANK_FOLLOW(_Ranking ins, _Ranking prd) {
		if (ins.rl == ins) {
			IERR("RANK_FOLLOW");
		}
		if (ins.bl != null) {
			RANK_OUT(ins);
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

	/* packet */ static void RANK_OUT(_Ranking ins) {
		_Ranking suc = null;
		_Ranking bl = null;
		_Ranking ll = null;
		_Ranking rl = null;
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

	/* packet */ static void RANK_INTO(_Ranking ins, _Ranking head, double rnk) {
		if (ins.rl == ins)
			IERR("RANK_INTO-1");
		if (ins.bl != null)
			RANK_OUT(ins);
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
				_Ranking e = head.ll;

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

	/* packet */ static void RANK_PRECEDE(_Ranking ins, _Ranking suc) {
		if (ins.rl == ins)
			IERR("RANK_PRECEDE-1");
		if (ins.bl != null)
			RANK_OUT(ins);
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

	/* packet */ static void RANK_PRIOR(_Ranking ins, _Ranking head, double rnk) {
		if (ins.rl == ins)
			IERR("RANK_PRIOR-1");
		if (ins.bl != null)
			RANK_OUT(ins);
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
				_Ranking e = head.ll;

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

	/* packet */ static void IERR(String msg) {
	}

	@Override
	public String toString() {
		return ("" + edit(this));
	}

	/* packet */ String ed() {
		return (name + "[" + rnk + "]");
	}

	/* packet */ static String edit(_Ranking sqs) {
		_Ranking x = RANK_FIRST(sqs);
		if (x == null)
			return ("none");
		StringBuilder s = new StringBuilder();
		do
			s.append(x.ed()).append(", ");
		while ((x = RANK_SUC(x)) != null);
		return (s.toString());
	}

//	public static void main(String[] args) {
//		_Ranking sqs;
//		System.out.println("BEGIN TESTING Class Ranking");
//		sqs = new _Ranking("MAIN");
//		sqs.bl = sqs;
//		sqs.ll = sqs;
//		sqs.rl = sqs;
//
//		RANK_INTO(new _Ranking(), sqs, 34);
//		RANK_INTO(new _Ranking(), sqs, 14);
//		RANK_INTO(new _Ranking(), sqs, 36);
//		RANK_INTO(new _Ranking(), sqs, 3);
//		RANK_PRIOR(new _Ranking("PRIOR"), sqs, 34);
//		RANK_INTO(new _Ranking("NORMAL"), sqs, 34);
//
//		System.out.println("FIRST=" + _Ranking.RANK_FIRST(sqs));
//
//		System.out.println("  END TESTING Class Ranking");
//	}

}
