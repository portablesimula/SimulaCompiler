// JavaLine 1 <== SourceLine 122
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$$SudokuPuzzle$PBLK19$print_output extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=122, lastLine=131, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 124
    int i=0;
    int j=0;
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$print_output(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("print_output",124);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$print_output STM$() {
        TRACE_BEGIN_STM$("print_output",124);
        // JavaLine 25 <== SourceLine 125
        for(boolean CB$125:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$125) continue;
        // JavaLine 29 <== SourceLine 126
        for(boolean CB$126:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$126) continue;
        // JavaLine 33 <== SourceLine 127
        if(VALUE$((!(((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[1]].Given$2)))) {
            // JavaLine 35 <== SourceLine 128
            new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[1]],((SudokuPuzzle$PBLK19)(CUR$.SL$)).green$1);
        }
    }
}
// JavaLine 40 <== SourceLine 129
sysout().outtext(new TXT$("Puzzle solved in"));
sysout().outint(((SudokuPuzzle$PBLK19)(CUR$.SL$)).nSteps$2,8);
sysout().outtext(new TXT$(" steps"));
// JavaLine 44 <== SourceLine 130
sysout().outimage();
TRACE_END_STM$("print_output",130);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure print_output",1,122,10,124,25,125,29,126,33,127,35,128,40,129,44,130,49,131);
} // End of Procedure
