// JavaLine 1 ==> SourceLine 1321
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$identifier$identError extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1321, lastLine=1322, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$identifier$identError setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$identifier$identError.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER1$semchecker1$identifier$identError(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$identifier$identError(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("identError",1321);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$identifier$identError STM$() {
        TRACE_BEGIN_STM$("identError",1321);
        // JavaLine 41 ==> SourceLine 1322
        new ERRMSG$error1qlin(((CHECKER1)(CUR$.SL$.SL$.SL$)),p$n,((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning);
        ((CHECKER1$semchecker1$identifier)(CUR$.SL$)).kind=((CHECKER1)(CUR$.SL$.SL$.SL$)).K_error;
        ((CHECKER1$semchecker1$identifier)(CUR$.SL$)).type=((CHECKER1)(CUR$.SL$.SL$.SL$)).IELSE;
        TRACE_END_STM$("identError",1322);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure identError",1,1321,41,1322,48,1322);
}
