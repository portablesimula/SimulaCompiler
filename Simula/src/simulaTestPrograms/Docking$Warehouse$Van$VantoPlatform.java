package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$Van$VantoPlatform extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Docking$Warehouse$Van$VantoPlatform(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$Van$VantoPlatform STM$() {
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.setColor(((Docking)(CUR$.SL$.SL$.SL$)).black$1);
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).drPos$2)),((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).qLine$2)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$Warehouse$Van$AnvanceQueue(((Docking$Warehouse$Van)(CUR$.SL$)));
        if(VALUE$((((Docking$Warehouse)(CUR$.SL$.SL$)).qLength$2>(0)))) {
            ((Docking$Warehouse)(CUR$.SL$.SL$)).qLength$2=(((Docking$Warehouse)(CUR$.SL$.SL$)).qLength$2-(1));
        }
        ((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3=((((Docking$Warehouse)(CUR$.SL$.SL$)).dLine1$2+(((((Docking$Warehouse$Van)(CUR$.SL$)).myDock$3.p2$nr-(1))*(20))))-(5));
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).drPos$2)),((double)((((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3+(5)))),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).speed$3)));
        ((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3=(((Docking$Warehouse)(CUR$.SL$.SL$)).dLine1$2+(((((Docking$Warehouse$Van)(CUR$.SL$)).myDock$3.p2$nr-(1))*(20))));
        ((Docking$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).pPos$2)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$Warehouse$Van)(CUR$.SL$)).speed$3)));
        new Docking$trace(((Docking)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is moved to plattform ...")));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoPlatform",1,107,14,108,16,109,18,110,20,111,24,113,26,114,28,116,30,117,32,118,36,119);
}
