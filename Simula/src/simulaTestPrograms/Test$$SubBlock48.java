// JavaLine 1 <== SourceLine 48
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:59:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$SubBlock48 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=48, lastLine=51, hasLocalClasses=false, System=false
    // Declare locals as attributes
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 10 <== SourceLine 49
    int i=0;
    // Normal Constructor
    public Test$$SubBlock48(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock48",49);
        // JavaLine 18 <== SourceLine 48
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock48",48);
        // JavaLine 27 <== SourceLine 50
        i=6;
        TRACE_END_STM$("SubBlock48",50);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","SubBlock SubBlock48",1,48,10,49,18,48,27,50,32,51);
} // End of SubBlock
