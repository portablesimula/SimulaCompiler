// JavaLine 1 ==> SourceLine 383
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:43:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=383, lastLine=384, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error1 setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$error1.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$error1(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$error1(RTObject$ SL$,int sp$n,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("error1",383);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$error1 STM$() {
        TRACE_BEGIN_STM$("error1",383);
        // JavaLine 44 ==> SourceLine 384
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        TRACE_END_STM$("error1",384);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error1",1,383,44,384,50,384);
}
