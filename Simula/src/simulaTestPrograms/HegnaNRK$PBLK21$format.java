// JavaLine 1 ==> SourceLine 51
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$format extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=51, lastLine=54, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$antall;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 52
    public ARRAY$<int[]>fnr=null;
    public ARRAY$<int[]>spos=null;
    // JavaLine 15 ==> SourceLine 53
    public int ark_lengde=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$format(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("format",53);
        // JavaLine 25 ==> SourceLine 52
        int[] fnr$LB=new int[1]; int[] fnr$UB=new int[1];
        fnr$LB[0]=1; fnr$UB[0]=p$antall;
        BOUND_CHECK$(fnr$LB[0],fnr$UB[0]);
        fnr=new ARRAY$<int[]>(new int[fnr$UB[0]-fnr$LB[0]+1],fnr$LB,fnr$UB);
        int[] spos$LB=new int[1]; int[] spos$UB=new int[1];
        spos$LB[0]=1; spos$UB[0]=p$antall;
        BOUND_CHECK$(spos$LB[0],spos$UB[0]);
        spos=new ARRAY$<int[]>(new int[spos$UB[0]-spos$LB[0]+1],spos$LB,spos$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("format",52,inner);
                // JavaLine 38 ==> SourceLine 54
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("format",54);
                }
                TRACE_END_STM$("format",54);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public HegnaNRK$PBLK21$format STM$() { return((HegnaNRK$PBLK21$format)CODE$.EXEC$()); }
    public HegnaNRK$PBLK21$format START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class format",1,51,12,52,15,53,25,52,38,54,50,54);
}
