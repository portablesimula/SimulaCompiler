// JavaLine 1 ==> SourceLine 1204
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$outcodefile extends OutbyteFile$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=4, firstLine=1204, lastLine=1206, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(4); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1205
    public COMMON$quantity opq=null;
    // Normal Constructor
    public COMMON$outcodefile(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("outcodefile",1205);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,4) {
            public void STM$() {
                TRACE_BEGIN_STM$("outcodefile",1205,inner);
                // JavaLine 23 ==> SourceLine 1206
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("outcodefile",1206);
                }
                TRACE_END_STM$("outcodefile",1206);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$outcodefile STM$() { return((COMMON$outcodefile)CODE$.EXEC$()); }
    public COMMON$outcodefile START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class outcodefile",1,1204,11,1205,23,1206,34,1206);
}
