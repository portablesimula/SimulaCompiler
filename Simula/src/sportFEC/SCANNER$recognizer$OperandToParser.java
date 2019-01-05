// JavaLine 1 ==> SourceLine 927
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$OperandToParser extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=927, lastLine=936, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 929
    COMMON$component inspect$928$6=null;
    // Normal Constructor
    public SCANNER$recognizer$OperandToParser(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("OperandToParser",929);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$OperandToParser STM$() {
        TRACE_BEGIN_STM$("OperandToParser",929);
        // JavaLine 25 ==> SourceLine 928
        {
            // BEGIN INSPECTION 
            inspect$928$6=((SCANNER)(CUR$.SL$.SL$)).parser;
            if(inspect$928$6!=null) //INSPECT inspect$928$6
            // JavaLine 30 ==> SourceLine 929
            {
                TRACE_BEGIN_STM$("CompoundStatement929",929);
                ((SCANNER)(CUR$.SL$.SL$)).opt=((SCANNER)(CUR$.SL$.SL$)).IROPD;
                inspect$928$6.getopt=true;
                // JavaLine 35 ==> SourceLine 934
                call(((COMMON$component)inspect$928$6));
                // JavaLine 37 ==> SourceLine 935
                inspect$928$6.cs=((SCANNER)(CUR$.SL$.SL$)).opt=((SCANNER)(CUR$.SL$.SL$)).optx=((SCANNER)(CUR$.SL$.SL$)).opdhi=((SCANNER)(CUR$.SL$.SL$)).opdlo=((SCANNER)(CUR$.SL$.SL$)).NUL;
                TRACE_END_STM$("CompoundStatement929",935);
            }
        }
        TRACE_END_STM$("OperandToParser",935);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure OperandToParser",1,927,11,929,25,928,30,929,35,934,37,935,45,936);
}
