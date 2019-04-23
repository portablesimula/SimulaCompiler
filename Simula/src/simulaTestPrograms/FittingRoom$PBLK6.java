package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Apr 22 09:54:44 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    int u$2=0;
    FittingRoom$PBLK6$FittingRoom fittingRoom1$2=null;
    public FittingRoom$PBLK6(RTObject$ staticLink) {
        super(staticLink);
        BPRG("FittingRoom$PBLK6");
    }
    public FittingRoom$PBLK6 STM$() {
        fittingRoom1$2=new FittingRoom$PBLK6$FittingRoom(((FittingRoom$PBLK6)CUR$)).STM$();
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Sam")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Sally")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Andy")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Peter")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Elisabeth")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Harry")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Robert")).START$()));
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("John")).START$()));
        hold(((double)(100)));
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new FittingRoom$PBLK6(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","PrefixedBlock FittingRoom$PBLK6",1,6,10,55,12,56,19,58,21,59,23,60,25,61,27,62,29,63,31,64,33,65,35,66,37,67,46,68);
}
