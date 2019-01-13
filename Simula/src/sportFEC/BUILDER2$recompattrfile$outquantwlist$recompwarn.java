// JavaLine 1 ==> SourceLine 802
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$recompattrfile$outquantwlist$recompwarn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=802, lastLine=803, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$recompattrfile$outquantwlist$recompwarn setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$recompattrfile$outquantwlist$recompwarn.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER2$recompattrfile$outquantwlist$recompwarn(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$recompattrfile$outquantwlist$recompwarn(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recompwarn",802);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$recompattrfile$outquantwlist$recompwarn STM$() {
        TRACE_BEGIN_STM$("recompwarn",802);
        // JavaLine 41 ==> SourceLine 803
        new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),((BUILDER2$recompattrfile$outquantwlist)(CUR$.SL$)).p$q,(-(p$n)));
        TRACE_END_STM$("recompwarn",803);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure recompwarn",1,802,41,803,46,803);
}
