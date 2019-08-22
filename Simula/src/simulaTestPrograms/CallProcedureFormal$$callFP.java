package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Aug 15 21:46:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CallProcedureFormal$$callFP extends PROC$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=3, lastLine=10, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public PRCQNT$ p$F;
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 5
    float r=0.0f;
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public CallProcedureFormal$$callFP setPar(Object param) {
        //Util.BREAK("CALL CallProcedureFormal$$callFP.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$F=procValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CallProcedureFormal$$callFP(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public CallProcedureFormal$$callFP(RTObject$ SL$,PRCQNT$ sp$F) {
        super(SL$);
        // Parameter assignment to locals
        this.p$F = sp$F;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public CallProcedureFormal$$callFP STM$() {
        // JavaLine 40 <== SourceLine 6
        r=((float)(intValue(p$F.CPF()
        		.setPar(new NAME$<Integer>(){ public Integer get() { return(7); } })
        		.setPar(new NAME$<Integer>(){ public Integer get() { return(9); } })
        		.ENT$().RESULT$())));
        // JavaLine 42 <== SourceLine 7
        i=intValue(p$F.CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(7); } }).setPar(new NAME$<Integer>(){ public Integer get() { return(9); } }).ENT$().RESULT$());
        // JavaLine 44 <== SourceLine 9
        i=intValue(p$F.CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(9); } }).ENT$().RESULT$());
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CallProcedureFormal.sim","Procedure callFP",10,5,40,6,42,7,44,9,48,10);
} // End of Procedure
