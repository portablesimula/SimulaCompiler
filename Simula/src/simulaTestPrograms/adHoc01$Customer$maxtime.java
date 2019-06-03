// JavaLine 1 <== SourceLine 15
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:07:07 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$Customer$maxtime extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=15, lastLine=18, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public float p$T;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public adHoc01$Customer$maxtime setPar(Object param) {
        //Util.BREAK("CALL adHoc01$Customer$maxtime.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$T=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc01$Customer$maxtime(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public adHoc01$Customer$maxtime(RTObject$ SL$,float sp$T) {
        super(SL$);
        // Parameter assignment to locals
        this.p$T = sp$T;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("maxtime",15);
        STM$();
    }
    // Procedure Statements
    public adHoc01$Customer$maxtime STM$() {
        TRACE_BEGIN_STM$("maxtime",15);
        // JavaLine 41 <== SourceLine 16
        ((adHoc01)(CUR$.SL$.SL$)).ActivateAt(true,((adHoc01)(CUR$.SL$.SL$)).current(),p$T,false);
        // JavaLine 43 <== SourceLine 17
        if(VALUE$((!(((adHoc01$Customer)(CUR$.SL$)).idle())))) {
            ((adHoc01$Customer)(CUR$.SL$)).out();
        }
        TRACE_END_STM$("maxtime",17);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure maxtime",1,15,41,16,43,17,50,18);
} // End of Procedure
