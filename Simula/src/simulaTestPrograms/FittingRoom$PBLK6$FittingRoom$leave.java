package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:07 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$FittingRoom$leave extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public FittingRoom$PBLK6$FittingRoom$leave(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public FittingRoom$PBLK6$FittingRoom$leave STM$() {
        ((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).inUse=false;
        new FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable(((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)));
        ((FittingRoom$PBLK6)(CUR$.SL$.SL$)).ActivateDirect(false,((Process$)(((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door.first())));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure leave",1,18,14,19,16,20,18,21,22,22);
}
