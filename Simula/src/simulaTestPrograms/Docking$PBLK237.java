// JavaLine 1 <== SourceLine 237
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK237 extends Docking$PBLK12$Warehouse {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=237, lastLine=239, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK237(RTObject$ staticLink,int sp2$nDocks) {
        super(staticLink,sp2$nDocks);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Docking$PBLK237",237);
    }
    // Class Statements
    public Docking$PBLK237 STM$() {
        TRACE_BEGIN_STM$("Docking$PBLK237",237);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class Warehouse: Code before inner
        // JavaLine 26 <== SourceLine 209
        new Docking$PBLK12$Warehouse$drawMap(((Docking$PBLK12$Warehouse)CUR$),p2$nDocks);
        // JavaLine 28 <== SourceLine 211
        platforms$2=new Head$(((Docking$PBLK12$Warehouse)CUR$)).STM$();
        Waiting$2=new Head$(((Docking$PBLK12$Warehouse)CUR$)).STM$();
        // JavaLine 31 <== SourceLine 212
        for(boolean CB$212:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){hi$2=(int)x$; return(x$);};  public Number get(){return((Number)hi$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p2$nDocks); }})
           )) { if(!CB$212) continue;
        new Docking$PBLK12$Warehouse$Dock(((Docking$PBLK12$Warehouse)CUR$),hi$2).STM$().into(platforms$2);
    }
    // JavaLine 37 <== SourceLine 214
    ((Docking$PBLK12$Warehouse)CUR$).ActivateDirect(false,((Docking$PBLK12$Warehouse$Generator)new Docking$PBLK12$Warehouse$Generator(((Docking$PBLK12$Warehouse)CUR$)).START$()));
    // Class Docking$PBLK237: Code before inner
    // JavaLine 40 <== SourceLine 237
    hold(((double)(960.0f)));
    // JavaLine 42 <== SourceLine 238
    if(VALUE$((((Docking$PBLK12)(CUR$.SL$)).cnt$2<(6)))) {
        new Docking$PBLK12$Warehouse$RemoveAllVans(((Docking$PBLK237)CUR$));
    }
    // Class Warehouse: Code after inner
    // JavaLine 47 <== SourceLine 218
    new Docking$PBLK12$Warehouse$UpdateReport(((Docking$PBLK12$Warehouse)CUR$));
    // JavaLine 49 <== SourceLine 220
    hi$2=((Docking$PBLK12)(CUR$.SL$)).white$1;
    // JavaLine 51 <== SourceLine 238
    TRACE_END_STM$("Docking$PBLK237",238);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK237",1,237,26,209,28,211,31,212,37,214,40,237,42,238,47,218,49,220,51,238,55,239);
} // End of Class
