// JavaLine 1 ==> SourceLine 488
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$putstring extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=488, lastLine=489, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$hi;
    public char p$lo;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$putstring setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$putstring.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$hi=(char)objectValue(param); break;
                case 1: p$lo=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$putstring(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$putstring(RTObject$ SL$,char sp$hi,char sp$lo) {
        super(SL$);
        // Parameter assignment to locals
        this.p$hi = sp$hi;
        this.p$lo = sp$lo;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("putstring",488);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$putstring STM$() {
        TRACE_BEGIN_STM$("putstring",488);
        // JavaLine 44 ==> SourceLine 489
        new BUILDER2$normalattrfile$puttext(((BUILDER2$normalattrfile)(CUR$.SL$)),new COMMON$nameof(((BUILDER2)(CUR$.SL$.SL$)),p$hi,p$lo).RESULT$);
        TRACE_END_STM$("putstring",489);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure putstring",1,488,44,489,49,489);
}
