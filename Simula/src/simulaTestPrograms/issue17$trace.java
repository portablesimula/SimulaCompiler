package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$t;
    private int $npar=0; // Number of actual parameters transmitted.
    public issue17$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public issue17$trace(RTObject$ SL$)
    { super(SL$); }
    public issue17$trace(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        this.p$t = sp$t;
        BBLK();
        STM$();
    }
    public issue17$trace STM$() {
        sysout().outtext(p$t);
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","Procedure trace",28,11,33,12);
}
