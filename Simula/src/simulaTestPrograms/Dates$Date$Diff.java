// JavaLine 1 ==> SourceLine 64
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Diff extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=64, lastLine=68, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Dates$Date p$Dx;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Diff setPar(Object param) {
        //Util.BREAK("CALL Dates$Date$Diff.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Dx=(Dates$Date)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Dates$Date$Diff(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$Date$Diff(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Dx = sp$Dx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Diff",64);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Diff STM$() {
        TRACE_BEGIN_STM$("Diff",64);
        // JavaLine 44 ==> SourceLine 67
        RESULT$=(new Dates$Date$N_days(p$Dx).RESULT$-(new Dates$Date$N_days(((Dates$Date)(CUR$.SL$))).RESULT$));
        TRACE_END_STM$("Diff",67);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Diff",1,64,44,67,49,68);
}
