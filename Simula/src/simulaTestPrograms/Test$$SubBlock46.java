// JavaLine 1 <== SourceLine 46
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jun 30 14:35:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$SubBlock46 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=46, lastLine=49, hasLocalClasses=false, System=false
    // Declare locals as attributes
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 10 <== SourceLine 47
    int i=0;
    // Normal Constructor
    public Test$$SubBlock46(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock46",47);
        // JavaLine 18 <== SourceLine 46
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock46",46);
        // JavaLine 27 <== SourceLine 48
        i=6;
        TRACE_END_STM$("SubBlock46",48);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","SubBlock SubBlock46",1,46,10,47,18,46,27,48,32,49);
} // End of SubBlock
