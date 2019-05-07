package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 14:57:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public trace(RTObject$ SL$)
    { super(SL$); }
    public trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public trace STM$() {
        sysout().outtext(p$msg);
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Procedure trace",1,28,29,30,34,31);
}
