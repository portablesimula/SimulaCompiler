package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:43:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class NoughtsAndCrosses$Player extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public char p$symb;
    public int i=0;
    public int j=0;
    public NoughtsAndCrosses$Player oponent=null;
    public PRCQNT$ Move$0(){ throw new RuntimeException("No Virtual Match: Move"); }
    public NoughtsAndCrosses$Player(RTObject$ staticLink,char sp$symb) {
        super(staticLink);
        this.p$symb = sp$symb;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("Player",35);
    }
    public NoughtsAndCrosses$Player STM$() {
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
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Class Player",1,8,10,10,22,39,24,40,26,41,29,42,31,43,33,44,35,45,37,46,46,39,49,48);
}
