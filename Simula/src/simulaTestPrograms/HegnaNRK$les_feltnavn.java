package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_feltnavn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ felt=null;
    public HegnaNRK$les_feltnavn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_feltnavn STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Felt:"));
        felt=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        ((HegnaNRK)(CUR$.SL$)).feltnr$1=new HegnaNRK$finn_felt(((HegnaNRK)(CUR$.SL$)),felt).RESULT$;
        while((((HegnaNRK)(CUR$.SL$)).feltnr$1==(0))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),6);
                felt=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                ((HegnaNRK)(CUR$.SL$)).feltnr$1=new HegnaNRK$finn_felt(((HegnaNRK)(CUR$.SL$)),felt).RESULT$;
            }
        }
        RESULT$=felt;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_feltnavn",1,480,10,482,18,483,20,484,22,485,24,486,26,488,29,489,31,490,35,492,39,493);
}
