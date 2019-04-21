package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VariableByName$F extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public NAME$<Boolean> p$cond;
    public NAME$<Double> p$q;
    double j=0.0d;
    private int $npar=0; // Number of actual parameters transmitted.
    public VariableByName$F setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$cond=(NAME$<Boolean>)param; break;
                case 1: p$q=(NAME$<Double>)param; break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public VariableByName$F(RTObject$ SL$)
    { super(SL$); }
    public VariableByName$F(RTObject$ SL$,NAME$<Boolean> sp$cond,NAME$<Double> sp$q) {
        super(SL$);
        this.p$cond = sp$cond;
        this.p$q = sp$q;
        BBLK();
        STM$();
    }
    public VariableByName$F STM$() {
        j=p$q.get();
        p$q.put(((double)(9.7f)));
        p$q.put((p$q.get()+(((double)(13.4f)))));
        p$q.put(((p$cond.get())?(p$q.get()):((p$q.get()+(((double)(67.9f)))))));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VariableByName.sim","Procedure F",1,12,10,14,34,15,36,16,38,17,40,18,44,19);
}
