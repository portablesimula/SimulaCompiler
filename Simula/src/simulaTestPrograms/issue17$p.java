package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue17$p extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public issue17$p(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public issue17$p STM$() {
        new issue17$PBLK18(CUR$).START$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","Procedure p",1,14,8,16,16,39,20,40);
}
