package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$openerror extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$fname;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$openerror setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$fname=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$openerror(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$openerror(RTObject$ SL$,TXT$ sp$fname) {
        super(SL$);
        this.p$fname = sp$fname;
        BBLK();
        STM$();
    }
    public ERRMSG$openerror STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$fname;
        new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),336);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure openerror",1,393,29,394,34,394);
}
