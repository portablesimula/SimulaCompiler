package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$qlin extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public COMMON$quantity p$r;
    TXT$ ltxt=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$qlin setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$r=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$qlin(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$qlin(RTObject$ SL$,COMMON$quantity sp$r) {
        super(SL$);
        this.p$r = sp$r;
        BBLK();
        STM$();
    }
    public ERRMSG$qlin STM$() {
        if(VALUE$((p$r!=(null)))) {
            {
                if(VALUE$((p$r.line$1>(0)))) {
                    {
                        ltxt=new COMMON$leftint(((ERRMSG)(CUR$.SL$)),p$r.line$1).RESULT$;
                        ltxt=CONC(CONC(new TXT$("(l. "),ltxt),new TXT$(")"));
                    }
                } else
                ltxt=new TXT$("(ext.)");
                RESULT$=CONC(p$r.symb$1.symbol,ltxt);
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure qlin",1,247,11,248,33,249,35,250,38,251,44,252,46,253,52,255);
}
