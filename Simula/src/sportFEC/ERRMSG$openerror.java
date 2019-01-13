// JavaLine 1 ==> SourceLine 393
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$openerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=393, lastLine=394, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$fname;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$openerror setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$openerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$fname=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$openerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$openerror(RTObject$ SL$,TXT$ sp$fname) {
        super(SL$);
        // Parameter assignment to locals
        this.p$fname = sp$fname;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("openerror",393);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$openerror STM$() {
        TRACE_BEGIN_STM$("openerror",393);
        // JavaLine 41 ==> SourceLine 394
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$fname;
        new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),336);
        TRACE_END_STM$("openerror",394);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure openerror",1,393,41,394,47,394);
}
