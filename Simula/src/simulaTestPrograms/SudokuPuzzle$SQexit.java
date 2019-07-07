// JavaLine 1 <== SourceLine 80
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SudokuPuzzle$SQexit extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=80, lastLine=84, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SudokuPuzzle$SQexit(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("SQexit",80);
    }
    // Class Statements
    public SudokuPuzzle$SQexit STM$() {
        TRACE_BEGIN_STM$("SQexit",80);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 23 <== SourceLine 82
        // Class SQexit: Code before inner
        detach();
        // JavaLine 26 <== SourceLine 83
        new SudokuPuzzle$print_output(((SudokuPuzzle)(CUR$.SL$)));
        // JavaLine 28 <== SourceLine 82
        // Class SQexit: Code after inner
        TRACE_END_STM$("SQexit",82);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Class SQexit",1,80,23,82,26,83,28,82,33,84);
} // End of Class
