package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error2quants extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public COMMON$quantity p$q;
    public COMMON$quantity p$qt;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error2quants setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$q=(COMMON$quantity)objectValue(param); break;
                case 2: p$qt=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error2quants(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error2quants(RTObject$ SL$,int sp$n,COMMON$quantity sp$q,COMMON$quantity sp$qt) {
        super(SL$);
        this.p$n = sp$n;
        this.p$q = sp$q;
        this.p$qt = sp$qt;
        BBLK();
        STM$();
    }
    public ERRMSG$error2quants STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$qlin(((ERRMSG)(CUR$.SL$)),p$qt).RESULT$;
        new ERRMSG$error1id(((ERRMSG)(CUR$.SL$)),p$n,p$q.symb$1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error2quants",1,277,35,278,40,280);
}
