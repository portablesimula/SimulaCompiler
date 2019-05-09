package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:37:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku extends Simset$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    Head$ SQchain$1=null;
    public ARRAY$<Sudoku$SQ[][]>SQinst=null;
    public Sudoku(RTObject$ staticLink) {
        super(staticLink);
        BPRG("Sudoku");
        int[] SQinst$LB=new int[2]; int[] SQinst$UB=new int[2];
        SQinst$LB[0]=1; SQinst$UB[0]=9;
        BOUND_CHECK$(SQinst$LB[0],SQinst$UB[0]);
        SQinst$LB[1]=1; SQinst$UB[1]=9;
        BOUND_CHECK$(SQinst$LB[1],SQinst$UB[1]);
        SQinst=new ARRAY$<Sudoku$SQ[][]>(new Sudoku$SQ[SQinst$UB[0]-SQinst$LB[0]+1][SQinst$UB[1]-SQinst$LB[1]+1],SQinst$LB,SQinst$UB);
    }
    public Sudoku STM$() {
        SQchain$1=new Head$(((Sudoku)CUR$)).STM$();
        ((Sudoku$SQexit)new Sudoku$SQexit(((Sudoku)CUR$),false).START$()).into(SQchain$1);
        new Sudoku$get_input(((Sudoku)CUR$));
        ((Sudoku$SQexit)new Sudoku$SQexit(((Sudoku)CUR$),true).START$()).into(SQchain$1);
        resume(SQchain$1.first().suc());
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new Sudoku(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","PrefixedBlock Sudoku",1,1,10,2,15,2,24,76,26,77,28,78,30,79,32,80,41,82);
}
