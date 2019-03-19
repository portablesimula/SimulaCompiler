// JavaLine 1 ==> SourceLine 179
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=179, lastLine=183, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public HegnaNRK$PBLK21$verdi p$v;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("test_verdi_mindre",179);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre STM$() {
        TRACE_BEGIN_STM$("test_verdi_mindre",179);
        // JavaLine 44 ==> SourceLine 181
        RESULT$=((p$v instanceof HegnaNRK$PBLK21$tekstverdi)?(TXTREL$LT(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst,((HegnaNRK$PBLK21$tekstverdi)(p$v)).tekst)):(false));
        TRACE_END_STM$("test_verdi_mindre",181);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdi_mindre",1,179,44,181,49,183);
}
