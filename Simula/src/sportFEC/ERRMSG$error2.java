// JavaLine 1 ==> SourceLine 398
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:59:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error2 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=398, lastLine=399, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    public TXT$ p$t1;
    public TXT$ p$t2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error2 setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$error2.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$t1=(TXT$)objectValue(param); break;
                case 2: p$t2=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$error2(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$error2(RTObject$ SL$,int sp$n,TXT$ sp$t1,TXT$ sp$t2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("error2",398);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$error2 STM$() {
        TRACE_BEGIN_STM$("error2",398);
        // JavaLine 47 ==> SourceLine 399
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t1;
        ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t2;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        TRACE_END_STM$("error2",399);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error2",1,398,47,399,54,399);
}
