package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$kopi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    HegnaNRK$PBLK21$tekstverdi k=null;
    public HegnaNRK$PBLK21$tekstverdi$kopi(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$tekstverdi$kopi STM$() {
        k=new HegnaNRK$PBLK21$tekstverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        k.tekst$1=copy(copy(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1));
        RESULT$=k;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure kopi",1,108,10,109,18,110,20,111,22,112,26,113);
}
