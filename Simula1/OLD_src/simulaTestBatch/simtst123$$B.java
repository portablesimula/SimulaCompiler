package simulaTestBatch;
// Simula-1.0 Compiled at Wed Oct 02 09:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst123$$B extends simtst123$$A {
    final LABQNT$ BEGIN_B=new LABQNT$(this,4,"BEGIN_B");
    public LABQNT$ L1$0() { return(new LABQNT$(this,5,"L1")); }
    public PRCQNT$ P$0() { return(new PRCQNT$(this,simtst123$$B$P.class)); }
    public simtst123$$B(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst123$$B STM$() {
        simtst123$$B THIS$=(simtst123$$B)CUR$;
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
                LABEL$(4,"BEGIN_B");
                new simtst123$$trace((CUR$.SL$),new TXT$("BEGIN B"));
                LABEL$(5,"L1");
                new simtst123$$trace((CUR$.SL$),new TXT$("B.L1"));
                ((simtst123$)(CUR$.SL$)).n=Math.addExact(((simtst123$)(CUR$.SL$)).n,1);
                if(VALUE$((((simtst123$)(CUR$.SL$)).n<(4)))) {
                    {
                        new simtst123$$trace((CUR$.SL$),new TXT$("JUST BEFORE GOTO L1 - B.L1"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Class B",1,39,7,42,9,43,20,33,24,35,27,36,30,42,33,43,37,45,39,47,42,48,46,42,60,50);
}
