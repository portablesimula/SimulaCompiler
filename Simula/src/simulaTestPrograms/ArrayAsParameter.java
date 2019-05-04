package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ArrayAsParameter extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public ARRAY$<ArrayAsParameter$CC[]>R=null;
    public ARRAY$<int[]>A=null;
    public ARRAY$<int[][]>A2=null;
    int x=0;
    ArrayAsParameter$CC cx=null;
    public ArrayAsParameter(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("ArrayAsParameter");
        int[] R$LB=new int[1]; int[] R$UB=new int[1];
        R$LB[0]=1; R$UB[0]=312;
        BOUND_CHECK$(R$LB[0],R$UB[0]);
        R=new ARRAY$<ArrayAsParameter$CC[]>(new ArrayAsParameter$CC[R$UB[0]-R$LB[0]+1],R$LB,R$UB);
        int[] A$LB=new int[1]; int[] A$UB=new int[1];
        A$LB[0]=7; A$UB[0]=89;
        BOUND_CHECK$(A$LB[0],A$UB[0]);
        A=new ARRAY$<int[]>(new int[A$UB[0]-A$LB[0]+1],A$LB,A$UB);
        int[] A2$LB=new int[2]; int[] A2$UB=new int[2];
        A2$LB[0]=7; A2$UB[0]=89;
        BOUND_CHECK$(A2$LB[0],A2$UB[0]);
        A2$LB[1]=45; A2$UB[1]=97;
        BOUND_CHECK$(A2$LB[1],A2$UB[1]);
        A2=new ARRAY$<int[][]>(new int[A2$UB[0]-A2$LB[0]+1][A2$UB[1]-A2$LB[1]+1],A2$LB,A2$UB);
    }
    public RTObject$ STM$() {
        A.Elt[8-A.LB[0]]=45;
        x=A.Elt[88-A.LB[0]];
        A2.Elt[9-A2.LB[0]][56-A2.LB[1]]=45;
        x=A2.Elt[37-A2.LB[0]][78-A2.LB[1]];
        cx=new ArrayAsParameter$CC(((ArrayAsParameter)CUR$),A).STM$();
        cx.next=new ArrayAsParameter$CC(((ArrayAsParameter)CUR$),A).STM$();
        ((ARRAY$<int[]>)cx.p$AAA).Elt[(x+(9))-cx.p$AAA.LB[0]]=134;
        ((ARRAY$<int[]>)cx.next.p$AAA).Elt[(x+(11))-cx.next.p$AAA.LB[0]]=134;
        ((ARRAY$<int[][]>)cx.next.B2).Elt[(x+(15))-cx.next.B2.LB[0]][48-cx.next.B2.LB[1]]=134;
        R.Elt[45-R.LB[0]]=cx;
        cx.next=R.Elt[89-R.LB[0]];
        new ArrayAsParameter$Proc(((ArrayAsParameter)CUR$),A);
        new ArrayAsParameter$CC(((ArrayAsParameter)CUR$),A).STM$();
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new ArrayAsParameter(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ArrayAsParameter.sim","SimulaProgram ArrayAsParameter",1,3,10,4,12,5,14,6,16,7,22,3,27,4,32,5,41,23,43,24,45,25,47,26,49,27,51,28,53,29,55,30,57,31,59,33,61,34,63,36,65,37,74,38);
}
