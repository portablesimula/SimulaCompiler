// JavaLine 1 <== SourceLine 16
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 11:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample2$p extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=16, lastLine=42, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 18
    int i=0;
    // Normal Constructor
    public GotoSample2$p(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("p",18);
        STM$();
    }
    // Procedure Statements
    public GotoSample2$p STM$() {
        TRACE_BEGIN_STM$("p",18);
        // JavaLine 25 <== SourceLine 41
        new GotoSample2$PBLK20(CUR$).START$();
        TRACE_END_STM$("p",39);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample2.sim","Procedure p",1,16,11,18,25,41,30,42);
} // End of Procedure
