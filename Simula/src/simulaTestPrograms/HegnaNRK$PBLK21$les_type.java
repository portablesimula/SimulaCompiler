package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_type extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    char char$=0;
    public HegnaNRK$PBLK21$les_type(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_type STM$() {
        char$=sysin().inchar();
        while((char$==(((char)32)))) {
            char$=sysin().inchar();
        }
        RESULT$=char$;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_type",1,333,10,335,18,336,20,337,24,338,28,339);
}
