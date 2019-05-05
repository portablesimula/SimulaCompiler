// JavaLine 1 <== SourceLine 12
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12 extends Drawing$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=12, lastLine=244, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    final boolean DEBUG$2=(boolean)(false);
    // JavaLine 13 <== SourceLine 13
    final boolean verbose$2=(boolean)(false);
    // JavaLine 15 <== SourceLine 225
    int cnt$2=0;
    // JavaLine 17 <== SourceLine 227
    int U1$2=0;
    int U2$2=0;
    // Normal Constructor
    public Docking$PBLK12(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        // Parameter assignment to locals
        BPRG("Docking$PBLK12");
        // Declaration Code
        TRACE_BEGIN_DCL$("Docking$PBLK12",227);
    }
    // Class Statements
    public Docking$PBLK12 STM$() {
        TRACE_BEGIN_STM$("Docking$PBLK12",227);
        // Class Simset: Code before inner
        // Class Drawing: Code before inner
        // Class Docking$PBLK12: Code before inner
        // JavaLine 34 <== SourceLine 233
        U1$2=455470314;
        U2$2=950423827;
        // JavaLine 37 <== SourceLine 235
        for(boolean CB$235:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){cnt$2=(int)x$; return(x$);};  public Number get(){return((Number)cnt$2); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(6); }})
           )) { if(!CB$235) continue;
        // JavaLine 41 <== SourceLine 239
        new Docking$PBLK237(CUR$,cnt$2).START$();
        // JavaLine 43 <== SourceLine 238
    }
    // JavaLine 45 <== SourceLine 240
    sysout().outtext(new TXT$("End of Simulation"));
    sysout().outimage();
    // JavaLine 48 <== SourceLine 242
    while(true) {
        {
            TRACE_BEGIN_STM$("CompoundStatement242",242);
            TRACE_END_STM$("CompoundStatement242",242);
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    TRACE_END_STM$("Docking$PBLK12",242);
    EBLK();
    return(this);
} // End of Class Statements

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new Docking$PBLK12(CTX$,new TXT$("Warehouse Simulation"),500,300).STM$();
} // End of main
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK12",1,12,13,13,15,225,17,227,34,233,37,235,41,239,43,238,45,240,48,242,65,244);
} // End of Class
