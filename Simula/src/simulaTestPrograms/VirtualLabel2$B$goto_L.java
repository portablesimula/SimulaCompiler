package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualLabel2$B$goto_L extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public VirtualLabel2$B$goto_L(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public VirtualLabel2$B$goto_L STM$() {
        sysout().outtext(new TXT$("In Procedure 'goto_L'"));
        sysout().outimage();
        GOTO$(((VirtualLabel2$B)(CUR$.SL$)).L);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel2.sim","Procedure goto_L",1,15,14,17,17,18,21,19);
}
