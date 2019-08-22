package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$$simtst76$PBLK69$A$SubBlock74 extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    simtst76$$simtst76$PBLK69$A$SubBlock74$C Y=null;
    public simtst76$$simtst76$PBLK69$A$SubBlock74(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$)),copy(new TXT$("C")));
        Y=((simtst76$$simtst76$PBLK69$A$SubBlock74$C)new simtst76$$simtst76$PBLK69$A$SubBlock74$C(((simtst76$$simtst76$PBLK69$A$SubBlock74)(CUR$))).START$());
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$)),copy(new TXT$("E")));
        resume(Y);
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$)),copy(new TXT$("I")));
        resume(Y);
        ((simtst76$$simtst76$PBLK69$A)(CUR$.SL$)).detach();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","SubBlock SubBlock74",1,74,14,83,17,84,20,85,23,87,27,87);
}
