package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:27:08 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class NoughtsAndCrosses$Crosser extends NoughtsAndCrosses$Player {
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    public PRCQNT$ Move$0() { return(new PRCQNT$(this,NoughtsAndCrosses$Crosser$Move.class)); }
    public NoughtsAndCrosses$Crosser(RTObject$ staticLink,char sp$symb) {
        super(staticLink,sp$symb);
        TRACE_BEGIN_DCL$("Crosser",68);
    }
    public NoughtsAndCrosses$Crosser STM$() {
        detach();
        while((!(new NoughtsAndCrosses$Player$Done(((NoughtsAndCrosses$Player)CUR$)).RESULT$))) {
            {
                ((NoughtsAndCrosses$Player)CUR$).Move$0().CPF();
                ((NoughtsAndCrosses)(CUR$.SL$)).board.Elt[i-((NoughtsAndCrosses)(CUR$.SL$)).board.LB[0]][j-((NoughtsAndCrosses)(CUR$.SL$)).board.LB[1]]=p$symb;
                new NoughtsAndCrosses$Player$Print(((NoughtsAndCrosses$Player)CUR$));
                ((NoughtsAndCrosses)(CUR$.SL$)).count=(((NoughtsAndCrosses)(CUR$.SL$)).count+(1));
                if(VALUE$((((NoughtsAndCrosses)(CUR$.SL$)).count<(9)))) {
                    resume(oponent);
                } else
                {
                    sysout().outtext(new TXT$("No winner..."));
                    detach();
                }
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Class Crosser",1,61,15,39,17,40,19,41,22,42,24,43,26,44,28,45,30,46,39,70,42,70);
}
