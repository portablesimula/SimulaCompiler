// JavaLine 1 ==> SourceLine 418
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$subordinate extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=418, lastLine=427, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$quantity p$qa;
    public COMMON$quantity p$qb;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$subordinate setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$subordinate.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$qa=(COMMON$quantity)objectValue(param); break;
                case 1: p$qb=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$subordinate(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$subordinate(RTObject$ SL$,COMMON$quantity sp$qa,COMMON$quantity sp$qb) {
        super(SL$);
        // Parameter assignment to locals
        this.p$qa = sp$qa;
        this.p$qb = sp$qb;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("subordinate",418);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$subordinate STM$() {
        TRACE_BEGIN_STM$("subordinate",418);
        // JavaLine 47 ==> SourceLine 421
        if((p$qa.type==(p$qb.type))) {
            // JavaLine 49 ==> SourceLine 422
            {
                TRACE_BEGIN_STM$("CompoundStatement422",422);
                if(((p$qa.type==(((BUILDER1)(CUR$.SL$.SL$)).IREF))||((p$qa.type==(((BUILDER1)(CUR$.SL$.SL$)).IPTR))))) {
                    // JavaLine 53 ==> SourceLine 423
                    RESULT$=new BUILDER1$precheck0$subclass(((BUILDER1$precheck0)(CUR$.SL$)),p$qa.prefqual,p$qb.prefqual).RESULT$;
                } else
                // JavaLine 56 ==> SourceLine 424
                RESULT$=true;
                TRACE_END_STM$("CompoundStatement422",424);
            }
        } else
        // JavaLine 61 ==> SourceLine 426
        RESULT$=(p$qb.type==(((BUILDER1)(CUR$.SL$.SL$)).INOTY));
        TRACE_END_STM$("subordinate",426);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure subordinate",1,418,47,421,49,422,53,423,56,424,61,426,66,427);
}
