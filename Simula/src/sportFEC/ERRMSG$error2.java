package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error2 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public TXT$ p$t1;
    public TXT$ p$t2;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error2 setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$t1=(TXT$)objectValue(param); break;
                case 2: p$t2=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error2(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error2(RTObject$ SL$,int sp$n,TXT$ sp$t1,TXT$ sp$t2) {
        super(SL$);
        this.p$n = sp$n;
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        BBLK();
        STM$();
    }
    public ERRMSG$error2 STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t1;
        ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t2;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error2",1,398,35,399,41,399);
}
