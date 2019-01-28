// JavaLine 1 ==> SourceLine 3
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 26 19:56:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Editing extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=52, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int p=0;
    // JavaLine 12 ==> SourceLine 4
    TXT$ T=null;
    TXT$ U=null;
    // Normal Constructor
    public Editing(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Editing");
        // Declaration Code
        TRACE_BEGIN_DCL$("Editing",4);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("Editing",4);
        // JavaLine 26 ==> SourceLine 6
        sysout().outimage();
        sysout().outtext(new TXT$("*** Getfrac test case 1:"));
        sysout().outimage();
        // JavaLine 30 ==> SourceLine 8
        T=copy(copy(new TXT$("abra 5")));
        // JavaLine 32 ==> SourceLine 9
        U=TXT$.sub(T,6,1);
        // JavaLine 34 ==> SourceLine 11
        sysout().outtext(CONC(CONC(new TXT$("T=]"),T),new TXT$("[")));
        sysout().outimage();
        // JavaLine 37 ==> SourceLine 12
        sysout().outtext(CONC(CONC(new TXT$("U=]"),U),new TXT$("[")));
        sysout().outimage();
        // JavaLine 40 ==> SourceLine 14
        i=TXT$.getfrac(U);
        // JavaLine 42 ==> SourceLine 15
        p=TXT$.pos(U);
        // JavaLine 44 ==> SourceLine 16
        sysout().outtext(new TXT$("Result: i="));
        sysout().outint(i,4);
        sysout().outimage();
        // JavaLine 48 ==> SourceLine 17
        sysout().outtext(new TXT$("Facit:  i=   5"));
        sysout().outimage();
        // JavaLine 51 ==> SourceLine 18
        sysout().outtext(new TXT$("Result: p="));
        sysout().outint(p,4);
        sysout().outimage();
        // JavaLine 55 ==> SourceLine 19
        sysout().outtext(new TXT$("Facit:  p=   2"));
        sysout().outimage();
        // JavaLine 58 ==> SourceLine 21
        sysout().outimage();
        sysout().outtext(new TXT$("*** Getfrac test case 2:"));
        sysout().outimage();
        // JavaLine 62 ==> SourceLine 23
        T=copy(copy(new TXT$("abra    3545   768")));
        // JavaLine 64 ==> SourceLine 24
        U=TXT$.sub(T,5,9);
        // JavaLine 66 ==> SourceLine 26
        sysout().outtext(CONC(CONC(new TXT$("T=]"),T),new TXT$("[")));
        sysout().outimage();
        // JavaLine 69 ==> SourceLine 27
        sysout().outtext(CONC(CONC(new TXT$("U=]"),U),new TXT$("[")));
        sysout().outimage();
        // JavaLine 72 ==> SourceLine 29
        i=TXT$.getfrac(U);
        // JavaLine 74 ==> SourceLine 30
        p=TXT$.pos(U);
        // JavaLine 76 ==> SourceLine 31
        sysout().outtext(new TXT$("Result: i="));
        sysout().outint(i,4);
        sysout().outimage();
        // JavaLine 80 ==> SourceLine 32
        sysout().outtext(new TXT$("Facit:  i=3545"));
        sysout().outimage();
        // JavaLine 83 ==> SourceLine 33
        sysout().outtext(new TXT$("Result: p="));
        sysout().outint(p,4);
        sysout().outimage();
        // JavaLine 87 ==> SourceLine 34
        sysout().outtext(new TXT$("Facit:  p=   9"));
        sysout().outimage();
        // JavaLine 90 ==> SourceLine 36
        sysout().outimage();
        sysout().outtext(new TXT$("*** Getfrac test case 3:"));
        sysout().outimage();
        // JavaLine 94 ==> SourceLine 38
        T=copy(copy(new TXT$("ab           1 234 567 .")));
        // JavaLine 96 ==> SourceLine 39
        U=TXT$.sub(T,3,22);
        // JavaLine 98 ==> SourceLine 41
        sysout().outtext(CONC(CONC(new TXT$("T=]"),T),new TXT$("[")));
        sysout().outimage();
        // JavaLine 101 ==> SourceLine 42
        sysout().outtext(CONC(CONC(new TXT$("U=]"),U),new TXT$("[")));
        sysout().outimage();
        // JavaLine 104 ==> SourceLine 44
        i=TXT$.getfrac(U);
        // JavaLine 106 ==> SourceLine 45
        p=TXT$.pos(U);
        // JavaLine 108 ==> SourceLine 46
        sysout().outtext(new TXT$("Result: i="));
        sysout().outint(i,8);
        sysout().outimage();
        // JavaLine 112 ==> SourceLine 47
        sysout().outtext(new TXT$("Facit:  i= 1234567"));
        sysout().outimage();
        // JavaLine 115 ==> SourceLine 48
        sysout().outtext(new TXT$("Result: p="));
        sysout().outint(p,8);
        sysout().outimage();
        // JavaLine 119 ==> SourceLine 49
        sysout().outtext(new TXT$("Facit:  p=      21"));
        sysout().outimage();
        TRACE_END_STM$("Editing",49);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Editing(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Editing.sim","SimulaProgram Editing",1,3,12,4,26,6,30,8,32,9,34,11,37,12,40,14,42,15,44,16,48,17,51,18,55,19,58,21,62,23,64,24,66,26,69,27,72,29,74,30,76,31,80,32,83,33,87,34,90,36,94,38,96,39,98,41,101,42,104,44,106,45,108,46,112,47,115,48,119,49,131,52);
}
