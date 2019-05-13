package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 17:37:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst121$p extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public simtst121$p(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst121$p STM$() {
        new simtst121$PBLK35(CUR$).START$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst121.sim","Procedure p",1,31,8,33,16,55,20,56);
}
