// JavaLine 1 ==> SourceLine 218
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$M_leng extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=218, lastLine=223, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$Mx;
    public int p$Yx;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$M_leng setPar(Object param) {
        //Util.BREAK("CALL Dates$M_leng.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Mx=intValue(param); break;
                case 1: p$Yx=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Dates$M_leng(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$M_leng(RTObject$ SL$,int sp$Mx,int sp$Yx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Mx = sp$Mx;
        this.p$Yx = sp$Yx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("M_leng",218);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$M_leng STM$() {
        TRACE_BEGIN_STM$("M_leng",218);
        // JavaLine 47 ==> SourceLine 221
        if(VALUE$((p$Mx==(2)))) {
            RESULT$=((new Dates$L_year(((Dates)(CUR$.SL$)),p$Yx).RESULT$)?(29):(28));
        } else
        // JavaLine 51 ==> SourceLine 222
        RESULT$=((Dates)(CUR$.SL$)).M_tab.Elt[p$Mx-((Dates)(CUR$.SL$)).M_tab.LB[0]];
        TRACE_END_STM$("M_leng",222);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure M_leng",1,218,47,221,51,222,56,223);
}
