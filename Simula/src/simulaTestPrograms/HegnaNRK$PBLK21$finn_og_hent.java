package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_og_hent extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$start;
    int funn=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_og_hent setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$start=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$finn_og_hent(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$finn_og_hent(RTObject$ SL$,int sp$start) {
        super(SL$);
        this.p$start = sp$start;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$finn_og_hent STM$() {
        new HegnaNRK$PBLK21$stryk_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        funn=new HegnaNRK$PBLK21$finn_post(((HegnaNRK$PBLK21)(CUR$.SL$)),p$start).RESULT$;
        if(VALUE$((funn!=(0)))) {
            {
                new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn);
                sysout().outimage();
                new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
            }
        } else
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),5);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_og_hent",1,663,9,665,31,666,33,667,35,668,37,670,40,671,42,672,46,675,50,676);
}
