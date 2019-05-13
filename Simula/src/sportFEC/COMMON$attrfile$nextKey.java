package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$nextKey extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ REP=new LABQNT$(this,1,"REP");
    public COMMON$attrfile$nextKey(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$attrfile$nextKey STM$() {
        COMMON$attrfile$nextKey THIS$=(COMMON$attrfile$nextKey)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"REP");
                ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).bufSwap)))) {
                    {
                        new COMMON$attrfile$swapIbuffer(((COMMON$attrfile)(CUR$.SL$)));
                        GOTO$(REP);
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
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nextKey",1,1346,8,1347,23,1348,25,1349,44,1350);
}
