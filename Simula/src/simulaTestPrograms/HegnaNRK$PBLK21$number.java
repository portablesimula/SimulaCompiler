// JavaLine 1 ==> SourceLine 1037
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$number extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1037, lastLine=1038, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$c;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$number setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$number.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$c=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$number(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$number(RTObject$ SL$,char sp$c) {
        super(SL$);
        // Parameter assignment to locals
        this.p$c = sp$c;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("number",1037);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$number STM$() {
        TRACE_BEGIN_STM$("number",1037);
        // JavaLine 44 ==> SourceLine 1038
        RESULT$=(('0'<=(p$c))&((p$c<=('9'))));
        TRACE_END_STM$("number",1038);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure number",1,1037,44,1038,49,1038);
}
