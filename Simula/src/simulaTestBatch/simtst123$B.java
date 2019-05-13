package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 00:24:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst123$B extends simtst123$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ BEGIN_B=new LABQNT$(this,4,"BEGIN_B");
    public LABQNT$ L1$0() { return(new LABQNT$(this,5,"L1")); }
    public PRCQNT$ P$0() { return(new PRCQNT$(this,simtst123$B$P.class)); }
    public simtst123$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",46);
    }
    public simtst123$B STM$() {
        simtst123$B THIS$=(simtst123$B)CUR$;
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
                LABEL$(4,"BEGIN_B");
                new simtst123$trace(((simtst123)(CUR$.SL$)),new TXT$("BEGIN B"));
                LABEL$(5,"L1");
                new simtst123$trace(((simtst123)(CUR$.SL$)),new TXT$("B.L1"));
                ((simtst123)(CUR$.SL$)).n=(((simtst123)(CUR$.SL$)).n+(1));
                if(VALUE$((((simtst123)(CUR$.SL$)).n<(4)))) {
                    {
                        new simtst123$trace(((simtst123)(CUR$.SL$)),new TXT$("JUST BEFORE GOTO L1 - B.L1"));
                        sysout().outimage();
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst123.sim","Class B",1,44,8,47,10,48,22,38,26,40,29,41,32,47,35,48,39,50,41,52,45,53,49,47,63,55);
}
