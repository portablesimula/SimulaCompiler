// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:23:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23$PQ extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=6, lastLine=7, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public PRCQNT$ p$p;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public issue23$PQ setPar(Object param) {
        //Util.BREAK("CALL issue23$PQ.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$p=procValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public issue23$PQ(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public issue23$PQ(RTObject$ SL$,PRCQNT$ sp$p) {
        super(SL$);
        // Parameter assignment to locals
        this.p$p = sp$p;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("PQ",6);
        STM$();
    }
    // Procedure Statements
    public issue23$PQ STM$() {
        TRACE_BEGIN_STM$("PQ",6);
        // JavaLine 41 <== SourceLine 7
        p$p.CPF();
        TRACE_END_STM$("PQ",7);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","Procedure PQ",1,6,41,7,46,7);
} // End of Procedure
