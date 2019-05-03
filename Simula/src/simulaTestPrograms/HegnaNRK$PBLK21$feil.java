package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$feil extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$feil setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$feil(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$feil(RTObject$ SL$,int sp$i) {
        super(SL$);
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$feil STM$() {
        sysout().outtext(new TXT$("Feilmelding nr.:"));
        sysout().outint(p$i,4);
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure feil",1,258,29,261,31,262,36,263);
}
