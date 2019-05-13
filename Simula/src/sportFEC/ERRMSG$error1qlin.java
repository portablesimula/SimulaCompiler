package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error1qlin extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public COMMON$quantity p$q;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error1qlin setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error1qlin(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error1qlin(RTObject$ SL$,int sp$n,COMMON$quantity sp$q) {
        super(SL$);
        this.p$n = sp$n;
        this.p$q = sp$q;
        BBLK();
        STM$();
    }
    public ERRMSG$error1qlin STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$qlin(((ERRMSG)(CUR$.SL$)),p$q).RESULT$;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error1qlin",1,271,32,272,37,274);
}
