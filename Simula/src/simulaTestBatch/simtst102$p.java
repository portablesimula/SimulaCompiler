// JavaLine 1 ==> SourceLine 34
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:20:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102$p extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=34, lastLine=59, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 36
    int i=0;
    // Normal Constructor
    public simtst102$p(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("p",36);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst102$p STM$() {
        TRACE_BEGIN_STM$("p",36);
        // JavaLine 25 ==> SourceLine 58
        new simtst102$PBLK38(CUR$).START();
        TRACE_END_STM$("p",56);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Procedure p",1,34,11,36,25,58,30,59);
}
