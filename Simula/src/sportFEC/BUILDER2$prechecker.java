// JavaLine 1 ==> SourceLine 975
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER2$prechecker extends BUILDER1$precheck0 {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=975, lastLine=1725, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 978
    public TXT$ oldcheckcode=null;
    // JavaLine 13 ==> SourceLine 979
    public boolean B2out=false;
    // JavaLine 15 ==> SourceLine 981
    public COMMON$quantity blockpref=null;
    // Normal Constructor
    public BUILDER2$prechecker(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("prechecker",1719);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("prechecker",1719,inner);
                // JavaLine 27 ==> SourceLine 1725
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("prechecker",1725);
                }
                TRACE_END_STM$("prechecker",1725);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER2$prechecker STM$() { return((BUILDER2$prechecker)CODE$.EXEC$()); }
    public BUILDER2$prechecker START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Class prechecker",1,975,11,978,13,979,15,981,27,1725,38,1725);
}
