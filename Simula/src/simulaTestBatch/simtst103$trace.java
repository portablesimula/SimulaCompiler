package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 12:44:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    TXT$ case1=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst103$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst103$trace(RTObject$ SL$)
    { super(SL$); }
    public simtst103$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst103$trace STM$() {
        case1=CONC(CONC(new simtst103$edfix(((simtst103)(CUR$.SL$)),((float)(((simtst103)(CUR$.SL$)).time()))).RESULT$,new TXT$(": ")),p$msg);
        if(VALUE$(((simtst103)(CUR$.SL$)).verbose$2)) {
            {
                sysout().outtext(case1);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(case1,((simtst103)(CUR$.SL$)).facit.Elt[((simtst103)(CUR$.SL$)).traceCase$2-((simtst103)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simtst103)(CUR$.SL$)).found_error$2=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simtst103)(CUR$.SL$)).traceCase$2,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),case1));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simtst103)(CUR$.SL$)).facit.Elt[((simtst103)(CUR$.SL$)).traceCase$2-((simtst103)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simtst103)(CUR$.SL$)).traceCase$2=Math.addExact(((simtst103)(CUR$.SL$)).traceCase$2,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst103.sim","Procedure trace",1,22,9,24,31,25,33,26,40,27,42,29,45,30,49,31,52,32,57,34,61,35);
}
