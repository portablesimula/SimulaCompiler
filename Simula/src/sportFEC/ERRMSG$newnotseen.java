// JavaLine 1 ==> SourceLine 286
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:43:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$newnotseen extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=286, lastLine=305, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$quantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$symbolbox p$symx;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 287
    COMMON$quantity q=null;
    // JavaLine 17 ==> SourceLine 288
    COMMON$quantity inspect$288$1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$newnotseen setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$newnotseen.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$symx=(COMMON$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$newnotseen(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$newnotseen(RTObject$ SL$,COMMON$symbolbox sp$symx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$symx = sp$symx;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("newnotseen",288);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$newnotseen STM$() {
        TRACE_BEGIN_STM$("newnotseen",288);
        {
            // BEGIN INSPECTION 
            inspect$288$1=new COMMON$quantity(((ERRMSG)(CUR$.SL$))).STM$();
            if(inspect$288$1!=null) //INSPECT inspect$288$1
            // JavaLine 52 ==> SourceLine 289
            {
                TRACE_BEGIN_STM$("CompoundStatement289",289);
                q=((ERRMSG)(CUR$.SL$)).unknowns.fpar;
                // JavaLine 56 ==> SourceLine 290
                if((q==(null))) {
                    // JavaLine 58 ==> SourceLine 291
                    {
                        TRACE_BEGIN_STM$("CompoundStatement291",291);
                        ((ERRMSG)(CUR$.SL$)).unknowns.fpar=((COMMON$quantity)inspect$288$1);
                        inspect$288$1.virtno=1;
                        TRACE_END_STM$("CompoundStatement291",291);
                    }
                } else
                // JavaLine 66 ==> SourceLine 292
                {
                    TRACE_BEGIN_STM$("CompoundStatement292",292);
                    while((q.next!=(null))) {
                        q=((COMMON$quantity)(q.next));
                    }
                    // JavaLine 72 ==> SourceLine 293
                    q.next=((COMMON$quantity)inspect$288$1);
                    // JavaLine 74 ==> SourceLine 294
                    inspect$288$1.virtno=(q.virtno+(1));
                    TRACE_END_STM$("CompoundStatement292",294);
                }
                // JavaLine 78 ==> SourceLine 296
                inspect$288$1.symb=p$symx;
                // JavaLine 80 ==> SourceLine 297
                inspect$288$1.categ=((ERRMSG)(CUR$.SL$)).C_unknwn;
                inspect$288$1.kind=((ERRMSG)(CUR$.SL$)).K_error;
                inspect$288$1.type=((ERRMSG)(CUR$.SL$)).IELSE;
                inspect$288$1.plev=((ERRMSG)(CUR$.SL$)).one;
                // JavaLine 85 ==> SourceLine 298
                inspect$288$1.line=((ERRMSG)(CUR$.SL$)).linenr;
                inspect$288$1.dim=1;
                inspect$288$1.encl=((ERRMSG)(CUR$.SL$)).unknowns;
                // JavaLine 89 ==> SourceLine 301
                RESULT$=((COMMON$quantity)(((COMMON$identsymbol)(inspect$288$1.symb)).curmeaning=((COMMON$quantity)inspect$288$1)));
                TRACE_END_STM$("CompoundStatement289",301);
            }
        }
        TRACE_END_STM$("newnotseen",301);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure newnotseen",1,286,15,287,17,288,52,289,56,290,58,291,66,292,72,293,74,294,78,296,80,297,85,298,89,301,97,305);
}
