package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 00:24:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst123$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public LABQNT$ L1$0() { return(new LABQNT$(this,1,"L1")); }
    final LABQNT$ L3=new LABQNT$(this,2,"L3");
    final LABQNT$ L6=new LABQNT$(this,3,"L6");
    public PRCQNT$ P$0(){ throw new RuntimeException("No Virtual Match: P"); }
    public simtst123$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",36);
    }
    public simtst123$A STM$() {
        simtst123$A THIS$=(simtst123$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                new simtst123$trace(((simtst123)(CUR$.SL$)),new TXT$("A.L1"));
                ((simtst123)(CUR$.SL$)).n=(((simtst123)(CUR$.SL$)).n+(1));
                LABEL$(2,"L3");
                new simtst123$trace(((simtst123)(CUR$.SL$)),new TXT$("A.L3"));
                LABEL$(3,"L6");
                new simtst123$trace(((simtst123)(CUR$.SL$)),new TXT$("A.L6"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Class A",1,34,8,38,10,40,12,41,25,38,29,40,32,41,35,38,49,42);
}
