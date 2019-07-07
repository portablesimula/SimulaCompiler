// JavaLine 1 <== SourceLine 23
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon Jul 01 09:59:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Test$$callFP extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=23, lastLine=26, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public PRCQNT$ p$F;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Test$$callFP setPar(Object param) {
        //Util.BREAK("CALL Test$$callFP.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$F=procValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Test$$callFP(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Test$$callFP(RTObject$ SL$,PRCQNT$ sp$F) {
        super(SL$);
        // Parameter assignment to locals
        this.p$F = sp$F;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("callFP",23);
        STM$();
    }
    // Procedure Statements
    public Test$$callFP STM$() {
        TRACE_BEGIN_STM$("callFP",23);
        // JavaLine 40 <== SourceLine 25
        p$F.CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(7); } }).setPar(new NAME$<Integer>(){ public Integer get() { return(9); } }).ENT$();
        TRACE_END_STM$("callFP",25);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Test.sim","Procedure callFP",1,23,40,25,45,26);
} // End of Procedure
