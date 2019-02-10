// JavaLine 1 ==> SourceLine 151
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:07 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$expxerr extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=151, lastLine=154, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ch;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$expxerr setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$expxerr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ch=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$expxerr(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$expxerr(RTObject$ SL$,char sp$ch) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ch = sp$ch;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("expxerr",151);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$expxerr STM$() {
        TRACE_BEGIN_STM$("expxerr",151);
        // JavaLine 41 ==> SourceLine 152
        ((BUILDER2)(CUR$.SL$.SL$)).diag.Elt[0-((BUILDER2)(CUR$.SL$.SL$)).diag.LB[0]]=blanks(1);
        TXT$.putchar(((BUILDER2)(CUR$.SL$.SL$)).diag.Elt[0-((BUILDER2)(CUR$.SL$.SL$)).diag.LB[0]],p$ch);
        // JavaLine 44 ==> SourceLine 153
        ((BUILDER2)(CUR$.SL$.SL$)).diag.Elt[1-((BUILDER2)(CUR$.SL$.SL$)).diag.LB[0]]=((BUILDER2$normalattrfile)(CUR$.SL$)).CURF.filename();
        new ERRMSG$fatal0(((BUILDER2)(CUR$.SL$.SL$)),428);
        TRACE_END_STM$("expxerr",153);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure expxerr",1,151,41,152,44,153,50,154);
}
