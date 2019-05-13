package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error1id extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public COMMON$symbolbox p$symb;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error1id setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$symb=(COMMON$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error1id(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error1id(RTObject$ SL$,int sp$n,COMMON$symbolbox sp$symb) {
        super(SL$);
        this.p$n = sp$n;
        this.p$symb = sp$symb;
        BBLK();
        STM$();
    }
    public ERRMSG$error1id STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$symb.symbol;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error1id",1,388,32,389,37,389);
}
