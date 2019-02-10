// JavaLine 1 ==> SourceLine 1171
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$const$ extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1171, lastLine=1197, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1175
    public char ixhi=0;
    public char ixlo=0;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$const$$emit.class)); }
    public PRCQNT$ sameAs$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$const$$sameAs.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$const$(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("const$",1188);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("const$",1188,inner);
                // JavaLine 26 ==> SourceLine 1197
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("const$",1197);
                }
                TRACE_END_STM$("const$",1197);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$const$ STM$() { return((CHECKER1$semchecker1$const$)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$const$ START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class const$",1,1171,11,1175,26,1197,37,1197);
}
