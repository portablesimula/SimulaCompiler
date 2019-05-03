package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$heltallverdi extends HegnaNRK$PBLK21$verdi {
    public int prefixLevel() { return(1); }
    public int tall$1=0;
    public PRCQNT$ skriv$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$skriv.class)); }
    public PRCQNT$ kopi$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$kopi.class)); }
    public PRCQNT$ test_verdilikhet$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$test_verdilikhet.class)); }
    public PRCQNT$ test_verdi_mindre$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre.class)); }
    public PRCQNT$ les$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$les.class)); }
    public HegnaNRK$PBLK21$heltallverdi(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("heltallverdi",101);
    }
    public HegnaNRK$PBLK21$heltallverdi STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class heltallverdi",7,65,19,104,22,104);
}
