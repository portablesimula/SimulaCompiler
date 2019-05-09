package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_register extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ felt=null;
    TXT$ pass=null;
    public HegnaNRK$les_register(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_register STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Registernavn:"));
        felt=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        sysout().outtext(new TXT$("Henter database "));
        sysout().outtext(felt);
        sysout().outimage();
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Angi passord:"));
        pass=new HegnaNRK$les_navn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        sysout().outtext(new TXT$("Database "));
        sysout().outtext(felt);
        sysout().outtext(new TXT$(" tilkoblet"));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_register",1,468,10,470,19,471,21,472,23,473,27,474,29,475,31,476,35,477,39,478);
}
