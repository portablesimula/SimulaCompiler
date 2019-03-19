// JavaLine 1 ==> SourceLine 12
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12 extends Drawing$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=12, lastLine=244, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    final boolean DEBUG=false;
    // JavaLine 13 ==> SourceLine 13
    final boolean verbose=false;
    // JavaLine 15 ==> SourceLine 225
    int cnt=0;
    // JavaLine 17 ==> SourceLine 227
    int U1=0;
    int U2=0;
    // Normal Constructor
    public Docking$PBLK12(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        // Parameter assignment to locals
        BPRG("Docking$PBLK12");
        // Declaration Code
        TRACE_BEGIN_DCL$("Docking$PBLK12",227);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("Docking$PBLK12",227,inner);
                // JavaLine 31 ==> SourceLine 233
                U1=455470314;
                U2=950423827;
                // JavaLine 34 ==> SourceLine 235
                for(boolean CB$235:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){cnt=(int)x$; return(x$);};  public Number get(){return((Number)cnt); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(6); }})
                   )) { if(!CB$235) continue;
                // JavaLine 38 ==> SourceLine 239
                new Docking$PBLK237(CUR$,cnt).START();
            }
            // JavaLine 41 ==> SourceLine 240
            sysout().outtext(new TXT$("End of Simulation"));
            sysout().outimage();
            // JavaLine 44 ==> SourceLine 242
            while(true) {
                {
                    TRACE_BEGIN_STM$("CompoundStatement242",242);
                    TRACE_END_STM$("CompoundStatement242",242);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            TRACE_END_STM$("Docking$PBLK12",242);
        }
    };
} // End of Constructor

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new Docking$PBLK12(CTX$,new TXT$("Warehouse Simulation"),500,300).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK12",1,12,13,13,15,225,17,227,31,233,34,235,38,239,41,240,44,242,61,244);
}
