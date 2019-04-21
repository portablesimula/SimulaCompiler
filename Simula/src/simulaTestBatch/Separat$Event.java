package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Separat$Event extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$n;
    public int p$val;
    private int $npar=0; // Number of actual parameters transmitted.
    public Separat$Event setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$n=intValue(param); break;
                case 1: p$val=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Separat$Event(RTObject$ SL$)
    { super(SL$); }
    public Separat$Event(RTObject$ SL$,int sp$n,int sp$val) {
        super(SL$);
        this.p$n = sp$n;
        this.p$val = sp$val;
        BBLK();
        STM$();
    }
    public Separat$Event STM$() {
        ((Separat)(CUR$.SL$)).eventValue=p$val;
        ((Separat)(CUR$.SL$)).checkEvent$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(p$n); } public Integer put(Integer x$) { return(p$n=(int)x$); } }).setPar(new NAME$<Integer>(){ public Integer get() { return(p$val); } public Integer put(Integer x$) { return(p$val=(int)x$); } }).ENT$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Separat.sim","Procedure Event",1,16,32,17,37,17);
}
