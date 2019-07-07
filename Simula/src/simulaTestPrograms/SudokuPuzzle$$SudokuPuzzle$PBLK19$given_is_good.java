// JavaLine 1 <== SourceLine 108
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$$SudokuPuzzle$PBLK19$given_is_good extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=108, lastLine=120, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 110
    int i=0;
    int j=0;
    int check_val=0;
    // JavaLine 17 <== SourceLine 114
    SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ inspect$114$1=null;
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$given_is_good(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("given_is_good",114);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$given_is_good STM$() {
        TRACE_BEGIN_STM$("given_is_good",114);
        // JavaLine 31 <== SourceLine 111
        RESULT$=true;
        // JavaLine 33 <== SourceLine 112
        for(boolean CB$112:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$112) continue;
        // JavaLine 37 <== SourceLine 113
        for(boolean CB$113:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
           )) { if(!CB$113) continue;
        // JavaLine 41 <== SourceLine 114
        {
            // BEGIN INSPECTION 
            inspect$114$1=((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[1]];
            if(inspect$114$1!=null) // INSPECT inspect$114$1
            // JavaLine 46 <== SourceLine 115
            if(VALUE$((inspect$114$1.Given$2&((!(new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$legit(inspect$114$1,inspect$114$1.p2$val).RESULT$)))))) {
                // JavaLine 48 <== SourceLine 116
                {
                    TRACE_BEGIN_STM$("CompoundStatement116",116);
                    new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ$button_update(inspect$114$1,((SudokuPuzzle$PBLK19)(CUR$.SL$)).yellow$1);
                    // JavaLine 52 <== SourceLine 117
                    RESULT$=false;
                    // JavaLine 54 <== SourceLine 118
                    sysout().outtext(new TXT$("Invalid sudoku"));
                    sysout().outimage();
                    TRACE_END_STM$("CompoundStatement116",118);
                }
            }
        }
    }
}
TRACE_END_STM$("given_is_good",118);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure given_is_good",1,108,13,110,17,114,31,111,33,112,37,113,41,114,46,115,48,116,52,117,54,118,66,120);
} // End of Procedure
