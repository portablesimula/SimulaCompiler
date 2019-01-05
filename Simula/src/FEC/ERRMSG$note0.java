// JavaLine 1 ==> SourceLine 310
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$note0 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=310, lastLine=310, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$note0 setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$note0.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public ERRMSG$note0(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$note0(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("note0",310);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$note0 STM$() {
        TRACE_BEGIN_STM$("note0",310);
        new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),((ERRMSG)(CUR$.SL$)).NUL,p$n);
        TRACE_END_STM$("note0",310);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure note0",1,310,45,310);
}
