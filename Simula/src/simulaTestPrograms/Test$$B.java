// JavaLine 1 <== SourceLine 15
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:59:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Test$$B extends Test$$A {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=15, lastLine=21, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public double p1$p3;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 17
    public ARRAY$<float[]>RA=null;
    // Normal Constructor
    public Test$$B(RTObject$ staticLink,int sp$p1,float sp$p2,double sp1$p3) {
        super(staticLink,sp$p1,sp$p2);
        // Parameter assignment to locals
        this.p1$p3 = sp1$p3;
        // Declaration Code
        TRACE_BEGIN_DCL$("B",17);
        int[] RA$LB=new int[1]; int[] RA$UB=new int[1];
        RA$LB[0]=1; RA$UB[0]=lim;
        BOUND_CHECK$(RA$LB[0],RA$UB[0]);
        RA=new ARRAY$<float[]>(new float[RA$UB[0]-RA$LB[0]+1],RA$LB,RA$UB);
    }
    // Class Statements
    public Test$$B STM$() {
        TRACE_BEGIN_STM$("B",17);
        // Class A: Code before inner
        // JavaLine 29 <== SourceLine 10
        i=p$p1;
        // Class B: Code before inner
        // JavaLine 32 <== SourceLine 18
        RA.Elt[14-RA.LB[0]]=r;
        // JavaLine 34 <== SourceLine 20
        // Class B: Code after inner
        r=RA.Elt[14-RA.LB[0]];
        // Class A: Code after inner
        // JavaLine 38 <== SourceLine 12
        r=p$p2;
        // JavaLine 40 <== SourceLine 20
        TRACE_END_STM$("B",20);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","Class B",1,15,11,17,29,10,32,18,34,20,38,12,40,20,44,21);
} // End of Class
