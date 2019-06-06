// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Jun 06 12:16:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue32$Customer$abra extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=6, lastLine=13, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 9
    issue32$Customer inspect$9$0=null;
    // Normal Constructor
    public issue32$Customer$abra(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("abra",9);
        STM$();
    }
    // Procedure Statements
    public issue32$Customer$abra STM$() {
        TRACE_BEGIN_STM$("abra",9);
        // JavaLine 25 <== SourceLine 8
        ((Process$)(CUR$.SL$)).into(null);
        // JavaLine 27 <== SourceLine 9
        {
            // BEGIN INSPECTION 
            inspect$9$0=((issue32)(CUR$.SL$.SL$)).cust$2;
            if(inspect$9$0!=null) // INSPECT inspect$9$0
            // JavaLine 32 <== SourceLine 11
            {
                TRACE_BEGIN_STM$("CompoundStatement11",11);
                ((Process$)inspect$9$0).into(null);
                TRACE_END_STM$("CompoundStatement11",11);
            }
        }
        TRACE_END_STM$("abra",11);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue32.sim","Procedure abra",1,6,11,9,25,8,27,9,32,11,42,13);
} // End of Procedure
