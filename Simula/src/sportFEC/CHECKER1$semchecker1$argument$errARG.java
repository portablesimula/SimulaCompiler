// JavaLine 1 ==> SourceLine 2125
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$argument$errARG extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2125, lastLine=2130, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$eax;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 2126
    TXT$ etxt1=null;
    TXT$ etxt2=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$argument$errARG setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$argument$errARG.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$eax=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$argument$errARG(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$argument$errARG(RTObject$ SL$,int sp$eax) {
        super(SL$);
        // Parameter assignment to locals
        this.p$eax = sp$eax;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("errARG",2126);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$argument$errARG STM$() {
        TRACE_BEGIN_STM$("errARG",2126);
        // JavaLine 44 ==> SourceLine 2127
        etxt1=CONC(CONC(new TXT$(" par#"),new COMMON$leftint(((CHECKER1)(CUR$.SL$.SL$.SL$)),((CHECKER1$semchecker1$argument)(CUR$.SL$)).p$argno).RESULT$),new TXT$(" "));
        // JavaLine 46 ==> SourceLine 2128
        etxt2=new ERRMSG$qlin(((CHECKER1)(CUR$.SL$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastnap.ident.meaning).RESULT$;
        // JavaLine 48 ==> SourceLine 2129
        new ERRMSG$error2(((CHECKER1)(CUR$.SL$.SL$.SL$)),p$eax,etxt1,etxt2);
        TRACE_END_STM$("errARG",2129);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure errARG",1,2125,12,2126,44,2127,46,2128,48,2129,53,2130);
}
