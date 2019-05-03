package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hilse_melding extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$hilse_melding(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$hilse_melding STM$() {
        sysout().outimage();
        sysout().outtext(new TXT$("STORE NORSKE BEREGNINGSKOMPAGNIE"));
        sysout().outimage();
        sysout().outimage();
        sysout().outtext(new TXT$("Person-s�ke-system, versjon 29. februar 1984"));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hilse_melding",1,306,14,309,16,310,19,311,21,312,23,313,27,314);
}
