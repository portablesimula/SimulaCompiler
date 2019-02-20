// JavaLine 1 ==> SourceLine 226
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$L_year extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=226, lastLine=230, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$Yx;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$L_year setPar(Object param) {
        //Util.BREAK("CALL Dates$L_year.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Yx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Dates$L_year(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$L_year(RTObject$ SL$,int sp$Yx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Yx = sp$Yx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("L_year",226);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$L_year STM$() {
        TRACE_BEGIN_STM$("L_year",226);
        // JavaLine 44 ==> SourceLine 229
        RESULT$=(((mod(p$Yx,4)==(0))&((mod(p$Yx,100)>(0))))|((mod(p$Yx,400)==(0))));
        TRACE_END_STM$("L_year",229);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure L_year",1,226,44,229,49,230);
}
