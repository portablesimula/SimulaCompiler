package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$Van$VanFinished extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$Warehouse$Van$VanFinished(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$Van$VanFinished STM$() {
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.setColor(((Docking)(CUR$.SL$.SL$.SL$)).lightGray$1);
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)((((Docking$Warehouse)(CUR$.SL$.SL$)).wPos$2+(500)))),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$trace(((Docking)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is leaving")));
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.out();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VanFinished",1,132,14,133,16,134,18,135,20,136,24,137);
}
