// JavaLine 1 <== SourceLine 11
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$ extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=11, lastLine=144, hasLocalClasses=false, System=false
    // Declare locals as attributes
    int flow=0;
    // JavaLine 10 <== SourceLine 12
    char c=0;
    // Normal Constructor
    public SudokuPuzzle$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("SudokuPuzzle$");
        // Declaration Code
        TRACE_BEGIN_DCL$("SudokuPuzzle$",12);
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SudokuPuzzle$",12);
        // JavaLine 23 <== SourceLine 14
        sysout().outtext(new TXT$("Do you want flow tracking (Y/N): "));
        sysout().breakoutimage();
        // JavaLine 26 <== SourceLine 15
        c=sysin().inchar();
        // JavaLine 28 <== SourceLine 16
        if(VALUE$(((c==('y'))|((c==('Y')))))) {
            flow=1;
        }
        // JavaLine 32 <== SourceLine 143
        new SudokuPuzzle$PBLK19((CUR$),new TXT$("Sudoku"),540,540).STM$();
        TRACE_END_STM$("SudokuPuzzle$",142);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new SudokuPuzzle$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","SimulaProgram SudokuPuzzle$",1,11,10,12,23,14,26,15,28,16,32,143,43,144);
} // End of SubBlock
