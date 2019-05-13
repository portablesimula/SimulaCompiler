package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 10:30:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst126$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public LABQNT$ L1$0() { return(new LABQNT$(this,1,"L1")); }
    final LABQNT$ L3=new LABQNT$(this,2,"L3");
    final LABQNT$ L6=new LABQNT$(this,3,"L6");
    public PRCQNT$ P$0(){ throw new RuntimeException("No Virtual Match: P"); }
    public simtst126$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",36);
    }
    public simtst126$A STM$() {
        simtst126$A THIS$=(simtst126$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                new simtst126$trace(((simtst126)(CUR$.SL$)),new TXT$("A.L1"));
                ((simtst126)(CUR$.SL$)).n=(((simtst126)(CUR$.SL$)).n+(1));
                LABEL$(2,"L3");
                new simtst126$trace(((simtst126)(CUR$.SL$)),new TXT$("A.L3"));
                LABEL$(3,"L6");
                new simtst126$trace(((simtst126)(CUR$.SL$)),new TXT$("A.L6"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst126.sim","Class A",1,34,8,38,10,40,12,41,25,38,29,40,32,41,35,38,49,42);
}
