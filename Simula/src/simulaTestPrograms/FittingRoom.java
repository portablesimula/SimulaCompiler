package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:41:57 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    int u$2=0;
    FittingRoom$FittingRoom fittingRoom1$2=null;
    public FittingRoom(RTObject$ staticLink) {
        super(staticLink);
        BPRG("FittingRoom");
    }
    public FittingRoom STM$() {
        fittingRoom1$2=new FittingRoom$FittingRoom(((FittingRoom)CUR$)).STM$();
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Sam")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Sally")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Andy")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Peter")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Elisabeth")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Harry")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Robert")).START$()));
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("John")).START$()));
        hold(((double)(100)));
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new FittingRoom(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","PrefixedBlock FittingRoom",1,6,10,55,12,56,19,58,21,59,23,60,25,61,27,62,29,63,31,64,33,65,35,66,37,67,46,68);
}
