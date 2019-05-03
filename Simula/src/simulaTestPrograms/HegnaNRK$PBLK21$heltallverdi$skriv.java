package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$skriv extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$heltallverdi$skriv(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$heltallverdi$skriv STM$() {
        sysout().outint(((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1,5);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv",1,66,14,67,18,67);
}
