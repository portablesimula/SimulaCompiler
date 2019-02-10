// JavaLine 1 ==> SourceLine 1103
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:52:22 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$extbrecord extends COMMON$brecord {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=1103, lastLine=1137, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1104
    public COMMON$extquantity cause=null;
    // JavaLine 13 ==> SourceLine 1113
    public int exttagnum=0;
    // JavaLine 15 ==> SourceLine 1116
    public int ftag=0;
    // JavaLine 17 ==> SourceLine 1118
    public char checkhi=0;
    public char checklo=0;
    // JavaLine 20 ==> SourceLine 1120
    public char modulhi=0;
    public char modullo=0;
    // JavaLine 23 ==> SourceLine 1121
    public char status=0;
    // Normal Constructor
    public COMMON$extbrecord(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("extbrecord",1121);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("extbrecord",1121,inner);
                // JavaLine 35 ==> SourceLine 1137
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("extbrecord",1137);
                }
                TRACE_END_STM$("extbrecord",1137);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$extbrecord STM$() { return((COMMON$extbrecord)CODE$.EXEC$()); }
    public COMMON$extbrecord START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class extbrecord",1,1103,11,1104,13,1113,15,1116,17,1118,20,1120,23,1121,35,1137,46,1137);
}
