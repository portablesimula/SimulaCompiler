// JavaLine 1 <== SourceLine 1
package simulaTestPrograms;
// Simula-2.0 Compiled at Sun Aug 21 11:59:30 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00 extends _Simulation {
    // PrefixedBlockDeclaration: Kind=PrefixedBlock, BlockLevel=1, firstLine=1, lastLine=30, hasLocalClasses=true, System=true, detachUsed=false
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public adHoc00(_RTObject staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("adHoc00");
        // Declaration Code
    }
    // Class Statements
    public adHoc00 _STM() {
        // Class Simset: Code before inner
        // Class Simulation: Code before inner
        // Class adHoc00: Code before inner
        EBLK();
        return(this);
    } // End of Class Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        _RT.setRuntimeOptions(args);
        new adHoc00(CTX_)._STM();
    } // End of main
    public static _PROGINFO INFO_=new _PROGINFO("adHoc00.sim","PrefixedBlock adHoc00",1,1,32,30);
} // End of Class
