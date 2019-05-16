// JavaLine 1 <== SourceLine 14
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:22:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17$p extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=14, lastLine=40, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 16
    int i=0;
    // Normal Constructor
    public issue17$p(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("p",16);
        STM$();
    }
    // Procedure Statements
    public issue17$p STM$() {
        TRACE_BEGIN_STM$("p",16);
        // JavaLine 25 <== SourceLine 39
        new issue17$PBLK18(CUR$).START$();
        TRACE_END_STM$("p",37);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","Procedure p",1,14,11,16,25,39,30,40);
} // End of Procedure
