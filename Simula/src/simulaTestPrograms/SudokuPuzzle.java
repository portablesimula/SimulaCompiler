// JavaLine 1 <== SourceLine 12
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle extends Drawing$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=12, lastLine=140, hasLocalClasses=true, System=true, detachUsed=false
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 126
    Head$ SQchain$2=null;
    // JavaLine 13 <== SourceLine 127
    public ARRAY$<SudokuPuzzle$SQ[][]>SQinst=null;
    // JavaLine 15 <== SourceLine 128
    int flow$2=0;
    int nSteps$2=0;
    int maxSteps$2=0;
    // JavaLine 19 <== SourceLine 129
    char c$2=0;
    // Normal Constructor
    public SudokuPuzzle(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        // Parameter assignment to locals
        BPRG("SudokuPuzzle");
        // Declaration Code
        TRACE_BEGIN_DCL$("SudokuPuzzle",129);
        // JavaLine 28 <== SourceLine 127
        int[] SQinst$LB=new int[2]; int[] SQinst$UB=new int[2];
        SQinst$LB[0]=1; SQinst$UB[0]=9;
        BOUND_CHECK$(SQinst$LB[0],SQinst$UB[0]);
        SQinst$LB[1]=1; SQinst$UB[1]=9;
        BOUND_CHECK$(SQinst$LB[1],SQinst$UB[1]);
        SQinst=new ARRAY$<SudokuPuzzle$SQ[][]>(new SudokuPuzzle$SQ[SQinst$UB[0]-SQinst$LB[0]+1][SQinst$UB[1]-SQinst$LB[1]+1],SQinst$LB,SQinst$UB);
    }
    // Class Statements
    public SudokuPuzzle STM$() {
        TRACE_BEGIN_STM$("SudokuPuzzle",127);
        // Class Simset: Code before inner
        // Class Drawing: Code before inner
        // Class SudokuPuzzle: Code before inner
        // JavaLine 42 <== SourceLine 131
        setStroke(((float)(2)));
        // JavaLine 44 <== SourceLine 132
        setDrawColor(black$1);
        // JavaLine 46 <== SourceLine 133
        setFontSize(((float)(26)));
        // JavaLine 48 <== SourceLine 134
        new SudokuPuzzle$get_input(((SudokuPuzzle)(CUR$)));
        // JavaLine 50 <== SourceLine 135
        nSteps$2=0;
        maxSteps$2=2500;
        // JavaLine 53 <== SourceLine 136
        sysout().outtext(new TXT$("Do you want flow tracking (Y/N): "));
        sysout().breakoutimage();
        // JavaLine 56 <== SourceLine 137
        c$2=sysin().inchar();
        // JavaLine 58 <== SourceLine 138
        if(VALUE$(((c$2==('y'))|((c$2==('Y')))))) {
            flow$2=1;
        }
        // JavaLine 62 <== SourceLine 139
        if(VALUE$(new SudokuPuzzle$given_is_good(((SudokuPuzzle)(CUR$))).RESULT$)) {
            resume(SQchain$2.first());
        }
        TRACE_END_STM$("SudokuPuzzle",139);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new SudokuPuzzle(CTX$,new TXT$("Sudoku"),540,540).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","PrefixedBlock SudokuPuzzle",1,12,11,126,13,127,15,128,19,129,28,127,42,131,44,132,46,133,48,134,50,135,53,136,56,137,58,138,62,139,75,140);
} // End of Class
