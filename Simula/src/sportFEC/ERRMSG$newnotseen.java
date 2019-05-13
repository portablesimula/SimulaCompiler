package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$newnotseen extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$quantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public COMMON$symbolbox p$symx;
    COMMON$quantity q=null;
    COMMON$quantity inspect$288$7=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$newnotseen setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$symx=(COMMON$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$newnotseen(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$newnotseen(RTObject$ SL$,COMMON$symbolbox sp$symx) {
        super(SL$);
        this.p$symx = sp$symx;
        BBLK();
        STM$();
    }
    public ERRMSG$newnotseen STM$() {
        {
            inspect$288$7=new COMMON$quantity(((ERRMSG)(CUR$.SL$))).STM$();
            if(inspect$288$7!=null)
            {
                q=((ERRMSG)(CUR$.SL$)).unknowns.fpar;
                if(VALUE$((q==(null)))) {
                    {
                        ((ERRMSG)(CUR$.SL$)).unknowns.fpar=((COMMON$quantity)inspect$288$7);
                        inspect$288$7.virtno$1=1;
                    }
                } else
                {
                    while((q.next!=(null))) {
                        q=((COMMON$quantity)(q.next));
                    }
                    q.next=((COMMON$quantity)inspect$288$7);
                    inspect$288$7.virtno$1=(q.virtno$1+(1));
                }
                inspect$288$7.symb$1=p$symx;
                inspect$288$7.categ$1=((ERRMSG)(CUR$.SL$)).C_unknwn;
                inspect$288$7.kind$1=((ERRMSG)(CUR$.SL$)).K_error;
                inspect$288$7.type$1=((ERRMSG)(CUR$.SL$)).IELSE;
                inspect$288$7.plev$1=((ERRMSG)(CUR$.SL$)).one;
                inspect$288$7.line$1=((ERRMSG)(CUR$.SL$)).linenr;
                inspect$288$7.dim$1=1;
                inspect$288$7.encl$1=((ERRMSG)(CUR$.SL$)).unknowns;
                RESULT$=((COMMON$quantity)(((COMMON$identsymbol)(inspect$288$7.symb$1)).curmeaning$1=((COMMON$quantity)inspect$288$7)));
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure newnotseen",1,286,11,287,13,288,38,289,41,290,43,291,49,292,54,293,56,294,59,296,61,297,66,298,70,301,76,305);
}
