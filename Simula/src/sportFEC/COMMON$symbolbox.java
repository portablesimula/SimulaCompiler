// JavaLine 1 ==> SourceLine 94
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:52:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$symbolbox extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=94, lastLine=100, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 95
    public char idhi=0;
    public char idlo=0;
    // JavaLine 14 ==> SourceLine 96
    public int idtag=0;
    // JavaLine 16 ==> SourceLine 98
    public COMMON$symbolbox next=null;
    // JavaLine 18 ==> SourceLine 99
    public TXT$ symbol=null;
    // Normal Constructor
    public COMMON$symbolbox(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("symbolbox",99);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("symbolbox",99,inner);
                // JavaLine 31 ==> SourceLine 100
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("symbolbox",100);
                }
                TRACE_END_STM$("symbolbox",100);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$symbolbox STM$() { return((COMMON$symbolbox)CODE$.EXEC$()); }
    public COMMON$symbolbox START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class symbolbox",1,94,11,95,14,96,16,98,18,99,31,100,43,100);
}
