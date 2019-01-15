// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Jan 14 20:33:57 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HelloWorld extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=4, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // Normal Constructor
    public HelloWorld(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("HelloWorld");
        // Declaration Code
        TRACE_BEGIN_DCL$("HelloWorld",2);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("HelloWorld",2);
        sysout().outtext(new TXT$("Hello World!"));
        // JavaLine 22 ==> SourceLine 3
        sysout().outimage();
        TRACE_END_STM$("HelloWorld",3);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new HelloWorld(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HelloWorld.sim","SimulaProgram HelloWorld",1,2,22,3,33,4);
}
