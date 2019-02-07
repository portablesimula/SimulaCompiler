// JavaLine 1 ==> SourceLine 899
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$definer_format extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=899, lastLine=935, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 901
    int i=0;
    // JavaLine 13 ==> SourceLine 925
    HegnaNRK$PBLK21$format inspect$925$3=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$definer_format(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("definer_format",925);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$definer_format STM$() {
        TRACE_BEGIN_STM$("definer_format",925);
        // JavaLine 27 ==> SourceLine 902
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def>=(((HegnaNRK$PBLK21)(CUR$.SL$)).max_format_def)))) {
            // JavaLine 29 ==> SourceLine 903
            new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),13);
        } else
        // JavaLine 32 ==> SourceLine 906
        {
            TRACE_BEGIN_STM$("CompoundStatement906",906);
            ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn=new HegnaNRK$PBLK21$les_nytt_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            // JavaLine 36 ==> SourceLine 907
            ((HegnaNRK$PBLK21)(CUR$.SL$)).format_ark_lengde=new HegnaNRK$PBLK21$les_lengde(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            // JavaLine 38 ==> SourceLine 908
            ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def+(1));
            // JavaLine 40 ==> SourceLine 909
            ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def-((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn;
            // JavaLine 42 ==> SourceLine 911
            i=0;
            // JavaLine 44 ==> SourceLine 912
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
            // JavaLine 46 ==> SourceLine 913
            while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_felt))) {
                // JavaLine 48 ==> SourceLine 915
                {
                    TRACE_BEGIN_STM$("CompoundStatement915",915);
                    if(VALUE$((i>=(((HegnaNRK$PBLK21)(CUR$.SL$)).max_format_lengde)))) {
                        // JavaLine 52 ==> SourceLine 916
                        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),15);
                    } else
                    // JavaLine 55 ==> SourceLine 918
                    {
                        TRACE_BEGIN_STM$("CompoundStatement918",918);
                        i=(i+(1));
                        // JavaLine 59 ==> SourceLine 919
                        ((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr;
                        // JavaLine 61 ==> SourceLine 920
                        ((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.LB[0]]=new HegnaNRK$PBLK21$les_startposisjon(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                        TRACE_END_STM$("CompoundStatement918",920);
                    }
                    // JavaLine 65 ==> SourceLine 922
                    ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                    TRACE_END_STM$("CompoundStatement915",922);
                }
            }
            // JavaLine 70 ==> SourceLine 924
            ((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]]=new HegnaNRK$PBLK21$format(((HegnaNRK$PBLK21)(CUR$.SL$)),i).STM$();
            // JavaLine 72 ==> SourceLine 925
            {
                // BEGIN INSPECTION 
                inspect$925$3=((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]];
                if(inspect$925$3!=null) //INSPECT inspect$925$3
                // JavaLine 77 ==> SourceLine 927
                {
                    TRACE_BEGIN_STM$("CompoundStatement927",927);
                    inspect$925$3.ark_lengde=((HegnaNRK$PBLK21)(CUR$.SL$)).format_ark_lengde;
                    // JavaLine 81 ==> SourceLine 928
                    for(boolean CB$928:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$925$3.p$antall); }})
                       )) { if(!CB$928) continue;
                    // JavaLine 85 ==> SourceLine 930
                    {
                        TRACE_BEGIN_STM$("CompoundStatement930",930);
                        inspect$925$3.fnr.Elt[i-inspect$925$3.fnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_fnr.LB[0]];
                        // JavaLine 89 ==> SourceLine 931
                        inspect$925$3.spos.Elt[i-inspect$925$3.spos.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).format_spos.LB[0]];
                        TRACE_END_STM$("CompoundStatement930",931);
                    }
                }
                TRACE_END_STM$("CompoundStatement927",931);
            }
        }
        TRACE_END_STM$("CompoundStatement906",931);
    }
    TRACE_END_STM$("definer_format",931);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure definer_format",1,899,11,901,13,925,27,902,29,903,32,906,36,907,38,908,40,909,42,911,44,912,46,913,48,915,52,916,55,918,59,919,61,920,65,922,70,924,72,925,77,927,81,928,85,930,89,931,102,935);
}
