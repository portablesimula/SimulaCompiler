package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$offset_const extends Common$const$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=4, firstLine=714, lastLine=717, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 9 <== SourceLine 715
    public int of$4=0;
    public int ndot$4=0;
    // JavaLine 12 <== SourceLine 716
    public ARRAY$<int[]>q=null;
    // Normal Constructor
    public Common$offset_const(RTObject$ staticLink,int sp3$instr) {
        super(staticLink,sp3$instr);
        // Parameter assignment to locals
        // Declaration Code
        int[] q$LB=new int[1]; int[] q$UB=new int[1];
        q$LB[0]=1; q$UB[0]=5;
        BOUND_CHECK$(q$LB[0],q$UB[0]);
        q=new ARRAY$<int[]>(new int[q$UB[0]-q$LB[0]+1],q$LB,q$UB);
    }
    // Class Statements
    public Common$offset_const STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class expr: Code before inner
        // JavaLine 29 <== SourceLine 677
        ;
        // JavaLine 31 <== SourceLine 716
        // Class const$: Code before inner
        // JavaLine 33 <== SourceLine 705
        ;
        // JavaLine 35 <== SourceLine 717
        // Class offset_const: Code before inner
        // Class offset_const: Code after inner
        // Class const$: Code after inner
        // Class expr: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class offset_const",9,715,12,716,29,677,31,716,33,705,35,717,42,717);
} // End of Class
