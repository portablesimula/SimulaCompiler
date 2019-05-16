// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:23:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23$PP extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=3, lastLine=4, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public ARRAY$<?> p$a;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public issue23$PP setPar(Object param) {
        //Util.BREAK("CALL issue23$PP.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$a=arrayValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public issue23$PP(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public issue23$PP(RTObject$ SL$,ARRAY$<?> sp$a) {
        super(SL$);
        // Parameter assignment to locals
        this.p$a = sp$a;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("PP",3);
        STM$();
    }
    // Procedure Statements
    public issue23$PP STM$() {
        TRACE_BEGIN_STM$("PP",3);
        // JavaLine 41 <== SourceLine 4
        sysout().outfix(((ARRAY$<float[]>)p$a).Elt[1-p$a.LB[0]],2,5);
        TRACE_END_STM$("PP",4);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","Procedure PP",1,3,41,4,46,4);
} // End of Procedure
