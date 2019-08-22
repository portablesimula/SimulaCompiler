package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$$simtst76$PBLK27$A$SubBlock31 extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    simtst76$$simtst76$PBLK27$A$SubBlock31$C Y=null;
    public simtst76$$simtst76$PBLK27$A$SubBlock31(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$)),copy(new TXT$("B")));
        Y=((simtst76$$simtst76$PBLK27$A$SubBlock31$C)new simtst76$$simtst76$PBLK27$A$SubBlock31$C(((simtst76$$simtst76$PBLK27$A$SubBlock31)(CUR$))).START$());
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$)),copy(new TXT$("D")));
        resume(Y);
        new simtst76$$Print(((simtst76$)(CUR$.SL$.SL$.SL$)),copy(new TXT$("F")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","SubBlock SubBlock31",1,31,14,37,16,38,18,39,20,40,22,41,26,42);
}
