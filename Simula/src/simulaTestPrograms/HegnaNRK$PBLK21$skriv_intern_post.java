package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int post_fri=0;
    HegnaNRK$PBLK21$post inspect$799$2=null;
    public HegnaNRK$PBLK21$skriv_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$skriv_intern_post STM$() {
        post_fri=new HegnaNRK$PBLK21$ledig_post_plass(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        if(VALUE$((post_fri!=(0)))) {
            {
                ((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[post_fri-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]=new HegnaNRK$PBLK21$post(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1).STM$();
                {
                    inspect$799$2=((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[post_fri-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]];
                    if(inspect$799$2!=null)
                    for(boolean CB$800:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1); }})
                       )) { if(!CB$800) continue;
                    {
                        inspect$799$2.feltnr.Elt[i-inspect$799$2.feltnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]];
                        inspect$799$2.felt.Elt[i-inspect$799$2.felt.LB[0]]=new HegnaNRK$PBLK21$felt_kopi(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]]).RESULT$;
                    }
                }
            }
            ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1+(1));
            ((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1=post_fri;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_intern_post",1,792,8,794,11,799,19,795,21,796,23,798,26,799,30,800,34,802,37,803,42,805,44,806,50,808);
}
