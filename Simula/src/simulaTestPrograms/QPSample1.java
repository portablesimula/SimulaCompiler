// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample1 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=52, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    QPSample1$C x=null;
    // Normal Constructor
    public QPSample1(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("QPSample1");
        // Declaration Code
        TRACE_BEGIN_DCL$("QPSample1",30);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("QPSample1",30);
        // JavaLine 23 ==> SourceLine 35
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 26 ==> SourceLine 36
        sysout().outtext(new TXT$("Simple QPS-Sample1 -- Expected Output:"));
        sysout().outimage();
        // JavaLine 29 ==> SourceLine 37
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 32 ==> SourceLine 38
        sysout().outtext(new TXT$("In Block - Just Before call procedure P"));
        sysout().outimage();
        // JavaLine 35 ==> SourceLine 39
        sysout().outtext(new TXT$("In Procedure Q - Just Before first Detach"));
        sysout().outimage();
        // JavaLine 38 ==> SourceLine 40
        sysout().outtext(new TXT$("In Procedure P - Just Before first Resume(x)"));
        sysout().outimage();
        // JavaLine 41 ==> SourceLine 41
        sysout().outtext(new TXT$("In Procedure Q - Just Before second Detach"));
        sysout().outimage();
        // JavaLine 44 ==> SourceLine 42
        sysout().outtext(new TXT$("In Block - Just Before final END"));
        sysout().outimage();
        // JavaLine 47 ==> SourceLine 43
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 50 ==> SourceLine 44
        sysout().outtext(new TXT$("Simple QPS-Sample1 -- Actual Output:"));
        sysout().outimage();
        // JavaLine 53 ==> SourceLine 45
        sysout().outtext(new TXT$("-----------------------------------------"));
        sysout().outimage();
        // JavaLine 56 ==> SourceLine 48
        new QPSample1$trace(((QPSample1)CUR$),new TXT$("In Block - Just Before call procedure P"));
        // JavaLine 58 ==> SourceLine 49
        new QPSample1$P(((QPSample1)CUR$));
        // JavaLine 60 ==> SourceLine 51
        new QPSample1$trace(((QPSample1)CUR$),new TXT$("In Block - Just Before final END"));
        TRACE_END_STM$("QPSample1",51);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new QPSample1(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample1.sim","SimulaProgram QPSample1",1,2,23,35,26,36,29,37,32,38,35,39,38,40,41,41,44,42,47,43,50,44,53,45,56,48,58,49,60,51,71,52);
}
