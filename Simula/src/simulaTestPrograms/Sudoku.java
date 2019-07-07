// JavaLine 1 <== SourceLine 1
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:08:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku extends Simset$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=1, lastLine=81, hasLocalClasses=true, System=true, detachUsed=false
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    Head$ SQchain$1=null;
    // JavaLine 12 <== SourceLine 2
    public ARRAY$<Sudoku$SQ[][]>SQinst=null;
    // Normal Constructor
    public Sudoku(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("Sudoku");
        // Declaration Code
        TRACE_BEGIN_DCL$("Sudoku",72);
        // JavaLine 21 <== SourceLine 2
        int[] SQinst$LB=new int[2]; int[] SQinst$UB=new int[2];
        SQinst$LB[0]=1; SQinst$UB[0]=9;
        BOUND_CHECK$(SQinst$LB[0],SQinst$UB[0]);
        SQinst$LB[1]=1; SQinst$UB[1]=9;
        BOUND_CHECK$(SQinst$LB[1],SQinst$UB[1]);
        SQinst=new ARRAY$<Sudoku$SQ[][]>(new Sudoku$SQ[SQinst$UB[0]-SQinst$LB[0]+1][SQinst$UB[1]-SQinst$LB[1]+1],SQinst$LB,SQinst$UB);
    }
    // Class Statements
    public Sudoku STM$() {
        TRACE_BEGIN_STM$("Sudoku",2);
        // Class Simset: Code before inner
        // Class Sudoku: Code before inner
        // JavaLine 34 <== SourceLine 75
        SQchain$1=new Head$(((Sudoku)(CUR$))).STM$();
        // JavaLine 36 <== SourceLine 76
        ((Sudoku$SQexit)new Sudoku$SQexit(((Sudoku)(CUR$)),false).START$()).into(SQchain$1);
        // JavaLine 38 <== SourceLine 77
        new Sudoku$get_input(((Sudoku)(CUR$)));
        // JavaLine 40 <== SourceLine 78
        ((Sudoku$SQexit)new Sudoku$SQexit(((Sudoku)(CUR$)),true).START$()).into(SQchain$1);
        // JavaLine 42 <== SourceLine 79
        resume(SQchain$1.first().suc());
        TRACE_END_STM$("Sudoku",79);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Sudoku(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","PrefixedBlock Sudoku",1,1,12,2,21,2,34,75,36,76,38,77,40,78,42,79,53,81);
} // End of Class
