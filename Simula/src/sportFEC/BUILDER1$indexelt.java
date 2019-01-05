// JavaLine 1 ==> SourceLine 79
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$indexelt extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=79, lastLine=82, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 80
    public int index=0;
    // JavaLine 13 ==> SourceLine 81
    public BUILDER1$indexelt next=null;
    // Normal Constructor
    public BUILDER1$indexelt(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("indexelt",81);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("indexelt",81,inner);
                // JavaLine 26 ==> SourceLine 82
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("indexelt",82);
                }
                TRACE_END_STM$("indexelt",82);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$indexelt STM$() { return((BUILDER1$indexelt)CODE$.EXEC$()); }
    public BUILDER1$indexelt START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class indexelt",1,79,11,80,13,81,26,82,38,82);
}
