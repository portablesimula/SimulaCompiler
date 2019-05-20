// JavaLine 1 <== SourceLine 4
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon May 20 10:13:03 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue26$report extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=4, lastLine=7, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$message;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public issue26$report setPar(Object param) {
        //Util.BREAK("CALL issue26$report.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$message=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public issue26$report(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public issue26$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        // Parameter assignment to locals
        this.p$message = sp$message;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("report",4);
        STM$();
    }
    // Procedure Statements
    public issue26$report STM$() {
        TRACE_BEGIN_STM$("report",4);
        // JavaLine 41 <== SourceLine 6
        sysout().outtext(p$message);
        sysout().outimage();
        TRACE_END_STM$("report",6);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue26.sim","Procedure report",1,4,41,6,47,7);
} // End of Procedure
