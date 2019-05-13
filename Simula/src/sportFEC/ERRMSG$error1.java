package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error1 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public TXT$ p$t;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error1 setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error1(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error1(RTObject$ SL$,int sp$n,TXT$ sp$t) {
        super(SL$);
        this.p$n = sp$n;
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public ERRMSG$error1 STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error1",1,383,32,384,37,384);
}
