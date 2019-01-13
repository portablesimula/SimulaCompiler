// JavaLine 1 ==> SourceLine 282
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$notimp extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=282, lastLine=283, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$notimp setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$notimp.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$notimp(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$notimp(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("notimp",282);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$notimp STM$() {
        TRACE_BEGIN_STM$("notimp",282);
        // JavaLine 41 ==> SourceLine 283
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t;
        new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),309);
        TRACE_END_STM$("notimp",283);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure notimp",1,282,41,283,47,283);
}
