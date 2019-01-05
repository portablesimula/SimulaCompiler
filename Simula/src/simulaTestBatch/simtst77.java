// JavaLine 1 ==> SourceLine 11
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Sat Jan 05 09:02:04 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst77 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=11, lastLine=95, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 12 ==> SourceLine 12
    final boolean verbose=false;
    // JavaLine 14 ==> SourceLine 14
    final TXT$ fileName=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/any77");
    // Normal Constructor
    public simtst77(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst77");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst77",46);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst77",46);
        // JavaLine 27 ==> SourceLine 72
        if(verbose) {
            // JavaLine 29 ==> SourceLine 73
            {
                TRACE_BEGIN_STM$("CompoundStatement73",73);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 77"));
                // JavaLine 33 ==> SourceLine 74
                sysout().outimage();
                // JavaLine 35 ==> SourceLine 75
                sysout().outtext(new TXT$("--- Test infile using two infile objects reading from the"));
                // JavaLine 37 ==> SourceLine 76
                sysout().outimage();
                // JavaLine 39 ==> SourceLine 77
                sysout().outtext(CONC(new TXT$("--- same external file: "),fileName));
                // JavaLine 41 ==> SourceLine 78
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement73",78);
            }
        }
        // JavaLine 47 ==> SourceLine 81
        resume(new simtst77$Les(((simtst77)CUR$),3,new simtst77$Les(((simtst77)CUR$),7,null).START()).START());
        // JavaLine 49 ==> SourceLine 83
        if(found_error) {
        } else
        // JavaLine 52 ==> SourceLine 86
        {
            TRACE_BEGIN_STM$("CompoundStatement86",86);
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 77"));
            TRACE_END_STM$("CompoundStatement86",86);
        }
        // JavaLine 58 ==> SourceLine 89
        if(verbose) {
            // JavaLine 60 ==> SourceLine 90
            {
                TRACE_BEGIN_STM$("CompoundStatement90",90);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 77"));
                // JavaLine 64 ==> SourceLine 95
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement90",95);
            }
        }
        TRACE_END_STM$("simtst77",95);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst77(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst77.sim","SimulaProgram simtst77",1,11,12,12,14,14,27,72,29,73,33,74,35,75,37,76,39,77,41,78,47,81,49,83,52,86,58,89,60,90,64,95,77,95);
}
