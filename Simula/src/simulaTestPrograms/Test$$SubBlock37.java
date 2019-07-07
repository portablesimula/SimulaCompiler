// JavaLine 1 <== SourceLine 37
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jun 30 12:41:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$SubBlock37 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=37, lastLine=40, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 11 <== SourceLine 38
    int i=0;
    // Normal Constructor
    public Test$$SubBlock37(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock37",38);
        // JavaLine 19 <== SourceLine 37
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock37",37);
        // JavaLine 28 <== SourceLine 39
        i=6;
        TRACE_END_STM$("SubBlock37",39);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","SubBlock SubBlock37",1,37,11,38,19,37,28,39,33,40);
} // End of SubBlock
