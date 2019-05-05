// JavaLine 1 <== SourceLine 20
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse extends Simulation$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=20, lastLine=222, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p2$nDocks;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 22
    public final float washTime$2=(float)(20.0f);
    public final float pTime$2=(float)(5.0f);
    // JavaLine 16 <== SourceLine 23
    public final double unloadSpeed$2=(double)(1000.0d);
    // JavaLine 18 <== SourceLine 24
    public double accWait$2=0.0d;
    // JavaLine 20 <== SourceLine 25
    public int Totnr$2=0;
    // JavaLine 22 <== SourceLine 26
    public TextElement$ report$2=null;
    // JavaLine 24 <== SourceLine 28
    public final int vanWidth$2=(int)(5);
    public final int vanHeight$2=(int)(5);
    // JavaLine 27 <== SourceLine 30
    public final int qLine$2=(int)(10);
    public final int qPos$2=(int)(30);
    // JavaLine 30 <== SourceLine 31
    public final int drPos$2=(int)(15);
    // JavaLine 32 <== SourceLine 32
    public final int pPos$2=(int)(40);
    // JavaLine 34 <== SourceLine 33
    public final int uPos$2=(int)(120);
    // JavaLine 36 <== SourceLine 34
    public final int wPos$2=(int)(200);
    // JavaLine 38 <== SourceLine 35
    public final int dLine1$2=(int)(75);
    // JavaLine 40 <== SourceLine 36
    public int qLength$2=0;
    // JavaLine 42 <== SourceLine 201
    public Head$ platforms$2=null;
    public Head$ Waiting$2=null;
    public int hi$2=0;
    // Normal Constructor
    public Docking$PBLK12$Warehouse(RTObject$ staticLink,int sp2$nDocks) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$nDocks = sp2$nDocks;
        // Declaration Code
        TRACE_BEGIN_DCL$("Warehouse",203);
    }
    // Class Statements
    public Docking$PBLK12$Warehouse STM$() {
        TRACE_BEGIN_STM$("Warehouse",203);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class Warehouse: Code before inner
        // JavaLine 60 <== SourceLine 209
        new Docking$PBLK12$Warehouse$drawMap(((Docking$PBLK12$Warehouse)CUR$),p2$nDocks);
        // JavaLine 62 <== SourceLine 211
        platforms$2=new Head$(((Docking$PBLK12$Warehouse)CUR$)).STM$();
        Waiting$2=new Head$(((Docking$PBLK12$Warehouse)CUR$)).STM$();
        // JavaLine 65 <== SourceLine 212
        for(boolean CB$212:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){hi$2=(int)x$; return(x$);};  public Number get(){return((Number)hi$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p2$nDocks); }})
           )) { if(!CB$212) continue;
        new Docking$PBLK12$Warehouse$Dock(((Docking$PBLK12$Warehouse)CUR$),hi$2).STM$().into(platforms$2);
    }
    // JavaLine 71 <== SourceLine 214
    ((Docking$PBLK12$Warehouse)CUR$).ActivateDirect(false,((Docking$PBLK12$Warehouse$Generator)new Docking$PBLK12$Warehouse$Generator(((Docking$PBLK12$Warehouse)CUR$)).START$()));
    // JavaLine 73 <== SourceLine 220
    // Class Warehouse: Code after inner
    // JavaLine 75 <== SourceLine 218
    new Docking$PBLK12$Warehouse$UpdateReport(((Docking$PBLK12$Warehouse)CUR$));
    // JavaLine 77 <== SourceLine 220
    hi$2=((Docking$PBLK12)(CUR$.SL$)).white$1;
    TRACE_END_STM$("Warehouse",220);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Warehouse",1,20,13,22,16,23,18,24,20,25,22,26,24,28,27,30,30,31,32,32,34,33,36,34,38,35,40,36,42,201,60,209,62,211,65,212,71,214,73,220,75,218,77,220,82,222);
} // End of Class
