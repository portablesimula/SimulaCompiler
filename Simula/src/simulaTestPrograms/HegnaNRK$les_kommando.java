package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_kommando extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    int kommando=0;
    TXT$ kommando_navn=null;
    public HegnaNRK$les_kommando(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_kommando STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Kommando:"));
        kommando_navn=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        kommando=new HegnaNRK$finn_kommando(((HegnaNRK)(CUR$.SL$)),kommando_navn).RESULT$;
        while((kommando==(0))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),1);
                kommando_navn=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                kommando=new HegnaNRK$finn_kommando(((HegnaNRK)(CUR$.SL$)),kommando_navn).RESULT$;
            }
        }
        RESULT$=kommando;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_kommando",1,278,10,280,12,281,20,282,22,283,24,284,26,285,28,287,31,288,33,289,37,291,41,292);
}
