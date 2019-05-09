package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$slutt_melding extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$slutt_melding(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$slutt_melding STM$() {
        sysout().outtext(new TXT$("Takk for samv�ret"));
        sysout().outimage();
        sysout().outtext(new TXT$("Velkommen igjen om fire �r."));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure slutt_melding",1,316,14,319,17,320,21,321);
}
