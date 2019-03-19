// JavaLine 1 ==> SourceLine 31
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst107$PBLK12$startup extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=31, lastLine=32, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst107$PBLK12$startup(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("startup",31);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst107$PBLK12$startup STM$() {
        TRACE_BEGIN_STM$("startup",31);
        // JavaLine 23 ==> SourceLine 32
        new simtst107$PBLK12$outstate(((simtst107$PBLK12)(CUR$.SL$)),0);
        ((simtst107$PBLK12)(CUR$.SL$)).ActivateAt(true,((simtst107$PBLK12)(CUR$.SL$)).main,((simtst107$PBLK12)(CUR$.SL$)).time()+(((double)(20.0f))),false);
        TRACE_END_STM$("startup",32);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","Procedure startup",1,31,23,32,29,32);
}
