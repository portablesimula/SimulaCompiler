// JavaLine 1 <== SourceLine 56
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Jun 06 12:16:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QueDemo$PBLK56 extends QueDemo$$QueueingSystem {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=2, firstLine=56, lastLine=60, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public QueDemo$PBLK56(RTObject$ staticLink,int sp2$nDocks,int sp2$nForks) {
        super(staticLink,sp2$nDocks,sp2$nForks);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("QueDemo$PBLK56",56);
    }
    // Class Statements
    public QueDemo$PBLK56 STM$() {
        TRACE_BEGIN_STM$("QueDemo$PBLK56",56);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class QueueingSystem: Code before inner
        // JavaLine 26 <== SourceLine 44
        FreeDocks$2=new Head$(((QueDemo$$QueueingSystem)(CUR$))).STM$();
        Waiting$2=new Head$(((QueDemo$$QueueingSystem)(CUR$))).STM$();
        // JavaLine 29 <== SourceLine 45
        for(boolean CB$45:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){cnt$2=(int)x$; return(x$);};  public Number get(){return((Number)cnt$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p2$nDocks); }})
           )) { if(!CB$45) continue;
        new QueDemo$$QueueingSystem$Dock(((QueDemo$$QueueingSystem)(CUR$))).STM$().into(FreeDocks$2);
    }
    // JavaLine 35 <== SourceLine 47
    hold(((double)(6.0f)));
    ((QueDemo$$QueueingSystem)(CUR$)).ActivateDirect(false,((QueDemo$$QueueingSystem$Generator)new QueDemo$$QueueingSystem$Generator(((QueDemo$$QueueingSystem)(CUR$))).START$()));
    // Class QueDemo$PBLK56: Code before inner
    // JavaLine 39 <== SourceLine 56
    hold(((double)(16.0f)));
    sysout().outtext(new TXT$("Trucks waitingtime: "));
    // JavaLine 42 <== SourceLine 57
    sysout().outfix(wt$2,3,9);
    sysout().outtext(new TXT$(" Nr Docks: "));
    sysout().outint(((QueDemo$)(CUR$.SL$)).nD,3);
    // JavaLine 46 <== SourceLine 58
    sysout().outtext(new TXT$(" Nr Forks: "));
    sysout().outint(((QueDemo$)(CUR$.SL$)).nF,3);
    // JavaLine 49 <== SourceLine 59
    sysout().outtext(new TXT$(" Nr trucks: "));
    sysout().outint(totnr$2,4);
    sysout().outimage();
    // Class QueueingSystem: Code after inner
    TRACE_END_STM$("QueDemo$PBLK56",59);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("QueDemo.sim","PrefixedBlock QueDemo$PBLK56",1,56,26,44,29,45,35,47,39,56,42,57,46,58,49,59,57,60);
} // End of Class
