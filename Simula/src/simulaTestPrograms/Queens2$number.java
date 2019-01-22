// JavaLine 1 ==> SourceLine 49
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 17:05:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$number extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=49, lastLine=50, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    public int p$j;
    public int p$k;
    public int p$l;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$number setPar(Object param) {
        //Util.BREAK("CALL Queens2$number.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$j=intValue(param); break;
                case 2: p$k=intValue(param); break;
                case 3: p$l=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Queens2$number(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Queens2$number(RTObject$ SL$,int sp$i,int sp$j,int sp$k,int sp$l) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        this.p$j = sp$j;
        this.p$k = sp$k;
        this.p$l = sp$l;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("number",49);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$number STM$() {
        TRACE_BEGIN_STM$("number",49);
        // JavaLine 53 ==> SourceLine 50
        RESULT$=((((((p$i*(8))+(p$j))*(8))+(p$k))*(8))+(p$l));
        TRACE_END_STM$("number",50);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure number",1,49,53,50,58,50);
}
