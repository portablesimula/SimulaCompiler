package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$tekstverdi$kopi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    HegnaNRK$tekstverdi k=null;
    public HegnaNRK$tekstverdi$kopi(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$tekstverdi$kopi STM$() {
        k=new HegnaNRK$tekstverdi(((HegnaNRK)(CUR$.SL$.SL$))).STM$();
        k.tekst$1=copy(copy(((HegnaNRK$tekstverdi)(CUR$.SL$)).tekst$1));
        RESULT$=k;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure kopi",1,108,10,109,18,110,20,111,22,112,26,113);
}
