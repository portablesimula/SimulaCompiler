package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 10:27:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst114$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst114$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst114$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst114$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst114$trace STM$() {
        if(VALUE$(((simtst114)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst114)(CUR$.SL$)).facit.Elt[((simtst114)(CUR$.SL$)).traceCase-((simtst114)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst114)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst114)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst114)(CUR$.SL$)).facit.Elt[((simtst114)(CUR$.SL$)).traceCase-((simtst114)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst114)(CUR$.SL$)).traceCase=(((simtst114)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst114.sim","Procedure trace",1,14,29,16,36,17,38,19,41,20,45,21,48,22,53,24,57,25);
}
