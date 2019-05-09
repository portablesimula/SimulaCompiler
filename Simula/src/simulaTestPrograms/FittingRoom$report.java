package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:41:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$report extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$message;
    private int $npar=0; // Number of actual parameters transmitted.
    public FittingRoom$report setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$message=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public FittingRoom$report(RTObject$ SL$)
    { super(SL$); }
    public FittingRoom$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        this.p$message = sp$message;
        BBLK();
        STM$();
    }
    public FittingRoom$report STM$() {
        sysout().outfix(((FittingRoom)(CUR$.SL$)).time(),2,6);
        sysout().outtext(CONC(new TXT$(": "),p$message));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure report",1,39,29,40,35,41);
}
