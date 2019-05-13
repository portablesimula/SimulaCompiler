package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 10:30:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst126$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst126$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst126$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst126$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst126$trace STM$() {
        if(VALUE$(((simtst126)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst126)(CUR$.SL$)).facit.Elt[((simtst126)(CUR$.SL$)).traceCase-((simtst126)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst126)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst126)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst126)(CUR$.SL$)).facit.Elt[((simtst126)(CUR$.SL$)).traceCase-((simtst126)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst126)(CUR$.SL$)).traceCase=(((simtst126)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst126.sim","Procedure trace",1,20,29,22,36,23,38,25,41,26,45,27,48,28,53,30,57,31);
}
