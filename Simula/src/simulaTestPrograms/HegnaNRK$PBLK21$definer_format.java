package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$definer_format extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    HegnaNRK$PBLK21$format inspect$925$4=null;
    public HegnaNRK$PBLK21$definer_format(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$definer_format STM$() {
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1>=(((HegnaNRK$PBLK21)(CUR$.SL$)).max_format_def$1)))) {
            new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),13);
        } else
        {
            ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn$1=new HegnaNRK$PBLK21$les_nytt_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            ((HegnaNRK$PBLK21)(CUR$.SL$)).format_ark_lengde$1=new HegnaNRK$PBLK21$les_lengde(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1+(1));
            ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1-((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn$1;
            i=0;
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_felt$1))) {
                {
                    if(VALUE$((i>=(((HegnaNRK$PBLK21)(CUR$.SL$)).max_format_lengde$1)))) {
                        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),15);
                    } else
                    {
                        i=(i+(1));
                        ((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1;
                        ((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.LB[0]]=new HegnaNRK$PBLK21$les_startposisjon(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                    }
                    ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                }
            }
            ((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]]=new HegnaNRK$PBLK21$format(((HegnaNRK$PBLK21)(CUR$.SL$)),i).STM$();
            {
                inspect$925$4=((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]];
                if(inspect$925$4!=null)
                {
                    inspect$925$4.ark_lengde=((HegnaNRK$PBLK21)(CUR$.SL$)).format_ark_lengde$1;
                    for(boolean CB$928:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$925$4.p$antall); }})
                       )) { if(!CB$928) continue;
                    {
                        inspect$925$4.fnr.Elt[i-inspect$925$4.fnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.LB[0]];
                        inspect$925$4.spos.Elt[i-inspect$925$4.spos.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.LB[0]];
                    }
                }
            }
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure definer_format",1,899,8,901,10,925,18,902,20,903,23,906,26,907,28,908,30,909,32,911,34,912,36,913,38,915,41,916,44,918,47,919,49,920,52,922,56,924,58,925,62,927,65,928,69,930,72,931,81,935);
}
