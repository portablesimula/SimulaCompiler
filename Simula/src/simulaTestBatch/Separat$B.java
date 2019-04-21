package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Apr 21 13:18:11 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Separat$B extends Separat$A {
    public int prefixLevel() { return(1); }
    public ARRAY$<float[]>X=null;
    public int ord$1=0;
    public Separat$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",44);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new Separat$P(((Separat)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public Separat$B STM$() {
        ord=((Separat)(CUR$.SL$)).nA=(((Separat)(CUR$.SL$)).nA+(1));
        new Separat$Event(((Separat)(CUR$.SL$)),2,234);
        ord$1=((Separat)(CUR$.SL$)).nB=(((Separat)(CUR$.SL$)).nB+(1));
        new Separat$Event(((Separat)(CUR$.SL$)),3,729);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Separat.sim","Class B",1,41,8,42,10,43,15,42,22,37,24,38,26,45,28,46,30,45,33,47);
}
