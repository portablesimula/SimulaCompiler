// JavaLine 1 ==> SourceLine 1127
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tainn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1127, lastLine=1134, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$tainn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("tainn",1127);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$tainn STM$() {
        TRACE_BEGIN_STM$("tainn",1127);
        // JavaLine 23 ==> SourceLine 1130
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Database-navn:"));
        // JavaLine 25 ==> SourceLine 1131
        ((HegnaNRK$PBLK21)(CUR$.SL$)).innbase_navn=new HegnaNRK$PBLK21$open_innbase(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 27 ==> SourceLine 1132
        new HegnaNRK$PBLK21$hent_innbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 29 ==> SourceLine 1133
        new HegnaNRK$PBLK21$lukk_innbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("tainn",1133);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure tainn",1,1127,23,1130,25,1131,27,1132,29,1133,34,1134);
}
