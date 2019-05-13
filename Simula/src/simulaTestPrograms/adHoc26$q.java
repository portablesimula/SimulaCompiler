// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 12 10:13:44 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc26$q extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=6, lastLine=0, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public LABQNT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$$SW;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public adHoc26$q setPar(Object param) {
        //Util.BREAK("CALL adHoc26$q.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$$SW=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc26$q(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public adHoc26$q(RTObject$ SL$,int sp$$SW) {
        super(SL$);
        // Parameter assignment to locals
        this.p$$SW = sp$$SW;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("q",6);
        STM$();
    }
    // Switch Body
    public adHoc26$q STM$() {
        switch(p$$SW-1) {
            case 0: RESULT$=((((adHoc26)(CUR$.SL$)).b)?(((adHoc26)(CUR$.SL$)).L3):(((adHoc26)(CUR$.SL$)).L2)); break;
            case 1: RESULT$=((adHoc26)(CUR$.SL$)).T1; break;
            default: throw new RuntimeException("Illegal switch index: "+p$$SW);
        }
        EBLK();
        return(this);
    } // End of Switch BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc26.sim","Procedure q",1,6,50,0);
} // End of Procedure
