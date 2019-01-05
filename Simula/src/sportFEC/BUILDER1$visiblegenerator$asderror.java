// JavaLine 1 ==> SourceLine 126
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$visiblegenerator$asderror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=126, lastLine=127, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$visiblegenerator$asderror setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$visiblegenerator$asderror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$visiblegenerator$asderror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$visiblegenerator$asderror(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("asderror",126);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$visiblegenerator$asderror STM$() {
        TRACE_BEGIN_STM$("asderror",126);
        // JavaLine 41 ==> SourceLine 127
        if((((BUILDER1)(CUR$.SL$.SL$)).numerrfound==(0))) {
            new ERRMSG$error0(((BUILDER1)(CUR$.SL$.SL$)),p$n);
        }
        new BUILDER1$StopScode(((BUILDER1)(CUR$.SL$.SL$)));
        TRACE_END_STM$("asderror",127);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure asderror",1,126,41,127,49,127);
}
