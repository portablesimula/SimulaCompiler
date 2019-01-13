// JavaLine 1 ==> SourceLine 500
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$power$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=500, lastLine=509, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 501
    CHECKER1$semchecker1$exp inspect$501$87=null;
    // Normal Constructor
    public CHECKER1$semchecker1$power$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",501);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$power$emit STM$() {
        TRACE_BEGIN_STM$("emit",501);
        {
            // BEGIN INSPECTION 
            inspect$501$87=((CHECKER1$semchecker1$power)(CUR$.SL$)).p1$left;
            if(inspect$501$87!=null) //INSPECT inspect$501$87
            {
                TRACE_BEGIN_STM$("CompoundStatement501",501);
                inspect$501$87.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                inspect$501$87.emit$0().CPF();
                TRACE_END_STM$("CompoundStatement501",501);
            }
        }
        // JavaLine 36 ==> SourceLine 503
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPOWE;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
        // JavaLine 39 ==> SourceLine 504
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1$semchecker1$power)(CUR$.SL$)).p1$right.type;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).optx=((CHECKER1$semchecker1$power)(CUR$.SL$)).basetype;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 43 ==> SourceLine 505
        ((CHECKER1$semchecker1$power)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$power)(CUR$.SL$)).p1$right.emit$0().CPF();
        // JavaLine 46 ==> SourceLine 507
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPOWE;
        // JavaLine 48 ==> SourceLine 508
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1$semchecker1$power)(CUR$.SL$)).p1$right.type;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).optx=((CHECKER1$semchecker1$power)(CUR$.SL$)).basetype;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",508);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,500,11,501,36,503,39,504,43,505,46,507,48,508,55,509);
}
