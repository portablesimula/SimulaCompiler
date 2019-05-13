package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 09:52:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst124$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst124$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst124$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst124$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst124$trace STM$() {
        if(VALUE$(((simtst124)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst124)(CUR$.SL$)).facit.Elt[((simtst124)(CUR$.SL$)).traceCase-((simtst124)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst124)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst124)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst124)(CUR$.SL$)).facit.Elt[((simtst124)(CUR$.SL$)).traceCase-((simtst124)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst124)(CUR$.SL$)).traceCase=(((simtst124)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst124.sim","Procedure trace",1,20,29,22,36,23,38,25,41,26,45,27,48,28,53,30,57,31);
}
