package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$Warehouse$Dock extends Link$ {
    public int prefixLevel() { return(2); }
    public int p2$nr;
    public Docking$Warehouse$Dock(RTObject$ staticLink,int sp2$nr) {
        super(staticLink);
        this.p2$nr = sp2$nr;
        TRACE_BEGIN_DCL$("Dock",202);
    }
    public Docking$Warehouse$Dock STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Dock",1,202,15,203,18,203);
}
