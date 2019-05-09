package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$hent_innbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    InFile$ inspect$1198$6=null;
    HegnaNRK$format inspect$1220$7=null;
    HegnaNRK$post inspect$1235$8=null;
    public HegnaNRK$hent_innbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$hent_innbase STM$() {
        {
            inspect$1198$6=((HegnaNRK)(CUR$.SL$)).innbase$1;
            if(inspect$1198$6!=null)
            if(VALUE$((!(inspect$1198$6.lastitem())))) {
                new HegnaNRK$hent_innbase$SubBlock1199(CUR$).STM$();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent_innbase",1,1196,8,1198,10,1220,12,1235,20,1198,25,1257,31,1257);
}
