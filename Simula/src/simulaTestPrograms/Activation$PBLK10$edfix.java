package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 28 21:54:05 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Activation$PBLK10$edfix extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public float p$r;
    TXT$ t=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public Activation$PBLK10$edfix setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$r=floatValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Activation$PBLK10$edfix(RTObject$ SL$)
    { super(SL$); }
    public Activation$PBLK10$edfix(RTObject$ SL$,float sp$r) {
        super(SL$);
        this.p$r = sp$r;
        BBLK();
        STM$();
    }
    public Activation$PBLK10$edfix STM$() {
        t=blanks(6);
        TXT$.putfix(t,p$r,2);
        RESULT$=t;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Activation.sim","Procedure edfix",1,19,11,20,38,20);
}
