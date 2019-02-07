// JavaLine 1 ==> SourceLine 158
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$test_verdilikhet extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=158, lastLine=177, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public HegnaNRK$PBLK21$verdi p$v;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$tekstverdi$test_verdilikhet.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("test_verdilikhet",158);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet STM$() {
        TRACE_BEGIN_STM$("test_verdilikhet",158);
        // JavaLine 44 ==> SourceLine 160
        if(VALUE$((!(p$v instanceof HegnaNRK$PBLK21$tekstverdi)))) {
            RESULT$=false;
        } else
        // JavaLine 48 ==> SourceLine 177
        new HegnaNRK$PBLK21$tekstverdi$test_verdilikhet$SubBlock162(CUR$).STM$();
        TRACE_END_STM$("test_verdilikhet",175);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdilikhet",1,158,44,160,48,177,53,177);
}
