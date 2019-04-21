package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$ClearBoard extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Queens2$ClearBoard(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Queens2$ClearBoard STM$() {
        for(boolean CB$43:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
           )) { if(!CB$43) continue;
        {
            for(boolean CB$44:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
               )) { if(!CB$44) continue;
            {
                new Queens2$Setpos(((Queens2)(CUR$.SL$)),(4+((2*(((Queens2)(CUR$.SL$)).i)))),(21+((4*(((Queens2)(CUR$.SL$)).j)))));
                sysout().outchar(((char)32));
            }
        }
        sysout().breakoutimage();
    }
}
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure ClearBoard",1,42,14,43,18,44,23,45,29,46,35,47);
}
