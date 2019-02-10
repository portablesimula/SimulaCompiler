// JavaLine 1 ==> SourceLine 2122
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$argument$sameAs extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2122, lastLine=2125, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$e;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$argument$sameAs setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$argument$sameAs.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$e=(CHECKER1$semchecker1$exp)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$argument$sameAs(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$argument$sameAs(RTObject$ SL$,CHECKER1$semchecker1$exp sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sameAs",2122);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$argument$sameAs STM$() {
        TRACE_BEGIN_STM$("sameAs",2122);
        TRACE_END_STM$("sameAs",2122);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure sameAs",1,2122,47,2125);
}
