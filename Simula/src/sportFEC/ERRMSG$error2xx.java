package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$error2xx extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n1;
    public char p$n2;
    public char p$n3;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$error2xx setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n1=intValue(param); break;
                case 1: p$n2=(char)objectValue(param); break;
                case 2: p$n3=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$error2xx(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$error2xx(RTObject$ SL$,int sp$n1,char sp$n2,char sp$n3) {
        super(SL$);
        this.p$n1 = sp$n1;
        this.p$n2 = sp$n2;
        this.p$n3 = sp$n3;
        BBLK();
        STM$();
    }
    public ERRMSG$error2xx STM$() {
        if(VALUE$((p$n2!=(((ERRMSG)(CUR$.SL$)).IELSE)))) {
            {
                ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),rank(p$n2)).RESULT$;
                ((ERRMSG)(CUR$.SL$)).diag.Elt[1-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new ERRMSG$errmsg(((ERRMSG)(CUR$.SL$)),rank(p$n3)).RESULT$;
                new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),p$n1);
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure error2xx",1,403,35,404,37,405,41,406,47,406);
}
