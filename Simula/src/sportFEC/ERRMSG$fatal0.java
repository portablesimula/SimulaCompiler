// JavaLine 1 ==> SourceLine 319
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 19:59:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$fatal0 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=319, lastLine=319, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$fatal0 setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$fatal0.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public ERRMSG$fatal0(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$fatal0(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("fatal0",319);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$fatal0 STM$() {
        TRACE_BEGIN_STM$("fatal0",319);
        new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),((char)3),p$n);
        TRACE_END_STM$("fatal0",319);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure fatal0",1,319,45,319);
}
