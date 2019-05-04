package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Separat$B extends Separat$A {
    public int prefixLevel() { return(1); }
    public ARRAY$<float[]>X=null;
    public int ord$1=0;
    public Separat$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",49);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new Separat$P(((Separat)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public Separat$B STM$() {
        ord=((Separat)(CUR$.SL$)).nA=(((Separat)(CUR$.SL$)).nA+(1));
        new Separat$Print(((Separat)(CUR$.SL$)),CONC(new TXT$("Event A-1: "),new Separat$A$idA(((Separat$A)CUR$)).RESULT$));
        ord$1=((Separat)(CUR$.SL$)).nB=(((Separat)(CUR$.SL$)).nB+(1));
        new Separat$Print(((Separat)(CUR$.SL$)),CONC(new TXT$("Event B-1: "),new Separat$B$idB(((Separat$B)CUR$)).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Class B",1,46,8,47,10,48,15,47,22,42,24,43,26,50,28,51,30,50,33,52);
}
