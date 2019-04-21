package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Separat$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<float[]>X=null;
    public int ord=0;
    public Separat$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",36);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new Separat$P(((Separat)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public Separat$A STM$() {
        ord=((Separat)(CUR$.SL$)).nA=(((Separat)(CUR$.SL$)).nA+(1));
        new Separat$Event(((Separat)(CUR$.SL$)),2,234);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Separat.sim","Class A",1,33,8,34,10,35,16,34,23,37,25,38,27,37,30,39);
}
