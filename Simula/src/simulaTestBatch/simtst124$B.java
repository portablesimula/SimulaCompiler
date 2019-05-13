package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 09:52:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst124$B extends simtst124$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ BEGIN_B=new LABQNT$(this,2,"BEGIN_B");
    public LABQNT$ L1$0() { return(new LABQNT$(this,3,"L1")); }
    public simtst124$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",48);
    }
    public simtst124$B STM$() {
        simtst124$B THIS$=(simtst124$B)CUR$;
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
                LABEL$(2,"BEGIN_B");
                new simtst124$trace(((simtst124)(CUR$.SL$)),new TXT$("BEGIN B"));
                LABEL$(3,"L1");
                new simtst124$trace(((simtst124)(CUR$.SL$)),new TXT$("B.L1"));
                ((simtst124)(CUR$.SL$)).n=(((simtst124)(CUR$.SL$)).n+(1));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst124.sim","Class B",1,45,8,47,10,48,21,37,25,38,27,40,30,41,34,47,37,48,41,47,55,50);
}
