// JavaLine 1 ==> SourceLine 1825
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$casestat$L2output extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1825, lastLine=1826, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$code;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$casestat$L2output setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$casestat$L2output.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$code=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$casestat$L2output(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$casestat$L2output(RTObject$ SL$,char sp$code) {
        super(SL$);
        // Parameter assignment to locals
        this.p$code = sp$code;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("L2output",1825);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$casestat$L2output STM$() {
        TRACE_BEGIN_STM$("L2output",1825);
        // JavaLine 41 ==> SourceLine 1826
        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ICASE;
        ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=p$code;
        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("L2output",1826);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure L2output",1,1825,41,1826,48,1826);
}
