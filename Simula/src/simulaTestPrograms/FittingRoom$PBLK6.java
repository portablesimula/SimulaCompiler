// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:45 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom$PBLK6 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=6, lastLine=68, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 55
    int u$2=0;
    // JavaLine 15 <== SourceLine 56
    FittingRoom$PBLK6$FittingRoom fittingRoom1$2=null;
    // Normal Constructor
    public FittingRoom$PBLK6(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("FittingRoom$PBLK6");
        // Declaration Code
        TRACE_BEGIN_DCL$("FittingRoom$PBLK6",56);
    }
    // Class Statements
    public FittingRoom$PBLK6 STM$() {
        TRACE_BEGIN_STM$("FittingRoom$PBLK6",56);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class FittingRoom$PBLK6: Code before inner
        // JavaLine 31 <== SourceLine 58
        fittingRoom1$2=new FittingRoom$PBLK6$FittingRoom(((FittingRoom$PBLK6)CUR$)).STM$();
        // JavaLine 33 <== SourceLine 59
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Sam")).START$()));
        // JavaLine 35 <== SourceLine 60
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Sally")).START$()));
        // JavaLine 37 <== SourceLine 61
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Andy")).START$()));
        // JavaLine 39 <== SourceLine 62
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Peter")).START$()));
        // JavaLine 41 <== SourceLine 63
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Elisabeth")).START$()));
        // JavaLine 43 <== SourceLine 64
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Harry")).START$()));
        // JavaLine 45 <== SourceLine 65
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("Robert")).START$()));
        // JavaLine 47 <== SourceLine 66
        ((FittingRoom$PBLK6)CUR$).ActivateDirect(false,((FittingRoom$PBLK6$Person)new FittingRoom$PBLK6$Person(((FittingRoom$PBLK6)CUR$),new TXT$("John")).START$()));
        // JavaLine 49 <== SourceLine 67
        hold(((double)(100)));
        TRACE_END_STM$("FittingRoom$PBLK6",67);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new FittingRoom$PBLK6(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","PrefixedBlock FittingRoom$PBLK6",1,6,13,55,15,56,31,58,33,59,35,60,37,61,39,62,41,63,43,64,45,65,47,66,49,67,60,68);
} // End of Class
