package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:00:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr02$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr02$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr02$trace(RTObject$ SL$)
    { super(SL$); }
    public simerr02$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simerr02$trace STM$() {
        if(VALUE$(((simerr02)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simerr02)(CUR$.SL$)).facit.Elt[((simerr02)(CUR$.SL$)).traceCase-((simerr02)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simerr02)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simerr02)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simerr02)(CUR$.SL$)).facit.Elt[((simerr02)(CUR$.SL$)).traceCase-((simerr02)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simerr02)(CUR$.SL$)).traceCase=Math.addExact(((simerr02)(CUR$.SL$)).traceCase,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr02.sim","Procedure trace",1,20,29,22,36,23,38,25,41,26,45,27,48,28,53,30,57,31);
}
