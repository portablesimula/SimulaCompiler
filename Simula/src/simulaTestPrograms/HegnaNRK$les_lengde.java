package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_lengde extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    int i=0;
    public HegnaNRK$les_lengde(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_lengde STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Ark-lengde:"));
        i=new HegnaNRK$sikker_inint(((HegnaNRK)(CUR$.SL$))).RESULT$;
        while(((i<(0))&((i>(100))))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),14);
                i=new HegnaNRK$sikker_inint(((HegnaNRK)(CUR$.SL$))).RESULT$;
            }
        }
        RESULT$=i;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_lengde",1,992,10,993,18,994,20,995,22,996,24,998,27,999,31,1001,35,1002);
}
