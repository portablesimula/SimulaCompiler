package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$kopi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    HegnaNRK$PBLK21$heltallverdi k=null;
    public HegnaNRK$PBLK21$heltallverdi$kopi(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$heltallverdi$kopi STM$() {
        k=new HegnaNRK$PBLK21$heltallverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        k.tall$1=((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1;
        RESULT$=k;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure kopi",1,68,10,69,18,70,20,71,22,72,26,73);
}
