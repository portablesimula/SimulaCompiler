package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$symbolgroup extends CLASS$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<COMMON$symbolbox[]>val=null;
    public COMMON$symbolgroup(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("symbolgroup",88);
        int[] val$LB=new int[1]; int[] val$UB=new int[1];
        val$LB[0]=0; val$UB[0]=255;
        BOUND_CHECK$(val$LB[0],val$UB[0]);
        val=new ARRAY$<COMMON$symbolbox[]>(new COMMON$symbolbox[val$UB[0]-val$LB[0]+1],val$LB,val$UB);
    }
    public COMMON$symbolgroup STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class symbolgroup",1,86,8,88,20,92,23,92);
}
