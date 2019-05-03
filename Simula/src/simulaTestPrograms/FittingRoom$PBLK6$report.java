package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:07 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$report extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$message;
    private int $npar=0; // Number of actual parameters transmitted.
    public FittingRoom$PBLK6$report setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$message=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public FittingRoom$PBLK6$report(RTObject$ SL$)
    { super(SL$); }
    public FittingRoom$PBLK6$report(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        this.p$message = sp$message;
        BBLK();
        STM$();
    }
    public FittingRoom$PBLK6$report STM$() {
        sysout().outfix(((FittingRoom$PBLK6)(CUR$.SL$)).time(),2,6);
        sysout().outtext(CONC(new TXT$(": "),p$message));
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure report",1,39,29,40,35,41);
}
