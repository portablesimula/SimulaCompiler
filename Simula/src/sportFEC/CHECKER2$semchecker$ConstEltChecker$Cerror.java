// JavaLine 1 ==> SourceLine 339
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:52:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$ConstEltChecker$Cerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=339, lastLine=340, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER2$semchecker$ConstEltChecker$Cerror setPar(Object param) {
        //Util.BREAK("CALL CHECKER2$semchecker$ConstEltChecker$Cerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER2$semchecker$ConstEltChecker$Cerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER2$semchecker$ConstEltChecker$Cerror(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Cerror",339);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$ConstEltChecker$Cerror STM$() {
        TRACE_BEGIN_STM$("Cerror",339);
        // JavaLine 41 ==> SourceLine 340
        new ERRMSG$errQT(((CHECKER2)(CUR$.SL$.SL$.SL$)),((CHECKER2$semchecker$ConstEltChecker)(CUR$.SL$)).meaning,p$n);
        ((CHECKER2$semchecker$ConstEltChecker)(CUR$.SL$)).meaning.special=((CHECKER2)(CUR$.SL$.SL$.SL$)).NUL;
        TRACE_END_STM$("Cerror",340);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure Cerror",1,339,41,340,47,340);
}
