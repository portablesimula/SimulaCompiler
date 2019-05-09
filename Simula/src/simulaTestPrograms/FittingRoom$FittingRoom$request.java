package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:41:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$FittingRoom$request extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public FittingRoom$FittingRoom$request(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public FittingRoom$FittingRoom$request STM$() {
        if(VALUE$(((FittingRoom$FittingRoom)(CUR$.SL$)).inUse)) {
            {
                ((FittingRoom)(CUR$.SL$.SL$)).wait(((FittingRoom$FittingRoom)(CUR$.SL$)).door);
                ((FittingRoom$FittingRoom)(CUR$.SL$)).door.first().out();
            }
        }
        ((FittingRoom$FittingRoom)(CUR$.SL$)).inUse=true;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure request",1,10,14,11,16,12,19,13,23,15,27,16);
}
