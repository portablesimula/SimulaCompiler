package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$outim extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst98$outim(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst98$outim STM$() {
        if(VALUE$(((simtst98)(CUR$.SL$)).trace)) {
            sysout().outimage();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure outim",1,40,19,40);
}
