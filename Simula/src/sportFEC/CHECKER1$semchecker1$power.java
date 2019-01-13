// JavaLine 1 ==> SourceLine 497
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$power extends CHECKER1$semchecker1$arithop {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=497, lastLine=516, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 499
    public char basetype=0;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$power$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$power(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("power",508);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("power",508,inner);
                // JavaLine 24 ==> SourceLine 512
                if((((CHECKER1)(CUR$.SL$.SL$)).ltype==(((CHECKER1)(CUR$.SL$.SL$)).ILONG))) {
                    // JavaLine 26 ==> SourceLine 513
                    {
                        TRACE_BEGIN_STM$("CompoundStatement513",513);
                        if((((CHECKER1)(CUR$.SL$.SL$)).rtype==(((CHECKER1)(CUR$.SL$.SL$)).IREAL))) {
                            type=((CHECKER1)(CUR$.SL$.SL$)).IREAL;
                        }
                        TRACE_END_STM$("CompoundStatement513",513);
                    }
                }
                // JavaLine 35 ==> SourceLine 515
                basetype=((CHECKER1)(CUR$.SL$.SL$)).ltype;
                // JavaLine 37 ==> SourceLine 512
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("power",512);
                }
                TRACE_END_STM$("power",512);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$power STM$() { return((CHECKER1$semchecker1$power)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$power START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class power",1,497,11,499,24,512,26,513,35,515,37,512,48,516);
}
