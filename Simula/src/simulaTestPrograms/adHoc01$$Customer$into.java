// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue May 28 14:01:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$$Customer$into extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=6, lastLine=10, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$location;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public adHoc01$$Customer$into setPar(Object param) {
        //Util.BREAK("CALL adHoc01$$Customer$into.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$location=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc01$$Customer$into(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public adHoc01$$Customer$into(RTObject$ SL$,int sp$location) {
        super(SL$);
        // Parameter assignment to locals
        this.p$location = sp$location;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("into",6);
        STM$();
    }
    // Procedure Statements
    public adHoc01$$Customer$into STM$() {
        TRACE_BEGIN_STM$("into",6);
        // JavaLine 41 <== SourceLine 8
        if(VALUE$((p$location==(8)))) {
            new adHoc01$$Customer$into(((adHoc01$$Customer)(CUR$.SL$)),16);
        }
        TRACE_END_STM$("into",8);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure into",1,6,41,8,48,10);
} // End of Procedure
