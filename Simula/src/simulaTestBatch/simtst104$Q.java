package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Apr 30 10:26:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst104$Q extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<PRCQNT$> p$F;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst104$Q setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$F=(NAME$<PRCQNT$>)param; break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst104$Q(RTObject$ SL$)
    { super(SL$); }
    public simtst104$Q(RTObject$ SL$,NAME$<PRCQNT$> sp$F) {
        super(SL$);
        this.p$F = sp$F;
        BBLK();
        STM$();
    }
    public simtst104$Q STM$() {
        RESULT$=floatValue(p$F.get().CPF().RESULT$());
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst104.sim","Procedure Q",1,32,31,34,35,35);
}
