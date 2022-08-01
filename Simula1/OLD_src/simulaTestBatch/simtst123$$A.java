package simulaTestBatch;
// Simula-1.0 Compiled at Wed Oct 02 09:47:31 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst123$$A extends CLASS$ {
    public LABQNT$ L1$0() { return(new LABQNT$(this,1,"L1")); }
    final LABQNT$ L3=new LABQNT$(this,2,"L3");
    final LABQNT$ L6=new LABQNT$(this,3,"L6");
    public PRCQNT$ P$0(){ throw new RuntimeException("No Virtual Match: P"); }
    public simtst123$$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
    }
    public simtst123$$A STM$() {
        simtst123$$A THIS$=(simtst123$$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                new simtst123$$trace((CUR$.SL$),new TXT$("A.L1"));
                ((simtst123$)(CUR$.SL$)).n=Math.addExact(((simtst123$)(CUR$.SL$)).n,1);
                LABEL$(2,"L3");
                new simtst123$$trace((CUR$.SL$),new TXT$("A.L3"));
                LABEL$(3,"L6");
                new simtst123$$trace((CUR$.SL$),new TXT$("A.L6"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Class A",1,29,7,33,9,35,11,36,23,33,27,35,30,36,33,33,47,37);
}
