package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:20:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$PBLK1 extends Simset$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    Head$ SQchain$1=null;
    public ARRAY$<Sudoku$PBLK1$SQ[][]>SQinst=null;
    public Sudoku$PBLK1(RTObject$ staticLink) {
        super(staticLink);
        BPRG("Sudoku$PBLK1");
        int[] SQinst$LB=new int[2]; int[] SQinst$UB=new int[2];
        SQinst$LB[0]=1; SQinst$UB[0]=9;
        BOUND_CHECK$(SQinst$LB[0],SQinst$UB[0]);
        SQinst$LB[1]=1; SQinst$UB[1]=9;
        BOUND_CHECK$(SQinst$LB[1],SQinst$UB[1]);
        SQinst=new ARRAY$<Sudoku$PBLK1$SQ[][]>(new Sudoku$PBLK1$SQ[SQinst$UB[0]-SQinst$LB[0]+1][SQinst$UB[1]-SQinst$LB[1]+1],SQinst$LB,SQinst$UB);
    }
    public Sudoku$PBLK1 STM$() {
        SQchain$1=new Head$(((Sudoku$PBLK1)CUR$)).STM$();
        ((Sudoku$PBLK1$SQexit)new Sudoku$PBLK1$SQexit(((Sudoku$PBLK1)CUR$),false).START$()).into(SQchain$1);
        new Sudoku$PBLK1$get_input(((Sudoku$PBLK1)CUR$));
        ((Sudoku$PBLK1$SQexit)new Sudoku$PBLK1$SQexit(((Sudoku$PBLK1)CUR$),true).START$()).into(SQchain$1);
        resume(SQchain$1.first().suc());
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new Sudoku$PBLK1(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","PrefixedBlock Sudoku$PBLK1",1,1,10,2,15,2,24,76,26,77,28,78,30,79,32,80,41,82);
}
