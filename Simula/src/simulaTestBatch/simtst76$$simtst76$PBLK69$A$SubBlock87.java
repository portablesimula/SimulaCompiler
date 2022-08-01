package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$$simtst76$PBLK69$A$SubBlock87 extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    public simtst76$$simtst76$PBLK69$A$SubBlock87$C Y=null;
    public simtst76$$simtst76$PBLK69$A$SubBlock87(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        new simtst76$$Print((CUR$.SL$.SL$.SL$),copy(new TXT$("C")));
        ;
        Y=((simtst76$$simtst76$PBLK69$A$SubBlock87$C)new simtst76$$simtst76$PBLK69$A$SubBlock87$C((CUR$)).START$());
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$),copy(new TXT$("E")));
        ;
        resume(Y,84);
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$),copy(new TXT$("I")));
        ;
        resume(Y,85);
        ;
        ((simtst76$$simtst76$PBLK69$A)(CUR$.SL$)).detach(87);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","SubBlock SubBlock87",1,74,14,83,19,84,24,85,29,87,33,87);
}
