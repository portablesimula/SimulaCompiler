package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst76$$simtst76$PBLK69$A$SubBlock74$C extends CLASS$ {
    public boolean isDetachUsed() { return(true); }
    public simtst76$$simtst76$PBLK69$A$SubBlock74$C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
    }
    public simtst76$$simtst76$PBLK69$A$SubBlock74$C STM$() {
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$.SL$)),copy(new TXT$("D")));
        detach();
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$.SL$)),copy(new TXT$("F")));
        ((simtst76$$simtst76$PBLK69$A)(CUR$.SL$.SL$)).detach();
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$.SL$)),copy(new TXT$("H")));
        detach();
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$.SL$)),copy(new TXT$("J")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Class C",1,76,13,77,16,78,19,79,22,80,24,77,27,81);
}
