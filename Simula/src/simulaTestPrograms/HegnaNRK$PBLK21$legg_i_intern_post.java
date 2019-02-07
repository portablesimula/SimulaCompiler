// JavaLine 1 ==> SourceLine 852
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$legg_i_intern_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=852, lastLine=864, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 854
    int fnr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$legg_i_intern_post(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("legg_i_intern_post",854);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$legg_i_intern_post STM$() {
        TRACE_BEGIN_STM$("legg_i_intern_post",854);
        // JavaLine 25 ==> SourceLine 855
        fnr=new HegnaNRK$PBLK21$finn_intern_feltnr(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr).RESULT$;
        // JavaLine 27 ==> SourceLine 856
        if(VALUE$((fnr==(0)))) {
            // JavaLine 29 ==> SourceLine 858
            {
                TRACE_BEGIN_STM$("CompoundStatement858",858);
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall>=(((HegnaNRK$PBLK21)(CUR$.SL$)).max_intern_felt)))) {
                    // JavaLine 33 ==> SourceLine 859
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),8);
                } else
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall=(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall+(1));
                // JavaLine 37 ==> SourceLine 860
                fnr=((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall;
                // JavaLine 39 ==> SourceLine 861
                ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[fnr-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr;
                TRACE_END_STM$("CompoundStatement858",861);
            }
        }
        // JavaLine 44 ==> SourceLine 863
        ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[fnr-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]]=new HegnaNRK$PBLK21$felt_kopi(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi).RESULT$;
        TRACE_END_STM$("legg_i_intern_post",863);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure legg_i_intern_post",1,852,11,854,25,855,27,856,29,858,33,859,37,860,39,861,44,863,49,864);
}
