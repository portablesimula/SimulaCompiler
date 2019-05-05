// JavaLine 1 <== SourceLine 39
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:22:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$PrtChar extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=39, lastLine=40, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HexDump$PrtChar setPar(Object param) {
        //Util.BREAK("CALL HexDump$PrtChar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HexDump$PrtChar(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HexDump$PrtChar(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("PrtChar",39);
        STM$();
    }
    // Procedure Statements
    public HexDump$PrtChar STM$() {
        TRACE_BEGIN_STM$("PrtChar",39);
        // JavaLine 44 <== SourceLine 40
        RESULT$=((((p$n>(31))&((p$n<(128)))))?(char$(p$n)):('.'));
        TRACE_END_STM$("PrtChar",40);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure PrtChar",1,39,44,40,49,40);
} // End of Procedure
