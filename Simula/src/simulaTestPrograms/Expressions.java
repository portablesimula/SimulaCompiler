// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 20 18:15:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Expressions extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=7, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    int k=0;
    // Normal Constructor
    public Expressions(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Expressions");
        // Declaration Code
        TRACE_BEGIN_DCL$("Expressions",2);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("Expressions",2);
        // JavaLine 24 ==> SourceLine 4
        k=(+(j));
        // JavaLine 26 ==> SourceLine 5
        k=j;
        TRACE_END_STM$("Expressions",5);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Expressions(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Expressions.sim","SimulaProgram Expressions",1,2,24,4,26,5,37,7);
}
