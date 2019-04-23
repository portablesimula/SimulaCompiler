package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 23 08:20:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Sudoku$PBLK1$SQexit extends Link$ {
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    public boolean p2$success;
    public int i$2=0;
    public int j$2=0;
    public Sudoku$PBLK1$SQexit(RTObject$ staticLink,boolean sp2$success) {
        super(staticLink);
        this.p2$success = sp2$success;
        TRACE_BEGIN_DCL$("SQexit",5);
    }
    public Sudoku$PBLK1$SQexit STM$() {
        detach();
        if(VALUE$(p2$success)) {
            {
                sysout().outtext(new TXT$("PUZZLE SOLUTION:"));
                sysout().outimage();
                for(boolean CB$9:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i$2=(int)x$; return(x$);};  public Number get(){return((Number)i$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                   )) { if(!CB$9) continue;
                {
                    for(boolean CB$10:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j$2=(int)x$; return(x$);};  public Number get(){return((Number)j$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(9); }})
                       )) { if(!CB$10) continue;
                    sysout().outint(((Sudoku$PBLK1)(CUR$.SL$)).SQinst.Elt[i$2-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[0]][j$2-((Sudoku$PBLK1)(CUR$.SL$)).SQinst.LB[1]].p2$val,2);
                }
                sysout().outimage();
            }
        }
        sysout().outimage();
        sysout().outtext(new TXT$("WE DID IT!"));
    }
} else
sysout().outtext(new TXT$("The puzzle has no solution!"));
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Sudoku.sim","Class SQexit",1,4,10,5,19,6,21,7,23,8,27,9,31,10,36,11,39,12,43,14,45,15,49,17,51,6,54,18);
}
