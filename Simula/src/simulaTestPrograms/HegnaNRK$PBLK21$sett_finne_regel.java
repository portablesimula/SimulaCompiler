// JavaLine 1 ==> SourceLine 780
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sett_finne_regel extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=780, lastLine=790, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$sett_finne_regel(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sett_finne_regel",780);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$sett_finne_regel STM$() {
        TRACE_BEGIN_STM$("sett_finne_regel",780);
        // JavaLine 23 ==> SourceLine 783
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_finne_regel)))) {
            // JavaLine 25 ==> SourceLine 785
            {
                TRACE_BEGIN_STM$("CompoundStatement785",785);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall=(((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall+(1));
                // JavaLine 29 ==> SourceLine 786
                ((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr;
                // JavaLine 31 ==> SourceLine 787
                ((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi;
                TRACE_END_STM$("CompoundStatement785",787);
            }
        } else
        // JavaLine 36 ==> SourceLine 789
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),9);
        TRACE_END_STM$("sett_finne_regel",789);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sett_finne_regel",1,780,23,783,25,785,29,786,31,787,36,789,41,790);
}
