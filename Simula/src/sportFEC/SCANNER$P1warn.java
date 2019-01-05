// JavaLine 1 ==> SourceLine 88
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$P1warn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=88, lastLine=90, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$P1warn setPar(Object param) {
        //Util.BREAK("CALL SCANNER$P1warn.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public SCANNER$P1warn(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$P1warn(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P1warn",88);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$P1warn STM$() {
        TRACE_BEGIN_STM$("P1warn",88);
        // JavaLine 41 ==> SourceLine 89
        new SCANNER$setP1line(((SCANNER)(CUR$.SL$)));
        new ERRMSG$outP1message(((SCANNER)(CUR$.SL$)),(((SCANNER)(CUR$.SL$)).lexScanner.linepos+(1)),p$n,((char)1));
        TRACE_END_STM$("P1warn",89);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure P1warn",1,88,41,89,47,90);
}
