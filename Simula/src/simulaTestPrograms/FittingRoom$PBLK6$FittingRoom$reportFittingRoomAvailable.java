package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Apr 22 09:54:44 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable extends BASICIO$ {
    public int prefixLevel() { return(0); }
    Link$ elt=null;
    public FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public FittingRoom$PBLK6$FittingRoom$reportFittingRoomAvailable STM$() {
        sysout().outfix(((FittingRoom$PBLK6)(CUR$.SL$.SL$)).time(),2,6);
        sysout().outtext(new TXT$(": FittingRoom becomes available, Queue: "));
        elt=((FittingRoom$PBLK6$FittingRoom)(CUR$.SL$)).door.first();
        if(VALUE$((elt==(null)))) {
            sysout().outtext(new TXT$("Empty"));
        }
        while((elt!=(null))) {
            {
                sysout().outtext(CONC(new TXT$(" "),((FittingRoom$PBLK6$Person)(elt)).p3$pname));
                elt=elt.suc();
            }
        }
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Procedure reportFittingRoomAvailable",1,24,8,25,16,26,19,27,21,28,25,29,27,30,30,31,34,33,38,34);
}
