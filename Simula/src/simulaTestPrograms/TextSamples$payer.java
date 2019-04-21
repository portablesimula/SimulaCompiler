package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:04 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TextSamples$payer extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$T;
    private int $npar=0; // Number of actual parameters transmitted.
    public TextSamples$payer setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$T=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public TextSamples$payer(RTObject$ SL$)
    { super(SL$); }
    public TextSamples$payer(RTObject$ SL$,TXT$ sp$T) {
        super(SL$);
        this.p$T = sp$T;
        BBLK();
        STM$();
    }
    public TextSamples$payer STM$() {
        TXT$.setpos(p$T,6);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("TextSamples.sim","Procedure payer",1,4,29,6,33,7);
}
