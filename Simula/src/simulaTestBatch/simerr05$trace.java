package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 20:18:00 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr05$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simerr05$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simerr05$trace(RTObject$ SL$)
    { super(SL$); }
    public simerr05$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simerr05$trace STM$() {
        if(VALUE$(((simerr05)(CUR$.SL$)).verbose)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        if(VALUE$(TXTREL$NE(p$msg,((simerr05)(CUR$.SL$)).facit.Elt[((simerr05)(CUR$.SL$)).traceCase-((simerr05)(CUR$.SL$)).facit.LB[0]]))) {
            {
                ((simerr05)(CUR$.SL$)).found_error=true;
                sysout().outtext(new TXT$("ERROR in Case "));
                sysout().outint(((simerr05)(CUR$.SL$)).traceCase,0);
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Trace: "),p$msg));
                sysout().outimage();
                sysout().outtext(CONC(new TXT$("Facit: "),((simerr05)(CUR$.SL$)).facit.Elt[((simerr05)(CUR$.SL$)).traceCase-((simerr05)(CUR$.SL$)).facit.LB[0]]));
                sysout().outimage();
            }
        }
        ((simerr05)(CUR$.SL$)).traceCase=Math.addExact(((simerr05)(CUR$.SL$)).traceCase,1);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr05.sim","Procedure trace",1,19,29,21,36,22,38,24,41,25,45,26,48,27,53,29,57,30);
}
