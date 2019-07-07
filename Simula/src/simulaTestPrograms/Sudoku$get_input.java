// JavaLine 1 <== SourceLine 58
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Jul 07 11:08:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$get_input extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=58, lastLine=73, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 60
    int i=0;
    int j=0;
    // JavaLine 13 <== SourceLine 63
    InFile$ inspect$63$0=null;
    // Normal Constructor
    public Sudoku$get_input(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("get_input",63);
        STM$();
    }
    // Procedure Statements
    public Sudoku$get_input STM$() {
        TRACE_BEGIN_STM$("get_input",63);
        // JavaLine 27 <== SourceLine 62
        sysout().outtext(new TXT$("PUZZLE INPUT:"));
        sysout().outimage();
        // JavaLine 30 <== SourceLine 63
        {
            // BEGIN INSPECTION 
            inspect$63$0=new InFile$(((BASICIO$)CTX$),new TXT$("data/SudokuDifficult.txt")).STM$();
            if(inspect$63$0!=null) // INSPECT inspect$63$0
            // JavaLine 35 <== SourceLine 64
            {
                TRACE_BEGIN_STM$("CompoundStatement64",64);
                inspect$63$0.open(blanks(80));
                // JavaLine 39 <== SourceLine 65
                for(boolean CB$65:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$65) continue;
                // JavaLine 43 <== SourceLine 66
                {
                    TRACE_BEGIN_STM$("CompoundStatement66",66);
                    for(boolean CB$66:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                       )) { if(!CB$66) continue;
                    // JavaLine 49 <== SourceLine 67
                    ((Sudoku)(CUR$.SL$)).SQinst.Elt[i-((Sudoku)(CUR$.SL$)).SQinst.LB[0]][j-((Sudoku)(CUR$.SL$)).SQinst.LB[1]]=((Sudoku$SQ)new Sudoku$SQ(((Sudoku)(CUR$.SL$)),i,j,inspect$63$0.inint()).START$());
                }
                // JavaLine 52 <== SourceLine 68
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement66",68);
            }
        }
        // JavaLine 57 <== SourceLine 70
        inspect$63$0.close();
        TRACE_END_STM$("CompoundStatement64",70);
    }
}
// JavaLine 62 <== SourceLine 72
sysout().outimage();
TRACE_END_STM$("get_input",72);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Procedure get_input",1,58,10,60,13,63,27,62,30,63,35,64,39,65,43,66,49,67,52,68,57,70,62,72,67,73);
} // End of Procedure
