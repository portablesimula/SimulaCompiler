// JavaLine 1 ==> SourceLine 131
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$nameof extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=131, lastLine=132, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$hi;
    public char p$lo;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$nameof setPar(Object param) {
        //Util.BREAK("CALL COMMON$nameof.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$hi=(char)objectValue(param); break;
                case 1: p$lo=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public COMMON$nameof(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public COMMON$nameof(RTObject$ SL$,char sp$hi,char sp$lo) {
        super(SL$);
        // Parameter assignment to locals
        this.p$hi = sp$hi;
        this.p$lo = sp$lo;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("nameof",131);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$nameof STM$() {
        TRACE_BEGIN_STM$("nameof",131);
        // JavaLine 47 ==> SourceLine 132
        RESULT$=((ARRAY$<COMMON$symbolbox[]>)((COMMON)(CUR$.SL$)).symtab.Elt[rank(p$hi)-((COMMON)(CUR$.SL$)).symtab.LB[0]].val).Elt[rank(p$lo)-((COMMON)(CUR$.SL$)).symtab.Elt[rank(p$hi)-((COMMON)(CUR$.SL$)).symtab.LB[0]].val.LB[0]].symbol;
        TRACE_END_STM$("nameof",132);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nameof",1,131,47,132,52,132);
}
