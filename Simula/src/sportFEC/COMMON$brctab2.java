package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class COMMON$brctab2 extends CLASS$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<COMMON$brecord[]>val=null;
    public COMMON$brctab2(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("brctab2",808);
        int[] val$LB=new int[1]; int[] val$UB=new int[1];
        val$LB[0]=0; val$UB[0]=255;
        BOUND_CHECK$(val$LB[0],val$UB[0]);
        val=new ARRAY$<COMMON$brecord[]>(new COMMON$brecord[val$UB[0]-val$LB[0]+1],val$LB,val$UB);
    }
    public COMMON$brctab2 STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Class brctab2",1,806,8,808,20,810,23,810);
}
