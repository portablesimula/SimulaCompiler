package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$test_verdilikhet extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HegnaNRK$PBLK21$verdi p$v;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$v=(HegnaNRK$PBLK21$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        this.p$v = sp$v;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$heltallverdi$test_verdilikhet STM$() {
        RESULT$=((p$v instanceof HegnaNRK$PBLK21$heltallverdi)?((((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1==(((HegnaNRK$PBLK21$heltallverdi)(p$v)).tall$1))):(false));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdilikhet",1,74,31,76,35,78);
}
