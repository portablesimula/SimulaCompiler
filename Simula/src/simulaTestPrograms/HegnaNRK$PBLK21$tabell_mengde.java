// JavaLine 1 ==> SourceLine 217
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$tabell_mengde extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=217, lastLine=220, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$antall;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 219
    public ARRAY$<int[]>tabell=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$tabell_mengde(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("tabell_mengde",219);
        int[] tabell$LB=new int[1]; int[] tabell$UB=new int[1];
        tabell$LB[0]=1; tabell$UB[0]=p$antall;
        BOUND_CHECK$(tabell$LB[0],tabell$UB[0]);
        tabell=new ARRAY$<int[]>(new int[tabell$UB[0]-tabell$LB[0]+1],tabell$LB,tabell$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("tabell_mengde",219,inner);
                // JavaLine 30 ==> SourceLine 220
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("tabell_mengde",220);
                }
                TRACE_END_STM$("tabell_mengde",220);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public HegnaNRK$PBLK21$tabell_mengde STM$() { return((HegnaNRK$PBLK21$tabell_mengde)CODE$.EXEC$()); }
    public HegnaNRK$PBLK21$tabell_mengde START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class tabell_mengde",1,217,12,219,30,220,42,220);
}
