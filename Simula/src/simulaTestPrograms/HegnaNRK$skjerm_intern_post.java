package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$skjerm_intern_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public HegnaNRK$skjerm_intern_post(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$skjerm_intern_post STM$() {
        for(boolean CB$840:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$)).felt_antall$1); }})
           )) { if(!CB$840) continue;
        {
            ((HegnaNRK)(CUR$.SL$)).feltnr$1=((HegnaNRK)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK)(CUR$.SL$)).intern_feltnr.LB[0]];
            ((HegnaNRK)(CUR$.SL$)).feltnavn$1=((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK)(CUR$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.LB[0]];
            ((HegnaNRK)(CUR$.SL$)).felttype$1=((HegnaNRK)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK)(CUR$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$)).felttype_tabell.LB[0]];
            sysout().outtext(((HegnaNRK)(CUR$.SL$)).feltnavn$1);
            sysout().outchar(':');
            TXT$.setpos(sysout().image,(((HegnaNRK)(CUR$.SL$)).navne_lengde$1+(1)));
            ((HegnaNRK)(CUR$.SL$)).intern_felt.Elt[i-((HegnaNRK)(CUR$.SL$)).intern_felt.LB[0]].skriv$0().CPF();
            sysout().outimage();
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skjerm_intern_post",1,837,8,839,16,840,20,842,23,843,25,844,27,845,30,846,32,847,34,848,40,850);
}
