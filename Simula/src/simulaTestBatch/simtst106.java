// JavaLine 1 ==> SourceLine 12
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=12, lastLine=247, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 11 ==> SourceLine 14
    final TXT$ fileName=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/testing/batch/files/data96");
    // JavaLine 13 ==> SourceLine 21
    InFile$ inspect$20$0=null;
    // Normal Constructor
    public simtst106(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst106");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst106",21);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst106",21);
        // JavaLine 26 ==> SourceLine 16
        sysout().outtext(new TXT$("--- START Simula a.s. TEST 96"));
        sysout().outimage();
        // JavaLine 29 ==> SourceLine 17
        sysout().outtext(new TXT$("    Test of Simulation - reads from infile \"data96\"."));
        // JavaLine 31 ==> SourceLine 18
        sysout().outimage();
        sysout().outimage();
        // JavaLine 34 ==> SourceLine 20
        {
            // BEGIN INSPECTION 
            inspect$20$0=new InFile$(((BASICIO$)CTX$),fileName).STM$();
            if(inspect$20$0!=null) //INSPECT inspect$20$0
            // JavaLine 39 ==> SourceLine 242
            new simtst106$PBLK76(CUR$).START();
        }
        // JavaLine 42 ==> SourceLine 243
        sysout().outtext(new TXT$("--- END Simula a.s. TEST 96"));
        // JavaLine 44 ==> SourceLine 244
        if(VALUE$((!(found_error)))) {
            sysout().outtext(new TXT$(" (NO ERRORS FOUND)"));
        }
        // JavaLine 48 ==> SourceLine 245
        sysout().outimage();
        TRACE_END_STM$("simtst106",245);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simtst106(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","SimulaProgram simtst106",1,12,11,14,13,21,26,16,29,17,31,18,34,20,39,242,42,243,44,244,48,245,59,247);
}
