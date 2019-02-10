// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:41:56 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=6, lastLine=68, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 55
    int u=0;
    // JavaLine 15 ==> SourceLine 56
    FittingRoom$PBLK6$FittingRoom fittingRoom1=null;
    // Normal Constructor
    public FittingRoom$PBLK6(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("FittingRoom$PBLK6");
        // Declaration Code
        TRACE_BEGIN_DCL$("FittingRoom$PBLK6",56);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("FittingRoom$PBLK6",56,inner);
                // JavaLine 28 ==> SourceLine 58
                fittingRoom1=new FittingRoom$PBLK6$FittingRoom(((FittingRoom$PBLK6)CUR$)).STM$();
                // JavaLine 30 ==> SourceLine 59
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Sam")).START());
                // JavaLine 32 ==> SourceLine 60
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Sally")).START());
                // JavaLine 34 ==> SourceLine 61
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Andy")).START());
                // JavaLine 36 ==> SourceLine 62
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Peter")).START());
                // JavaLine 38 ==> SourceLine 63
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Elisabeth")).START());
                // JavaLine 40 ==> SourceLine 64
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Harry")).START());
                // JavaLine 42 ==> SourceLine 65
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Robert")).START());
                // JavaLine 44 ==> SourceLine 66
                ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("John")).START());
                // JavaLine 46 ==> SourceLine 67
                hold(((double)(100)));
                TRACE_END_STM$("FittingRoom$PBLK6",67);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new FittingRoom$PBLK6(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","PrefixedBlock FittingRoom$PBLK6",1,6,13,55,15,56,28,58,30,59,32,60,34,61,36,62,38,63,40,64,42,65,44,66,46,67,57,68);
}
