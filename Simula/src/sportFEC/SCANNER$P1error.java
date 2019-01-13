// JavaLine 1 ==> SourceLine 84
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$P1error extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=84, lastLine=86, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$P1error setPar(Object param) {
        //Util.BREAK("CALL SCANNER$P1error.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public SCANNER$P1error(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$P1error(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P1error",84);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$P1error STM$() {
        TRACE_BEGIN_STM$("P1error",84);
        // JavaLine 41 ==> SourceLine 85
        new SCANNER$setP1line(((SCANNER)(CUR$.SL$)));
        new ERRMSG$outP1message(((SCANNER)(CUR$.SL$)),(((SCANNER)(CUR$.SL$)).lexScanner.linepos+(1)),p$n,((char)2));
        TRACE_END_STM$("P1error",85);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure P1error",1,84,41,85,47,86);
}
