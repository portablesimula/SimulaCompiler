// JavaLine 1 ==> SourceLine 54
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$codebuffer$elt extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=54, lastLine=69, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 55
    public char opdhii=0;
    public char opdloo=0;
    public char optxx=0;
    public char opnn=0;
    // JavaLine 16 ==> SourceLine 56
    public PARSER$codebuffer$elt next=null;
    // Normal Constructor
    public PARSER$codebuffer$elt(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("elt",67);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("elt",67,inner);
                // JavaLine 29 ==> SourceLine 69
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("elt",69);
                }
                TRACE_END_STM$("elt",69);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$codebuffer$elt STM$() { return((PARSER$codebuffer$elt)CODE$.EXEC$()); }
    public PARSER$codebuffer$elt START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class elt",1,54,11,55,16,56,29,69,41,69);
}
