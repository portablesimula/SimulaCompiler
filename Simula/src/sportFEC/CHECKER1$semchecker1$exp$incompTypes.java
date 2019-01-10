// JavaLine 1 ==> SourceLine 153
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$exp$incompTypes extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=153, lastLine=164, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ltype;
    public char p$rtype;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$exp$incompTypes setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$exp$incompTypes.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ltype=(char)objectValue(param); break;
                case 1: p$rtype=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$exp$incompTypes(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$exp$incompTypes(RTObject$ SL$,char sp$ltype,char sp$rtype) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ltype = sp$ltype;
        this.p$rtype = sp$rtype;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("incompTypes",153);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$exp$incompTypes STM$() {
        TRACE_BEGIN_STM$("incompTypes",153);
        // JavaLine 44 ==> SourceLine 160
        if((p$rtype!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IELSE))) {
            // JavaLine 46 ==> SourceLine 161
            {
                TRACE_BEGIN_STM$("CompoundStatement161",161);
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).diag.Elt[2-((CHECKER1)(CUR$.SL$.SL$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((CHECKER1)(CUR$.SL$.SL$.SL$)),rank(((CHECKER1$semchecker1$exp)(CUR$.SL$)).p$ch)).RESULT$;
                // JavaLine 50 ==> SourceLine 162
                new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$.SL$)),400,p$ltype,p$rtype);
                TRACE_END_STM$("CompoundStatement161",162);
            }
        }
        // JavaLine 55 ==> SourceLine 163
        new BUILDER1$StopScode(((CHECKER1)(CUR$.SL$.SL$.SL$)));
        ((CHECKER1$semchecker1$exp)(CUR$.SL$)).type=((CHECKER1)(CUR$.SL$.SL$.SL$)).IELSE;
        TRACE_END_STM$("incompTypes",163);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure incompTypes",1,153,44,160,46,161,50,162,55,163,61,164);
}
