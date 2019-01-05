// JavaLine 1 ==> SourceLine 364
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:43:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$note1id extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=364, lastLine=365, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    public COMMON$symbolbox p$symb;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$note1id setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$note1id.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$symb=(COMMON$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$note1id(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$note1id(RTObject$ SL$,int sp$n,COMMON$symbolbox sp$symb) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$symb = sp$symb;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("note1id",364);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$note1id STM$() {
        TRACE_BEGIN_STM$("note1id",364);
        // JavaLine 44 ==> SourceLine 365
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$symb.symbol;
        new ERRMSG$note0(((ERRMSG)(CUR$.SL$)),p$n);
        TRACE_END_STM$("note1id",365);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure note1id",1,364,44,365,50,365);
}
