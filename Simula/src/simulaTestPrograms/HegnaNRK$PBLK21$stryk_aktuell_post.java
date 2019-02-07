// JavaLine 1 ==> SourceLine 825
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$stryk_aktuell_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=825, lastLine=835, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$stryk_aktuell_post(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("stryk_aktuell_post",825);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$stryk_aktuell_post STM$() {
        TRACE_BEGIN_STM$("stryk_aktuell_post",825);
        // JavaLine 23 ==> SourceLine 828
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell!=(0)))) {
            // JavaLine 25 ==> SourceLine 830
            {
                TRACE_BEGIN_STM$("CompoundStatement830",830);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]=null;
                // JavaLine 29 ==> SourceLine 831
                ((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell=0;
                // JavaLine 31 ==> SourceLine 832
                ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster-(1));
                TRACE_END_STM$("CompoundStatement830",832);
            }
        } else
        // JavaLine 36 ==> SourceLine 834
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),10);
        TRACE_END_STM$("stryk_aktuell_post",834);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure stryk_aktuell_post",1,825,23,828,25,830,29,831,31,832,36,834,41,835);
}
