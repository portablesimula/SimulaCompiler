package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent_innbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    InFile$ inspect$1198$7=null;
    HegnaNRK$PBLK21$format inspect$1220$8=null;
    HegnaNRK$PBLK21$post inspect$1235$9=null;
    public HegnaNRK$PBLK21$hent_innbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$hent_innbase STM$() {
        {
            inspect$1198$7=((HegnaNRK$PBLK21)(CUR$.SL$)).innbase$1;
            if(inspect$1198$7!=null)
            if(VALUE$((!(inspect$1198$7.lastitem())))) {
                new HegnaNRK$PBLK21$hent_innbase$SubBlock1199(CUR$).STM$();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent_innbase",1,1196,8,1198,10,1220,12,1235,20,1198,25,1257,31,1257);
}
