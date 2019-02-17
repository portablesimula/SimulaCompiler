// JavaLine 1 ==> SourceLine 495
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$noter_ny_felt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=495, lastLine=505, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$noter_ny_felt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("noter_ny_felt",495);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$noter_ny_felt STM$() {
        TRACE_BEGIN_STM$("noter_ny_felt",495);
        // JavaLine 23 ==> SourceLine 498
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_felt_def)))) {
            // JavaLine 25 ==> SourceLine 500
            {
                TRACE_BEGIN_STM$("CompoundStatement500",500);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def+(1));
                // JavaLine 29 ==> SourceLine 501
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn;
                // JavaLine 31 ==> SourceLine 502
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype;
                TRACE_END_STM$("CompoundStatement500",502);
            }
        } else
        // JavaLine 36 ==> SourceLine 504
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),7);
        TRACE_END_STM$("noter_ny_felt",504);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure noter_ny_felt",1,495,23,498,25,500,29,501,31,502,36,504,41,505);
}
