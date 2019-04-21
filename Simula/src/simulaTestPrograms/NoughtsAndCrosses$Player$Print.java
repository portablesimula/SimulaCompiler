package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:27:08 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Player$Print extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public NoughtsAndCrosses$Player$Print(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public NoughtsAndCrosses$Player$Print STM$() {
        for(boolean CB$14:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
           )) { if(!CB$14) continue;
        {
            for(boolean CB$15:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
               )) { if(!CB$15) continue;
            sysout().outchar(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).j-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]);
        }
        sysout().outimage();
    }
}
sysout().outimage();
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Print",1,12,14,14,18,15,23,16,26,17,30,19,34,20);
}
