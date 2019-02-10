// JavaLine 1 ==> SourceLine 480
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$integerdivide extends CHECKER1$semchecker1$arithop {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=480, lastLine=487, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$integerdivide(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("integerdivide",480);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("integerdivide",480,inner);
                // JavaLine 21 ==> SourceLine 484
                if(VALUE$((((CHECKER1)(CUR$.SL$.SL$)).ltype>=(((CHECKER1)(CUR$.SL$.SL$)).IREAL)))) {
                    new CHECKER1$semchecker1$exp$typeError(p1$left,302);
                }
                // JavaLine 25 ==> SourceLine 485
                if(VALUE$((((CHECKER1)(CUR$.SL$.SL$)).rtype>=(((CHECKER1)(CUR$.SL$.SL$)).IREAL)))) {
                    new CHECKER1$semchecker1$exp$typeError(p1$right,303);
                }
                // JavaLine 29 ==> SourceLine 486
                type=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
                // JavaLine 31 ==> SourceLine 484
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("integerdivide",484);
                }
                TRACE_END_STM$("integerdivide",484);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$integerdivide STM$() { return((CHECKER1$semchecker1$integerdivide)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$integerdivide START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class integerdivide",1,480,21,484,25,485,29,486,31,484,42,487);
}
