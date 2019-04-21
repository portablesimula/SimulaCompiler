package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$AnvanceQueue extends BASICIO$ {
    public int prefixLevel() { return(0); }
    Docking$PBLK12$Warehouse$Van v=null;
    int n=0;
    public Docking$PBLK12$Warehouse$Van$AnvanceQueue(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$Van$AnvanceQueue STM$() {
        v=((Docking$PBLK12$Warehouse$Van)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).Waiting$2.first()));
        while((v!=(null))) {
            {
                v.vanShape$3.instantMoveTo(((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qPos$2+(((n*(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanHeight$2))*(2)))))),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLine$2)));
                n=(n+(1));
                v=((Docking$PBLK12$Warehouse$Van)(v.suc()));
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure AnvanceQueue",1,98,8,99,17,100,19,101,21,102,24,103,31,105);
}
