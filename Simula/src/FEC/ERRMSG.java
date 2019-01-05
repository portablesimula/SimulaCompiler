// JavaLine 1 ==> SourceLine 6
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class ERRMSG extends COMMON {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=1, firstLine=6, lastLine=1002, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 40
    public int numwarnfound=0;
    // JavaLine 13 ==> SourceLine 41
    public int maxerrno=0;
    // JavaLine 15 ==> SourceLine 42
    public final int uplim=450;
    // JavaLine 17 ==> SourceLine 44
    public DirectFile$ ERRORFILE=null;
    public boolean ERRnotopen=false;
    // JavaLine 20 ==> SourceLine 46
    public final int messlength=50;
    // JavaLine 22 ==> SourceLine 164
    public int lasterrpos=0;
    public int lasterrmess=0;
    public int errloop=0;
    // JavaLine 26 ==> SourceLine 165
    public int lasterrline=0;
    public PRCQNT$ COMMONerror$0() { return(new PRCQNT$(this,ERRMSG$COMMONerror.class)); }
    // Normal Constructor
    public ERRMSG(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("ERRMSG",999);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("ERRMSG",999,inner);
                // JavaLine 39 ==> SourceLine 1002
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("ERRMSG",1002);
                }
                TRACE_END_STM$("ERRMSG",1002);
            }
        };
    } // End of Constructor
    // Class Statements
    public ERRMSG STM$() { return((ERRMSG)CODE$.EXEC$()); }
    public ERRMSG START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Class ERRMSG",1,6,11,40,13,41,15,42,17,44,20,46,22,164,26,165,39,1002,50,1002);
}
