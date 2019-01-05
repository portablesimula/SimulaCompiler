// JavaLine 1 ==> SourceLine 269
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$ParsErr extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=269, lastLine=273, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$n;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$ParsErr setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$ParsErr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$ParsErr(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$ParsErr(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ParsErr",269);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$ParsErr STM$() {
        TRACE_BEGIN_STM$("ParsErr",269);
        // JavaLine 41 ==> SourceLine 270
        if(((p$n!=(212))||((((PARSER)(CUR$.SL$.SL$)).numerrfound==(0))))) {
            // JavaLine 43 ==> SourceLine 272
            {
                TRACE_BEGIN_STM$("CompoundStatement272",272);
                new PARSER$grammer$setCurPos(((PARSER$grammer)(CUR$.SL$)));
                new ERRMSG$outP1message(((PARSER)(CUR$.SL$.SL$)),((PARSER$grammer)(CUR$.SL$)).currentPos,p$n,((char)2));
                TRACE_END_STM$("CompoundStatement272",272);
            }
        }
        TRACE_END_STM$("ParsErr",272);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure ParsErr",1,269,41,270,43,272,54,273);
}
