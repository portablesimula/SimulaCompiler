package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 14:57:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Q extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Q(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Q STM$() {
        new trace(((simtst116)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before first Detach"));
        ((C)(CUR$.SL$)).detach();
        new trace(((simtst116)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before second Detach"));
        ((C)(CUR$.SL$)).detach();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Procedure Q",1,43,14,46,16,47,18,49,20,50,24,52);
}
