// JavaLine 1 <== SourceLine 87
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SudokuPuzzle$$SudokuPuzzle$PBLK19$SQexit extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=87, lastLine=91, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQexit(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("SQexit",87);
    }
    // Class Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$SQexit STM$() {
        TRACE_BEGIN_STM$("SQexit",87);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 23 <== SourceLine 89
        // Class SQexit: Code before inner
        detach();
        // JavaLine 26 <== SourceLine 90
        new SudokuPuzzle$$SudokuPuzzle$PBLK19$print_output(((SudokuPuzzle$PBLK19)(CUR$.SL$)));
        // JavaLine 28 <== SourceLine 89
        // Class SQexit: Code after inner
        TRACE_END_STM$("SQexit",89);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Class SQexit",1,87,23,89,26,90,28,89,33,91);
} // End of Class
