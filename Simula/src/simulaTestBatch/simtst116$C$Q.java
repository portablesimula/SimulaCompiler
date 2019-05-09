package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 09 10:47:07 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst116$C$Q extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst116$C$Q(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst116$C$Q STM$() {
        new simtst116$trace(((simtst116)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before first Detach"));
        ((simtst116$C)(CUR$.SL$)).detach();
        new simtst116$trace(((simtst116)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before second Detach"));
        ((simtst116$C)(CUR$.SL$)).detach();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Procedure Q",1,38,14,41,16,42,18,44,20,45,24,47);
}
