// JavaLine 1 ==> SourceLine 17
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample2$prt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=17, lastLine=20, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public QPSample2$prt setPar(Object param) {
        //Util.BREAK("CALL QPSample2$prt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public QPSample2$prt(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public QPSample2$prt(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("prt",17);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public QPSample2$prt STM$() {
        TRACE_BEGIN_STM$("prt",17);
        // JavaLine 41 ==> SourceLine 18
        if(VALUE$(((QPSample2)(CUR$.SL$)).verbose)) {
            // JavaLine 43 ==> SourceLine 19
            {
                TRACE_BEGIN_STM$("CompoundStatement19",19);
                sysout().outtext(p$msg);
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement19",19);
            }
        }
        TRACE_END_STM$("prt",19);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Procedure prt",1,17,41,18,43,19,54,20);
}
