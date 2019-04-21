package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VantoQueue extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$PBLK12$Warehouse$Van$VantoQueue(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$Van$VantoQueue STM$() {
        ((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).setFillColor(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).red$1);
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.fillRectangle(((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qPos$2+(((((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLength$2*(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanHeight$2))*(2)))))),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLine$2)),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanWidth$2)),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanHeight$2)));
        ((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLength$2=(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLength$2+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoQueue",1,92,14,93,16,94,18,95,22,96);
}
