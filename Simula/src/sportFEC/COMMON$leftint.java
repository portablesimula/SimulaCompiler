// JavaLine 1 ==> SourceLine 814
package sportFEC;
// Simula-Beta-0.3 Compiled at Wed Feb 06 13:19:01 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$leftint extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=814, lastLine=818, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$leftint setPar(Object param) {
        //Util.BREAK("CALL COMMON$leftint.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public COMMON$leftint(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public COMMON$leftint(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("leftint",814);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$leftint STM$() {
        TRACE_BEGIN_STM$("leftint",814);
        // JavaLine 44 ==> SourceLine 815
        TXT$.putint(((COMMON)(CUR$.SL$)).leftintbuf,p$i);
        p$i=11;
        // JavaLine 47 ==> SourceLine 816
        while((loadChar(((COMMON)(CUR$.SL$)).leftintbuf,p$i)!=(((char)32)))) {
            p$i=(p$i-(1));
        }
        // JavaLine 51 ==> SourceLine 817
        RESULT$=copy(copy(TXT$.sub(((COMMON)(CUR$.SL$)).leftintbuf,(p$i+(2)),(11-(p$i)))));
        TRACE_END_STM$("leftint",817);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure leftint",1,814,44,815,47,816,51,817,56,818);
}
