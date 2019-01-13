// JavaLine 1 ==> SourceLine 196
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$operation extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=196, lastLine=226, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p1$left;
    public CHECKER1$semchecker1$exp p1$right;
    // Declare locals as attributes
    public PRCQNT$ sameAs$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$operation$sameAs.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$operation(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        this.p1$left = sp1$left;
        this.p1$right = sp1$right;
        // Declaration Code
        TRACE_BEGIN_DCL$("operation",216);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("operation",216,inner);
                // JavaLine 26 ==> SourceLine 226
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("operation",226);
                }
                TRACE_END_STM$("operation",226);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$operation STM$() { return((CHECKER1$semchecker1$operation)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$operation START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class operation",1,196,26,226,37,226);
}
