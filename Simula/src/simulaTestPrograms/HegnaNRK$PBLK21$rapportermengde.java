package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$rapportermengde extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public HegnaNRK$PBLK21$rapportermengde(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$rapportermengde STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn$1=new HegnaNRK$PBLK21$les_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        for(boolean CB$1444:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).mengde$1.p$antall); }})
           )) { if(!CB$1444) continue;
        {
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),((ARRAY$<int[]>)((HegnaNRK$PBLK21)(CUR$.SL$)).mengde$1.tabell).Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).mengde$1.tabell.LB[0]]);
            new HegnaNRK$PBLK21$trykk_rapport(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1);
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure rapportermengde",1,1440,8,1442,16,1443,18,1444,22,1446,25,1447,31,1449);
}
