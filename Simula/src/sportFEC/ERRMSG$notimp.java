package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$notimp extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$t;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$notimp setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$notimp(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$notimp(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public ERRMSG$notimp STM$() {
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=p$t;
        new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),309);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure notimp",1,282,29,283,34,283);
}
