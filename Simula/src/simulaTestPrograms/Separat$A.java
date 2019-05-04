package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Separat$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<float[]>X=null;
    public int ord=0;
    public Separat$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",41);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new Separat$P(((Separat)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public Separat$A STM$() {
        ord=((Separat)(CUR$.SL$)).nA=(((Separat)(CUR$.SL$)).nA+(1));
        new Separat$Print(((Separat)(CUR$.SL$)),CONC(new TXT$("Event A-1: "),new Separat$A$idA(((Separat$A)CUR$)).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Class A",1,38,8,39,10,40,16,39,23,42,25,43,27,42,30,44);
}
