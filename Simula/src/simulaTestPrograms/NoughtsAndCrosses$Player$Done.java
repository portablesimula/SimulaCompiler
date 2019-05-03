package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:43:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Player$Done extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    char winner=0;
    public NoughtsAndCrosses$Player$Done(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public NoughtsAndCrosses$Player$Done STM$() {
        if(VALUE$((((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))))|(((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]])))))))) {
            winner=((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]];
        } else
        for(boolean CB$27:new ForList(
            new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }})
           ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(((NoughtsAndCrosses$Player)(CUR$.SL$)).i+(1)); }},new NAME$<Boolean>() { public Boolean get(){return((((NoughtsAndCrosses$Player)(CUR$.SL$)).i<=(3))&((winner==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$)))); }})
           )) { if(!CB$27) continue;
        if(VALUE$(((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]])))))) {
            winner=((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]];
        } else
        if(VALUE$(((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]])))))) {
            winner=((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]];
        }
    }
    if(VALUE$((winner!=(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$)))) {
        {
            sysout().outtext(new TXT$("The winner is "));
            sysout().outchar(winner);
            sysout().outimage();
            RESULT$=true;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Done",1,22,10,23,18,24,20,26,23,27,28,28,30,29,33,31,35,32,39,33,41,34,46,35,52,37);
}
