package simulaTestPrograms;
// Simula-1.0 Compiled at Thu Jun 06 15:32:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class QueDemo$$QueueingSystem extends Simulation$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=6, lastLine=48, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p2$nDocks;
    public int p2$nForks;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 8
    public int cnt$2=0;
    public int totnr$2=0;
    public double wt$2=0.0d;
    // JavaLine 17 <== SourceLine 9
    public ARRAY$<int[]>acm=null;
    // JavaLine 19 <== SourceLine 35
    public Head$ FreeDocks$2=null;
    public Head$ Waiting$2=null;
    // Normal Constructor
    public QueDemo$$QueueingSystem(RTObject$ staticLink,int sp2$nDocks,int sp2$nForks) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$nDocks = sp2$nDocks;
        this.p2$nForks = sp2$nForks;
        // Declaration Code
        TRACE_BEGIN_DCL$("QueueingSystem",44);
        // JavaLine 30 <== SourceLine 9
        int[] acm$LB=new int[1]; int[] acm$UB=new int[1];
        acm$LB[0]=6; acm$UB[0]=22;
        BOUND_CHECK$(acm$LB[0],acm$UB[0]);
        acm=new ARRAY$<int[]>(new int[acm$UB[0]-acm$LB[0]+1],acm$LB,acm$UB);
    }
    // Class Statements
    public QueDemo$$QueueingSystem STM$() {
        TRACE_BEGIN_STM$("QueueingSystem",9);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // JavaLine 41 <== SourceLine 44
        // Class QueueingSystem: Code before inner
        FreeDocks$2=new Head$(((QueDemo$$QueueingSystem)(CUR$))).STM$();
        Waiting$2=new Head$(((QueDemo$$QueueingSystem)(CUR$))).STM$();
        // JavaLine 45 <== SourceLine 45
        for(boolean CB$45:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){cnt$2=(int)x$; return(x$);};  public Number get(){return((Number)cnt$2); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p2$nDocks); }})
           )) { if(!CB$45) continue;
        new QueDemo$$QueueingSystem$Dock(((QueDemo$$QueueingSystem)(CUR$))).STM$().into(FreeDocks$2);
    }
    // JavaLine 51 <== SourceLine 47
    hold(((double)(6.0f)));
    ((QueDemo$$QueueingSystem)(CUR$)).ActivateDirect(false,((QueDemo$$QueueingSystem$Generator)new QueDemo$$QueueingSystem$Generator(((QueDemo$$QueueingSystem)(CUR$))).START$()));
    // JavaLine 54 <== SourceLine 44
    // Class QueueingSystem: Code after inner
    TRACE_END_STM$("QueueingSystem",44);
    EBLK();
    return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("QueDemo.sim","Class QueueingSystem",13,8,17,9,19,35,30,9,41,44,45,45,51,47,54,44,59,48);
} // End of Class
