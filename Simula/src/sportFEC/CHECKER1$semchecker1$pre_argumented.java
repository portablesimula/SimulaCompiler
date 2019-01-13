// JavaLine 1 ==> SourceLine 1725
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$pre_argumented extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1725, lastLine=1783, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$identifier p1$ident;
    public CHECKER1$semchecker1$argument p1$arguments;
    public int p1$noofexpargs;
    public int p1$noofactargs;
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$pre_argumented$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$pre_argumented(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$identifier sp1$ident,CHECKER1$semchecker1$argument sp1$arguments,int sp1$noofexpargs,int sp1$noofactargs) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        this.p1$ident = sp1$ident;
        this.p1$arguments = sp1$arguments;
        this.p1$noofexpargs = sp1$noofexpargs;
        this.p1$noofactargs = sp1$noofactargs;
        // Declaration Code
        TRACE_BEGIN_DCL$("pre_argumented",1779);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("pre_argumented",1779,inner);
                // JavaLine 30 ==> SourceLine 1783
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("pre_argumented",1783);
                }
                TRACE_END_STM$("pre_argumented",1783);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$pre_argumented STM$() { return((CHECKER1$semchecker1$pre_argumented)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$pre_argumented START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class pre_argumented",1,1725,30,1783,41,1783);
}
