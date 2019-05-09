package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$heltallverdi$skriv extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$heltallverdi$skriv(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$heltallverdi$skriv STM$() {
        sysout().outint(((HegnaNRK$heltallverdi)(CUR$.SL$)).tall$1,5);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv",1,66,14,67,18,67);
}
