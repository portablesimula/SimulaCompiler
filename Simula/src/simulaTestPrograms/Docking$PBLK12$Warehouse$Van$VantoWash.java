package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VantoWash extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$PBLK12$Warehouse$Van$VantoWash(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$Van$VantoWash STM$() {
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).wPos$2)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is washing")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoWash",1,127,14,128,16,129,20,130);
}
