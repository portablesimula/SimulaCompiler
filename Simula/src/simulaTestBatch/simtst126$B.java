package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 10:30:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst126$B extends simtst126$A {
    public int prefixLevel() { return(1); }
    final LABQNT$ BEGIN_B=new LABQNT$(this,4,"BEGIN_B");
    public LABQNT$ L1$0() { return(new LABQNT$(this,5,"L1")); }
    public PRCQNT$ P$0() { return(new PRCQNT$(this,simtst126$B$P.class)); }
    public simtst126$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",46);
    }
    public simtst126$B STM$() {
        simtst126$B THIS$=(simtst126$B)CUR$;
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
                LABEL$(4,"BEGIN_B");
                new simtst126$trace(((simtst126)(CUR$.SL$)),new TXT$("BEGIN B"));
                LABEL$(5,"L1");
                new simtst126$trace(((simtst126)(CUR$.SL$)),new TXT$("B.L1"));
                ((simtst126)(CUR$.SL$)).n=(((simtst126)(CUR$.SL$)).n+(1));
                if(VALUE$((((simtst126)(CUR$.SL$)).n<(4)))) {
                    {
                        new simtst126$trace(((simtst126)(CUR$.SL$)),new TXT$("JUST BEFORE GOTO S(1) - B.L1"));
                        GOTO$(new simtst126$A$S1(((simtst126$B)CUR$),1).RESULT$);
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst126.sim","Class B",1,44,8,47,10,48,22,38,26,40,29,41,32,47,35,48,39,50,41,52,44,53,48,47,62,55);
}
