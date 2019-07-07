// JavaLine 1 <== SourceLine 86
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:14:25 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$get_input extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=86, lastLine=99, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 88
    int i=0;
    int j=0;
    // JavaLine 13 <== SourceLine 90
    InFile$ inspect$90$0=null;
    // Normal Constructor
    public SudokuPuzzle$get_input(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("get_input",90);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$get_input STM$() {
        TRACE_BEGIN_STM$("get_input",90);
        // JavaLine 27 <== SourceLine 89
        ((SudokuPuzzle)(CUR$.SL$)).SQchain$2=new Head$(((SudokuPuzzle)(CUR$.SL$))).STM$();
        // JavaLine 29 <== SourceLine 90
        {
            // BEGIN INSPECTION 
            inspect$90$0=new InFile$(((BASICIO$)CTX$),new TXT$("data/SudokuPuzzle.sdk")).STM$();
            if(inspect$90$0!=null) // INSPECT inspect$90$0
            // JavaLine 34 <== SourceLine 91
            {
                TRACE_BEGIN_STM$("CompoundStatement91",91);
                inspect$90$0.open(blanks(80));
                // JavaLine 38 <== SourceLine 92
                sysout().outimage();
                // JavaLine 40 <== SourceLine 93
                for(boolean CB$93:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$93) continue;
                // JavaLine 44 <== SourceLine 94
                for(boolean CB$94:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$94) continue;
                // JavaLine 48 <== SourceLine 95
                ((SudokuPuzzle)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle)(CUR$.SL$)).SQinst.LB[1]]=((SudokuPuzzle$SQ)new SudokuPuzzle$SQ(((SudokuPuzzle)(CUR$.SL$)),i,j,inspect$90$0.inint()).START$());
            }
        }
        // JavaLine 52 <== SourceLine 96
        inspect$90$0.close();
        TRACE_END_STM$("CompoundStatement91",96);
    }
}
// JavaLine 57 <== SourceLine 98
((SudokuPuzzle$SQexit)new SudokuPuzzle$SQexit(((SudokuPuzzle)(CUR$.SL$))).START$()).into(((SudokuPuzzle)(CUR$.SL$)).SQchain$2);
TRACE_END_STM$("get_input",98);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure get_input",1,86,10,88,13,90,27,89,29,90,34,91,38,92,40,93,44,94,48,95,52,96,57,98,62,99);
} // End of Procedure
