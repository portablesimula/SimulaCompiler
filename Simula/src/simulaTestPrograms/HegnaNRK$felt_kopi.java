package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$felt_kopi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HegnaNRK$verdi p$felt;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$felt_kopi setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$felt=(HegnaNRK$verdi)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$felt_kopi(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$felt_kopi(RTObject$ SL$,HegnaNRK$verdi sp$felt) {
        super(SL$);
        this.p$felt = sp$felt;
        BBLK();
        STM$();
    }
    public HegnaNRK$felt_kopi STM$() {
        RESULT$=p$felt;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure felt_kopi",1,866,31,867,35,867);
}
