// JavaLine 1 <== SourceLine 47
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:58:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$SubBlock47 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=47, lastLine=50, hasLocalClasses=false, System=false
    // Declare locals as attributes
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 10 <== SourceLine 48
    int i=0;
    // Normal Constructor
    public Test$$SubBlock47(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock47",48);
        // JavaLine 18 <== SourceLine 47
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock47",47);
        // JavaLine 27 <== SourceLine 49
        i=6;
        TRACE_END_STM$("SubBlock47",49);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","SubBlock SubBlock47",1,47,10,48,18,47,27,49,32,50);
} // End of SubBlock
