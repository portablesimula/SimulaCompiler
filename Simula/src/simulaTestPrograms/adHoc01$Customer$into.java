// JavaLine 1 <== SourceLine 10
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:09:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$Customer$into extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=10, lastLine=13, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc01$Customer$into(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("into",10);
        STM$();
    }
    // Procedure Statements
    public adHoc01$Customer$into STM$() {
        TRACE_BEGIN_STM$("into",10);
        // JavaLine 23 <== SourceLine 12
        ((Process$)CUR$).into(null);
        TRACE_END_STM$("into",12);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure into",1,10,23,12,28,13);
} // End of Procedure
