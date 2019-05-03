package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:15:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Declarations$OK extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Declarations$OK(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Declarations$OK STM$() {
        sysout().outtext(new TXT$("OK"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Declarations.sim","Procedure OK",1,3,17,3);
}
