package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$pnr;
    int i=0;
    HegnaNRK$PBLK21$post inspect$813$3=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$hent_post setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$pnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$hent_post(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$hent_post(RTObject$ SL$,int sp$pnr) {
        super(SL$);
        this.p$pnr = sp$pnr;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$hent_post STM$() {
        {
            inspect$813$3=((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[p$pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]];
            if(inspect$813$3!=null)
            {
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1=inspect$813$3.p$antall;
                for(boolean CB$816:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1); }})
                   )) { if(!CB$816) continue;
                {
                    ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]=inspect$813$3.feltnr.Elt[i-inspect$813$3.feltnr.LB[0]];
                    ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]]=new HegnaNRK$PBLK21$felt_kopi(((HegnaNRK$PBLK21)(CUR$.SL$)),inspect$813$3.felt.Elt[i-inspect$813$3.felt.LB[0]]).RESULT$;
                }
            }
            ((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1=p$pnr;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent_post",1,810,9,812,11,813,36,815,39,816,43,818,46,819,50,821,56,823);
}
