// JavaLine 1 ==> SourceLine 9
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu Feb 21 16:18:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr07$A$F extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=9, lastLine=9, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public float p$x;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr07$A$F setPar(Object param) {
        //Util.BREAK("CALL simerr07$A$F.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$x=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simerr07$A$F(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simerr07$A$F(RTObject$ SL$,float sp$x) {
        super(SL$);
        // Parameter assignment to locals
        this.p$x = sp$x;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("F",9);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simerr07$A$F STM$() {
        TRACE_BEGIN_STM$("F",9);
        TRACE_END_STM$("F",9);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simerr07.sim","Procedure F",1,9,47,9);
}
