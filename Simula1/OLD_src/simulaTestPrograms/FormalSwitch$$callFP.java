// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Aug 18 11:51:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FormalSwitch$$callFP extends PROC$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=6, lastLine=9, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public PRCQNT$ p$F;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public FormalSwitch$$callFP setPar(Object param) {
        //Util.BREAK("CALL FormalSwitch$$callFP.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public FormalSwitch$$callFP(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public FormalSwitch$$callFP(RTObject$ SL$,PRCQNT$ sp$F) {
        super(SL$);
        // Parameter assignment to locals
        this.p$F = sp$F;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public FormalSwitch$$callFP STM$() {
        // JavaLine 38 <== SourceLine 8
        GOTO$((LABQNT$)(p$F.CPF()
        		.setPar(new NAME$<Integer>(){ public Integer get() { return(4); } })
        		.ENT$().RESULT$()));
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FormalSwitch.sim","Procedure callFP",1,6,38,8,42,9);
} // End of Procedure
