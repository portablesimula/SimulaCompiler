package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:27:08 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    int count=0;
    char null$=0;
    public ARRAY$<char[][]>board=null;
    NoughtsAndCrosses$Crosser Cross_Player=null;
    NoughtsAndCrosses$Noughter Nought_Player=null;
    public NoughtsAndCrosses(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("NoughtsAndCrosses");
        int[] board$LB=new int[2]; int[] board$UB=new int[2];
        board$LB[0]=1; board$UB[0]=3;
        BOUND_CHECK$(board$LB[0],board$UB[0]);
        board$LB[1]=1; board$UB[1]=3;
        BOUND_CHECK$(board$LB[1],board$UB[1]);
        board=new ARRAY$<char[][]>(new char[board$UB[0]-board$LB[0]+1][board$UB[1]-board$LB[1]+1],board$LB,board$UB);
    }
    public RTObject$ STM$() {
        Cross_Player=((NoughtsAndCrosses$Crosser)new NoughtsAndCrosses$Crosser(((NoughtsAndCrosses)CUR$),'X').START$());
        Nought_Player=((NoughtsAndCrosses$Noughter)new NoughtsAndCrosses$Noughter(((NoughtsAndCrosses)CUR$),'O').START$());
        Cross_Player.oponent=Nought_Player;
        Nought_Player.oponent=Cross_Player;
        resume(Cross_Player);
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new NoughtsAndCrosses(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","SimulaProgram NoughtsAndCrosses",1,2,10,3,12,4,14,5,16,6,22,4,31,72,33,73,35,74,37,75,39,77,48,79);
}
