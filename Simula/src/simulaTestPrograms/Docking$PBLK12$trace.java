package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$trace extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$msg;
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK12$trace setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Docking$PBLK12$trace(RTObject$ SL$)
    { super(SL$); }
    public Docking$PBLK12$trace(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        this.p$msg = sp$msg;
        BBLK();
        STM$();
    }
    public Docking$PBLK12$trace STM$() {
        if(VALUE$(((Docking$PBLK12)(CUR$.SL$)).verbose$2)) {
            {
                sysout().outtext(p$msg);
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure trace",1,15,29,16,31,17,39,17);
}
