// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:13:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample0 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=57, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    QPSample0$C x=null;
    // Normal Constructor
    public QPSample0(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("QPSample0");
        // Declaration Code
        TRACE_BEGIN_DCL$("QPSample0",30);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("QPSample0",30);
        // JavaLine 23 ==> SourceLine 35
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 26 ==> SourceLine 36
        sysout().outtext(new TXT$("Simple QPS-Sample0 -- Expected Output:"));
        sysout().outimage();
        // JavaLine 29 ==> SourceLine 37
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 32 ==> SourceLine 38
        sysout().outtext(new TXT$("In Block - Just Before create first A"));
        sysout().outimage();
        // JavaLine 35 ==> SourceLine 39
        sysout().outtext(new TXT$("In Procedure Q - Just Before first Detach"));
        sysout().outimage();
        // JavaLine 38 ==> SourceLine 40
        sysout().outtext(new TXT$("In Class A - Just Before first Resume(x)"));
        sysout().outimage();
        // JavaLine 41 ==> SourceLine 41
        sysout().outtext(new TXT$("In Procedure Q - Just Before second Detach"));
        sysout().outimage();
        // JavaLine 44 ==> SourceLine 42
        sysout().outtext(new TXT$("In Block - Just Before create second A"));
        sysout().outimage();
        // JavaLine 47 ==> SourceLine 43
        sysout().outtext(new TXT$("In Procedure Q - Just Before first Detach"));
        sysout().outimage();
        // JavaLine 50 ==> SourceLine 44
        sysout().outtext(new TXT$("In Class A - Just Before first Resume(x)"));
        sysout().outimage();
        // JavaLine 53 ==> SourceLine 45
        sysout().outtext(new TXT$("In Procedure Q - Just Before second Detach"));
        sysout().outimage();
        // JavaLine 56 ==> SourceLine 46
        sysout().outtext(new TXT$("In Block - Just Before final END"));
        sysout().outimage();
        // JavaLine 59 ==> SourceLine 47
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 62 ==> SourceLine 48
        sysout().outtext(new TXT$("Simple QPS-Sample0 -- Actual Output:"));
        sysout().outimage();
        // JavaLine 65 ==> SourceLine 49
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 68 ==> SourceLine 51
        new QPSample0$trace(((QPSample0)CUR$),new TXT$("In Block - Just Before create first A"));
        // JavaLine 70 ==> SourceLine 52
        new QPSample0$A(((QPSample0)CUR$)).STM$();
        // JavaLine 72 ==> SourceLine 53
        new QPSample0$trace(((QPSample0)CUR$),new TXT$("In Block - Just Before create second A"));
        // JavaLine 74 ==> SourceLine 54
        new QPSample0$A(((QPSample0)CUR$)).STM$();
        // JavaLine 76 ==> SourceLine 55
        new QPSample0$trace(((QPSample0)CUR$),new TXT$("In Block - Just Before final END"));
        TRACE_END_STM$("QPSample0",55);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new QPSample0(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample0.sim","SimulaProgram QPSample0",1,2,23,35,26,36,29,37,32,38,35,39,38,40,41,41,44,42,47,43,50,44,53,45,56,46,59,47,62,48,65,49,68,51,70,52,72,53,74,54,76,55,87,57);
}
