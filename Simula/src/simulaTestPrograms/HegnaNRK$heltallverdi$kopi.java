package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$heltallverdi$kopi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    HegnaNRK$heltallverdi k=null;
    public HegnaNRK$heltallverdi$kopi(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$heltallverdi$kopi STM$() {
        k=new HegnaNRK$heltallverdi(((HegnaNRK)(CUR$.SL$.SL$))).STM$();
        k.tall$1=((HegnaNRK$heltallverdi)(CUR$.SL$)).tall$1;
        RESULT$=k;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure kopi",1,68,10,69,18,70,20,71,22,72,26,73);
}
