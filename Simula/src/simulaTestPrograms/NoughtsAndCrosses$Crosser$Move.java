package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:43:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Crosser$Move extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ exit=new LABQNT$(this,1,"exit");
    public NoughtsAndCrosses$Crosser$Move(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public NoughtsAndCrosses$Crosser$Move STM$() {
        NoughtsAndCrosses$Crosser$Move THIS$=(NoughtsAndCrosses$Crosser$Move)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                for(boolean CB$65:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Crosser)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Crosser)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
                   )) { if(!CB$65) continue;
                for(boolean CB$66:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Crosser)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Crosser)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
                   )) { if(!CB$66) continue;
                if(VALUE$((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Crosser)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Crosser)(CUR$.SL$)).j-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$)))) {
                    GOTO$(exit);
                }
            }
        }
        LABEL$(1,"exit");
        sysout().outtext(new TXT$("Crosser's turn:"));
        sysout().outimage();
        break LOOP$;
    }
    catch(LABQNT$ q) {
        CUR$=THIS$;
        if(q.SL$!=CUR$) {
            CUR$.STATE$=OperationalState.terminated;
            throw(q);
        }
        JTX$=q.index; continue LOOP$;
    }
}
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Move",1,63,8,68,20,65,24,66,28,67,34,68,51,69);
}
