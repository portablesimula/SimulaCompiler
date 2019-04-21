package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$RemoveAllVans extends BASICIO$ {
    public int prefixLevel() { return(0); }
    Link$ elt=null;
    Link$ next=null;
    Link$ inspect$45$1=null;
    public Docking$PBLK12$Warehouse$RemoveAllVans(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$RemoveAllVans STM$() {
        elt=((Docking$PBLK12)(CUR$.SL$.SL$)).renderingSet().first();
        while((elt!=(null))) {
            {
                next=elt.suc();
                {
                    inspect$45$1=elt;
                    if(inspect$45$1 instanceof ShapeElement$)
                    {
                        ((ShapeElement$)inspect$45$1).instantMoveTo(((double)(5000)),((double)(5000)));
                        ((ShapeElement$)inspect$45$1).out();
                    }
                }
                elt=next;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure RemoveAllVans",1,39,8,40,11,45,19,42,21,43,23,44,26,45,30,46,33,48,37,50,43,52);
}
