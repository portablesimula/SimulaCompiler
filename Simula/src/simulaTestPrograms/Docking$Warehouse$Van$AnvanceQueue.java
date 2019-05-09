package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$Van$AnvanceQueue extends BASICIO$ {
    public int prefixLevel() { return(0); }
    Docking$Warehouse$Van v=null;
    int n=0;
    public Docking$Warehouse$Van$AnvanceQueue(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$Van$AnvanceQueue STM$() {
        v=((Docking$Warehouse$Van)(((Docking$Warehouse)(CUR$.SL$.SL$)).Waiting$2.first()));
        while((v!=(null))) {
            {
                v.vanShape$3.instantMoveTo(((double)((((Docking$Warehouse)(CUR$.SL$.SL$)).qPos$2+(((n*(((Docking$Warehouse)(CUR$.SL$.SL$)).vanHeight$2))*(2)))))),((double)(((Docking$Warehouse)(CUR$.SL$.SL$)).qLine$2)));
                n=(n+(1));
                v=((Docking$Warehouse$Van)(v.suc()));
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure AnvanceQueue",1,98,8,99,17,100,19,101,21,102,24,103,31,105);
}
