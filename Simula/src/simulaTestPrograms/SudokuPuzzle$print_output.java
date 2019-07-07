// JavaLine 1 <== SourceLine 115
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$print_output extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=115, lastLine=124, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 117
    int i=0;
    int j=0;
    // Normal Constructor
    public SudokuPuzzle$print_output(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("print_output",117);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$print_output STM$() {
        TRACE_BEGIN_STM$("print_output",117);
        // JavaLine 25 <== SourceLine 118
        for(boolean CB$118:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$118) continue;
        // JavaLine 29 <== SourceLine 119
        for(boolean CB$119:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$119) continue;
        // JavaLine 33 <== SourceLine 120
        if(VALUE$((!(((SudokuPuzzle)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[1]].Given$2)))) {
            // JavaLine 35 <== SourceLine 121
            new SudokuPuzzle$SQ$button_update(((SudokuPuzzle)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[1]],((SudokuPuzzle)(CUR$.SL$)).green$1);
        }
    }
}
// JavaLine 40 <== SourceLine 122
sysout().outtext(new TXT$("Puzzle solved in"));
sysout().outint(((SudokuPuzzle)(CUR$.SL$)).nSteps$2,8);
sysout().outtext(new TXT$(" steps"));
// JavaLine 44 <== SourceLine 123
sysout().outimage();
TRACE_END_STM$("print_output",123);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure print_output",1,115,10,117,25,118,29,119,33,120,35,121,40,122,44,123,49,124);
} // End of Procedure
