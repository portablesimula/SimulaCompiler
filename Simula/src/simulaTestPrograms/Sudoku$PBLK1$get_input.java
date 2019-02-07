// JavaLine 1 ==> SourceLine 58
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:41:55 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$PBLK1$get_input extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=58, lastLine=74, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 60
    int i=0;
    int j=0;
    // JavaLine 14 ==> SourceLine 63
    InFile$ inspect$63$0=null;
    // Normal Constructor
    public Sudoku$PBLK1$get_input(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("get_input",63);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Sudoku$PBLK1$get_input STM$() {
        TRACE_BEGIN_STM$("get_input",63);
        // JavaLine 28 ==> SourceLine 62
        sysout().outtext(new TXT$("PUZZLE INPUT:"));
        sysout().outimage();
        // JavaLine 31 ==> SourceLine 63
        {
            // BEGIN INSPECTION 
            inspect$63$0=new InFile$(((BASICIO$)CTX$),new TXT$("SudokuDifficult.txt")).STM$();
            if(inspect$63$0!=null) //INSPECT inspect$63$0
            // JavaLine 36 ==> SourceLine 65
            {
                TRACE_BEGIN_STM$("CompoundStatement65",65);
                inspect$63$0.open(blanks(80));
                // JavaLine 40 ==> SourceLine 66
                for(boolean CB$66:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$66) continue;
                // JavaLine 44 ==> SourceLine 67
                {
                    TRACE_BEGIN_STM$("CompoundStatement67",67);
                    for(boolean CB$67:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                       )) { if(!CB$67) continue;
                    // JavaLine 50 ==> SourceLine 68
                    ((Sudoku$PBLK1)(CUR$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[0]][j-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[1]]=new Sudoku$PBLK1$SQ(((Sudoku$PBLK1)(CUR$.SL$)),i,j,inspect$63$0.inint()).START();
                }
                // JavaLine 53 ==> SourceLine 69
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement67",69);
            }
        }
        // JavaLine 58 ==> SourceLine 71
        inspect$63$0.close();
        TRACE_END_STM$("CompoundStatement65",71);
    }
}
// JavaLine 63 ==> SourceLine 73
sysout().outimage();
TRACE_END_STM$("get_input",73);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Procedure get_input",1,58,11,60,14,63,28,62,31,63,36,65,40,66,44,67,50,68,53,69,58,71,63,73,68,74);
}
