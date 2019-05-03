package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$felt_kopi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HegnaNRK$PBLK21$verdi p$felt;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$felt_kopi setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$felt=(HegnaNRK$PBLK21$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$felt_kopi(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$felt_kopi(RTObject$ SL$,HegnaNRK$PBLK21$verdi sp$felt) {
        super(SL$);
        this.p$felt = sp$felt;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$felt_kopi STM$() {
        RESULT$=p$felt;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure felt_kopi",1,866,31,867,35,867);
}
