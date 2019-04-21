package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse extends Simulation$ {
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    public int p2$nDocks;
    public final float washTime$2=(float)(20.0f);
    public final float pTime$2=(float)(5.0f);
    public final double unloadSpeed$2=(double)(1000.0d);
    public double accWait$2=0.0d;
    public int Totnr$2=0;
    public TextElement$ report$2=null;
    public final int vanWidth$2=(int)(5);
    public final int vanHeight$2=(int)(5);
    public final int qLine$2=(int)(10);
    public final int qPos$2=(int)(30);
    public final int drPos$2=(int)(15);
    public final int pPos$2=(int)(40);
    public final int uPos$2=(int)(120);
    public final int wPos$2=(int)(200);
    public final int dLine1$2=(int)(75);
    public int qLength$2=0;
    public Head$ platforms$2=null;
    public Head$ Waiting$2=null;
    public int hi$2=0;
    public Docking$PBLK12$Warehouse(RTObject$ staticLink,int sp2$nDocks) {
        super(staticLink);
        this.p2$nDocks = sp2$nDocks;
        TRACE_BEGIN_DCL$("Warehouse",203);
    }
    public Docking$PBLK12$Warehouse STM$() {
        new Docking$PBLK12$Warehouse$drawMap(((Docking$PBLK12$Warehouse)CUR$),p2$nDocks);
        platforms$2=new Head$(((Docking$PBLK12$Warehouse)CUR$)).STM$();
        Waiting$2=new Head$(((Docking$PBLK12$Warehouse)CUR$)).STM$();
        for(boolean CB$212:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){hi$2=(int)x$; return(x$);};  public Number get(){return((Number)hi$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p2$nDocks); }})
           )) { if(!CB$212) continue;
        new Docking$PBLK12$Warehouse$Dock(((Docking$PBLK12$Warehouse)CUR$),hi$2).STM$().into(platforms$2);
    }
    ((Docking$PBLK12$Warehouse)CUR$).ActivateDirect(false,((Docking$PBLK12$Warehouse$Generator)new Docking$PBLK12$Warehouse$Generator(((Docking$PBLK12$Warehouse)CUR$)).START$()));
    new Docking$PBLK12$Warehouse$UpdateReport(((Docking$PBLK12$Warehouse)CUR$));
    hi$2=((Docking$PBLK12)(CUR$.SL$)).white$1;
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Warehouse",1,20,10,22,13,23,15,24,17,25,19,26,21,28,24,30,27,31,29,32,31,33,33,34,35,35,37,36,39,201,49,209,51,211,54,212,60,214,62,218,64,220,68,222);
}
