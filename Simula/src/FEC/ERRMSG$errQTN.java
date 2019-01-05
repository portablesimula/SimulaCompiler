// JavaLine 1 ==> SourceLine 265
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$errQTN extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=265, lastLine=268, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    public int p$n;
    public COMMON$quantity p$qt;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$errQTN setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$errQTN.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                case 2: p$qt=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$errQTN(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$errQTN(RTObject$ SL$,COMMON$quantity sp$q,int sp$n,COMMON$quantity sp$qt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        this.p$n = sp$n;
        this.p$qt = sp$qt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("errQTN",265);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$errQTN STM$() {
        TRACE_BEGIN_STM$("errQTN",265);
        // JavaLine 47 ==> SourceLine 266
        ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$qlin(((ERRMSG)(CUR$.SL$)),p$qt).RESULT$;
        new ERRMSG$errQT(((ERRMSG)(CUR$.SL$)),p$q,p$n);
        TRACE_END_STM$("errQTN",266);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure errQTN",1,265,47,266,53,268);
}
