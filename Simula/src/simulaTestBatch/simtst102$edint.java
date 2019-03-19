// JavaLine 1 ==> SourceLine 16
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:20:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102$edint extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=16, lastLine=17, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 17
    TXT$ t=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst102$edint setPar(Object param) {
        //Util.BREAK("CALL simtst102$edint.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public simtst102$edint(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst102$edint(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("edint",17);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst102$edint STM$() {
        TRACE_BEGIN_STM$("edint",17);
        t=blanks(2);
        TXT$.putint(t,p$i);
        RESULT$=t;
        TRACE_END_STM$("edint",17);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Procedure edint",1,16,15,17,52,17);
}
