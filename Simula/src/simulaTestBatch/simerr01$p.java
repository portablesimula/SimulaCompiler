package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 16:39:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr01$p extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public simerr01$p(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simerr01$p STM$() {
        new simerr01$PBLK48(CUR$).START$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr01.sim","Procedure p",1,44,8,46,16,69,20,70);
}
