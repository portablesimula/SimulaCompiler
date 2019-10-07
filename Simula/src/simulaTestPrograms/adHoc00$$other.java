// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue Oct 01 12:37:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00$$other extends PROC$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=4, lastLine=5, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc00$$other(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public adHoc00$$other STM$() {
        // JavaLine 23 <== SourceLine 5
        RESULT$=new TXT$("abra");
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","Procedure other",1,4,23,5,27,5);
} // End of Procedure
