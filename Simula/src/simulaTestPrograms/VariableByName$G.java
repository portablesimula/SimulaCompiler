package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VariableByName$G extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public NAME$<VariableByName$A> p$q;
    public VariableByName$A p$r;
    private int $npar=0; // Number of actual parameters transmitted.
    public VariableByName$G setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$q=(NAME$<VariableByName$A>)param; break;
                case 1: p$r=(VariableByName$A)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public VariableByName$G(RTObject$ SL$)
    { super(SL$); }
    public VariableByName$G(RTObject$ SL$,NAME$<VariableByName$A> sp$q,VariableByName$A sp$r) {
        super(SL$);
        this.p$q = sp$q;
        this.p$r = sp$r;
        BBLK();
        STM$();
    }
    public VariableByName$G STM$() {
        p$q.put(p$r);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VariableByName.sim","Procedure G",1,21,32,22,36,22);
}
