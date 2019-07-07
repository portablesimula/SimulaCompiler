package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:59:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Test$$A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=3, lastLine=13, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public int p$p1;
    public float p$p2;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 5
    public final int lim=(int)(40);
    // JavaLine 13 <== SourceLine 6
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 15 <== SourceLine 7
    public final TXT$ T=(TXT$)(new TXT$("Constant"));
    // JavaLine 17 <== SourceLine 8
    public int i=0;
    // JavaLine 19 <== SourceLine 9
    public float r=0.0f;
    // Normal Constructor
    public Test$$A(RTObject$ staticLink,int sp$p1,float sp$p2) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$p1 = sp$p1;
        this.p$p2 = sp$p2;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",9);
        // JavaLine 30 <== SourceLine 6
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=lim;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    // Class Statements
    public Test$$A STM$() {
        TRACE_BEGIN_STM$("A",6);
        // Class A: Code before inner
        // JavaLine 40 <== SourceLine 10
        i=p$p1;
        // JavaLine 42 <== SourceLine 12
        // Class A: Code after inner
        r=p$p2;
        TRACE_END_STM$("A",12);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","Class A",11,5,13,6,15,7,17,8,19,9,30,6,40,10,42,12,48,13);
} // End of Class
