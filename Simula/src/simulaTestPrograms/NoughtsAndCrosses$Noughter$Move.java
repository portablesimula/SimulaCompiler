package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:43:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Noughter$Move extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean ok=false;
    public NoughtsAndCrosses$Noughter$Move(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public NoughtsAndCrosses$Noughter$Move STM$() {
        while((!(ok))) {
            {
                sysout().outtext(new TXT$("Give position for nought as i,j : "));
                sysout().breakoutimage();
                ((NoughtsAndCrosses$Noughter)(CUR$.SL$)).i=sysin().inint();
                sysin().inchar();
                ((NoughtsAndCrosses$Noughter)(CUR$.SL$)).j=sysin().inint();
                ok=(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Noughter)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Noughter)(CUR$.SL$)).j-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$));
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Move",1,52,8,53,16,54,18,55,22,56,31,58);
}
