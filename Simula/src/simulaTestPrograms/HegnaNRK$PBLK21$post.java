// JavaLine 1 <== SourceLine 250
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$post extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=250, lastLine=254, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$antall;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 252
    public ARRAY$<int[]>feltnr=null;
    // JavaLine 14 <== SourceLine 253
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>felt=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$post(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("post",253);
        // JavaLine 24 <== SourceLine 252
        int[] feltnr$LB=new int[1]; int[] feltnr$UB=new int[1];
        feltnr$LB[0]=1; feltnr$UB[0]=p$antall;
        BOUND_CHECK$(feltnr$LB[0],feltnr$UB[0]);
        feltnr=new ARRAY$<int[]>(new int[feltnr$UB[0]-feltnr$LB[0]+1],feltnr$LB,feltnr$UB);
        // JavaLine 29 <== SourceLine 253
        int[] felt$LB=new int[1]; int[] felt$UB=new int[1];
        felt$LB[0]=1; felt$UB[0]=p$antall;
        BOUND_CHECK$(felt$LB[0],felt$UB[0]);
        felt=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[felt$UB[0]-felt$LB[0]+1],felt$LB,felt$UB);
    }
    // Class Statements
    public HegnaNRK$PBLK21$post STM$() {
        TRACE_BEGIN_STM$("post",253);
        // JavaLine 38 <== SourceLine 254
        // Class post: Code before inner
        // Class post: Code after inner
        TRACE_END_STM$("post",254);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class post",1,250,12,252,14,253,24,252,29,253,38,254,44,254);
} // End of Class
