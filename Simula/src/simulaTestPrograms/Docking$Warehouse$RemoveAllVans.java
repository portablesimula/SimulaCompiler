package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$Warehouse$RemoveAllVans extends BASICIO$ {
    public int prefixLevel() { return(0); }
    Link$ elt=null;
    Link$ next=null;
    Link$ inspect$45$12=null;
    public Docking$Warehouse$RemoveAllVans(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public Docking$Warehouse$RemoveAllVans STM$() {
        elt=((Docking)(CUR$.SL$.SL$)).renderingSet().first();
        while((elt!=(null))) {
            {
                next=elt.suc();
                {
                    inspect$45$12=elt;
                    if(inspect$45$12 instanceof ShapeElement$)
                    {
                        ((ShapeElement$)inspect$45$12).instantMoveTo(((double)(5000)),((double)(5000)));
                        ((ShapeElement$)inspect$45$12).out();
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
