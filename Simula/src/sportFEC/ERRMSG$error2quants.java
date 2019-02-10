// JavaLine 1 ==> SourceLine 277
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:59:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error2quants extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=277, lastLine=280, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    public COMMON$quantity p$q;
    public COMMON$quantity p$qt;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error2quants setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$error2quants.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$q=(COMMON$quantity)objectValue(param); break;
                case 2: p$qt=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$error2quants(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$error2quants(RTObject$ SL$,int sp$n,COMMON$quantity sp$q,COMMON$quantity sp$qt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$q = sp$q;
        this.p$qt = sp$qt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("error2quants",277);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$error2quants STM$() {
        TRACE_BEGIN_STM$("error2quants",277);
        // JavaLine 47 ==> SourceLine 278
        ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$qlin(((ERRMSG)(CUR$.SL$)),p$qt).RESULT$;
        new ERRMSG$error1id(((ERRMSG)(CUR$.SL$)),p$n,p$q.symb);
        TRACE_END_STM$("error2quants",278);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error2quants",1,277,47,278,53,280);
}
