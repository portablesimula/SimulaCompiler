// JavaLine 1 ==> SourceLine 7
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InspectionSamples$F extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=7, lastLine=8, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public InspectionSamples$A RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$g;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public InspectionSamples$F setPar(Object param) {
        //Util.BREAK("CALL InspectionSamples$F.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$g=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public InspectionSamples$F(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public InspectionSamples$F(RTObject$ SL$,int sp$g) {
        super(SL$);
        // Parameter assignment to locals
        this.p$g = sp$g;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("F",7);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public InspectionSamples$F STM$() {
        TRACE_BEGIN_STM$("F",7);
        // JavaLine 44 ==> SourceLine 8
        RESULT$=(((p$g>(15)))?(((InspectionSamples)(CUR$.SL$)).x):(((InspectionSamples)(CUR$.SL$)).y));
        TRACE_END_STM$("F",8);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("InspectionSamples.sim","Procedure F",1,7,44,8,49,8);
}
