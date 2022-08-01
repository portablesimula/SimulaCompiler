package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst76$$simtst76$PBLK27$A$SubBlock42$C extends CLASS$ {
    public boolean isDetachUsed() { return(true); }
    public simtst76$$simtst76$PBLK27$A$SubBlock42$C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
    }
    public simtst76$$simtst76$PBLK27$A$SubBlock42$C STM$() {
        new simtst76$$Print((CUR$.SL$.SL$.SL$.SL$),copy(new TXT$("C")));
        ;
        detach(33);
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$.SL$),copy(new TXT$("E")));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Class C",1,32,13,33,18,34,21,33,24,35);
}
