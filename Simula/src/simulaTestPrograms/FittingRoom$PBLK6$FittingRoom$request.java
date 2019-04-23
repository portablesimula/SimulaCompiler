package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Apr 22 09:54:44 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$FittingRoom$request extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public FittingRoom$PBLK6$FittingRoom$request(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public FittingRoom$PBLK6$FittingRoom$request STM$() {
        if(VALUE$(((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).inUse)) {
            {
                ((FittingRoom$PBLK6)(CUR$.SL$.SL$)).wait(((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door);
                ((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door.first().out();
            }
        }
        ((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).inUse=true;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure request",1,10,14,11,16,12,19,13,23,15,27,16);
}
