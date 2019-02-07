// JavaLine 1 ==> SourceLine 932
package sportFEC;
// Simula-Beta-0.3 Compiled at Wed Feb 06 13:19:01 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$quantity extends COMMON$sembox {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=932, lastLine=1100, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 933
    public char type=0;
    public char kind=0;
    public char categ=0;
    public char special=0;
    // JavaLine 16 ==> SourceLine 934
    public char protect=0;
    // JavaLine 18 ==> SourceLine 935
    public char visible=0;
    // JavaLine 20 ==> SourceLine 936
    public int plev=0;
    // JavaLine 22 ==> SourceLine 938
    public int dim=0;
    // JavaLine 24 ==> SourceLine 939
    public int virtno=0;
    // JavaLine 26 ==> SourceLine 940
    public int ftag=0;
    // JavaLine 28 ==> SourceLine 941
    public int line=0;
    // JavaLine 30 ==> SourceLine 942
    public COMMON$symbolbox symb=null;
    // JavaLine 32 ==> SourceLine 943
    public COMMON$brecord encl=null;
    // JavaLine 34 ==> SourceLine 945
    public COMMON$brecord descr=null;
    // JavaLine 36 ==> SourceLine 946
    public COMMON$quantity prefqual=null;
    // JavaLine 38 ==> SourceLine 947
    public COMMON$quantity match=null;
    // Normal Constructor
    public COMMON$quantity(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("quantity",947);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("quantity",947,inner);
                // JavaLine 50 ==> SourceLine 1100
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("quantity",1100);
                }
                TRACE_END_STM$("quantity",1100);
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$quantity STM$() { return((COMMON$quantity)CODE$.EXEC$()); }
    public COMMON$quantity START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class quantity",1,932,11,933,16,934,18,935,20,936,22,938,24,939,26,940,28,941,30,942,32,943,34,945,36,946,38,947,50,1100,61,1100);
}
