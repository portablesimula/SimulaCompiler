// JavaLine 1 <== SourceLine 93
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:47:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SudokuPuzzle$$SudokuPuzzle$PBLK19$get_input extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=93, lastLine=106, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 95
    int i=0;
    int j=0;
    // JavaLine 13 <== SourceLine 97
    InFile$ inspect$97$0=null;
    // Normal Constructor
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$get_input(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("get_input",97);
        STM$();
    }
    // Procedure Statements
    public SudokuPuzzle$$SudokuPuzzle$PBLK19$get_input STM$() {
        TRACE_BEGIN_STM$("get_input",97);
        // JavaLine 27 <== SourceLine 96
        ((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQchain$2=new Head$(((SudokuPuzzle$PBLK19)(CUR$.SL$))).STM$();
        // JavaLine 29 <== SourceLine 97
        {
            // BEGIN INSPECTION 
            inspect$97$0=new InFile$(((BASICIO$)CTX$),new TXT$("data/SudokuPuzzle.sdk")).STM$();
            if(inspect$97$0!=null) // INSPECT inspect$97$0
            // JavaLine 34 <== SourceLine 98
            {
                TRACE_BEGIN_STM$("CompoundStatement98",98);
                inspect$97$0.open(blanks(80));
                // JavaLine 38 <== SourceLine 99
                sysout().outimage();
                // JavaLine 40 <== SourceLine 100
                for(boolean CB$100:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$100) continue;
                // JavaLine 44 <== SourceLine 101
                for(boolean CB$101:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$101) continue;
                // JavaLine 48 <== SourceLine 102
                ((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.Elt[i-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[0]][j-((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQinst.LB[1]]=((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ)new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQ(((SudokuPuzzle$PBLK19)(CUR$.SL$)),i,j,inspect$97$0.inint()).START$());
            }
        }
        // JavaLine 52 <== SourceLine 103
        inspect$97$0.close();
        TRACE_END_STM$("CompoundStatement98",103);
    }
}
// JavaLine 57 <== SourceLine 105
((SudokuPuzzle$$SudokuPuzzle$PBLK19$SQexit)new SudokuPuzzle$$SudokuPuzzle$PBLK19$SQexit(((SudokuPuzzle$PBLK19)(CUR$.SL$))).START$()).into(((SudokuPuzzle$PBLK19)(CUR$.SL$)).SQchain$2);
TRACE_END_STM$("get_input",105);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SudokuPuzzle.sim","Procedure get_input",1,93,10,95,13,97,27,96,29,97,34,98,38,99,40,100,44,101,48,102,52,103,57,105,62,106);
} // End of Procedure
