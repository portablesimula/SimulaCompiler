// JavaLine 1 ==> SourceLine 522
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$unary$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=522, lastLine=529, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 523
    CHECKER1$semchecker1$exp inspect$523$88=null;
    // Normal Constructor
    public CHECKER1$semchecker1$unary$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",523);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$unary$emit STM$() {
        TRACE_BEGIN_STM$("emit",523);
        {
            // BEGIN INSPECTION 
            inspect$523$88=((CHECKER1$semchecker1$unary)(CUR$.SL$)).p1$left;
            if(inspect$523$88!=null) //INSPECT inspect$523$88
            {
                TRACE_BEGIN_STM$("CompoundStatement523",523);
                inspect$523$88.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                inspect$523$88.emit$0().CPF();
                // JavaLine 33 ==> SourceLine 524
                if((inspect$523$88.type==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ICHAR))) {
                    // JavaLine 35 ==> SourceLine 525
                    {
                        TRACE_BEGIN_STM$("CompoundStatement525",525);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPRHI;
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1)(CUR$.SL$.SL$.SL$)).IINTG;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement525",525);
                    }
                }
                TRACE_END_STM$("CompoundStatement523",525);
            }
        }
        // JavaLine 47 ==> SourceLine 528
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IUMNS;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",528);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,522,11,523,33,524,35,525,47,528,53,529);
}
