package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VantoUnload extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$PBLK12$Warehouse$Van$VantoUnload(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$Van$VantoUnload STM$() {
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.setColor(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).green$1);
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).uPos$2)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is unloading")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoUnload",1,121,14,122,16,123,18,124,22,125);
}
