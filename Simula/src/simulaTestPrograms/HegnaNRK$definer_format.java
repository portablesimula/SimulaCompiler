package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$definer_format extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    HegnaNRK$format inspect$925$3=null;
    public HegnaNRK$definer_format(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$definer_format STM$() {
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).antall_format_def$1>=(((HegnaNRK)(CUR$.SL$)).max_format_def$1)))) {
            new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),13);
        } else
        {
            ((HegnaNRK)(CUR$.SL$)).formatnavn$1=new HegnaNRK$les_nytt_formatnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
            ((HegnaNRK)(CUR$.SL$)).format_ark_lengde$1=new HegnaNRK$les_lengde(((HegnaNRK)(CUR$.SL$))).RESULT$;
            ((HegnaNRK)(CUR$.SL$)).antall_format_def$1=(((HegnaNRK)(CUR$.SL$)).antall_format_def$1+(1));
            ((HegnaNRK)(CUR$.SL$)).formatnavn_tabell.Elt[((HegnaNRK)(CUR$.SL$)).antall_format_def$1-((HegnaNRK)(CUR$.SL$)).formatnavn_tabell.LB[0]]=((HegnaNRK)(CUR$.SL$)).formatnavn$1;
            i=0;
            ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_feltnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
            while((((HegnaNRK)(CUR$.SL$)).feltnr$1!=(((HegnaNRK)(CUR$.SL$)).quit_felt$1))) {
                {
                    if(VALUE$((i>=(((HegnaNRK)(CUR$.SL$)).max_format_lengde$1)))) {
                        new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),15);
                    } else
                    {
                        i=(i+(1));
                        ((HegnaNRK)(CUR$.SL$)).format_fnr.Elt[i-((HegnaNRK)(CUR$.SL$)).format_fnr.LB[0]]=((HegnaNRK)(CUR$.SL$)).feltnr$1;
                        ((HegnaNRK)(CUR$.SL$)).format_spos.Elt[i-((HegnaNRK)(CUR$.SL$)).format_spos.LB[0]]=new HegnaNRK$les_startposisjon(((HegnaNRK)(CUR$.SL$))).RESULT$;
                    }
                    ((HegnaNRK)(CUR$.SL$)).feltnavn$1=new HegnaNRK$les_feltnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                }
            }
            ((HegnaNRK)(CUR$.SL$)).format_peker.Elt[((HegnaNRK)(CUR$.SL$)).antall_format_def$1-((HegnaNRK)(CUR$.SL$)).format_peker.LB[0]]=new HegnaNRK$format(((HegnaNRK)(CUR$.SL$)),i).STM$();
            {
                inspect$925$3=((HegnaNRK)(CUR$.SL$)).format_peker.Elt[((HegnaNRK)(CUR$.SL$)).antall_format_def$1-((HegnaNRK)(CUR$.SL$)).format_peker.LB[0]];
                if(inspect$925$3!=null)
                {
                    inspect$925$3.ark_lengde=((HegnaNRK)(CUR$.SL$)).format_ark_lengde$1;
                    for(boolean CB$928:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$925$3.p$antall); }})
                       )) { if(!CB$928) continue;
                    {
                        inspect$925$3.fnr.Elt[i-inspect$925$3.fnr.LB[0]]=((HegnaNRK)(CUR$.SL$)).format_fnr.Elt[i-((HegnaNRK)(CUR$.SL$)).format_fnr.LB[0]];
                        inspect$925$3.spos.Elt[i-inspect$925$3.spos.LB[0]]=((HegnaNRK)(CUR$.SL$)).format_spos.Elt[i-((HegnaNRK)(CUR$.SL$)).format_spos.LB[0]];
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
