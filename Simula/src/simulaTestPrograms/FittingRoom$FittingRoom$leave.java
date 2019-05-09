package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:41:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$FittingRoom$leave extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public FittingRoom$FittingRoom$leave(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public FittingRoom$FittingRoom$leave STM$() {
        ((FittingRoom$FittingRoom)(CUR$.SL$)).inUse=false;
        new FittingRoom$FittingRoom$reportFittingRoomAvailable(((FittingRoom$FittingRoom)(CUR$.SL$)));
        ((FittingRoom)(CUR$.SL$.SL$)).ActivateDirect(false,((Process$)(((FittingRoom$FittingRoom)(CUR$.SL$)).door.first())));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure leave",1,18,14,19,16,20,18,21,22,22);
}
