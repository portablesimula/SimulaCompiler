package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Apr 29 09:38:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CoroutineSample$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public CoroutineSample$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public CoroutineSample$trace(RTObject$ SL$)
    { super(SL$); }
    public CoroutineSample$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public CoroutineSample$trace STM$() {
        if(VALUE$(((CoroutineSample)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((CoroutineSample)(CUR$.SL$)).facit.Elt[((CoroutineSample)(CUR$.SL$)).traceCase-((CoroutineSample)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((CoroutineSample)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((CoroutineSample)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((CoroutineSample)(CUR$.SL$)).facit.Elt[((CoroutineSample)(CUR$.SL$)).traceCase-((CoroutineSample)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((CoroutineSample)(CUR$.SL$)).traceCase=(((CoroutineSample)(CUR$.SL$)).traceCase+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("CoroutineSample.sim","Procedure trace",1,15,29,17,36,18,38,20,41,21,45,22,48,23,53,25,57,26);
}
