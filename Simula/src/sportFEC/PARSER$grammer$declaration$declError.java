// JavaLine 1 ==> SourceLine 787
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$declaration$declError extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=787, lastLine=788, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$declaration$declError setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$declaration$declError.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$declaration$declError(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$declaration$declError(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("declError",787);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$declaration$declError STM$() {
        TRACE_BEGIN_STM$("declError",787);
        // JavaLine 41 ==> SourceLine 788
        ((PARSER$grammer$declaration)(CUR$.SL$)).errorno=1;
        new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$.SL$)),p$i);
        GOTO$(((PARSER$grammer$declaration)(CUR$.SL$)).PARSE); // GOTO EVALUATED LABEL
        TRACE_END_STM$("declError",788);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure declError",1,787,41,788,48,788);
}
