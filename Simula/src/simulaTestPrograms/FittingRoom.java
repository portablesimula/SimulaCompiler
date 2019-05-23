// JavaLine 1 <== SourceLine 6
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 23 15:35:48 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class FittingRoom extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=6, lastLine=69, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 56
    int u$2=0;
    // JavaLine 15 <== SourceLine 57
    FittingRoom$FittingRoom fittingRoom1$2=null;
    // Normal Constructor
    public FittingRoom(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("FittingRoom");
        // Declaration Code
        TRACE_BEGIN_DCL$("FittingRoom",57);
    }
    // Class Statements
    public FittingRoom STM$() {
        TRACE_BEGIN_STM$("FittingRoom",57);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class FittingRoom: Code before inner
        // JavaLine 31 <== SourceLine 59
        fittingRoom1$2=new FittingRoom$FittingRoom(((FittingRoom)CUR$)).STM$();
        // JavaLine 33 <== SourceLine 60
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Sam")).START$()));
        // JavaLine 35 <== SourceLine 61
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Sally")).START$()));
        // JavaLine 37 <== SourceLine 62
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Andy")).START$()));
        // JavaLine 39 <== SourceLine 63
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Peter")).START$()));
        // JavaLine 41 <== SourceLine 64
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Elisabeth")).START$()));
        // JavaLine 43 <== SourceLine 65
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Harry")).START$()));
        // JavaLine 45 <== SourceLine 66
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("Robert")).START$()));
        // JavaLine 47 <== SourceLine 67
        ((FittingRoom)CUR$).ActivateDirect(false,((FittingRoom$Person)new FittingRoom$Person(((FittingRoom)CUR$),new TXT$("John")).START$()));
        // JavaLine 49 <== SourceLine 68
        hold(((double)(100)));
        TRACE_END_STM$("FittingRoom",68);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new FittingRoom(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","PrefixedBlock FittingRoom",1,6,13,56,15,57,31,59,33,60,35,61,37,62,39,63,41,64,43,65,45,66,47,67,49,68,60,69);
} // End of Class
