package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$errQT extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$quantity p$q;
    public int p$n;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$errQT setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$errQT(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$errQT(RTObject$ SL$,COMMON$quantity sp$q,int sp$n) {
        super(SL$);
        this.p$q = sp$q;
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public ERRMSG$errQT STM$() {
        if(VALUE$((p$q!=(null)))) {
            {
                ((ERRMSG)(CUR$.SL$)).messageLinenr=p$q.line$1;
                new ERRMSG$error1id(((ERRMSG)(CUR$.SL$)),p$n,p$q.symb$1);
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure errQT",1,258,32,259,34,260,42,262);
}
