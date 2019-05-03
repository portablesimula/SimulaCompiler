package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$datareg extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean mer=false;
    int i=0;
    char c=0;
    TXT$ test=null;
    HegnaNRK$PBLK21$format inspect$1045$5=null;
    public HegnaNRK$PBLK21$datareg(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$datareg STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn$1=new HegnaNRK$PBLK21$les_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        {
            inspect$1045$5=((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]];
            if(inspect$1045$5!=null)
            {
                mer=true;
                while(mer) {
                    {
                        new HegnaNRK$PBLK21$stryk_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                        for(boolean CB$1051:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$1045$5.p$antall); }})
                           )) { if(!CB$1051) continue;
                        {
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1=inspect$1045$5.fnr.Elt[i-inspect$1045$5.fnr.LB[0]];
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]];
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype$1=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
                            new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1);
                            test=blanks(((((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde$1+(1))-(TXT$.length(((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1))));
                            TXT$.setpos(test,1);
                            while(TXT$.more(test)) {
                                TXT$.putchar(test,'.');
                            }
                            new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),test);
                            new HegnaNRK$PBLK21$les_feltverdi(((HegnaNRK$PBLK21)(CUR$.SL$)));
                            new HegnaNRK$PBLK21$legg_i_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                        }
                    }
                    new HegnaNRK$PBLK21$skriv_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                    new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Mer? (J/N):"));
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
