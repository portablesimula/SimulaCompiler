// JavaLine 1 ==> SourceLine 296
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:52:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$caseexp$whenvalue extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=296, lastLine=302, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER2$semchecker$caseexp$whenvalue setPar(Object param) {
        //Util.BREAK("CALL CHECKER2$semchecker$caseexp$whenvalue.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER2$semchecker$caseexp$whenvalue(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER2$semchecker$caseexp$whenvalue(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("whenvalue",296);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$caseexp$whenvalue STM$() {
        TRACE_BEGIN_STM$("whenvalue",296);
        // JavaLine 41 ==> SourceLine 297
        if(VALUE$((((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$casetype!=(((CHECKER2)(CUR$.SL$.SL$.SL$)).IELSE)))) {
            // JavaLine 43 ==> SourceLine 298
            {
                TRACE_BEGIN_STM$("CompoundStatement298",298);
                if(VALUE$(((p$i<(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$lb))|((((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$ub<(p$i)))))) {
                    // JavaLine 47 ==> SourceLine 299
                    new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$.SL$)),437);
                } else
                {
                    TRACE_BEGIN_STM$("CompoundStatement299",299);
                    p$i=(p$i-(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$lb));
                    // JavaLine 53 ==> SourceLine 300
                    if(VALUE$(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).seen.Elt[p$i-((CHECKER2$semchecker$caseexp)(CUR$.SL$)).seen.LB[0]])) {
                        new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$.SL$)),438);
                    } else
                    new CHECKER2$semchecker$caseexp$outsdest(((CHECKER2$semchecker$caseexp)(CUR$.SL$)),p$i);
                    TRACE_END_STM$("CompoundStatement299",300);
                }
                TRACE_END_STM$("CompoundStatement298",300);
            }
        }
        TRACE_END_STM$("whenvalue",300);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure whenvalue",1,296,41,297,43,298,47,299,53,300,66,302);
}
