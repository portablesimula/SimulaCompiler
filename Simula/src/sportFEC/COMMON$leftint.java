package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$leftint extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$leftint setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public COMMON$leftint(RTObject$ SL$)
    { super(SL$); }
    public COMMON$leftint(RTObject$ SL$,int sp$i) {
        super(SL$);
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public COMMON$leftint STM$() {
        TXT$.putint(((COMMON)(CUR$.SL$)).leftintbuf,p$i);
        p$i=11;
        while((loadChar(((COMMON)(CUR$.SL$)).leftintbuf,p$i)!=(((char)32)))) {
            p$i=(p$i-(1));
        }
        RESULT$=copy(copy(TXT$.sub(((COMMON)(CUR$.SL$)).leftintbuf,(p$i+(2)),(11-(p$i)))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure leftint",1,814,31,815,34,816,38,817,42,818);
}
