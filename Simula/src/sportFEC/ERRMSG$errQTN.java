package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$errQTN extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$quantity p$q;
    public int p$n;
    public COMMON$quantity p$qt;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$errQTN setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                case 2: p$qt=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$errQTN(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$errQTN(RTObject$ SL$,COMMON$quantity sp$q,int sp$n,COMMON$quantity sp$qt) {
        super(SL$);
        this.p$q = sp$q;
        this.p$n = sp$n;
        this.p$qt = sp$qt;
        BBLK();
        STM$();
    }
    public ERRMSG$errQTN STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$qlin(((ERRMSG)(CUR$.SL$)),p$qt).RESULT$;
        new ERRMSG$errQT(((ERRMSG)(CUR$.SL$)),p$q,p$n);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure errQTN",1,265,35,266,40,268);
}
