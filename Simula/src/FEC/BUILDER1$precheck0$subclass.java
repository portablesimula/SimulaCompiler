// JavaLine 1 ==> SourceLine 406
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$subclass extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=406, lastLine=415, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$quantity p$qx;
    public COMMON$quantity p$qy;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$subclass setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$subclass.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$qx=(COMMON$quantity)objectValue(param); break;
                case 1: p$qy=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$subclass(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$subclass(RTObject$ SL$,COMMON$quantity sp$qx,COMMON$quantity sp$qy) {
        super(SL$);
        // Parameter assignment to locals
        this.p$qx = sp$qx;
        this.p$qy = sp$qy;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("subclass",406);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$subclass STM$() {
        TRACE_BEGIN_STM$("subclass",406);
        // JavaLine 47 ==> SourceLine 411
        while((p$qx.plev>(p$qy.plev))) {
            p$qx=p$qx.prefqual;
        }
        // JavaLine 51 ==> SourceLine 412
        if((((p$qx==(p$qy))||((p$qx.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_error))))||((p$qy.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_error))))) {
            // JavaLine 53 ==> SourceLine 414
            RESULT$=true;
        } else
        RESULT$=false;
        TRACE_END_STM$("subclass",414);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure subclass",1,406,47,411,51,412,53,414,60,415);
}
