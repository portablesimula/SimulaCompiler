package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 05 12:42:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst112$B$goto_L extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst112$B$goto_L(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst112$B$goto_L STM$() {
        new simtst112$trace(((simtst112)(CUR$.SL$.SL$)),new TXT$("In Procedure 'goto_L'"));
        GOTO$(((simtst112$B)(CUR$.SL$)).L);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst112.sim","Procedure goto_L",1,40,14,42,16,43,20,44);
}
