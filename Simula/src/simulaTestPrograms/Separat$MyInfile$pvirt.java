package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Separat$MyInfile$pvirt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public FILE$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    public int p$j;
    private int $npar=0; // Number of actual parameters transmitted.
    public Separat$MyInfile$pvirt setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$j=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Separat$MyInfile$pvirt(RTObject$ SL$)
    { super(SL$); }
    public Separat$MyInfile$pvirt(RTObject$ SL$,int sp$i,int sp$j) {
        super(SL$);
        this.p$i = sp$i;
        this.p$j = sp$j;
        BBLK();
        STM$();
    }
    public Separat$MyInfile$pvirt STM$() {
        p$i=34;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure pvirt",1,28,34,29,38,30);
}
