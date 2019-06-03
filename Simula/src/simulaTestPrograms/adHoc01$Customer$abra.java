// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 30 18:23:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$Customer$abra extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=4, lastLine=5, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc01$Customer$abra(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("abra",4);
        STM$();
    }
    // Procedure Statements
    public adHoc01$Customer$abra STM$() {
        TRACE_BEGIN_STM$("abra",4);
        // JavaLine 23 <== SourceLine 5
        ((Process$)CUR$).into(null);
        TRACE_END_STM$("abra",5);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure abra",1,4,23,5,28,5);
} // End of Procedure
