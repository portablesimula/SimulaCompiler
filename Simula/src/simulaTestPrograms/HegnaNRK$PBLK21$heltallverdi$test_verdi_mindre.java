// JavaLine 1 ==> SourceLine 79
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=79, lastLine=83, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public HegnaNRK$PBLK21$verdi p$v;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$v=(HegnaNRK$PBLK21$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("test_verdi_mindre",79);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre STM$() {
        TRACE_BEGIN_STM$("test_verdi_mindre",79);
        // JavaLine 44 ==> SourceLine 81
        RESULT$=((p$v instanceof HegnaNRK$PBLK21$heltallverdi)?((((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall<(((HegnaNRK$PBLK21$heltallverdi)(p$v)).tall))):(false));
        TRACE_END_STM$("test_verdi_mindre",81);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdi_mindre",1,79,44,81,49,83);
}
