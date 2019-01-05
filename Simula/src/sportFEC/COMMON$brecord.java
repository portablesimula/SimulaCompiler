// JavaLine 1 ==> SourceLine 822
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$brecord extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=822, lastLine=929, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 824
    public char blnohi=0;
    public char blnolo=0;
    public char blev=0;
    public char rtblev=0;
    // JavaLine 16 ==> SourceLine 825
    public char dcltag=0;
    public char stmtag=0;
    public char inrtag=0;
    // JavaLine 20 ==> SourceLine 826
    public char kind=0;
    // JavaLine 22 ==> SourceLine 828
    public boolean thisused=false;
    // JavaLine 24 ==> SourceLine 829
    public boolean localclasses=false;
    // JavaLine 26 ==> SourceLine 830
    public boolean descriptorpr=false;
    // JavaLine 28 ==> SourceLine 831
    public boolean hasCode=false;
    // JavaLine 30 ==> SourceLine 832
    public char inspected=0;
    // JavaLine 32 ==> SourceLine 833
    public int connests=0;
    // JavaLine 34 ==> SourceLine 835
    public int npar=0;
    // JavaLine 36 ==> SourceLine 837
    public int navirt=0;
    // JavaLine 38 ==> SourceLine 838
    public int line1=0;
    // JavaLine 40 ==> SourceLine 839
    public COMMON$quantity declquant=null;
    // JavaLine 42 ==> SourceLine 840
    public COMMON$quantity fpar=null;
    // JavaLine 44 ==> SourceLine 841
    public COMMON$quantity favirt=null;
    // JavaLine 46 ==> SourceLine 842
    public COMMON$idpack hidlist=null;
    // JavaLine 48 ==> SourceLine 845
    public COMMON$stackedb preinsp=null;
    // Normal Constructor
    public COMMON$brecord(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("brecord",845);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("brecord",845,inner);
                // JavaLine 61 ==> SourceLine 929
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("brecord",929);
                }
                TRACE_END_STM$("brecord",929);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public COMMON$brecord STM$() { return((COMMON$brecord)CODE$.EXEC$()); }
    public COMMON$brecord START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class brecord",1,822,11,824,16,825,20,826,22,828,24,829,26,830,28,831,30,832,32,833,34,835,36,837,38,838,40,839,42,840,44,841,46,842,48,845,61,929,73,929);
}
