// JavaLine 1 ==> SourceLine 86
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$newTag extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=86, lastLine=87, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public BUILDER1$newTag(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("newTag",86);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$newTag STM$() {
        TRACE_BEGIN_STM$("newTag",86);
        // JavaLine 26 ==> SourceLine 87
        RESULT$=((BUILDER1)(CUR$.SL$)).lastusedtag=(((BUILDER1)(CUR$.SL$)).lastusedtag+(1));
        TRACE_END_STM$("newTag",87);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure newTag",1,86,26,87,31,87);
}
