package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$lukk_utbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$lukk_utbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$lukk_utbase STM$() {
        ((HegnaNRK)(CUR$.SL$)).utbase$1.close();
        ((HegnaNRK)(CUR$.SL$)).fil_image$1=null;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure lukk_utbase",1,1190,14,1192,16,1193,20,1194);
}
