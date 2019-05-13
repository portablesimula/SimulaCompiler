package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 09:52:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst124$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public LABQNT$ L1$0() { return(new LABQNT$(this,1,"L1")); }
    public simtst124$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",37);
    }
    public simtst124$A STM$() {
        simtst124$A THIS$=(simtst124$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                new simtst124$trace(((simtst124)(CUR$.SL$)),new TXT$("A.L1"));
                ((simtst124)(CUR$.SL$)).n=(((simtst124)(CUR$.SL$)).n+(1));
                if(VALUE$((((simtst124)(CUR$.SL$)).n<(4)))) {
                    {
                        new simtst124$trace(((simtst124)(CUR$.SL$)),new TXT$("JUST BEFORE GOTO L1 - B.L1"));
                        GOTO$(L1$0());
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst124.sim","Class A",1,34,8,37,20,37,24,38,26,40,29,41,33,37,47,43);
}
