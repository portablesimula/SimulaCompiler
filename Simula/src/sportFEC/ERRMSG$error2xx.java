// JavaLine 1 ==> SourceLine 403
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:59:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error2xx extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=403, lastLine=406, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n1;
    public char p$n2;
    public char p$n3;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error2xx setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$error2xx.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n1=intValue(param); break;
                case 1: p$n2=(char)objectValue(param); break;
                case 2: p$n3=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$error2xx(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$error2xx(RTObject$ SL$,int sp$n1,char sp$n2,char sp$n3) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n1 = sp$n1;
        this.p$n2 = sp$n2;
        this.p$n3 = sp$n3;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("error2xx",403);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$error2xx STM$() {
        TRACE_BEGIN_STM$("error2xx",403);
        // JavaLine 47 ==> SourceLine 404
        if(VALUE$((p$n2!=(((ERRMSG)(CUR$.SL$)).IELSE)))) {
            // JavaLine 49 ==> SourceLine 405
            {
                TRACE_BEGIN_STM$("CompoundStatement405",405);
                ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),rank(p$n2)).RESULT$;
                ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),rank(p$n3)).RESULT$;
                // JavaLine 54 ==> SourceLine 406
                new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n1);
                TRACE_END_STM$("CompoundStatement405",406);
            }
        }
        TRACE_END_STM$("error2xx",406);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error2xx",1,403,47,404,49,405,54,406,62,406);
}
