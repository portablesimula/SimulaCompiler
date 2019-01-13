// JavaLine 1 ==> SourceLine 229
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$expinparantes extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=229, lastLine=243, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$expinparantes$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$expinparantes(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("expinparantes",237);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("expinparantes",237,inner);
                // JavaLine 22 ==> SourceLine 239
                if((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                }
                // JavaLine 26 ==> SourceLine 240
                cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                // JavaLine 28 ==> SourceLine 241
                type=p1$right.type;
                qual=p1$right.qual;
                // JavaLine 31 ==> SourceLine 239
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("expinparantes",239);
                }
                TRACE_END_STM$("expinparantes",239);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$expinparantes STM$() { return((CHECKER1$semchecker1$expinparantes)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$expinparantes START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class expinparantes",1,229,22,239,26,240,28,241,31,239,42,243);
}
