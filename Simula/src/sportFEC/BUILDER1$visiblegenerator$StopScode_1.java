package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$visiblegenerator$StopScode_1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=120, lastLine=123, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$m;
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$visiblegenerator$StopScode_1 setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$visiblegenerator$StopScode_1.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$m=(char)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$visiblegenerator$StopScode_1(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$visiblegenerator$StopScode_1(RTObject$ SL$,char sp$m,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$m = sp$m;
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("StopScode_1",120);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$visiblegenerator$StopScode_1 STM$() {
        TRACE_BEGIN_STM$("StopScode_1",120);
        // JavaLine 43 ==> SourceLine 121
        if((((BUILDER1)(CUR$.SL$.SL$)).numerrfound==(0))) {
            new ERRMSG$internerr(((BUILDER1)(CUR$.SL$.SL$)),p$m,p$n);
        }
        // JavaLine 47 ==> SourceLine 122
        new BUILDER1$StopScode(((BUILDER1)(CUR$.SL$.SL$)));
        TRACE_END_STM$("StopScode_1",122);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure StopScode_1",43,121,47,122,52,123);
}
