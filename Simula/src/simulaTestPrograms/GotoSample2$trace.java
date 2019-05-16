package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 11:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class GotoSample2$trace extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=6, lastLine=8, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public GotoSample2$trace setPar(Object param) {
        //Util.BREAK("CALL GotoSample2$trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public GotoSample2$trace(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public GotoSample2$trace(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trace",6);
        STM$();
    }
    // Procedure Statements
    public GotoSample2$trace STM$() {
        TRACE_BEGIN_STM$("trace",6);
        // JavaLine 40 <== SourceLine 7
        sysout().outtext(p$t);
        sysout().outimage();
        TRACE_END_STM$("trace",7);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample2.sim","Procedure trace",40,7,46,8);
} // End of Procedure
