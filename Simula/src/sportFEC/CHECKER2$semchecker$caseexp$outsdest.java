// JavaLine 1 ==> SourceLine 290
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:52:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$caseexp$outsdest extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=290, lastLine=294, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER2$semchecker$caseexp$outsdest setPar(Object param) {
        //Util.BREAK("CALL CHECKER2$semchecker$caseexp$outsdest.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER2$semchecker$caseexp$outsdest(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER2$semchecker$caseexp$outsdest(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outsdest",290);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$caseexp$outsdest STM$() {
        TRACE_BEGIN_STM$("outsdest",290);
        // JavaLine 41 ==> SourceLine 291
        ((CHECKER2$semchecker$caseexp)(CUR$.SL$)).seen.Elt[p$i-((CHECKER2$semchecker$caseexp)(CUR$.SL$)).seen.LB[0]]=true;
        // JavaLine 43 ==> SourceLine 292
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).opihi=char$((p$i/(256)));
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).opilo=char$(rem(p$i,256));
        // JavaLine 46 ==> SourceLine 293
        ((CHECKER2$semchecker)(CUR$.SL$.SL$)).opc=((CHECKER2)(CUR$.SL$.SL$.SL$)).IACTE;
        call(((CHECKER2)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("outsdest",293);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure outsdest",1,290,41,291,43,292,46,293,52,294);
}
