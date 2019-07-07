// JavaLine 1 <== SourceLine 38
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jun 30 13:55:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$SubBlock38 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=38, lastLine=41, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 11 <== SourceLine 39
    int i=0;
    // Normal Constructor
    public Test$$SubBlock38(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock38",39);
        // JavaLine 19 <== SourceLine 38
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock38",38);
        // JavaLine 28 <== SourceLine 40
        i=6;
        TRACE_END_STM$("SubBlock38",40);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","SubBlock SubBlock38",1,38,11,39,19,38,28,40,33,41);
} // End of SubBlock
