// JavaLine 1 ==> SourceLine 89
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$newTags extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=89, lastLine=90, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$incr;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$newTags setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$newTags.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$incr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$newTags(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$newTags(RTObject$ SL$,int sp$incr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$incr = sp$incr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("newTags",89);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$newTags STM$() {
        TRACE_BEGIN_STM$("newTags",89);
        // JavaLine 41 ==> SourceLine 90
        ((BUILDER1)(CUR$.SL$)).lastusedtag=(((BUILDER1)(CUR$.SL$)).lastusedtag+(p$incr));
        TRACE_END_STM$("newTags",90);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure newTags",1,89,41,90,46,90);
}
