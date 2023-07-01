/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

public class _Ranking {
	_Ranking bl,ll,rl;
	double rnk;

	public final String name;
	_Ranking(String name) { this.name=name; }
	public _Ranking() { this.name=null; }

//	public void RANK_IN_SQS (Process prc,boolean afore) {
//		Process evt= SQS.last;
//		while(evt.EVTIME > prc.EVTIME) evt = evt.pred;
//		if(afore) while(evt.EVTIME == prc.EVTIME) evt = evt.pred;
//		follow(evt);
//	};
	
    public static _Ranking RANK_PRED (_Ranking ins) {
        _Ranking prd=null; // Return value
        if(ins.rl == ins) {
            prd = null;
        } else if(ins.rl != null) {
            prd = ins.rl;
        } else if(ins.ll != null) {
            prd = ins.ll;
            if(prd.rl == prd) {
                prd = null;
            }
        } else if(ins.bl == null) {
            prd = null;
        } else {
            prd = ins;
            while(prd.bl.ll == prd) {
                prd = prd.bl;
            }
            prd = prd.bl.ll;
        }
        return(prd);
    }

    public static _Ranking RANK_SUC (_Ranking ins) {
        _Ranking suc=null; // Return value
        // JavaLine 170 <== SourceLine 121
        if((ins.bl == (null))) {
            // JavaLine 172 <== SourceLine 122
            suc = ((_Ranking)(null));
        } else if((ins.bl.rl == (ins.bl))) {
            // JavaLine 175 <== SourceLine 123
            suc = ((_Ranking)(null));
        } else {
            // JavaLine 178 <== SourceLine 125
            suc = ins.bl;
            if((((suc.rl != (ins))) && (((suc.rl != (null)))))) {
                // JavaLine 181 <== SourceLine 130
                suc = suc.rl;
                while((suc.ll != (null))) {
                    suc = suc.ll;
                }
            }
        }
        return(suc);
    }

    public static void RANK_CLEAR (_Ranking head) {
        // JavaLine 192 <== SourceLine 121
        _Ranking ins=null;
        // JavaLine 194 <== SourceLine 122
        _Ranking temp=null;
        if((head.rl != (head))) {
            IERR("RANK_CLEAR");
        }
        // JavaLine 199 <== SourceLine 124
        if((head.bl != (head))) {
            ins = head.bl;
            // JavaLine 202 <== SourceLine 125
            ins.ll = ((_Ranking)(null));
            // JavaLine 204 <== SourceLine 126
            head.ll.bl = ((_Ranking)(null));
            // JavaLine 206 <== SourceLine 127
            head.ll = head;
            // JavaLine 208 <== SourceLine 128
            head.bl = head;
            // JavaLine 210 <== SourceLine 129
            while((ins.bl != (null))) {
                // JavaLine 212 <== SourceLine 134
                REPEAT134:while(true) {
                    temp = ins.bl;
                    ins.bl = ((_Ranking)(null));
                    // JavaLine 216 <== SourceLine 135
                    ins = temp;
                    if(!(((ins.rl == (null))) && (((ins.bl != (null)))))) break REPEAT134;
                    // JavaLine 219 <== SourceLine 136
                    ins.ll = ((_Ranking)(null));
                }
                // JavaLine 222 <== SourceLine 139
                ins.ll = ins.rl;
                // JavaLine 224 <== SourceLine 140
                ins.rl = ((_Ranking)(null));
                // JavaLine 226 <== SourceLine 141
                REPEAT141:while(true) {
                    while((ins.ll != (null))) {
                        ins = ins.ll;
                    }
                    // JavaLine 231 <== SourceLine 143
                    if(!(ins.rl != (null))) break REPEAT141;
                    // JavaLine 233 <== SourceLine 145
                    ins.ll = ins.rl;
                    // JavaLine 235 <== SourceLine 146
                    ins.rl = ((_Ranking)(null));
                }
                // JavaLine 238 <== SourceLine 141
            }
        }
    }
    // JavaLine 242 <== SourceLine 119
    public static boolean RANK_EMPTY (_Ranking head) {
        boolean empty=false; // Return value
        // JavaLine 245 <== SourceLine 121
        if((head.rl != (head))) {
            IERR("RANK_EMPTY");
        }
        // JavaLine 249 <== SourceLine 123
        empty = (head.bl == (head));
        return(empty);
    }
    // JavaLine 253 <== SourceLine 119
    public static _Ranking RANK_FIRST (_Ranking head) {
        _Ranking first=null; // Return value
        // JavaLine 256 <== SourceLine 121
        if((head.rl != (head))) {
            IERR("RANK_FIRST");
        }
        // JavaLine 260 <== SourceLine 122
        first = head.bl;
        if((first == (head))) {
            first = ((_Ranking)(null));
        }
        return(first);
    }
    // JavaLine 267 <== SourceLine 119
    public static _Ranking RANK_LAST (_Ranking head) {
        _Ranking last=null; // Return value
        // JavaLine 270 <== SourceLine 121
        if((head.rl != (head))) {
            IERR("RANK_LAST");
        }
        // JavaLine 274 <== SourceLine 122
        last = head.ll;
        if((last == (head))) {
            last = ((_Ranking)(null));
        }
        return(last);
    }
    // JavaLine 281 <== SourceLine 119
    public static void RANK_FOLLOW (_Ranking ins,_Ranking prd) {
        // JavaLine 283 <== SourceLine 122
        if((ins.rl == (ins))) {
            IERR("RANK_FOLLOW");
        }
        // JavaLine 287 <== SourceLine 123
        if((ins.bl != (null))) {
            RANK_OUT(ins);
        }
        // JavaLine 291 <== SourceLine 124
        if(((prd != (null)))) {
            // JavaLine 293 <== SourceLine 127
            if((prd.bl != (null))) {
                // JavaLine 295 <== SourceLine 129
                ins.rnk = prd.rnk;
                if((prd == (prd.bl.ll))) {
                    // JavaLine 298 <== SourceLine 130
                    prd.bl.ll = ins;
                } else {
                    prd.bl.rl = ins;
                }
                // JavaLine 303 <== SourceLine 131
                ins.ll = prd;
                ins.bl = prd.bl;
                // JavaLine 306 <== SourceLine 132
                prd.bl = ins;
            }
        }
    }
    // JavaLine 311 <== SourceLine 119
    public static void RANK_OUT (_Ranking ins) {
        // JavaLine 313 <== SourceLine 121
        _Ranking suc=null;
        _Ranking bl=null;
        _Ranking ll=null;
        // JavaLine 317 <== SourceLine 122
        _Ranking rl=null;
        if((ins.rl == (ins))) {
            IERR("RANK_OUT");
        }
        // JavaLine 322 <== SourceLine 125
        if((ins.bl != (null))) {
            bl = ins.bl;
            ll = ins.ll;
            // JavaLine 326 <== SourceLine 126
            rl = ins.rl;
            // JavaLine 328 <== SourceLine 127
            if((ll == (null))) {
                // JavaLine 330 <== SourceLine 129
                if((bl.ll == (ins))) {
                    bl.ll = bl.rl;
                }
                // JavaLine 334 <== SourceLine 131
                bl.rl = ((_Ranking)(null));
                // JavaLine 336 <== SourceLine 132
            } else if((ll.rl == (ll))) {
                // JavaLine 338 <== SourceLine 133
                if((bl == (ll))) {
                    // JavaLine 340 <== SourceLine 135
                    ll.ll = ll;
                    // JavaLine 342 <== SourceLine 136
                    ll.bl = ll;
                } else {
                    // JavaLine 345 <== SourceLine 137
                    bl.ll = bl.rl;
                    // JavaLine 347 <== SourceLine 139
                    bl.rl = ((_Ranking)(null));
                    // JavaLine 349 <== SourceLine 140
                    suc = bl;
                    while((suc.ll != (null))) {
                        suc = suc.ll;
                    }
                    // JavaLine 354 <== SourceLine 141
                    ll.bl = suc;
                    // JavaLine 356 <== SourceLine 142
                    suc.ll = ll;
                }
                // JavaLine 359 <== SourceLine 144
            } else if((rl == (null))) {
                if((bl.ll == (ins))) {
                    bl.ll = ll;
                } else {
                    bl.rl = ll;
                }
                // JavaLine 366 <== SourceLine 146
                ll.bl = bl;
            } else {
                // JavaLine 369 <== SourceLine 148
                if((bl.ll == (ins))) {
                    bl.ll = rl;
                } else {
                    bl.rl = rl;
                }
                // JavaLine 375 <== SourceLine 153
                rl.bl = bl;
                // JavaLine 377 <== SourceLine 154
                suc = rl;
                while((suc.ll != (null))) {
                    suc = suc.ll;
                }
                // JavaLine 382 <== SourceLine 155
                ll.bl = suc;
                // JavaLine 384 <== SourceLine 156
                suc.ll = ll;
            }
            // JavaLine 387 <== SourceLine 158
            ins.bl = ((_Ranking)(null));
            // JavaLine 389 <== SourceLine 159
            ins.ll = ((_Ranking)(null));
            // JavaLine 391 <== SourceLine 160
            ins.rl = ((_Ranking)(null));
        }
    }
    // JavaLine 395 <== SourceLine 119
    public static void RANK_INTO (_Ranking ins,_Ranking head,double rnk) {
        if(ins.rl == ins) IERR("RANK_INTO-1");
        if(ins.bl != null) RANK_OUT(ins);
        if((head != (null))) {
            if(head.rl != head) IERR("RANK_INTO-2");
            ins.rnk = rnk;
            if(rnk >= head.ll.rnk) {
                ins.bl = head;
                ins.ll = head.ll;
                head.ll.bl = ins;
                head.ll = ins;
            } else if(rnk < head.bl.rnk) {
                ins.ll = head;
                ins.bl = head.bl;
                head.bl.ll = ins;
                head.bl = ins;
            } else {
            	_Ranking e = head.ll;

            	LOOP: while(true) {
            		//_LABEL(0,"L1");
            		//_LABEL(0,"L2");
            		if((e.ll == (null))) {
            			e.ll = ins;
            		} else if(rnk < e.ll.rnk) {
            			e = e.ll;
            			continue LOOP; //_GOTO(L1);
            		} else if((e.rl == (null))) {
            			e.rl = ins;
            		} else if(rnk < e.rl.rnk) {
            			e = e.rl;
            			continue LOOP; //_GOTO(L2);
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
    // JavaLine 468 <== SourceLine 119
    public static void RANK_PRECEDE (_Ranking ins,_Ranking suc) {
        if(ins.rl == ins) IERR("RANK_PRECEDE-1");
        if(ins.bl != null) RANK_OUT(ins);
        if(suc != null) {
            if(suc.rl == suc) IERR("RANK_PRECEDE-2");
            if(suc.bl != null) {
                ins.rnk = suc.rnk;
                ins.bl = suc;
                ins.ll = suc.ll;
                ins.rl = suc.rl;
                suc.ll = ins;
                suc.rl = ((_Ranking)(null));
                if(ins.ll != null) {
                    ins.ll.bl = ins;
                    if(ins.rl != null) ins.rl.bl = ins;
                }
            }
        }
    }
    // JavaLine 506 <== SourceLine 119
    public static void RANK_PRIOR (_Ranking ins,_Ranking head,double rnk) {
        if(ins.rl == ins) IERR("RANK_PRIOR-1");
        if(ins.bl != null) RANK_OUT(ins);
        if((head != (null))) {
            if(head.rl != head) IERR("RANK_PRIOR-2");
            ins.rnk = rnk;
            if(rnk > head.ll.rnk) {
                ins.bl = head;
                ins.ll = head.ll;
                head.ll.bl = ins;
                head.ll = ins;
            } else if(rnk <= head.bl.rnk) {
                ins.ll = head;
                ins.bl = head.bl;
                head.bl.ll = ins;
                head.bl = ins;
            } else {
            	_Ranking e = head.ll;
                
                LOOP: while(true) {
                	//_LABEL(0,"L1");
                	//_LABEL(0,"L2");
                	if(e.ll == null) {
                		e.ll = ins;
                	} else if(rnk <= e.ll.rnk) {
                		e = e.ll;
                		continue LOOP; //_GOTO(L1);
                	} else if(e.rl == null) {
                		e.rl = ins;
                	} else if(rnk <= e.rl.rnk) {
                		e = e.rl;
                		continue LOOP; //_GOTO(L2);
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

    public static void IERR(String msg) {}  
    
    public String toString() {
    	return(""+edit(this));
    }
    
    public String ed() {
    	return(name+"["+rnk+"]");
    }

    public static String edit(_Ranking sqs) {
    	_Ranking x=RANK_FIRST(sqs);
    	if(x==null) return("none");
    	StringBuilder s=new StringBuilder();
    	do s.append(x.ed()).append(", ");
    	while((x=RANK_SUC(x))!=null);
    	return(s.toString());
    }
    
	public static void main(String[] args) {
		_Ranking sqs;
		System.out.println("BEGIN TESTING Class Ranking");
		sqs=new _Ranking("MAIN");
		sqs.bl = sqs;
		sqs.ll = sqs;
		sqs.rl = sqs;

		RANK_INTO(new _Ranking(),sqs,34);
		RANK_INTO(new _Ranking(),sqs,14);
		RANK_INTO(new _Ranking(),sqs,36);
		RANK_INTO(new _Ranking(),sqs,3);
		RANK_PRIOR(new _Ranking("PRIOR"),sqs,34);
		RANK_INTO(new _Ranking("NORMAL"),sqs,34);
		
		System.out.println("FIRST="+_Ranking.RANK_FIRST(sqs));
		
//		System.out.println("SQS="+Ranking.edit(sqs));
		System.out.println("  END TESTING Class Ranking");
	}

}
