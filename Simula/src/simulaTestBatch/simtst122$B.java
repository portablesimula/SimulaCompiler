package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 22:54:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst122$B extends simtst122$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ L2=new LABQNT$(this,2,"L2");
    public simtst122$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",35);
    }
    public simtst122$B STM$() {
        simtst122$B THIS$=(simtst122$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                new simtst122$trace(((simtst122)(CUR$.SL$)),new TXT$("A.L1"));
                ((simtst122)(CUR$.SL$)).n=(((simtst122)(CUR$.SL$)).n+(1));
                LABEL$(2,"L2");
                new simtst122$trace(((simtst122)(CUR$.SL$)),new TXT$("B.L2"));
                ((simtst122)(CUR$.SL$)).n=(((simtst122)(CUR$.SL$)).n+(1));
                if(VALUE$((((simtst122)(CUR$.SL$)).n<(4)))) {
                    GOTO$(L1);
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst122.sim","Class B",1,33,8,35,19,30,23,35,27,36,31,35,45,37);
}
