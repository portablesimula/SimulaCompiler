package simulaTestPrograms;
// Simula-1.0 Compiled at Sat May 25 13:14:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$$test extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=3, lastLine=7, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    public TXT$ p$result;
    public TXT$ p$expected;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public adHoc01$$test setPar(Object param) {
        //Util.BREAK("CALL adHoc01$$test.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                case 1: p$result=(TXT$)objectValue(param); break;
                case 2: p$expected=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc01$$test(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public adHoc01$$test(RTObject$ SL$,TXT$ sp$msg,TXT$ sp$result,TXT$ sp$expected) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        this.p$result = sp$result;
        this.p$expected = sp$expected;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("test",3);
        STM$();
    }
    // Procedure Statements
    public adHoc01$$test STM$() {
        TRACE_BEGIN_STM$("test",3);
        // JavaLine 46 <== SourceLine 5
        sysout().outtext(p$msg);
        sysout().outtext(p$result);
        // JavaLine 49 <== SourceLine 6
        sysout().outimage();
        TRACE_END_STM$("test",6);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure test",46,5,49,6,54,7);
} // End of Procedure
