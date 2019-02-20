// JavaLine 1 ==> SourceLine 142
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_same extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=142, lastLine=146, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Dates$Date p$Dx;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Is_same setPar(Object param) {
        //Util.BREAK("CALL Dates$Date$Is_same.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Dates$Date$Is_same(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$Date$Is_same(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Dx = sp$Dx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_same",142);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_same STM$() {
        TRACE_BEGIN_STM$("Is_same",142);
        // JavaLine 44 ==> SourceLine 145
        RESULT$=(((((Dates$Date)(CUR$.SL$)).p$D==(p$Dx.p$D))&((((Dates$Date)(CUR$.SL$)).p$M==(p$Dx.p$M))))&((((Dates$Date)(CUR$.SL$)).p$Y==(p$Dx.p$Y))));
        TRACE_END_STM$("Is_same",145);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_same",1,142,44,145,49,146);
}
