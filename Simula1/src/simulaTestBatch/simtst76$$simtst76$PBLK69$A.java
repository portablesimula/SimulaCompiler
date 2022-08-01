package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst76$$simtst76$PBLK69$A extends Link$ {
    public boolean isDetachUsed() { return(true); }
    public simtst76$$simtst76$PBLK69$A(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst76$$simtst76$PBLK69$A STM$() {
        new simtst76$$Print((CUR$.SL$.SL$),copy(new TXT$("A")));
        ;
        detach(73);
        ;
        new simtst76$$simtst76$PBLK69$A$SubBlock87((CUR$)).STM$();
        ;
        new simtst76$$Print((CUR$.SL$.SL$),copy(new TXT$("L")));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Class A",1,71,12,72,15,73,18,87,21,88,24,72,27,89);
}
