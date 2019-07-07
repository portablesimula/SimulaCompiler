// JavaLine 1 <== SourceLine 29
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:59:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$P extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=29, lastLine=36, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$p1;
    public float p$p2;
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 32
    public ARRAY$<TXT$[]>TA=null;
    // JavaLine 17 <== SourceLine 33
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Test$$P setPar(Object param) {
        //Util.BREAK("CALL Test$$P.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$p1=intValue(param); break;
                case 1: p$p2=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Test$$P(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Test$$P(RTObject$ SL$,int sp$p1,float sp$p2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$p1 = sp$p1;
        this.p$p2 = sp$p2;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P",33);
        // JavaLine 45 <== SourceLine 32
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
        STM$();
    }
    // Procedure Statements
    public Test$$P STM$() {
        TRACE_BEGIN_STM$("P",32);
        // JavaLine 55 <== SourceLine 34
        RESULT$=p$p1;
        // JavaLine 57 <== SourceLine 35
        i=6;
        TRACE_END_STM$("P",35);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","Procedure P",1,29,15,32,17,33,45,32,55,34,57,35,62,36);
} // End of Procedure
