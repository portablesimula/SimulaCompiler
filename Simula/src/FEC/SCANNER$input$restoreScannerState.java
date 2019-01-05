// JavaLine 1 ==> SourceLine 418
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$input$restoreScannerState extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=418, lastLine=428, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 419
    SCANNER$recognizer inspect$419$10=null;
    // Normal Constructor
    public SCANNER$input$restoreScannerState(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("restoreScannerState",419);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$input$restoreScannerState STM$() {
        TRACE_BEGIN_STM$("restoreScannerState",419);
        {
            // BEGIN INSPECTION 
            inspect$419$10=((SCANNER)(CUR$.SL$.SL$)).lexScanner;
            if(inspect$419$10!=null) //INSPECT inspect$419$10
            // JavaLine 29 ==> SourceLine 420
            {
                TRACE_BEGIN_STM$("CompoundStatement420",420);
                inspect$419$10.linepos=((SCANNER$input)(CUR$.SL$)).lexpos;
                inspect$419$10.linelength=((SCANNER$input)(CUR$.SL$)).lexlen;
                // JavaLine 34 ==> SourceLine 421
                inspect$419$10.atom=((SCANNER$input)(CUR$.SL$)).lexatom;
                inspect$419$10.line=((SCANNER$input)(CUR$.SL$)).lexline;
                TRACE_END_STM$("CompoundStatement420",421);
            }
        }
        // JavaLine 40 ==> SourceLine 423
        ((SCANNER)(CUR$.SL$.SL$)).listingon=((SCANNER$input)(CUR$.SL$)).liston;
        // JavaLine 42 ==> SourceLine 424
        ((SCANNER)(CUR$.SL$.SL$)).line=((SCANNER)(CUR$.SL$.SL$)).lexScanner.line;
        // JavaLine 44 ==> SourceLine 425
        ((SCANNER)(CUR$.SL$.SL$)).cursource=((SCANNER$input)(CUR$.SL$)).prev;
        ((SCANNER$input)(CUR$.SL$)).prev=null;
        // JavaLine 47 ==> SourceLine 426
        if((((SCANNER)(CUR$.SL$.SL$)).cursource!=(null))) {
            // JavaLine 49 ==> SourceLine 427
            ((SCANNER)(CUR$.SL$.SL$)).incrlnr=(!(((SCANNER)(CUR$.SL$.SL$)).cursource.p$inserted));
        }
        TRACE_END_STM$("restoreScannerState",427);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure restoreScannerState",1,418,11,419,29,420,34,421,40,423,42,424,44,425,47,426,49,427,55,428);
}
