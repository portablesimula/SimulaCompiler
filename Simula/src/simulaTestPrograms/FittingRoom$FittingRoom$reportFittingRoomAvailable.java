package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:41:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$FittingRoom$reportFittingRoomAvailable extends BASICIO$ {
    public int prefixLevel() { return(0); }
    Link$ elt=null;
    public FittingRoom$FittingRoom$reportFittingRoomAvailable(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public FittingRoom$FittingRoom$reportFittingRoomAvailable STM$() {
        sysout().outfix(((FittingRoom)(CUR$.SL$.SL$)).time(),2,6);
        sysout().outtext(new TXT$(": FittingRoom becomes available, Queue: "));
        elt=((FittingRoom$FittingRoom)(CUR$.SL$)).door.first();
        if(VALUE$((elt==(null)))) {
            sysout().outtext(new TXT$("Empty"));
        }
        while((elt!=(null))) {
            {
                sysout().outtext(CONC(new TXT$(" "),((FittingRoom$Person)(elt)).p3$pname));
                elt=elt.suc();
            }
        }
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure reportFittingRoomAvailable",1,24,8,25,16,26,19,27,21,28,25,29,27,30,30,31,34,33,38,34);
}
