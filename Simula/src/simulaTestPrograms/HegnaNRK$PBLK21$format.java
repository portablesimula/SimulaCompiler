// JavaLine 1 <== SourceLine 51
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$format extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=51, lastLine=54, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$antall;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 52
    public ARRAY$<int[]>fnr=null;
    public ARRAY$<int[]>spos=null;
    // JavaLine 15 <== SourceLine 53
    public int ark_lengde=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$format(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("format",53);
        // JavaLine 25 <== SourceLine 52
        int[] fnr$LB=new int[1]; int[] fnr$UB=new int[1];
        fnr$LB[0]=1; fnr$UB[0]=p$antall;
        BOUND_CHECK$(fnr$LB[0],fnr$UB[0]);
        fnr=new ARRAY$<int[]>(new int[fnr$UB[0]-fnr$LB[0]+1],fnr$LB,fnr$UB);
        int[] spos$LB=new int[1]; int[] spos$UB=new int[1];
        spos$LB[0]=1; spos$UB[0]=p$antall;
        BOUND_CHECK$(spos$LB[0],spos$UB[0]);
        spos=new ARRAY$<int[]>(new int[spos$UB[0]-spos$LB[0]+1],spos$LB,spos$UB);
    }
    // Class Statements
    public HegnaNRK$PBLK21$format STM$() {
        TRACE_BEGIN_STM$("format",52);
        // JavaLine 38 <== SourceLine 54
        // Class format: Code before inner
        // Class format: Code after inner
        TRACE_END_STM$("format",54);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class format",1,51,12,52,15,53,25,52,38,54,44,54);
} // End of Class
