package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$datareg extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean mer=false;
    int i=0;
    char c=0;
    TXT$ test=null;
    HegnaNRK$format inspect$1045$4=null;
    public HegnaNRK$datareg(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$datareg STM$() {
        ((HegnaNRK)(CUR$.SL$)).formatnavn$1=new HegnaNRK$les_formatnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        {
            inspect$1045$4=((HegnaNRK)(CUR$.SL$)).format_peker.Elt[((HegnaNRK)(CUR$.SL$)).formatnr$1-((HegnaNRK)(CUR$.SL$)).format_peker.LB[0]];
            if(inspect$1045$4!=null)
            {
                mer=true;
                while(mer) {
                    {
                        new HegnaNRK$stryk_intern_post(((HegnaNRK)(CUR$.SL$)));
                        for(boolean CB$1051:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$1045$4.p$antall); }})
                           )) { if(!CB$1051) continue;
                        {
                            ((HegnaNRK)(CUR$.SL$)).feltnr$1=inspect$1045$4.fnr.Elt[i-inspect$1045$4.fnr.LB[0]];
                            ((HegnaNRK)(CUR$.SL$)).feltnavn$1=((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK)(CUR$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.LB[0]];
                            ((HegnaNRK)(CUR$.SL$)).felttype$1=((HegnaNRK)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK)(CUR$.SL$)).feltnr$1-((HegnaNRK)(CUR$.SL$)).felttype_tabell.LB[0]];
                            new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),((HegnaNRK)(CUR$.SL$)).feltnavn$1);
                            test=blanks(((((HegnaNRK)(CUR$.SL$)).navne_lengde$1+(1))-(TXT$.length(((HegnaNRK)(CUR$.SL$)).feltnavn$1))));
                            TXT$.setpos(test,1);
                            while(TXT$.more(test)) {
                                TXT$.putchar(test,'.');
                            }
                            new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),test);
                            new HegnaNRK$les_feltverdi(((HegnaNRK)(CUR$.SL$)));
                            new HegnaNRK$legg_i_intern_post(((HegnaNRK)(CUR$.SL$)));
                        }
                    }
                    new HegnaNRK$skriv_intern_post(((HegnaNRK)(CUR$.SL$)));
                    new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Mer? (J/N):"));
                    c=sysin().inchar();
                    while((c==(((char)32)))) {
                        c=sysin().inchar();
                    }
                    mer=(c==('J'));
                }
            }
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure datareg",1,1040,8,1042,12,1043,14,1045,22,1044,24,1045,28,1047,31,1048,33,1050,36,1051,40,1053,43,1054,45,1055,47,1056,49,1057,51,1058,56,1059,58,1060,60,1061,64,1063,66,1064,68,1065,70,1066,74,1067,82,1070);
}
