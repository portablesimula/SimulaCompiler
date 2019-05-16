package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:11:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr03$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr03$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr03$trace(RTObject$ SL$)
    { super(SL$); }
    public simerr03$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simerr03$trace STM$() {
        if(VALUE$(((simerr03)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simerr03)(CUR$.SL$)).facit.Elt[((simerr03)(CUR$.SL$)).traceCase-((simerr03)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simerr03)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simerr03)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simerr03)(CUR$.SL$)).facit.Elt[((simerr03)(CUR$.SL$)).traceCase-((simerr03)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simerr03)(CUR$.SL$)).traceCase=Math.addExact(((simerr03)(CUR$.SL$)).traceCase,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr03.sim","Procedure trace",1,18,29,20,36,21,38,23,41,24,45,25,48,26,53,28,57,29);
}
