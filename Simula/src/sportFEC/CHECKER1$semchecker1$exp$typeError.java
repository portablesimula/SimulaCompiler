// JavaLine 1 ==> SourceLine 166
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$exp$typeError extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=166, lastLine=170, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$exp$typeError setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$exp$typeError.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER1$semchecker1$exp$typeError(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$exp$typeError(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("typeError",166);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$exp$typeError STM$() {
        TRACE_BEGIN_STM$("typeError",166);
        // JavaLine 41 ==> SourceLine 167
        if((((CHECKER1$semchecker1$exp)(CUR$.SL$)).type!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IELSE))) {
            // JavaLine 43 ==> SourceLine 168
            {
                TRACE_BEGIN_STM$("CompoundStatement168",168);
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).diag.Elt[0-((CHECKER1)(CUR$.SL$.SL$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((CHECKER1)(CUR$.SL$.SL$.SL$)),rank(((CHECKER1$semchecker1$exp)(CUR$.SL$)).type)).RESULT$;
                new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$.SL$)),p$n);
                // JavaLine 48 ==> SourceLine 169
                new BUILDER1$StopScode(((CHECKER1)(CUR$.SL$.SL$.SL$)));
                ((CHECKER1$semchecker1$exp)(CUR$.SL$)).type=((CHECKER1)(CUR$.SL$.SL$.SL$)).IELSE;
                TRACE_END_STM$("CompoundStatement168",169);
            }
        }
        TRACE_END_STM$("typeError",169);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure typeError",1,166,41,167,43,168,48,169,57,170);
}
