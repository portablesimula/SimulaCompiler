// JavaLine 1 <== SourceLine 2
package simulaTestPrograms;
// Simula-1.0 Compiled at Mon May 20 10:13:03 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue26 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=2, lastLine=19, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    issue26$Car bil$2=null;
    // Normal Constructor
    public issue26(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("issue26");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue26",11);
    }
    // Class Statements
    public issue26 STM$() {
        TRACE_BEGIN_STM$("issue26",11);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class issue26: Code before inner
        // JavaLine 28 <== SourceLine 16
        bil$2=((issue26$Car)new issue26$Car(((issue26)CUR$),new TXT$("Bil 1")).START$());
        // JavaLine 30 <== SourceLine 17
        ((issue26)CUR$).ActivateDirect(false,bil$2);
        // JavaLine 32 <== SourceLine 18
        hold(((double)(12)));
        TRACE_END_STM$("issue26",18);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue26(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue26.sim","PrefixedBlock issue26",1,2,28,16,30,17,32,18,43,19);
} // End of Class
