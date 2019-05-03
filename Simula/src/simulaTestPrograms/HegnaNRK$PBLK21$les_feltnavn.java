package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_feltnavn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ felt=null;
    public HegnaNRK$PBLK21$les_feltnavn(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_feltnavn STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Felt:"));
        felt=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1=new HegnaNRK$PBLK21$finn_felt(((HegnaNRK$PBLK21)(CUR$.SL$)),felt).RESULT$;
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1==(0))) {
            {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),6);
                felt=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1=new HegnaNRK$PBLK21$finn_felt(((HegnaNRK$PBLK21)(CUR$.SL$)),felt).RESULT$;
            }
        }
        RESULT$=felt;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_feltnavn",1,480,10,482,18,483,20,484,22,485,24,486,26,488,29,489,31,490,35,492,39,493);
}
