package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_type extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    char char$=0;
    public HegnaNRK$les_type(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_type STM$() {
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
