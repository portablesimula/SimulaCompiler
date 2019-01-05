// JavaLine 1 ==> SourceLine 1638
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$specErr extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1638, lastLine=1639, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$L2Coder$specErr setPar(Object param) {
        //Util.BREAK("CALL SCANNER$L2Coder$specErr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public SCANNER$L2Coder$specErr(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$L2Coder$specErr(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("specErr",1638);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$specErr STM$() {
        TRACE_BEGIN_STM$("specErr",1638);
        // JavaLine 41 ==> SourceLine 1639
        ((SCANNER)(CUR$.SL$.SL$)).diag.Elt[0-((SCANNER)(CUR$.SL$.SL$)).diag.LB[0]]=new COMMON$nameof(((SCANNER)(CUR$.SL$.SL$)),((SCANNER)(CUR$.SL$.SL$)).opdhi,((SCANNER)(CUR$.SL$.SL$)).opdlo).RESULT$;
        new SCANNER$P1error(((SCANNER)(CUR$.SL$.SL$)),p$n);
        TRACE_END_STM$("specErr",1639);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure specErr",1,1638,41,1639,47,1639);
}
