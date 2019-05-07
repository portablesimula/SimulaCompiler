package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:18 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst117$Print extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst117$Print setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst117$Print(RTObject$ SL$)
    { super(SL$); }
    public simtst117$Print(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public simtst117$Print STM$() {
        sysout().outtext(p$msg);
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst117.sim","Procedure Print",28,4,33,4);
}
