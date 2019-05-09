package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:14:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TQueens extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<int[]>q=null;
    public ARRAY$<int[]>u=null;
    public ARRAY$<int[]>d=null;
    public TQueens(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("TQueens");
        int[] q$LB=new int[1]; int[] q$UB=new int[1];
        q$LB[0]=(-(17)); q$UB[0]=17;
        BOUND_CHECK$(q$LB[0],q$UB[0]);
        q=new ARRAY$<int[]>(new int[q$UB[0]-q$LB[0]+1],q$LB,q$UB);
        int[] u$LB=new int[1]; int[] u$UB=new int[1];
        u$LB[0]=(-(17)); u$UB[0]=17;
        BOUND_CHECK$(u$LB[0],u$UB[0]);
        u=new ARRAY$<int[]>(new int[u$UB[0]-u$LB[0]+1],u$LB,u$UB);
        int[] d$LB=new int[1]; int[] d$UB=new int[1];
        d$LB[0]=(-(17)); d$UB[0]=17;
        BOUND_CHECK$(d$LB[0],d$UB[0]);
        d=new ARRAY$<int[]>(new int[d$UB[0]-d$LB[0]+1],d$LB,d$UB);
    }
    public RTObject$ STM$() {
        new TQueens$p(((TQueens)CUR$),0,17,q.COPY(),u.COPY(),d.COPY());
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new TQueens(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("TQueens.sim","SimulaProgram TQueens",1,6,15,6,30,16,39,17);
}
