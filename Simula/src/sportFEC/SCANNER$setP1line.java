// JavaLine 1 ==> SourceLine 81
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 20:41:32 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$setP1line extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=81, lastLine=82, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$setP1line(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setP1line",81);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$setP1line STM$() {
        TRACE_BEGIN_STM$("setP1line",81);
        // JavaLine 23 ==> SourceLine 82
        ((SCANNER)(CUR$.SL$)).line=TXT$.sub(((SCANNER)(CUR$.SL$)).lexScanner.line,1,(((SCANNER)(CUR$.SL$)).lexScanner.linelength-(1)));
        TRACE_END_STM$("setP1line",82);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure setP1line",1,81,23,82,28,82);
}
