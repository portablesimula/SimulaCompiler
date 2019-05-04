package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class ArrayAsParameter$CC extends CLASS$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<?> p$AAA;
    public ARRAY$<int[][]>B2=null;
    public int m=0;
    public ArrayAsParameter$CC next=null;
    public ArrayAsParameter$CC(RTObject$ staticLink,ARRAY$<?> sp$AAA) {
        super(staticLink);
        this.p$AAA = sp$AAA;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("CC",13);
        int[] B2$LB=new int[2]; int[] B2$UB=new int[2];
        B2$LB[0]=7; B2$UB[0]=89;
        BOUND_CHECK$(B2$LB[0],B2$UB[0]);
        B2$LB[1]=45; B2$UB[1]=97;
        BOUND_CHECK$(B2$LB[1],B2$UB[1]);
        B2=new ARRAY$<int[][]>(new int[B2$UB[0]-B2$LB[0]+1][B2$UB[1]-B2$LB[1]+1],B2$LB,B2$UB);
    }
    public ArrayAsParameter$CC STM$() {
        m=((ARRAY$<int[]>)p$AAA).Elt[74-p$AAA.LB[0]];
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ArrayAsParameter.sim","Class CC",1,9,9,11,11,12,13,13,20,11,32,15);
}
