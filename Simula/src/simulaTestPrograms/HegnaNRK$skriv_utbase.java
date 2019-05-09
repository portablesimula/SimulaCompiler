package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$skriv_utbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    OutFile$ inspect$1261$9=null;
    HegnaNRK$format inspect$1283$10=null;
    HegnaNRK$post inspect$1299$11=null;
    public HegnaNRK$skriv_utbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$skriv_utbase STM$() {
        {
            inspect$1261$9=((HegnaNRK)(CUR$.SL$)).utbase$1;
            if(inspect$1261$9!=null)
            new HegnaNRK$skriv_utbase$SubBlock1262(CUR$).STM$();
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_utbase",1,1259,8,1261,10,1283,12,1299,20,1261,24,1344,29,1344);
}
