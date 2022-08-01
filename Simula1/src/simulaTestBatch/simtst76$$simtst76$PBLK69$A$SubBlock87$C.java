package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst76$$simtst76$PBLK69$A$SubBlock87$C extends CLASS$ {
    public boolean isDetachUsed() { return(true); }
    public simtst76$$simtst76$PBLK69$A$SubBlock87$C(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
    }
    public simtst76$$simtst76$PBLK69$A$SubBlock87$C STM$() {
        new simtst76$$Print((CUR$.SL$.SL$.SL$.SL$),copy(new TXT$("D")));
        ;
        detach(77);
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$.SL$),copy(new TXT$("F")));
        ;
        ((simtst76$$simtst76$PBLK69$A)(CUR$.SL$.SL$)).detach();
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$.SL$),copy(new TXT$("H")));
        ;
        detach(79);
        ;
        new simtst76$$Print((CUR$.SL$.SL$.SL$.SL$),copy(new TXT$("J")));
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","Class C",1,76,13,77,18,78,23,79,28,80,31,77,34,81);
}
