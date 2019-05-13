package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class MainSeparat$B extends MainSeparat$A {
    public int prefixLevel() { return(1); }
    public ARRAY$<float[]>X=null;
    public int ord$1=0;
    public MainSeparat$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",68);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new MainSeparat$P(((MainSeparat)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public MainSeparat$B STM$() {
        ord=((MainSeparat)(CUR$.SL$)).nA=(((MainSeparat)(CUR$.SL$)).nA+(1));
        new MainSeparat$trace(((MainSeparat)(CUR$.SL$)),CONC(new TXT$("Event A-1: "),new MainSeparat$A$idA(((MainSeparat$A)CUR$)).RESULT$));
        ord$1=((MainSeparat)(CUR$.SL$)).nB=(((MainSeparat)(CUR$.SL$)).nB+(1));
        new MainSeparat$trace(((MainSeparat)(CUR$.SL$)),CONC(new TXT$("Event B-1: "),new MainSeparat$B$idB(((MainSeparat$B)CUR$)).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Class B",1,65,8,66,10,67,15,66,22,61,24,62,26,69,28,70,30,69,33,71);
}
