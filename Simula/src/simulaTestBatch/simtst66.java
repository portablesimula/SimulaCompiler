// JavaLine 1 ==> SourceLine 10
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Mar 09 10:18:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst66 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=10, lastLine=131, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 12 ==> SourceLine 11
    final boolean verbose=false;
    // JavaLine 14 ==> SourceLine 13
    final TXT$ fileName=new TXT$("C:/GitHub/SimulaCompiler/Simula/src/simulaTestBatch/files/any66");
    // JavaLine 16 ==> SourceLine 68
    simtst66$Innfil fil1=null;
    simtst66$Innfil fil2=null;
    // Normal Constructor
    public simtst66(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst66");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst66",76);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst66",76);
        // JavaLine 30 ==> SourceLine 79
        if(VALUE$(verbose)) {
            // JavaLine 32 ==> SourceLine 80
            {
                TRACE_BEGIN_STM$("CompoundStatement80",80);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 66"));
                // JavaLine 36 ==> SourceLine 81
                sysout().outimage();
                // JavaLine 38 ==> SourceLine 82
                sysout().outtext(new TXT$("--- Test corutines and two instances of infile which read "));
                // JavaLine 40 ==> SourceLine 83
                sysout().outimage();
                // JavaLine 42 ==> SourceLine 84
                sysout().outtext(new TXT$("--- from the same file simultanously."));
                // JavaLine 44 ==> SourceLine 85
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement80",85);
            }
        }
        // JavaLine 50 ==> SourceLine 90
        fil1=new simtst66$Innfil(((simtst66)CUR$),new simtst66$Innfil(((simtst66)CUR$),null,copy(fileName),5).START(),copy(fileName),13).START();
        // JavaLine 52 ==> SourceLine 91
        fil2=fil1.p$neste;
        // JavaLine 54 ==> SourceLine 92
        fil2.p$neste=fil1;
        // JavaLine 56 ==> SourceLine 94
        resume(fil1);
        // JavaLine 58 ==> SourceLine 96
        if(VALUE$((!(new simtst66$Ok(((simtst66)CUR$),fil1,fil2,1).RESULT$)))) {
            // JavaLine 60 ==> SourceLine 115
            new simtst66$SubBlock98(CUR$).STM$();
        }
        // JavaLine 63 ==> SourceLine 117
        if(VALUE$(found_error)) {
            // JavaLine 65 ==> SourceLine 119
            sysout().outimage();
        } else
        // JavaLine 68 ==> SourceLine 120
        {
            TRACE_BEGIN_STM$("CompoundStatement120",120);
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 66"));
            TRACE_END_STM$("CompoundStatement120",120);
        }
        // JavaLine 74 ==> SourceLine 123
        fil1.fil.close();
        fil2.fil.close();
        // JavaLine 77 ==> SourceLine 126
        if(VALUE$(verbose)) {
            // JavaLine 79 ==> SourceLine 127
            {
                TRACE_BEGIN_STM$("CompoundStatement127",127);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 66"));
                // JavaLine 83 ==> SourceLine 131
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement127",131);
            }
        }
        TRACE_END_STM$("simtst66",131);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simtst66(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst66.sim","SimulaProgram simtst66",1,10,12,11,14,13,16,68,30,79,32,80,36,81,38,82,40,83,42,84,44,85,50,90,52,91,54,92,56,94,58,96,60,115,63,117,65,119,68,120,74,123,77,126,79,127,83,131,97,131);
}
