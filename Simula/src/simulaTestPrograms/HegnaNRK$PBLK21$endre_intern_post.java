// JavaLine 1 <== SourceLine 579
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$endre_intern_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=579, lastLine=590, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$endre_intern_post(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("endre_intern_post",579);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$endre_intern_post STM$() {
        TRACE_BEGIN_STM$("endre_intern_post",579);
        // JavaLine 23 <== SourceLine 582
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 25 <== SourceLine 583
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_felt$1))) {
            // JavaLine 27 <== SourceLine 585
            {
                TRACE_BEGIN_STM$("CompoundStatement585",585);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype$1=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
                // JavaLine 31 <== SourceLine 586
                new HegnaNRK$PBLK21$les_feltverdi(((HegnaNRK$PBLK21)(CUR$.SL$)));
                // JavaLine 33 <== SourceLine 587
                new HegnaNRK$PBLK21$legg_i_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                // JavaLine 35 <== SourceLine 588
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                TRACE_END_STM$("CompoundStatement585",588);
            }
        }
        TRACE_END_STM$("endre_intern_post",588);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure endre_intern_post",1,579,23,582,25,583,27,585,31,586,33,587,35,588,43,590);
} // End of Procedure
