package simulaTestBatch;
// Simula-1.0 Compiled at Sun Jun 02 12:51:10 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class p41 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<?> p$A;
    public NAME$<Integer> p$i;
    private int $npar=0; // Number of actual parameters transmitted.
    public p41 setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$A=arrayValue(param); break;
                case 1: p$i=(NAME$<Integer>)param; break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public p41(RTObject$ SL$)
    { super(SL$); }
    public p41(RTObject$ SL$,ARRAY$<?> sp$A,NAME$<Integer> sp$i) {
        super(SL$);
        this.p$A = sp$A;
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public p41 STM$() {
        ((ARRAY$<int[]>)p$A).Elt[p$i.get()-p$A.LB[0]]=p$i.get();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("p41.sim","Procedure p41",1,1,32,5,36,6);
}
