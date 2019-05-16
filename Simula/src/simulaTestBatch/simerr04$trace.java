package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:16:56 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr04$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr04$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr04$trace(RTObject$ SL$)
    { super(SL$); }
    public simerr04$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simerr04$trace STM$() {
        if(VALUE$(((simerr04)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simerr04)(CUR$.SL$)).facit.Elt[((simerr04)(CUR$.SL$)).traceCase-((simerr04)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simerr04)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simerr04)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simerr04)(CUR$.SL$)).facit.Elt[((simerr04)(CUR$.SL$)).traceCase-((simerr04)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simerr04)(CUR$.SL$)).traceCase=Math.addExact(((simerr04)(CUR$.SL$)).traceCase,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr04.sim","Procedure trace",1,16,29,18,36,19,38,21,41,22,45,23,48,24,53,26,57,27);
}
