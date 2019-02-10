// JavaLine 1 ==> SourceLine 314
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:59:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error0 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=314, lastLine=315, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error0 setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$error0.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$error0(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$error0(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("error0",314);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$error0 STM$() {
        TRACE_BEGIN_STM$("error0",314);
        // JavaLine 41 ==> SourceLine 315
        if(VALUE$((p$n<(0)))) {
            new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),((char)1),(-(p$n)));
        } else
        new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),((char)2),p$n);
        TRACE_END_STM$("error0",315);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error0",1,314,41,315,49,315);
}
