package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst76$$simtst76$PBLK69$A extends Link$ {
    public boolean isDetachUsed() { return(true); }
    public simtst76$$simtst76$PBLK69$A(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst76$$simtst76$PBLK69$A STM$() {
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$)),copy(new TXT$("A")));
        detach();
        new simtst76$$simtst76$PBLK69$A$SubBlock74((CUR$)).STM$();
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$)),copy(new TXT$("L")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Class A",1,71,12,72,14,73,16,87,18,88,20,72,23,92);
}
