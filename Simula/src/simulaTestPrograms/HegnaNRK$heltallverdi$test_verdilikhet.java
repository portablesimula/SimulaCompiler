package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$heltallverdi$test_verdilikhet extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HegnaNRK$verdi p$v;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$heltallverdi$test_verdilikhet setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$v=(HegnaNRK$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$heltallverdi$test_verdilikhet(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$heltallverdi$test_verdilikhet(RTObject$ SL$,HegnaNRK$verdi sp$v) {
        super(SL$);
        this.p$v = sp$v;
        BBLK();
        STM$();
    }
    public HegnaNRK$heltallverdi$test_verdilikhet STM$() {
        RESULT$=((p$v instanceof HegnaNRK$heltallverdi)?((((HegnaNRK$heltallverdi)(CUR$.SL$)).tall$1==(((HegnaNRK$heltallverdi)(p$v)).tall$1))):(false));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdilikhet",1,74,31,76,35,78);
}
