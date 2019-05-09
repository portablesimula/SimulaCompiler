package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$lukk_innbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$lukk_innbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$lukk_innbase STM$() {
        ((HegnaNRK)(CUR$.SL$)).innbase$1.close();
        ((HegnaNRK)(CUR$.SL$)).fil_image$1=null;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure lukk_innbase",1,1184,14,1186,16,1187,20,1188);
}
