package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$$simtst76$PBLK27$A$SubBlock42 extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    public simtst76$$simtst76$PBLK27$A$SubBlock42$C Y=null;
    public simtst76$$simtst76$PBLK27$A$SubBlock42(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        new simtst76$$Print((CUR$.SL$.SL$.SL$),copy(new TXT$("B")));
        ;
        Y=((simtst76$$simtst76$PBLK27$A$SubBlock42$C)new simtst76$$simtst76$PBLK27$A$SubBlock42$C((CUR$)).START$());
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$),copy(new TXT$("D")));
        ;
        resume(Y,40);
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$),copy(new TXT$("F")));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","SubBlock SubBlock42",1,31,14,37,17,38,20,39,23,40,26,41,31,42);
}
