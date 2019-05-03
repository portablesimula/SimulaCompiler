package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$list extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int pnr=0;
    public HegnaNRK$PBLK21$list(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$list STM$() {
        sysout().outimage();
        pnr=1;
        for(boolean CB$433:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1); }})
           )) { if(!CB$433) continue;
        {
            while((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null))) {
                pnr=(pnr+(1));
            }
            sysout().outtext(new TXT$("Post nr."));
            sysout().outint(pnr,4);
            sysout().outimage();
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),pnr);
            new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
            pnr=(pnr+(1));
        }
    }
    sysout().outtext(new TXT$("Totalt antall poster er"));
    sysout().outint(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1,4);
    sysout().outimage();
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure list",1,428,8,430,17,431,19,432,21,433,25,435,30,436,34,437,36,438,38,439,42,441,44,442,49,443);
}
