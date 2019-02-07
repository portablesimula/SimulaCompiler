// JavaLine 1 ==> SourceLine 1040
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$datareg extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1040, lastLine=1070, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1042
    boolean mer=false;
    int i=0;
    char c=0;
    // JavaLine 15 ==> SourceLine 1043
    TXT$ test=null;
    // JavaLine 17 ==> SourceLine 1045
    HegnaNRK$PBLK21$format inspect$1045$4=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$datareg(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("datareg",1045);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$datareg STM$() {
        TRACE_BEGIN_STM$("datareg",1045);
        // JavaLine 31 ==> SourceLine 1044
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn=new HegnaNRK$PBLK21$les_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 33 ==> SourceLine 1045
        {
            // BEGIN INSPECTION 
            inspect$1045$4=((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]];
            if(inspect$1045$4!=null) //INSPECT inspect$1045$4
            // JavaLine 38 ==> SourceLine 1047
            {
                TRACE_BEGIN_STM$("CompoundStatement1047",1047);
                mer=true;
                // JavaLine 42 ==> SourceLine 1048
                while(mer) {
                    // JavaLine 44 ==> SourceLine 1050
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1050",1050);
                        new HegnaNRK$PBLK21$stryk_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                        // JavaLine 48 ==> SourceLine 1051
                        for(boolean CB$1051:new ForList(
                            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$1045$4.p$antall); }})
                           )) { if(!CB$1051) continue;
                        // JavaLine 52 ==> SourceLine 1053
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1053",1053);
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr=inspect$1045$4.fnr.Elt[i-inspect$1045$4.fnr.LB[0]];
                            // JavaLine 56 ==> SourceLine 1054
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]];
                            // JavaLine 58 ==> SourceLine 1055
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
                            // JavaLine 60 ==> SourceLine 1056
                            new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn);
                            // JavaLine 62 ==> SourceLine 1057
                            test=blanks(((((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde+(1))-(TXT$.length(((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn))));
                            // JavaLine 64 ==> SourceLine 1058
                            TXT$.setpos(test,1);
                            while(TXT$.more(test)) {
                                TXT$.putchar(test,'.');
                            }
                            // JavaLine 69 ==> SourceLine 1059
                            new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),test);
                            // JavaLine 71 ==> SourceLine 1060
                            new HegnaNRK$PBLK21$les_feltverdi(((HegnaNRK$PBLK21)(CUR$.SL$)));
                            // JavaLine 73 ==> SourceLine 1061
                            new HegnaNRK$PBLK21$legg_i_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                            TRACE_END_STM$("CompoundStatement1053",1061);
                        }
                    }
                    // JavaLine 78 ==> SourceLine 1063
                    new HegnaNRK$PBLK21$skriv_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                    // JavaLine 80 ==> SourceLine 1064
                    new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Mer? (J/N):"));
                    // JavaLine 82 ==> SourceLine 1065
                    c=sysin().inchar();
                    // JavaLine 84 ==> SourceLine 1066
                    while((c==(((char)32)))) {
                        c=sysin().inchar();
                    }
                    // JavaLine 88 ==> SourceLine 1067
                    mer=(c==('J'));
                    TRACE_END_STM$("CompoundStatement1050",1067);
                }
            }
            TRACE_END_STM$("CompoundStatement1047",1067);
        }
    }
    TRACE_END_STM$("datareg",1067);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure datareg",1,1040,11,1042,15,1043,17,1045,31,1044,33,1045,38,1047,42,1048,44,1050,48,1051,52,1053,56,1054,58,1055,60,1056,62,1057,64,1058,69,1059,71,1060,73,1061,78,1063,80,1064,82,1065,84,1066,88,1067,99,1070);
}
