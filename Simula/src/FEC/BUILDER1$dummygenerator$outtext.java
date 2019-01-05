// JavaLine 1 ==> SourceLine 172
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$dummygenerator$outtext extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=172, lastLine=173, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$dummygenerator$outtext setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$dummygenerator$outtext.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$dummygenerator$outtext(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$dummygenerator$outtext(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outtext",172);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$dummygenerator$outtext STM$() {
        TRACE_BEGIN_STM$("outtext",172);
        TRACE_END_STM$("outtext",172);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure outtext",1,172,44,173);
}
