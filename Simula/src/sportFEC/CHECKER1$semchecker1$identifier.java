// JavaLine 1 ==> SourceLine 1284
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$identifier extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1284, lastLine=1485, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$identifier$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$identifier(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("identifier",1480);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("identifier",1480,inner);
                // JavaLine 22 ==> SourceLine 1485
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("identifier",1485);
                }
                TRACE_END_STM$("identifier",1485);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$identifier STM$() { return((CHECKER1$semchecker1$identifier)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$identifier START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class identifier",1,1284,22,1485,33,1485);
}