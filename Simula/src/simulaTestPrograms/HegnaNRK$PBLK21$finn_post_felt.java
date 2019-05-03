package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_post_felt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$pnr;
    public int p$finr;
    int i=0;
    int fnr=0;
    HegnaNRK$PBLK21$verdi pverdi=null;
    boolean funnet=false;
    boolean likhet=false;
    HegnaNRK$PBLK21$post inspect$734$1=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_post_felt setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$pnr=intValue(param); break;
                case 1: p$finr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$finn_post_felt(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$finn_post_felt(RTObject$ SL$,int sp$pnr,int sp$finr) {
        super(SL$);
        this.p$pnr = sp$pnr;
        this.p$finr = sp$finr;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$finn_post_felt STM$() {
        i=0;
        funnet=likhet=false;
        fnr=((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.Elt[p$finr-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.LB[0]];
        pverdi=((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.Elt[p$finr-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.LB[0]];
        {
            inspect$734$1=((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[p$pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]];
            if(inspect$734$1!=null)
            while(((!(funnet))&((i<(inspect$734$1.p$antall))))) {
                {
                    i=(i+(1));
                    if(VALUE$((fnr==(inspect$734$1.feltnr.Elt[i-inspect$734$1.feltnr.LB[0]])))) {
                        {
                            funnet=true;
                            likhet=((boolean)(pverdi.test_verdilikhet$0().CPF().setPar(new NAME$<HegnaNRK$PBLK21$verdi>(){ public HegnaNRK$PBLK21$verdi get() { return(inspect$734$1.felt.Elt[i-inspect$734$1.felt.LB[0]]); } public HegnaNRK$PBLK21$verdi put(HegnaNRK$PBLK21$verdi x$) { return(inspect$734$1.felt.Elt[i-inspect$734$1.felt.LB[0]]=(HegnaNRK$PBLK21$verdi)x$); } }).ENT$().RESULT$()));
                        }
                    }
                }
            }
        }
        RESULT$=likhet;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_post_felt",1,726,12,728,16,729,19,734,43,730,45,731,47,732,49,733,51,734,55,735,57,737,60,738,62,740,65,741,72,744,76,745);
}
