package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$Van$VantoUnload extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$Warehouse$Van$VantoUnload(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$Van$VantoUnload STM$() {
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.setColor(((Docking)(CUR$.SL$.SL$.SL$)).green$1);
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).uPos$2)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$trace(((Docking)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is unloading")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoUnload",1,121,14,122,16,123,18,124,22,125);
}
