package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$format extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$antall;
    public ARRAY$<int[]>fnr=null;
    public ARRAY$<int[]>spos=null;
    public int ark_lengde=0;
    public HegnaNRK$format(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("format",53);
        int[] fnr$LB=new int[1]; int[] fnr$UB=new int[1];
        fnr$LB[0]=1; fnr$UB[0]=p$antall;
        BOUND_CHECK$(fnr$LB[0],fnr$UB[0]);
        fnr=new ARRAY$<int[]>(new int[fnr$UB[0]-fnr$LB[0]+1],fnr$LB,fnr$UB);
        int[] spos$LB=new int[1]; int[] spos$UB=new int[1];
        spos$LB[0]=1; spos$UB[0]=p$antall;
        BOUND_CHECK$(spos$LB[0],spos$UB[0]);
        spos=new ARRAY$<int[]>(new int[spos$UB[0]-spos$LB[0]+1],spos$LB,spos$UB);
    }
    public HegnaNRK$format STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class format",1,51,9,52,12,53,19,52,30,54,33,54);
}
