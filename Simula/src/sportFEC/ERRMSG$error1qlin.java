// JavaLine 1 ==> SourceLine 271
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error1qlin extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=271, lastLine=274, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error1qlin setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$error1qlin.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$error1qlin(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$error1qlin(RTObject$ SL$,int sp$n,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("error1qlin",271);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$error1qlin STM$() {
        TRACE_BEGIN_STM$("error1qlin",271);
        // JavaLine 44 ==> SourceLine 272
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$qlin(((ERRMSG)(CUR$.SL$)),p$q).RESULT$;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        TRACE_END_STM$("error1qlin",272);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error1qlin",1,271,44,272,50,274);
}
