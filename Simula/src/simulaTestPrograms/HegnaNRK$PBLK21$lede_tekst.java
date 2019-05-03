package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$lede_tekst extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$tekst;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$lede_tekst setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$tekst=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$lede_tekst(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$lede_tekst(RTObject$ SL$,TXT$ sp$tekst) {
        super(SL$);
        this.p$tekst = sp$tekst;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$lede_tekst STM$() {
        if(VALUE$((TXT$.length(TXT$.strip(sysin().image))<(TXT$.pos(sysin().image))))) {
            {
                sysout().outtext(p$tekst);
                sysout().breakoutimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure lede_tekst",1,323,29,326,31,328,34,329,40,331);
}
