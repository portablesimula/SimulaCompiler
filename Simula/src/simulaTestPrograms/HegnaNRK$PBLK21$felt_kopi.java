// JavaLine 1 ==> SourceLine 866
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$felt_kopi extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=866, lastLine=867, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public HegnaNRK$PBLK21$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public HegnaNRK$PBLK21$verdi p$felt;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$felt_kopi setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$felt_kopi.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$felt=(HegnaNRK$PBLK21$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$felt_kopi(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$felt_kopi(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$felt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$felt = sp$felt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("felt_kopi",866);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$felt_kopi STM$() {
        TRACE_BEGIN_STM$("felt_kopi",866);
        // JavaLine 44 ==> SourceLine 867
        RESULT$=p$felt;
        TRACE_END_STM$("felt_kopi",867);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure felt_kopi",1,866,44,867,49,867);
}
