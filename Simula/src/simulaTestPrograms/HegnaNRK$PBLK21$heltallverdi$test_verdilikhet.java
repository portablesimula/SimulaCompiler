// JavaLine 1 ==> SourceLine 74
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$test_verdilikhet extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=74, lastLine=78, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public HegnaNRK$PBLK21$verdi p$v;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$heltallverdi$test_verdilikhet.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("test_verdilikhet",74);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet STM$() {
        TRACE_BEGIN_STM$("test_verdilikhet",74);
        // JavaLine 44 ==> SourceLine 76
        RESULT$=((p$v instanceof HegnaNRK$PBLK21$heltallverdi)?((((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall==(((HegnaNRK$PBLK21$heltallverdi)(p$v)).tall))):(false));
        TRACE_END_STM$("test_verdilikhet",76);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdilikhet",1,74,44,76,49,78);
}
