package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:07 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$PBLK6$FittingRoom extends CLASS$ {
    public int prefixLevel() { return(0); }
    public Head$ door=null;
    public boolean inUse=false;
    public FittingRoom$PBLK6$FittingRoom(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("FittingRoom",33);
    }
    public FittingRoom$PBLK6$FittingRoom STM$() {
        door=new Head$(((FittingRoom$PBLK6)(CUR$.SL$))).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class FittingRoom",7,7,9,8,20,37);
}
