// JavaLine 1 ==> SourceLine 285
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$ParsWarn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=285, lastLine=288, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$ParsWarn setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$ParsWarn.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$ParsWarn(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$ParsWarn(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ParsWarn",285);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$ParsWarn STM$() {
        TRACE_BEGIN_STM$("ParsWarn",285);
        // JavaLine 41 ==> SourceLine 287
        new PARSER$grammer$setCurPos(((PARSER$grammer)(CUR$.SL$)));
        new ERRMSG$outP1message(((PARSER)(CUR$.SL$.SL$)),((PARSER$grammer)(CUR$.SL$)).currentPos,p$n,((char)1));
        TRACE_END_STM$("ParsWarn",287);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure ParsWarn",1,285,41,287,47,288);
}
