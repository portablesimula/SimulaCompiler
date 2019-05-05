// JavaLine 1 <== SourceLine 1196
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent_innbase extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1196, lastLine=1257, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1198
    InFile$ inspect$1198$7=null;
    // JavaLine 13 <== SourceLine 1220
    HegnaNRK$PBLK21$format inspect$1220$8=null;
    // JavaLine 15 <== SourceLine 1235
    HegnaNRK$PBLK21$post inspect$1235$9=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$hent_innbase(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("hent_innbase",1235);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$hent_innbase STM$() {
        TRACE_BEGIN_STM$("hent_innbase",1235);
        // JavaLine 29 <== SourceLine 1198
        {
            // BEGIN INSPECTION 
            inspect$1198$7=((HegnaNRK$PBLK21)(CUR$.SL$)).innbase$1;
            if(inspect$1198$7!=null) // INSPECT inspect$1198$7
            if(VALUE$((!(inspect$1198$7.lastitem())))) {
                // JavaLine 35 <== SourceLine 1257
                new HegnaNRK$PBLK21$hent_innbase$SubBlock1199(CUR$).STM$();
            }
        }
        TRACE_END_STM$("hent_innbase",1254);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent_innbase",1,1196,11,1198,13,1220,15,1235,29,1198,35,1257,42,1257);
} // End of Procedure
