// JavaLine 1 ==> SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Mar 17 17:53:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample1$p extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=10, lastLine=35, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 12
    int i=0;
    // Normal Constructor
    public GotoSample1$p(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("p",12);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public GotoSample1$p STM$() {
        TRACE_BEGIN_STM$("p",12);
        // JavaLine 25 ==> SourceLine 34
        new GotoSample1$PBLK14(CUR$).START();
        TRACE_END_STM$("p",32);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample1.sim","Procedure p",1,10,11,12,25,34,30,35);
}
