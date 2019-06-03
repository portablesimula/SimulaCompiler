package simulaTestBatch;
// Simula-1.0 Compiled at Sun Jun 02 12:51:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst41$$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public NAME$<Integer> p$j;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst41$$P setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$j=(NAME$<Integer>)param; break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst41$$P(RTObject$ SL$)
    { super(SL$); }
    public simtst41$$P(RTObject$ SL$,NAME$<Integer> sp$j) {
        super(SL$);
        this.p$j = sp$j;
        BBLK();
        STM$();
    }
    public simtst41$$P STM$() {
        while((((simtst41$)(CUR$.SL$)).i<(100))) {
            new p41(((simtst41$)(CUR$.SL$)),((simtst41$)(CUR$.SL$)).A,new NAME$<Integer>(){ public Integer get() { return(p$j.get()); } public Integer put(Integer x$) { return(p$j.put((int)x$)); } });
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst41.sim","Procedure P",1,22,29,26,31,27,36,28);
}
