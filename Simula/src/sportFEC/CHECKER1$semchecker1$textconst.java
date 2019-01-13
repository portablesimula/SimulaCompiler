package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$textconst extends CHECKER1$semchecker1$const$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1201, lastLine=1229, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 1202
    public CHECKER1$semchecker1$identifier id=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$textconst$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$textconst(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("textconst",1226);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("textconst",1226,inner);
                // JavaLine 23 ==> SourceLine 1229
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("textconst",1229);
                }
                TRACE_END_STM$("textconst",1229);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$textconst STM$() { return((CHECKER1$semchecker1$textconst)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$textconst START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class textconst",10,1202,23,1229,34,1229);
}
