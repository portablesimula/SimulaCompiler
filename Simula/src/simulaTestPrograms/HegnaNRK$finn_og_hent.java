package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finn_og_hent extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$start;
    int funn=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$finn_og_hent setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$start=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$finn_og_hent(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$finn_og_hent(RTObject$ SL$,int sp$start) {
        super(SL$);
        this.p$start = sp$start;
        BBLK();
        STM$();
    }
    public HegnaNRK$finn_og_hent STM$() {
        new HegnaNRK$stryk_intern_post(((HegnaNRK)(CUR$.SL$)));
        funn=new HegnaNRK$finn_post(((HegnaNRK)(CUR$.SL$)),p$start).RESULT$;
        if(VALUE$((funn!=(0)))) {
            {
                new HegnaNRK$hent_post(((HegnaNRK)(CUR$.SL$)),funn);
                sysout().outimage();
                new HegnaNRK$skjerm_intern_post(((HegnaNRK)(CUR$.SL$)));
            }
        } else
        new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),5);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_og_hent",1,663,9,665,31,666,33,667,35,668,37,670,40,671,42,672,46,675,50,676);
}
