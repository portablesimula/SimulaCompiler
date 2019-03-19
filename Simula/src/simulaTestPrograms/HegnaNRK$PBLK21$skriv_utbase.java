// JavaLine 1 ==> SourceLine 1259
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_utbase extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1259, lastLine=1344, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1261
    OutFile$ inspect$1261$10=null;
    // JavaLine 13 ==> SourceLine 1283
    HegnaNRK$PBLK21$format inspect$1283$11=null;
    // JavaLine 15 ==> SourceLine 1299
    HegnaNRK$PBLK21$post inspect$1299$12=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$skriv_utbase(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skriv_utbase",1299);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$skriv_utbase STM$() {
        TRACE_BEGIN_STM$("skriv_utbase",1299);
        // JavaLine 29 ==> SourceLine 1261
        {
            // BEGIN INSPECTION 
            inspect$1261$10=((HegnaNRK$PBLK21)(CUR$.SL$)).utbase;
            if(inspect$1261$10!=null) //INSPECT inspect$1261$10
            // JavaLine 34 ==> SourceLine 1344
            new HegnaNRK$PBLK21$skriv_utbase$SubBlock1262(CUR$).STM$();
        }
        TRACE_END_STM$("skriv_utbase",1340);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_utbase",1,1259,11,1261,13,1283,15,1299,29,1261,34,1344,40,1344);
}
