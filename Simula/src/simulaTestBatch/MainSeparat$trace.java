package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MainSeparat$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public MainSeparat$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public MainSeparat$trace(RTObject$ SL$)
    { super(SL$); }
    public MainSeparat$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public MainSeparat$trace STM$() {
        if(VALUE$(((MainSeparat)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(((MainSeparat)(CUR$.SL$)).TESTING)) {
            {
                if(VALUE$(TXTREL$NE(p$msg,((MainSeparat)(CUR$.SL$)).facit.Elt[((MainSeparat)(CUR$.SL$)).traceCase-((MainSeparat)(CUR$.SL$)).facit.LB[0]]))) {
                    {
                        ((MainSeparat)(CUR$.SL$)).found_error=true;
                        sysout().outtext(new TXT$("ERROR in Case "));
                        sysout().outint(((MainSeparat)(CUR$.SL$)).traceCase,0);
                        sysout().outimage();
                        sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                        sysout().outimage();
                        sysout().outtext(CONC(new TXT$("Facit: "),((MainSeparat)(CUR$.SL$)).facit.Elt[((MainSeparat)(CUR$.SL$)).traceCase-((MainSeparat)(CUR$.SL$)).facit.LB[0]]));
                        sysout().outimage();
                    }
                }
                ((MainSeparat)(CUR$.SL$)).traceCase=(((MainSeparat)(CUR$.SL$)).traceCase+(1));
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Procedure trace",1,22,29,24,36,25,38,27,41,29,44,30,48,31,51,32,56,34,62,36);
}
