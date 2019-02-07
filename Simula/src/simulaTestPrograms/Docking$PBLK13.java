// JavaLine 1 ==> SourceLine 13
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:37:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13 extends Drawing$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=13, lastLine=223, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    final boolean verbose=true;
    // JavaLine 13 ==> SourceLine 207
    int cnt=0;
    // JavaLine 15 ==> SourceLine 209
    int U1=0;
    int U2=0;
    // Normal Constructor
    public Docking$PBLK13(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        // Parameter assignment to locals
        BPRG("Docking$PBLK13");
        // Declaration Code
        TRACE_BEGIN_DCL$("Docking$PBLK13",209);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("Docking$PBLK13",209,inner);
                // JavaLine 29 ==> SourceLine 215
                U1=455470314;
                U2=950423827;
                // JavaLine 32 ==> SourceLine 217
                for(boolean CB$217:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){cnt=(int)x$; return(x$);};  public Number get(){return((Number)cnt); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(6); }})
                   )) { if(!CB$217) continue;
                // JavaLine 36 ==> SourceLine 218
                new Docking$PBLK218(CUR$,cnt).START();
            }
            // JavaLine 39 ==> SourceLine 219
            sysout().outtext(new TXT$("End of Simulation"));
            sysout().outimage();
            // JavaLine 42 ==> SourceLine 221
            while(true) {
                {
                    TRACE_BEGIN_STM$("CompoundStatement221",221);
                    TRACE_END_STM$("CompoundStatement221",221);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            TRACE_END_STM$("Docking$PBLK13",221);
        }
    };
} // End of Constructor

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new Docking$PBLK13(CTX$,new TXT$("Warehouse Simulation"),500,300).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking$PBLK13",1,13,13,207,15,209,29,215,32,217,36,218,39,219,42,221,59,223);
}
