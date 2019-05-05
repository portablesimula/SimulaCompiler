package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:34:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Today extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ Tx=null;
    TXT$ Dx=null;
    TXT$ Mx=null;
    TXT$ Yx=null;
    public Dates$Today(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Dates$Today STM$() {
        Tx=datetime();
        Dx=TXT$.sub(Tx,9,2);
        Mx=TXT$.sub(Tx,6,2);
        Yx=TXT$.sub(Tx,1,4);
        RESULT$=new Dates$Date(((Dates)(CUR$.SL$)),TXT$.getint(Dx),TXT$.getint(Mx),TXT$.getint(Yx)).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Today",1,233,10,235,21,237,23,238,27,239,31,240);
}
