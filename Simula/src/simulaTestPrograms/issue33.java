// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed Jun 05 16:10:06 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue33 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=3, lastLine=16, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    issue33$Truck x$2=null;
    // JavaLine 14 <== SourceLine 4
    Head$ queue$2=null;
    // Normal Constructor
    public issue33(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("issue33");
        // Declaration Code
        TRACE_BEGIN_DCL$("issue33",7);
    }
    // Class Statements
    public issue33 STM$() {
        TRACE_BEGIN_STM$("issue33",7);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class issue33: Code before inner
        // JavaLine 30 <== SourceLine 12
        queue$2=new Head$(((issue33)(CUR$))).STM$();
        // JavaLine 32 <== SourceLine 13
        x$2=((issue33$Truck)new issue33$Truck(((issue33)(CUR$))).START$());
        // JavaLine 34 <== SourceLine 14
        x$2=((issue33$Truck)new issue33$Truck(((issue33)(CUR$))).START$());
        TRACE_END_STM$("issue33",14);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new issue33(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("issue33.sim","PrefixedBlock issue33",1,3,14,4,30,12,32,13,34,14,45,16);
} // End of Class
