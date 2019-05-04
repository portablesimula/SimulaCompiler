package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:42:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23$PP extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<?> p$a;
    private int $npar=0; // Number of actual parameters transmitted.
    public issue23$PP setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$a=arrayValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public issue23$PP(RTObject$ SL$)
    { super(SL$); }
    public issue23$PP(RTObject$ SL$,ARRAY$<?> sp$a) {
        super(SL$);
        this.p$a = sp$a;
        BBLK();
        STM$();
    }
    public issue23$PP STM$() {
        sysout().outfix(((ARRAY$<float[]>)p$a).Elt[1-p$a.LB[0]],2,5);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","Procedure PP",1,3,29,4,33,4);
}
