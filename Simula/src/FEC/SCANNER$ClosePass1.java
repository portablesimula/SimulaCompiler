// JavaLine 1 ==> SourceLine 2423
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$ClosePass1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=2423, lastLine=2431, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 2426
    OutbyteFile$ inspect$2426$32=null;
    // Normal Constructor
    public SCANNER$ClosePass1(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ClosePass1",2426);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$ClosePass1 STM$() {
        TRACE_BEGIN_STM$("ClosePass1",2426);
        // JavaLine 25 ==> SourceLine 2424
        while((((SCANNER)(CUR$.SL$)).cursource!=(null))) {
            ((SCANNER)(CUR$.SL$)).cursource.close$0().CPF();
        }
        // JavaLine 29 ==> SourceLine 2425
        ((SCANNER)(CUR$.SL$)).scanner=((SCANNER)(CUR$.SL$)).parser=null;
        ((SCANNER)(CUR$.SL$)).lexScanner=null;
        // JavaLine 32 ==> SourceLine 2426
        {
            // BEGIN INSPECTION 
            inspect$2426$32=((SCANNER)(CUR$.SL$)).L2OUPT;
            if(inspect$2426$32!=null) //INSPECT inspect$2426$32
            // JavaLine 37 ==> SourceLine 2428
            {
                TRACE_BEGIN_STM$("CompoundStatement2428",2428);
                inspect$2426$32.outtext(TXT$.sub(((SCANNER)(CUR$.SL$)).L2codebuffer,1,TXT$.pos(((SCANNER)(CUR$.SL$)).L2codebuffer)));
                inspect$2426$32.close();
                TRACE_END_STM$("CompoundStatement2428",2428);
            }
        }
        // JavaLine 45 ==> SourceLine 2430
        ((SCANNER)(CUR$.SL$)).P1coder=((SCANNER$L2Coder)(((SCANNER)(CUR$.SL$)).coder=null));
        TRACE_END_STM$("ClosePass1",2430);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure ClosePass1",1,2423,11,2426,25,2424,29,2425,32,2426,37,2428,45,2430,50,2431);
}
