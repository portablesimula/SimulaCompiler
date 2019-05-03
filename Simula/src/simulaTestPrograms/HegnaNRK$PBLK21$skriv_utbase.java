package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_utbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    OutFile$ inspect$1261$10=null;
    HegnaNRK$PBLK21$format inspect$1283$11=null;
    HegnaNRK$PBLK21$post inspect$1299$12=null;
    public HegnaNRK$PBLK21$skriv_utbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$skriv_utbase STM$() {
        {
            inspect$1261$10=((HegnaNRK$PBLK21)(CUR$.SL$)).utbase$1;
            if(inspect$1261$10!=null)
            new HegnaNRK$PBLK21$skriv_utbase$SubBlock1262(CUR$).STM$();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_utbase",1,1259,8,1261,10,1283,12,1299,20,1261,24,1344,29,1344);
}
