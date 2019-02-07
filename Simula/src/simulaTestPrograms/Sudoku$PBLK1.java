// JavaLine 1 ==> SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:41:55 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$PBLK1 extends Simset$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=1, lastLine=82, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    Head$ SQchain=null;
    // JavaLine 13 ==> SourceLine 2
    public ARRAY$<Sudoku$PBLK1$SQ[][]>SQinst=null;
    // Normal Constructor
    public Sudoku$PBLK1(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("Sudoku$PBLK1");
        // Declaration Code
        TRACE_BEGIN_DCL$("Sudoku$PBLK1",73);
        // JavaLine 22 ==> SourceLine 2
        int[] SQinst$LB=new int[2]; int[] SQinst$UB=new int[2];
        SQinst$LB[0]=1; SQinst$UB[0]=9;
        BOUND_CHECK$(SQinst$LB[0],SQinst$UB[0]);
        SQinst$LB[1]=1; SQinst$UB[1]=9;
        BOUND_CHECK$(SQinst$LB[1],SQinst$UB[1]);
        SQinst=new ARRAY$<Sudoku$PBLK1$SQ[][]>(new Sudoku$PBLK1$SQ[SQinst$UB[0]-SQinst$LB[0]+1][SQinst$UB[1]-SQinst$LB[1]+1],SQinst$LB,SQinst$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Sudoku$PBLK1",2,inner);
                // JavaLine 33 ==> SourceLine 76
                SQchain=new Head$(((Sudoku$PBLK1)CUR$)).STM$();
                // JavaLine 35 ==> SourceLine 77
                new Sudoku$PBLK1$SQexit(((Sudoku$PBLK1)CUR$),false).START().into(SQchain);
                // JavaLine 37 ==> SourceLine 78
                new Sudoku$PBLK1$get_input(((Sudoku$PBLK1)CUR$));
                // JavaLine 39 ==> SourceLine 79
                new Sudoku$PBLK1$SQexit(((Sudoku$PBLK1)CUR$),true).START().into(SQchain);
                // JavaLine 41 ==> SourceLine 80
                resume(SQchain.first().suc());
                TRACE_END_STM$("Sudoku$PBLK1",80);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Sudoku$PBLK1(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","PrefixedBlock Sudoku$PBLK1",1,1,13,2,22,2,33,76,35,77,37,78,39,79,41,80,52,82);
}
