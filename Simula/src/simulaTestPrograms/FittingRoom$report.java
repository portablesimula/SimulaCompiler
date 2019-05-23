// JavaLine 1 <== SourceLine 40
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$report extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=40, lastLine=42, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$message;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public FittingRoom$report setPar(Object param) {
        //Util.BREAK("CALL FittingRoom$report.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public FittingRoom$report(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public FittingRoom$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        // Parameter assignment to locals
        this.p$message = sp$message;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("report",40);
        STM$();
    }
    // Procedure Statements
    public FittingRoom$report STM$() {
        TRACE_BEGIN_STM$("report",40);
        // JavaLine 41 <== SourceLine 41
        sysout().outfix(((FittingRoom)(CUR$.SL$)).time(),2,6);
        sysout().outtext(CONC(new TXT$(": "),p$message));
        sysout().outimage();
        TRACE_END_STM$("report",41);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure report",1,40,41,41,48,42);
} // End of Procedure
