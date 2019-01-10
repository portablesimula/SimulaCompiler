// JavaLine 1 ==> SourceLine 304
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 12:01:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$caseexp$whenrange extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=304, lastLine=308, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$l;
    public int p$u;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER2$semchecker$caseexp$whenrange setPar(Object param) {
        //Util.BREAK("CALL CHECKER2$semchecker$caseexp$whenrange.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$l=intValue(param); break;
                case 1: p$u=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER2$semchecker$caseexp$whenrange(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER2$semchecker$caseexp$whenrange(RTObject$ SL$,int sp$l,int sp$u) {
        super(SL$);
        // Parameter assignment to locals
        this.p$l = sp$l;
        this.p$u = sp$u;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("whenrange",304);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$caseexp$whenrange STM$() {
        TRACE_BEGIN_STM$("whenrange",304);
        // JavaLine 44 ==> SourceLine 305
        if((((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$casetype!=(((CHECKER2)(CUR$.SL$.SL$.SL$)).IELSE))) {
            // JavaLine 46 ==> SourceLine 306
            {
                TRACE_BEGIN_STM$("CompoundStatement306",306);
                if((((p$u<(p$l))|((p$l<(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$lb))))|((((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$ub<(p$u))))) {
                    // JavaLine 50 ==> SourceLine 307
                    new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$.SL$)),439);
                } else
                while((p$l<=(p$u))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement307",307);
                        new CHECKER2$semchecker$caseexp$whenvalue(((CHECKER2$semchecker$caseexp)(CUR$.SL$)),p$l);
                        p$l=(p$l+(1));
                        TRACE_END_STM$("CompoundStatement307",307);
                    }
                }
                TRACE_END_STM$("CompoundStatement306",307);
            }
        }
        TRACE_END_STM$("whenrange",307);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure whenrange",1,304,44,305,46,306,50,307,67,308);
}
