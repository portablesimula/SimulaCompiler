package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualSample$B$Q extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float p$r;
    private int $npar=0; // Number of actual parameters transmitted.
    public VirtualSample$B$Q setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$r=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public VirtualSample$B$Q(RTObject$ SL$)
    { super(SL$); }
    public VirtualSample$B$Q(RTObject$ SL$,float sp$r) {
        super(SL$);
        this.p$r = sp$r;
        BBLK();
        STM$();
    }
    public VirtualSample$B$Q STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSample.sim","Procedure Q",1,19,31,20);
}
