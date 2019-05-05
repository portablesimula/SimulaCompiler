// JavaLine 1 <== SourceLine 217
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$tabell_mengde extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=217, lastLine=220, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$antall;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 219
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
    }
    // Class Statements
    public HegnaNRK$PBLK21$tabell_mengde STM$() {
        TRACE_BEGIN_STM$("tabell_mengde",219);
        // JavaLine 30 <== SourceLine 220
        // Class tabell_mengde: Code before inner
        // Class tabell_mengde: Code after inner
        TRACE_END_STM$("tabell_mengde",220);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class tabell_mengde",1,217,12,219,30,220,36,220);
} // End of Class
