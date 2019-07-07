// JavaLine 1 <== SourceLine 19
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$PBLK19 extends Drawing$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=19, lastLine=143, hasLocalClasses=true, System=true, detachUsed=false
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 133
    Head$ SQchain$2=null;
    // JavaLine 13 <== SourceLine 134
    public ARRAY$<SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ[][]>SQinst=null;
    // JavaLine 15 <== SourceLine 135
    int nSteps$2=0;
    int maxSteps$2=0;
    // Normal Constructor
    public SudokuPuzzle$PBLK19(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("SudokuPuzzle$PBLK19",135);
        // JavaLine 24 <== SourceLine 134
        int[] SQinst$LB=new int[2]; int[] SQinst$UB=new int[2];
        SQinst$LB[0]=1; SQinst$UB[0]=9;
        BOUND_CHECK$(SQinst$LB[0],SQinst$UB[0]);
        SQinst$LB[1]=1; SQinst$UB[1]=9;
        BOUND_CHECK$(SQinst$LB[1],SQinst$UB[1]);
        SQinst=new ARRAY$<SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ[][]>(new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ[SQinst$UB[0]-SQinst$LB[0]+1][SQinst$UB[1]-SQinst$LB[1]+1],SQinst$LB,SQinst$UB);
    }
    // Class Statements
    public SudokuPuzzle$PBLK19 STM$() {
        TRACE_BEGIN_STM$("SudokuPuzzle$PBLK19",134);
        // Class Simset: Code before inner
        // Class Drawing: Code before inner
        // Class SudokuPuzzle$PBLK19: Code before inner
        // JavaLine 38 <== SourceLine 137
        setStroke(((float)(2)));
        // JavaLine 40 <== SourceLine 138
        setDrawColor(black$1);
        // JavaLine 42 <== SourceLine 139
        setFontSize(((float)(26)));
        // JavaLine 44 <== SourceLine 140
        new SudokuPuzzle$$SudokuPuzzle$PBLK19$get_input(((SudokuPuzzle$PBLK19)(CUR$)));
        // JavaLine 46 <== SourceLine 141
        nSteps$2=0;
        maxSteps$2=2500;
        // JavaLine 49 <== SourceLine 142
        if(VALUE$(new SudokuPuzzle$$SudokuPuzzle$PBLK19$given_is_good(((SudokuPuzzle$PBLK19)(CUR$))).RESULT$)) {
            resume(SQchain$2.first());
        }
        TRACE_END_STM$("SudokuPuzzle$PBLK19",142);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","PrefixedBlock SudokuPuzzle$PBLK19",1,19,11,133,13,134,15,135,24,134,38,137,40,138,42,139,44,140,46,141,49,142,56,143);
} // End of Class
