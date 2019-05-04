package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:42:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue23 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<float[]>ra=null;
    public issue23(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue23");
        int[] ra$LB=new int[1]; int[] ra$UB=new int[1];
        ra$LB[0]=1; ra$UB[0]=10;
        BOUND_CHECK$(ra$LB[0],ra$UB[0]);
        ra=new ARRAY$<float[]>(new float[ra$UB[0]-ra$LB[0]+1],ra$LB,ra$UB);
    }
    public RTObject$ STM$() {
        ra.Elt[1-ra.LB[0]]=((float)(7));
        new issue23$PP(((issue23)CUR$),ra);
        new issue23$PQ(((issue23)CUR$),new PRCQNT$(((issue23)CUR$),issue23$theP.class));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new issue23(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue23.sim","SimulaProgram issue23",1,1,13,1,20,12,22,13,24,14,33,15);
}
