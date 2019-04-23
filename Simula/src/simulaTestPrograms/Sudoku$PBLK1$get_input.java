package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:20:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Sudoku$PBLK1$get_input extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    InFile$ inspect$63$0=null;
    public Sudoku$PBLK1$get_input(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Sudoku$PBLK1$get_input STM$() {
        sysout().outtext(new TXT$("PUZZLE INPUT:"));
        sysout().outimage();
        {
            inspect$63$0=new InFile$(((BASICIO$)CTX$),new TXT$("SudokuDifficult.txt")).STM$();
            if(inspect$63$0!=null)
            {
                inspect$63$0.open(blanks(80));
                for(boolean CB$66:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$66) continue;
                {
                    for(boolean CB$67:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                       )) { if(!CB$67) continue;
                    ((Sudoku$PBLK1)(CUR$.SL$)).SQinst.Elt[i-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[0]][j-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[1]]=((Sudoku$PBLK1$SQ)new Sudoku$PBLK1$SQ(((Sudoku$PBLK1)(CUR$.SL$)),i,j,inspect$63$0.inint()).START$());
                }
                sysout().outimage();
            }
        }
        inspect$63$0.close();
    }
}
sysout().outimage();
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Procedure get_input",1,58,8,60,11,63,19,62,22,63,26,65,29,66,33,67,38,68,41,69,45,71,49,73,53,74);
}
