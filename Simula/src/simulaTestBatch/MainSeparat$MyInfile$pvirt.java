package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MainSeparat$MyInfile$pvirt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public FILE$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    public int p$j;
    private int $npar=0; // Number of actual parameters transmitted.
    public MainSeparat$MyInfile$pvirt setPar(Object param) {
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
    public MainSeparat$MyInfile$pvirt(RTObject$ SL$)
    { super(SL$); }
    public MainSeparat$MyInfile$pvirt(RTObject$ SL$,int sp$i,int sp$j) {
        super(SL$);
        this.p$i = sp$i;
        this.p$j = sp$j;
        BBLK();
        STM$();
    }
    public MainSeparat$MyInfile$pvirt STM$() {
        p$i=34;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure pvirt",1,47,34,48,38,49);
}
