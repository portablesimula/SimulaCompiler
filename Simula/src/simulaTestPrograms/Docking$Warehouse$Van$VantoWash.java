package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$Van$VantoWash extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$Warehouse$Van$VantoWash(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$Van$VantoWash STM$() {
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).wPos$2)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$trace(((Docking)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is washing")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoWash",1,127,14,128,16,129,20,130);
}
