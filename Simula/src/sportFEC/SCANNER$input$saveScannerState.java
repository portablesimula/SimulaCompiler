// JavaLine 1 ==> SourceLine 407
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$input$saveScannerState extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=407, lastLine=416, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 408
    SCANNER$recognizer inspect$408$9=null;
    // Normal Constructor
    public SCANNER$input$saveScannerState(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("saveScannerState",408);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$input$saveScannerState STM$() {
        TRACE_BEGIN_STM$("saveScannerState",408);
        {
            // BEGIN INSPECTION 
            inspect$408$9=((SCANNER)(CUR$.SL$.SL$)).lexScanner;
            if(inspect$408$9!=null) //INSPECT inspect$408$9
            // JavaLine 29 ==> SourceLine 409
            {
                TRACE_BEGIN_STM$("CompoundStatement409",409);
                ((SCANNER$input)(CUR$.SL$)).lexatom=inspect$408$9.atom;
                ((SCANNER$input)(CUR$.SL$)).lexline=inspect$408$9.line;
                // JavaLine 34 ==> SourceLine 410
                ((SCANNER$input)(CUR$.SL$)).lexpos=inspect$408$9.linepos;
                ((SCANNER$input)(CUR$.SL$)).lexlen=inspect$408$9.linelength;
                // JavaLine 37 ==> SourceLine 411
                ((SCANNER$input)(CUR$.SL$)).liston=((SCANNER)(CUR$.SL$.SL$)).listingon;
                // JavaLine 39 ==> SourceLine 412
                if(((SCANNER$input)(CUR$.SL$)).p$inserted) {
                    ((SCANNER)(CUR$.SL$.SL$)).incrlnr=((SCANNER)(CUR$.SL$.SL$)).listingon=false;
                }
                // JavaLine 43 ==> SourceLine 413
                ((SCANNER$input)(CUR$.SL$)).prev=((SCANNER)(CUR$.SL$.SL$)).cursource;
                ((SCANNER)(CUR$.SL$.SL$)).cursource=((SCANNER$input)(CUR$.SL$));
                // JavaLine 46 ==> SourceLine 415
                inspect$408$9.atom=((SCANNER)(CUR$.SL$.SL$)).EOL;
                inspect$408$9.linepos=inspect$408$9.linelength;
                TRACE_END_STM$("CompoundStatement409",415);
            }
        }
        TRACE_END_STM$("saveScannerState",415);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure saveScannerState",1,407,11,408,29,409,34,410,37,411,39,412,43,413,46,415,55,416);
}
