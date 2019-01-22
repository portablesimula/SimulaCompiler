// JavaLine 1 ==> SourceLine 18
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 19 12:51:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class DetachSamples$P extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=18, lastLine=22, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public DetachSamples$P(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P",18);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public DetachSamples$P STM$() {
        TRACE_BEGIN_STM$("P",18);
        // JavaLine 23 ==> SourceLine 20
        ((DetachSamples)(CUR$.SL$)).detach();
        // JavaLine 25 ==> SourceLine 21
        ((DetachSamples)(CUR$.SL$)).x.detach();
        TRACE_END_STM$("P",21);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("DetachSamples.sim","Procedure P",1,18,23,20,25,21,30,22);
}
