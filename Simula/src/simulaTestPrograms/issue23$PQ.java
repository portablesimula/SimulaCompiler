package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:42:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23$PQ extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public PRCQNT$ p$p;
    private int $npar=0; // Number of actual parameters transmitted.
    public issue23$PQ setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$p=procValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public issue23$PQ(RTObject$ SL$)
    { super(SL$); }
    public issue23$PQ(RTObject$ SL$,PRCQNT$ sp$p) {
        super(SL$);
        this.p$p = sp$p;
        BBLK();
        STM$();
    }
    public issue23$PQ STM$() {
        p$p.CPF();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","Procedure PQ",1,6,29,7,33,7);
}
