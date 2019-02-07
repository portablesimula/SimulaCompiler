// JavaLine 1 ==> SourceLine 1353
package sportFEC;
// Simula-Beta-0.3 Compiled at Wed Feb 06 13:19:01 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$nextNumber extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1353, lastLine=1356, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public COMMON$attrfile$nextNumber(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("nextNumber",1353);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$nextNumber STM$() {
        TRACE_BEGIN_STM$("nextNumber",1353);
        // JavaLine 26 ==> SourceLine 1354
        RESULT$=((rank(loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p))*(256))+(rank(loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1))))));
        // JavaLine 28 ==> SourceLine 1355
        ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(2));
        TRACE_END_STM$("nextNumber",1355);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nextNumber",1,1353,26,1354,28,1355,33,1356);
}
