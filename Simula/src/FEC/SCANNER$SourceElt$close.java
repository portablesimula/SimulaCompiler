// JavaLine 1 ==> SourceLine 440
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$SourceElt$close extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=440, lastLine=443, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$SourceElt$close(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("close",440);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$SourceElt$close STM$() {
        TRACE_BEGIN_STM$("close",440);
        // JavaLine 23 ==> SourceLine 441
        if((((SCANNER$SourceElt)(CUR$.SL$)).sf!=(sysin()))) {
            ((SCANNER$SourceElt)(CUR$.SL$)).sf.close();
        }
        // JavaLine 27 ==> SourceLine 442
        new SCANNER$input$restoreScannerState(((SCANNER$SourceElt)(CUR$.SL$)));
        TRACE_END_STM$("close",442);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure close",1,440,23,441,27,442,32,443);
}
