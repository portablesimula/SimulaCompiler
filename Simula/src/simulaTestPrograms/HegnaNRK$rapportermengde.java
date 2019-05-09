package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$rapportermengde extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public HegnaNRK$rapportermengde(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$rapportermengde STM$() {
        ((HegnaNRK)(CUR$.SL$)).formatnavn$1=new HegnaNRK$les_formatnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        for(boolean CB$1444:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$)).mengde$1.p$antall); }})
           )) { if(!CB$1444) continue;
        {
            new HegnaNRK$hent_post(((HegnaNRK)(CUR$.SL$)),((ARRAY$<int[]>)((HegnaNRK)(CUR$.SL$)).mengde$1.tabell).Elt[i-((HegnaNRK)(CUR$.SL$)).mengde$1.tabell.LB[0]]);
            new HegnaNRK$trykk_rapport(((HegnaNRK)(CUR$.SL$)),((HegnaNRK)(CUR$.SL$)).formatnr$1);
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure rapportermengde",1,1440,8,1442,16,1443,18,1444,22,1446,25,1447,31,1449);
}
