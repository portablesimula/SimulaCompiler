// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Thu May 30 18:23:16 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=3, lastLine=10, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc01(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("adHoc01");
        // Declaration Code
        TRACE_BEGIN_DCL$("adHoc01",6);
    }
    // Class Statements
    public adHoc01 STM$() {
        TRACE_BEGIN_STM$("adHoc01",6);
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class adHoc01: Code before inner
        new adHoc01$Customer$abra(((adHoc01$Customer)new adHoc01$Customer(((adHoc01)CUR$)).START$()));
        TRACE_END_STM$("adHoc01",8);
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new adHoc01(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","PrefixedBlock adHoc01",1,3,37,10);
} // End of Class
