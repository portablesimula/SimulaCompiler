package simulaTestPrograms;
// Simula-1.0 Compiled at Fri Aug 16 09:45:27 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")


public final class ProcedureDeclaration$$P extends PROC$ {
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$p1;
    public float p$p2;
    // Declare locals as attributes
    public ARRAY$<TXT$[]>TA=null;
    int i=0;
    
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public ProcedureDeclaration$$P setPar(Object param) {
        try { switch($nParLeft--) {
                case 2: p$p1=intValue(param); break;
                case 1: p$p2=floatValue(param); break;
                default: throw new RuntimeException("Too many parameters");
        }   }
        catch(ClassCastException e) {
        	throw new RuntimeException("Wrong type of parameter: "+param,e); }
        return(this);
    }
    
    // Constructor in case of Formal/Virtual Procedure Call
    public ProcedureDeclaration$$P(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    
    // Normal Constructor
    public ProcedureDeclaration$$P(RTObject$ SL$,int sp$p1,float sp$p2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$p1 = sp$p1;
        this.p$p2 = sp$p2;
        BBLK();
        // Declaration Code
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=1; TA$UB[0]=40;
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
        STM$();
    }
    
    // Procedure Statements
    public ProcedureDeclaration$$P STM$() {
        RESULT$=p$p1;
        i=6;
        EBLK();
        return(this);
    }
}
