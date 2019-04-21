package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VariableByName$W extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$t;
    public NAME$<TXT$> p$u;
    public TXT$ p$z;
    private int $npar=0; // Number of actual parameters transmitted.
    public VariableByName$W setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                case 1: p$u=(NAME$<TXT$>)param; break;
                case 2: p$z=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public VariableByName$W(RTObject$ SL$)
    { super(SL$); }
    public VariableByName$W(RTObject$ SL$,TXT$ sp$t,NAME$<TXT$> sp$u,TXT$ sp$z) {
        super(SL$);
        this.p$t = sp$t;
        this.p$u = sp$u;
        this.p$z = sp$z;
        BBLK();
        STM$();
    }
    public VariableByName$W STM$() {
        TXT$.setpos(p$u.get(),4);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VariableByName.sim","Procedure W",1,24,35,25,39,25);
}
