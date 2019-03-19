// JavaLine 1 ==> SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Mar 13 15:33:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CoroutineSample$trace extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=4, lastLine=8, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CoroutineSample$trace setPar(Object param) {
        //Util.BREAK("CALL CoroutineSample$trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CoroutineSample$trace(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CoroutineSample$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trace",4);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CoroutineSample$trace STM$() {
        TRACE_BEGIN_STM$("trace",4);
        // JavaLine 41 ==> SourceLine 6
        sysout().outtext(p$msg);
        sysout().outimage();
        TRACE_END_STM$("trace",6);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CoroutineSample.sim","Procedure trace",1,4,41,6,47,8);
}
