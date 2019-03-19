// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Mar 13 15:33:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CoroutineSample extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=46, hasLocalClasses=true, System=true
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
        TRACE_BEGIN_DCL$("CoroutineSample",13);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("CoroutineSample",13);
        // JavaLine 23 ==> SourceLine 20
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 26 ==> SourceLine 21
        sysout().outtext(new TXT$("CoroutineSample -- Expected Output:"));
        sysout().outimage();
        // JavaLine 29 ==> SourceLine 22
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 32 ==> SourceLine 23
        sysout().outtext(new TXT$("Main: Before new A"));
        sysout().outimage();
        // JavaLine 35 ==> SourceLine 24
        sysout().outtext(new TXT$("A: State 1(Initiating)"));
        sysout().outimage();
        // JavaLine 38 ==> SourceLine 25
        sysout().outtext(new TXT$("Main: Before first call"));
        sysout().outimage();
        // JavaLine 41 ==> SourceLine 26
        sysout().outtext(new TXT$("A: State 2"));
        sysout().outimage();
        // JavaLine 44 ==> SourceLine 27
        sysout().outtext(new TXT$("Main: Before second call"));
        sysout().outimage();
        // JavaLine 47 ==> SourceLine 28
        sysout().outtext(new TXT$("A: State 3(Terminating)"));
        sysout().outimage();
        // JavaLine 50 ==> SourceLine 29
        sysout().outtext(new TXT$("Main: Before third call"));
        sysout().outimage();
        // JavaLine 53 ==> SourceLine 30
        sysout().outtext(new TXT$("ERROR: Call(x): x is not in detached state."));
        sysout().outimage();
        // JavaLine 56 ==> SourceLine 31
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 59 ==> SourceLine 32
        sysout().outtext(new TXT$("CoroutineSample -- Actual Output:"));
        sysout().outimage();
        // JavaLine 62 ==> SourceLine 33
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 65 ==> SourceLine 36
        {
            TRACE_BEGIN_STM$("CompoundStatement36",36);
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before new A"));
            // JavaLine 69 ==> SourceLine 37
            x=new CoroutineSample$A(((CoroutineSample)CUR$)).START();
            // JavaLine 71 ==> SourceLine 38
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before first call"));
            // JavaLine 73 ==> SourceLine 39
            call(x);
            // JavaLine 75 ==> SourceLine 40
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before second call"));
            // JavaLine 77 ==> SourceLine 41
            call(x);
            // JavaLine 79 ==> SourceLine 42
            new CoroutineSample$trace(((CoroutineSample)CUR$),new TXT$("Main: Before third call"));
            // JavaLine 81 ==> SourceLine 43
            call(x);
            TRACE_END_STM$("CompoundStatement36",43);
        }
        TRACE_END_STM$("CoroutineSample",43);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new CoroutineSample(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("CoroutineSample.sim","SimulaProgram CoroutineSample",1,2,23,20,26,21,29,22,32,23,35,24,38,25,41,26,44,27,47,28,50,29,53,30,56,31,59,32,62,33,65,36,69,37,71,38,73,39,75,40,77,41,79,42,81,43,94,46);
}
