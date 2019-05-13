package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 17:37:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst121$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst121$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst121$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst121$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst121$trace STM$() {
        if(VALUE$(((simtst121)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst121)(CUR$.SL$)).facit.Elt[((simtst121)(CUR$.SL$)).traceCase-((simtst121)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst121)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst121)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst121)(CUR$.SL$)).facit.Elt[((simtst121)(CUR$.SL$)).traceCase-((simtst121)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst121)(CUR$.SL$)).traceCase=(((simtst121)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst121.sim","Procedure trace",1,17,29,19,36,20,38,22,41,23,45,24,48,25,53,27,57,28);
}
