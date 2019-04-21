package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualSample$A$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public VirtualSample$A p$x;
    public int p$i;
    public float p$r;
    private int $npar=0; // Number of actual parameters transmitted.
    public VirtualSample$A$P setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$x=(VirtualSample$A)objectValue(param); break;
                case 1: p$i=intValue(param); break;
                case 2: p$r=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public VirtualSample$A$P(RTObject$ SL$)
    { super(SL$); }
    public VirtualSample$A$P(RTObject$ SL$,VirtualSample$A sp$x,int sp$i,float sp$r) {
        super(SL$);
        this.p$x = sp$x;
        this.p$i = sp$i;
        this.p$r = sp$r;
        BBLK();
        STM$();
    }
    public VirtualSample$A$P STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSample.sim","Procedure P",1,8,37,9);
}
