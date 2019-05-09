package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$hjelp extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public HegnaNRK$hjelp(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$hjelp STM$() {
        sysout().outimage();
        for(boolean CB$422:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$)).max_kommando$1); }})
           )) { if(!CB$422) continue;
        {
            sysout().outtext(((HegnaNRK)(CUR$.SL$)).kommando_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).kommando_tabell.LB[0]]);
            sysout().outimage();
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hjelp",1,418,8,420,16,421,18,422,22,424,30,426);
}
