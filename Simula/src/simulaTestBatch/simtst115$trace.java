package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:10:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst115$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst115$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst115$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst115$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst115$trace STM$() {
        if(VALUE$(((simtst115)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst115)(CUR$.SL$)).facit.Elt[((simtst115)(CUR$.SL$)).traceCase-((simtst115)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst115)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst115)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst115)(CUR$.SL$)).facit.Elt[((simtst115)(CUR$.SL$)).traceCase-((simtst115)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst115)(CUR$.SL$)).traceCase=(((simtst115)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst115.sim","Procedure trace",1,15,29,17,36,18,38,20,41,21,45,22,48,23,53,25,57,26);
}
