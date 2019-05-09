package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$Van$VantoQueue extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$Warehouse$Van$VantoQueue(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$Van$VantoQueue STM$() {
        ((Docking)(CUR$.SL$.SL$.SL$)).setFillColor(((Docking)(CUR$.SL$.SL$.SL$)).red$1);
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.fillRectangle(((double)((((Docking$Warehouse)(CUR$.SL$.SL$)).qPos$2+(((((Docking$Warehouse)(CUR$.SL$.SL$)).qLength$2*(((Docking$Warehouse)(CUR$.SL$.SL$)).vanHeight$2))*(2)))))),((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).qLine$2)),((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).vanWidth$2)),((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).vanHeight$2)));
        ((Docking$Warehouse)(CUR$.SL$.SL$)).qLength$2=(((Docking$Warehouse)(CUR$.SL$.SL$)).qLength$2+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoQueue",1,92,14,93,16,94,18,95,22,96);
}
