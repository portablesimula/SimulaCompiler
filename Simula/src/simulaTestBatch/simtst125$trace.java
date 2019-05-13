package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 10:19:31 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst125$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst125$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst125$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst125$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst125$trace STM$() {
        if(VALUE$(((simtst125)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simtst125)(CUR$.SL$)).facit.Elt[((simtst125)(CUR$.SL$)).traceCase-((simtst125)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst125)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst125)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst125)(CUR$.SL$)).facit.Elt[((simtst125)(CUR$.SL$)).traceCase-((simtst125)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst125)(CUR$.SL$)).traceCase=(((simtst125)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst125.sim","Procedure trace",1,21,29,23,36,24,38,26,41,27,45,28,48,29,53,31,57,32);
}
