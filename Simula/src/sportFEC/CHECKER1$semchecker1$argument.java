// JavaLine 1 ==> SourceLine 2113
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$argument extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=2113, lastLine=2132, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$argno;
    public CHECKER1$semchecker1$exp p$actual;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 2120
    public CHECKER1$semchecker1$argument nextarg=null;
    public PRCQNT$ emit$0() { throw new RuntimeException("No Virtual Match"); }
    // Normal Constructor
    public CHECKER1$semchecker1$argument(RTObject$ staticLink,int sp$argno,CHECKER1$semchecker1$exp sp$actual) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$argno = sp$argno;
        this.p$actual = sp$actual;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("argument",2129);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("argument",2129,inner);
                // JavaLine 29 ==> SourceLine 2132
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("argument",2132);
                }
                TRACE_END_STM$("argument",2132);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$argument STM$() { return((CHECKER1$semchecker1$argument)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$argument START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class argument",1,2113,13,2120,29,2132,41,2132);
}
