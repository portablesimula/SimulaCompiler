// JavaLine 1 <== SourceLine 1792
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$type_check$converr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1792, lastLine=1793, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$type_check$converr(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$type_check$converr STM$() {
        // JavaLine 20 <== SourceLine 1793
        new Common$ERROR(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,new Pass2$CompoundStatement21$SubBlock23$type_check$msg(((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$.SL$)),copy(new TXT$("Type conversion is undefined:  "))).RESULT$);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure converr",1,1792,20,1793,24,1793);
} // End of Procedure
