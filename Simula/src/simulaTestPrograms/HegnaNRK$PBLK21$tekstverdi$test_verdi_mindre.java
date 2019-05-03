package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HegnaNRK$PBLK21$verdi p$v;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$v=(HegnaNRK$PBLK21$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$v) {
        super(SL$);
        this.p$v = sp$v;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre STM$() {
        RESULT$=((p$v instanceof HegnaNRK$PBLK21$tekstverdi)?(TXTREL$LT(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1,((HegnaNRK$PBLK21$tekstverdi)(p$v)).tekst$1)):(false));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure test_verdi_mindre",1,179,31,181,35,183);
}
