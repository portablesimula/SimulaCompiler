// JavaLine 1 <== SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 11:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample2$ExceptionHandler extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=10, lastLine=14, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$ErrorText;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public GotoSample2$ExceptionHandler setPar(Object param) {
        //Util.BREAK("CALL GotoSample2$ExceptionHandler.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ErrorText=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public GotoSample2$ExceptionHandler(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public GotoSample2$ExceptionHandler(RTObject$ SL$,TXT$ sp$ErrorText) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ErrorText = sp$ErrorText;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ExceptionHandler",10);
        STM$();
    }
    // Procedure Statements
    public GotoSample2$ExceptionHandler STM$() {
        TRACE_BEGIN_STM$("ExceptionHandler",10);
        // JavaLine 41 <== SourceLine 12
        sysout().outtext(CONC(new TXT$("ExceptionHandler got error: "),p$ErrorText));
        sysout().outimage();
        // JavaLine 44 <== SourceLine 13
        terminate_program();
        TRACE_END_STM$("ExceptionHandler",13);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample2.sim","Procedure ExceptionHandler",1,10,41,12,44,13,49,14);
} // End of Procedure
