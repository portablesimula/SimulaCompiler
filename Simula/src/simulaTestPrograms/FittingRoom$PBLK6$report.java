// JavaLine 1 ==> SourceLine 39
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:33:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$report extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=39, lastLine=41, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$message;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public FittingRoom$PBLK6$report setPar(Object param) {
        //Util.BREAK("CALL FittingRoom$PBLK6$report.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public FittingRoom$PBLK6$report(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public FittingRoom$PBLK6$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        // Parameter assignment to locals
        this.p$message = sp$message;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("report",39);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public FittingRoom$PBLK6$report STM$() {
        TRACE_BEGIN_STM$("report",39);
        // JavaLine 41 ==> SourceLine 40
        sysout().outfix(((FittingRoom$PBLK6)(CUR$.SL$)).time(),2,6);
        sysout().outtext(CONC(new TXT$(": "),p$message));
        sysout().outimage();
        TRACE_END_STM$("report",40);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure report",1,39,41,40,48,41);
}
