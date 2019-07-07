// JavaLine 1 <== SourceLine 101
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$given_is_good extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=101, lastLine=113, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 103
    int i=0;
    int j=0;
    int check_val=0;
    // JavaLine 17 <== SourceLine 107
    SudokuPuzzle$SQ inspect$107$1=null;
    // Normal Constructor
    public SudokuPuzzle$given_is_good(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("given_is_good",107);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$given_is_good STM$() {
        TRACE_BEGIN_STM$("given_is_good",107);
        // JavaLine 31 <== SourceLine 104
        RESULT$=true;
        // JavaLine 33 <== SourceLine 105
        for(boolean CB$105:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$105) continue;
        // JavaLine 37 <== SourceLine 106
        for(boolean CB$106:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$106) continue;
        // JavaLine 41 <== SourceLine 107
        {
            // BEGIN INSPECTION 
            inspect$107$1=((SudokuPuzzle)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[1]];
            if(inspect$107$1!=null) // INSPECT inspect$107$1
            // JavaLine 46 <== SourceLine 108
            if(VALUE$((inspect$107$1.Given$2&((!(new SudokuPuzzle$SQ$legit(inspect$107$1,inspect$107$1.p2$val).RESULT$)))))) {
                // JavaLine 48 <== SourceLine 109
                {
                    TRACE_BEGIN_STM$("CompoundStatement109",109);
                    new SudokuPuzzle$SQ$button_update(inspect$107$1,((SudokuPuzzle)(CUR$.SL$)).yellow$1);
                    // JavaLine 52 <== SourceLine 110
                    RESULT$=false;
                    // JavaLine 54 <== SourceLine 111
                    sysout().outtext(new TXT$("Invalid sudoku"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement109",111);
                }
            }
        }
    }
}
TRACE_END_STM$("given_is_good",111);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure given_is_good",1,101,13,103,17,107,31,104,33,105,37,106,41,107,46,108,48,109,52,110,54,111,66,113);
} // End of Procedure
