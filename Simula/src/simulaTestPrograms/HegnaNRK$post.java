package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$post extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$antall;
    public ARRAY$<int[]>feltnr=null;
    public ARRAY$<HegnaNRK$verdi[]>felt=null;
    public HegnaNRK$post(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("post",253);
        int[] feltnr$LB=new int[1]; int[] feltnr$UB=new int[1];
        feltnr$LB[0]=1; feltnr$UB[0]=p$antall;
        BOUND_CHECK$(feltnr$LB[0],feltnr$UB[0]);
        feltnr=new ARRAY$<int[]>(new int[feltnr$UB[0]-feltnr$LB[0]+1],feltnr$LB,feltnr$UB);
        int[] felt$LB=new int[1]; int[] felt$UB=new int[1];
        felt$LB[0]=1; felt$UB[0]=p$antall;
        BOUND_CHECK$(felt$LB[0],felt$UB[0]);
        felt=new ARRAY$<HegnaNRK$verdi[]>(new HegnaNRK$verdi[felt$UB[0]-felt$LB[0]+1],felt$LB,felt$UB);
    }
    public HegnaNRK$post STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class post",1,250,9,252,11,253,18,252,23,253,30,254,33,254);
}
