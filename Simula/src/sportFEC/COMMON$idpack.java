// JavaLine 1 ==> SourceLine 1187
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$idpack extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=1187, lastLine=1197, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1188
    public char idhi=0;
    public char idlo=0;
    // JavaLine 14 ==> SourceLine 1189
    public int line=0;
    // JavaLine 16 ==> SourceLine 1190
    public COMMON$idpack next=null;
    // Normal Constructor
    public COMMON$idpack(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("idpack",1190);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("idpack",1190,inner);
                // JavaLine 29 ==> SourceLine 1197
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("idpack",1197);
                }
                TRACE_END_STM$("idpack",1197);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$idpack STM$() { return((COMMON$idpack)CODE$.EXEC$()); }
    public COMMON$idpack START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class idpack",1,1187,11,1188,14,1189,16,1190,29,1197,41,1197);
}
