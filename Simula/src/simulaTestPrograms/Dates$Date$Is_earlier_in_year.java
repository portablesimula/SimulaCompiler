// JavaLine 1 ==> SourceLine 160
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Date$Is_earlier_in_year extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=160, lastLine=166, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Dates$Date p$Dx;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Date$Is_earlier_in_year setPar(Object param) {
        //Util.BREAK("CALL Dates$Date$Is_earlier_in_year.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Dates$Date$Is_earlier_in_year(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$Date$Is_earlier_in_year(RTObject$ SL$,Dates$Date sp$Dx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Dx = sp$Dx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Is_earlier_in_year",160);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Date$Is_earlier_in_year STM$() {
        TRACE_BEGIN_STM$("Is_earlier_in_year",160);
        // JavaLine 44 ==> SourceLine 163
        if(VALUE$((((Dates$Date)(CUR$.SL$)).p$M==(p$Dx.p$M)))) {
            // JavaLine 46 ==> SourceLine 164
            {
                TRACE_BEGIN_STM$("CompoundStatement164",164);
                RESULT$=(((Dates$Date)(CUR$.SL$)).p$D<(p$Dx.p$D));
                TRACE_END_STM$("CompoundStatement164",164);
            }
        } else
        // JavaLine 53 ==> SourceLine 165
        RESULT$=(((Dates$Date)(CUR$.SL$)).p$M<(p$Dx.p$M));
        TRACE_END_STM$("Is_earlier_in_year",165);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Is_earlier_in_year",1,160,44,163,46,164,53,165,58,166);
}
