package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst76$$simtst76$PBLK27$A$SubBlock31$C extends CLASS$ {
    public boolean isDetachUsed() { return(true); }
    public simtst76$$simtst76$PBLK27$A$SubBlock31$C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
    }
    public simtst76$$simtst76$PBLK27$A$SubBlock31$C STM$() {
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$.SL$)),copy(new TXT$("C")));
        detach();
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$.SL$)),copy(new TXT$("E")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Class C",1,32,13,33,16,34,18,33,21,35);
}
