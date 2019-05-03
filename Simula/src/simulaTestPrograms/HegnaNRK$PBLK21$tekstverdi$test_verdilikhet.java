package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$test_verdilikhet extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HegnaNRK$PBLK21$verdi p$v;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$v=(HegnaNRK$PBLK21$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        this.p$v = sp$v;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet STM$() {
        if(VALUE$((!(p$v instanceof HegnaNRK$PBLK21$tekstverdi)))) {
            RESULT$=false;
        } else
        new HegnaNRK$PBLK21$tekstverdi$test_verdilikhet$SubBlock162(CUR$).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdilikhet",1,158,31,160,35,177,39,177);
}
