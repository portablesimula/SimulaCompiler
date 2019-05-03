package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 11:14:52 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue20$OK extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public issue20$OK(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public issue20$OK STM$() {
        sysout().outtext(new TXT$("OK"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue20.sim","Procedure OK",1,3,17,3);
}
