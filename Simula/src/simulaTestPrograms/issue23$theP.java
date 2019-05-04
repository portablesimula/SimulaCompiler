package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:42:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23$theP extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public issue23$theP(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public issue23$theP STM$() {
        sysout().outtext(new TXT$("  theP  "));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","Procedure theP",1,9,14,10,18,10);
}
