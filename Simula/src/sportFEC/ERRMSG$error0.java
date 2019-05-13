package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error0 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error0 setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error0(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error0(RTObject$ SL$,int sp$n) {
        super(SL$);
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public ERRMSG$error0 STM$() {
        if(VALUE$((p$n<(0)))) {
            new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),((char)1),(-(p$n)));
        } else
        new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),((char)2),p$n);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error0",1,314,29,315,36,315);
}
