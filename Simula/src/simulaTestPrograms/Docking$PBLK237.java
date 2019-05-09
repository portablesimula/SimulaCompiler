package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK237 extends Docking$Warehouse {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    public Docking$PBLK237(RTObject$ staticLink,int sp2$nDocks) {
        super(staticLink,sp2$nDocks);
    }
    public Docking$PBLK237 STM$() {
        new Docking$Warehouse$drawMap(((Docking$Warehouse)CUR$),p2$nDocks);
        platforms$2=new Head$(((Docking$Warehouse)CUR$)).STM$();
        Waiting$2=new Head$(((Docking$Warehouse)CUR$)).STM$();
        for(boolean CB$212:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){hi$2=(int)x$; return(x$);};  public Number get(){return((Number)hi$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p2$nDocks); }})
           )) { if(!CB$212) continue;
        new Docking$Warehouse$Dock(((Docking$Warehouse)CUR$),hi$2).STM$().into(platforms$2);
    }
    ((Docking$Warehouse)CUR$).ActivateDirect(false,((Docking$Warehouse$Generator)new Docking$Warehouse$Generator(((Docking$Warehouse)CUR$)).START$()));
    hold(((double)(960.0f)));
    if(VALUE$((((Docking)(CUR$.SL$)).cnt$2<(6)))) {
        new Docking$Warehouse$RemoveAllVans(((Docking$PBLK237)CUR$));
    }
    new Docking$Warehouse$UpdateReport(((Docking$Warehouse)CUR$));
    hi$2=((Docking)(CUR$.SL$)).white$1;
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK237",1,237,14,209,16,211,19,212,25,214,27,237,29,238,33,218,35,220,37,238,40,239);
}
