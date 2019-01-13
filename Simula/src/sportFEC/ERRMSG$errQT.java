// JavaLine 1 ==> SourceLine 258
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$errQT extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=258, lastLine=262, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$errQT setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$errQT.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$errQT(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$errQT(RTObject$ SL$,COMMON$quantity sp$q,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("errQT",258);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$errQT STM$() {
        TRACE_BEGIN_STM$("errQT",258);
        // JavaLine 44 ==> SourceLine 259
        if((p$q!=(null))) {
            // JavaLine 46 ==> SourceLine 260
            {
                TRACE_BEGIN_STM$("CompoundStatement260",260);
                ((ERRMSG)(CUR$.SL$)).messageLinenr=p$q.line;
                new ERRMSG$error1id(((ERRMSG)(CUR$.SL$)),p$n,p$q.symb);
                TRACE_END_STM$("CompoundStatement260",260);
            }
        }
        TRACE_END_STM$("errQT",260);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure errQT",1,258,44,259,46,260,57,262);
}
