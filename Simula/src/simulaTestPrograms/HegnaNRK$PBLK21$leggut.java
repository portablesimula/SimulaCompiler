// JavaLine 1 ==> SourceLine 1136
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$leggut extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1136, lastLine=1143, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$leggut(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("leggut",1136);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$leggut STM$() {
        TRACE_BEGIN_STM$("leggut",1136);
        // JavaLine 23 ==> SourceLine 1139
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Database-navn:"));
        // JavaLine 25 ==> SourceLine 1140
        ((HegnaNRK$PBLK21)(CUR$.SL$)).utbase_navn=new HegnaNRK$PBLK21$open_utbase(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 27 ==> SourceLine 1141
        new HegnaNRK$PBLK21$skriv_utbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 29 ==> SourceLine 1142
        new HegnaNRK$PBLK21$lukk_utbase(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("leggut",1142);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure leggut",1,1136,23,1139,25,1140,27,1141,29,1142,34,1143);
}
