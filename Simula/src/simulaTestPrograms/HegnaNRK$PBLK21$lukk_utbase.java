package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$lukk_utbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$lukk_utbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$lukk_utbase STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).utbase$1.close();
        ((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1=null;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure lukk_utbase",1,1190,14,1192,16,1193,20,1194);
}
