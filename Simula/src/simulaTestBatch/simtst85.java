// JavaLine 1 ==> SourceLine 12
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 17 13:27:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst85 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=12, lastLine=311, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    boolean errorfound=false;
    // JavaLine 11 ==> SourceLine 13
    boolean verbose=false;
    // JavaLine 13 ==> SourceLine 21
    DirectFile$ inspect$21$0=null;
    // Normal Constructor
    public simtst85(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst85");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst85",21);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst85",21);
        // JavaLine 26 ==> SourceLine 15
        if(VALUE$(verbose)) {
            // JavaLine 28 ==> SourceLine 16
            {
                TRACE_BEGIN_STM$("CompoundStatement16",16);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 85 (test DIRECTFILE)"));
                sysout().outimage();
                // JavaLine 33 ==> SourceLine 17
                sysout().outtext(new TXT$("    - does 'new directfile(\"direct85\")'.open(blanks(12)"));
                // JavaLine 35 ==> SourceLine 18
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement16",18);
            }
        }
        // JavaLine 41 ==> SourceLine 21
        {
            // BEGIN INSPECTION 
            inspect$21$0=new DirectFile$(((BASICIO$)CTX$),new TXT$("direct85")).STM$();
            if(inspect$21$0!=null) //INSPECT inspect$21$0
            // JavaLine 46 ==> SourceLine 299
            new simtst85$SubBlock23(CUR$).STM$();
        }
        // JavaLine 49 ==> SourceLine 301
        if(VALUE$(errorfound)) {
        } else
        // JavaLine 52 ==> SourceLine 303
        {
            TRACE_BEGIN_STM$("CompoundStatement303",303);
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 85"));
            TRACE_END_STM$("CompoundStatement303",303);
        }
        // JavaLine 58 ==> SourceLine 305
        if(VALUE$(verbose)) {
            // JavaLine 60 ==> SourceLine 306
            {
                TRACE_BEGIN_STM$("CompoundStatement306",306);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 85"));
                // JavaLine 64 ==> SourceLine 307
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement306",307);
            }
        }
        TRACE_END_STM$("simtst85",307);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simtst85(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst85.sim","SimulaProgram simtst85",1,12,11,13,13,21,26,15,28,16,33,17,35,18,41,21,46,299,49,301,52,303,58,305,60,306,64,307,78,311);
}
