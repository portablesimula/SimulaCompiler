package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu Apr 25 10:29:17 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class pa extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$n;
    private int $npar=0; // Number of actual parameters transmitted.
    public pa setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public pa(RTObject$ SL$)
    { super(SL$); }
    public pa(RTObject$ SL$,int sp$n) {
        super(SL$);
        this.p$n = sp$n;
        BBLK();
        STM$();
    }
    public pa STM$() {
        if(VALUE$((p$n<(10)))) {
            RESULT$=(p$n+(new pb(((pa)CUR$),(p$n+(1))).RESULT$));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("p40a.sim","Procedure pa",30,4,36,5);
}
