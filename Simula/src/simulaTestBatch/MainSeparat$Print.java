package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 13:17:21 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MainSeparat$Print extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public MainSeparat$Print setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public MainSeparat$Print(RTObject$ SL$)
    { super(SL$); }
    public MainSeparat$Print(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public MainSeparat$Print STM$() {
        sysout().outtext(p$msg);
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure Print",1,39,29,40,34,40);
}
