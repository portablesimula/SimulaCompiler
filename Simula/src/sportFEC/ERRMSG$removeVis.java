package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$removeVis extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$brecord p$brc;
    public COMMON$idpack p$visp;
    public int p$err;
    COMMON$idpack prev=null;
    COMMON$idpack cur=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$removeVis setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$brc=(COMMON$brecord)objectValue(param); break;
                case 1: p$visp=(COMMON$idpack)objectValue(param); break;
                case 2: p$err=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$removeVis(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$removeVis(RTObject$ SL$,COMMON$brecord sp$brc,COMMON$idpack sp$visp,int sp$err) {
        super(SL$);
        this.p$brc = sp$brc;
        this.p$visp = sp$visp;
        this.p$err = sp$err;
        BBLK();
        STM$();
    }
    public ERRMSG$removeVis STM$() {
        ((ERRMSG)(CUR$.SL$)).messageLinenr=p$visp.line;
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new COMMON$boxof(((ERRMSG)(CUR$.SL$)),p$visp.idhi,p$visp.idlo).RESULT$.symbol;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),(-(p$err)));
        cur=p$brc.hidlist;
        while((cur!=(p$visp))) {
            {
                prev=cur;
                cur=cur.next;
            }
        }
        if(VALUE$((prev==(null)))) {
            p$brc.hidlist=p$visp.next;
        } else
        prev.next=p$visp.next;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure removeVis",1,369,11,372,38,373,40,374,43,375,45,376,52,377,56,378,60,379);
}
