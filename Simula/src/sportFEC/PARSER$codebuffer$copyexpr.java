// JavaLine 1 ==> SourceLine 71
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$codebuffer$copyexpr extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=71, lastLine=74, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public PARSER$codebuffer$elt p$oldelt;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$codebuffer$copyexpr setPar(Object param) {
        //Util.BREAK("CALL PARSER$codebuffer$copyexpr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$oldelt=(PARSER$codebuffer$elt)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$codebuffer$copyexpr(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$codebuffer$copyexpr(RTObject$ SL$,PARSER$codebuffer$elt sp$oldelt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$oldelt = sp$oldelt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("copyexpr",71);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$codebuffer$copyexpr STM$() {
        TRACE_BEGIN_STM$("copyexpr",71);
        // JavaLine 41 ==> SourceLine 72
        while((p$oldelt!=(null))) {
            // JavaLine 43 ==> SourceLine 73
            {
                TRACE_BEGIN_STM$("CompoundStatement73",73);
                new PARSER$codebuffer$elt$emit(p$oldelt);
                p$oldelt=p$oldelt.next;
                TRACE_END_STM$("CompoundStatement73",73);
            }
        }
        TRACE_END_STM$("copyexpr",73);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure copyexpr",1,71,41,72,43,73,54,74);
}
