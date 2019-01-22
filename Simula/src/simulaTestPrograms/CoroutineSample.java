// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 20 10:46:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CoroutineSample extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=45, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    CoroutineSample$A x=null;
    // Normal Constructor
    public CoroutineSample(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("CoroutineSample");
        // Declaration Code
        TRACE_BEGIN_DCL$("CoroutineSample",12);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("CoroutineSample",12);
        // JavaLine 23 ==> SourceLine 19
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 26 ==> SourceLine 20
        sysout().outtext(new TXT$("CoroutineSample -- Expected Output:"));
        sysout().outimage();
        // JavaLine 29 ==> SourceLine 21
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 32 ==> SourceLine 22
        sysout().outtext(new TXT$("Main: Before new A"));
        sysout().outimage();
        // JavaLine 35 ==> SourceLine 23
        sysout().outtext(new TXT$("A: State 1(Initiating)"));
        sysout().outimage();
        // JavaLine 38 ==> SourceLine 24
        sysout().outtext(new TXT$("Main: Before first call"));
        sysout().outimage();
        // JavaLine 41 ==> SourceLine 25
        sysout().outtext(new TXT$("A: State 2"));
        sysout().outimage();
        // JavaLine 44 ==> SourceLine 26
        sysout().outtext(new TXT$("Main: Before second call"));
        sysout().outimage();
        // JavaLine 47 ==> SourceLine 27
        sysout().outtext(new TXT$("A: State 3(Terminating)"));
        sysout().outimage();
        // JavaLine 50 ==> SourceLine 28
        sysout().outtext(new TXT$("Main: Before third call"));
        sysout().outimage();
        // JavaLine 53 ==> SourceLine 29
        sysout().outtext(new TXT$("ERROR: Call(x): x is not in detached state."));
        sysout().outimage();
        // JavaLine 56 ==> SourceLine 30
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 59 ==> SourceLine 31
        sysout().outtext(new TXT$("CoroutineSample -- Actual Output:"));
        sysout().outimage();
        // JavaLine 62 ==> SourceLine 32
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 65 ==> SourceLine 35
        {
            TRACE_BEGIN_STM$("CompoundStatement35",35);
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before new A"));
            // JavaLine 69 ==> SourceLine 36
            x=new CoroutineSample$A(((CoroutineSample)CUR$)).START();
            // JavaLine 71 ==> SourceLine 37
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before first call"));
            // JavaLine 73 ==> SourceLine 38
            call(x);
            // JavaLine 75 ==> SourceLine 39
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before second call"));
            // JavaLine 77 ==> SourceLine 40
            call(x);
            // JavaLine 79 ==> SourceLine 41
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before third call"));
            // JavaLine 81 ==> SourceLine 42
            call(x);
            TRACE_END_STM$("CompoundStatement35",42);
        }
        TRACE_END_STM$("CoroutineSample",42);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new CoroutineSample(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("CoroutineSample.sim","SimulaProgram CoroutineSample",1,2,23,19,26,20,29,21,32,22,35,23,38,24,41,25,44,26,47,27,50,28,53,29,56,30,59,31,62,32,65,35,69,36,71,37,73,38,75,39,77,40,79,41,81,42,94,45);
}
