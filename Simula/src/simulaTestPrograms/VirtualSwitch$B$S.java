package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualSwitch$B$S extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public LABQNT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$$SW;
    private int $npar=0; // Number of actual parameters transmitted.
    public VirtualSwitch$B$S setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$$SW=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public VirtualSwitch$B$S(RTObject$ SL$)
    { super(SL$); }
    public VirtualSwitch$B$S(RTObject$ SL$,int sp$$SW) {
        super(SL$);
        this.p$$SW = sp$$SW;
        BBLK();
        STM$();
    }
    public VirtualSwitch$B$S STM$() {
        switch(p$$SW-1) {
            case 0: RESULT$=((VirtualSwitch$B)(CUR$.SL$)).L2; break;
            case 1: RESULT$=((VirtualSwitch$B)(CUR$.SL$)).L; break;
            default: throw new RuntimeException("Illegal switch index: "+p$$SW);
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSwitch.sim","Procedure S",1,14,38,0);
}
