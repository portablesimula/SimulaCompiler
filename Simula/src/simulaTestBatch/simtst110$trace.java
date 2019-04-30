package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Apr 29 14:51:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst110$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst110$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst110$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst110$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst110$trace STM$() {
        if(VALUE$(((simtst110)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst110)(CUR$.SL$)).facit.Elt[((simtst110)(CUR$.SL$)).traceCase-((simtst110)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst110)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst110)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst110)(CUR$.SL$)).facit.Elt[((simtst110)(CUR$.SL$)).traceCase-((simtst110)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst110)(CUR$.SL$)).traceCase=(((simtst110)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst110.sim","Procedure trace",1,16,29,18,36,19,38,21,41,22,45,23,48,24,53,26,57,27);
}
