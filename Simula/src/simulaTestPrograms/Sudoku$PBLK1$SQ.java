package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:20:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Sudoku$PBLK1$SQ extends Link$ {
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    public int p2$row;
    public int p2$col;
    public int p2$val;
    public int next_val$2=0;
    public Sudoku$PBLK1$SQ(RTObject$ staticLink,int sp2$row,int sp2$col,int sp2$val) {
        super(staticLink);
        this.p2$row = sp2$row;
        this.p2$col = sp2$col;
        this.p2$val = sp2$val;
        TRACE_BEGIN_DCL$("SQ",40);
    }
    public Sudoku$PBLK1$SQ STM$() {
        sysout().outint(p2$val,2);
        if(VALUE$((p2$val==(0)))) {
            into(((Sudoku$PBLK1)(CUR$.SL$)).SQchain$1);
        }
        detach();
        while(true) {
            {
                for(boolean CB$48:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){next_val$2=(int)x$; return(x$);};  public Number get(){return((Number)next_val$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$48) continue;
                if(VALUE$(new Sudoku$PBLK1$SQ$legit(((Sudoku$PBLK1$SQ)CUR$),next_val$2).RESULT$)) {
                    {
                        p2$val=next_val$2;
                        resume(suc());
                    }
                }
            }
            p2$val=0;
            resume(pred());
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Class SQ",1,20,12,22,22,42,24,43,26,44,29,45,31,47,33,48,38,49,40,50,43,51,48,53,50,55,55,42,58,56);
}
