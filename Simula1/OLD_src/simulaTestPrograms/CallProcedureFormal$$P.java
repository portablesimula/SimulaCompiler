// JavaLine 1 <== SourceLine 13
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Aug 15 21:46:43 CEST 2019
import simula.runtime.*;
//@SuppressWarnings("unchecked")


public final class CallProcedureFormal$$P extends PROC$ {
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$p1;
    public float p$p2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public CallProcedureFormal$$P setPar(Object param) {
        //Util.BREAK("CALL CallProcedureFormal$$P.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$p1=intValue(param); break;
                case 1: p$p2=floatValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CallProcedureFormal$$P(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public CallProcedureFormal$$P(RTObject$ SL$,int sp$p1,float sp$p2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$p1 = sp$p1;
        this.p$p2 = sp$p2;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public CallProcedureFormal$$P STM$() {
        // JavaLine 44 <== SourceLine 15
        RESULT$=p$p1;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CallProcedureFormal.sim","Procedure P",1,13,44,15,48,16);
} // End of Procedure
