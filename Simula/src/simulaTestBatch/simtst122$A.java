package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 22:54:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst122$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ L1=new LABQNT$(this,1,"L1");
    public simtst122$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",30);
    }
    public simtst122$A STM$() {
        simtst122$A THIS$=(simtst122$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                new simtst122$trace(((simtst122)(CUR$.SL$)),new TXT$("A.L1"));
                ((simtst122)(CUR$.SL$)).n=(((simtst122)(CUR$.SL$)).n+(1));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst122.sim","Class A",1,28,8,30,36,31);
}
