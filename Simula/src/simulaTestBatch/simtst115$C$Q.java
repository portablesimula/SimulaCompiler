package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:10:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst115$C$Q extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst115$C$Q(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst115$C$Q STM$() {
        new simtst115$trace(((simtst115)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before first Detach"));
        ((simtst115$C)(CUR$.SL$)).detach();
        new simtst115$trace(((simtst115)(CUR$.SL$.SL$)),new TXT$("In Procedure Q - Just Before second Detach"));
        ((simtst115$C)(CUR$.SL$)).detach();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst115.sim","Procedure Q",1,38,14,41,16,42,18,44,20,45,24,47);
}
