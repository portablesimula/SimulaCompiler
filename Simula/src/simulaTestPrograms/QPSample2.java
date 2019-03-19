// JavaLine 1 ==> SourceLine 11
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample2 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=11, lastLine=102, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    final boolean verbose=true;
    // JavaLine 12 ==> SourceLine 12
    boolean found_error=false;
    // JavaLine 14 ==> SourceLine 14
    int n=0;
    // JavaLine 16 ==> SourceLine 15
    public ARRAY$<TXT$[]>facit=null;
    public ARRAY$<TXT$[]>notes=null;
    // JavaLine 19 ==> SourceLine 31
    QPSample2$C1 X1=null;
    // JavaLine 21 ==> SourceLine 37
    QPSample2$C2 X2=null;
    // Normal Constructor
    public QPSample2(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("QPSample2");
        // Declaration Code
        TRACE_BEGIN_DCL$("QPSample2",45);
        // JavaLine 30 ==> SourceLine 15
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
        int[] notes$LB=new int[1]; int[] notes$UB=new int[1];
        notes$LB[0]=0; notes$UB[0]=8;
        BOUND_CHECK$(notes$LB[0],notes$UB[0]);
        notes=new ARRAY$<TXT$[]>(new TXT$[notes$UB[0]-notes$LB[0]+1],notes$LB,notes$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("QPSample2",15);
        // JavaLine 43 ==> SourceLine 62
        sysout().outtext(new TXT$("--- START Simula a.s. TEST 69"));
        // JavaLine 45 ==> SourceLine 63
        sysout().outimage();
        // JavaLine 47 ==> SourceLine 64
        sysout().outtext(new TXT$("--- Test complex use of detach, call and resume."));
        // JavaLine 49 ==> SourceLine 65
        sysout().outimage();
        sysout().outimage();
        // JavaLine 52 ==> SourceLine 68
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("--------------------------------------------------------"));
        // JavaLine 54 ==> SourceLine 69
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("Begin Annotated example from Simula Standard sect. 7.3.1"));
        // JavaLine 56 ==> SourceLine 70
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("--------------------------------------------------------"));
        // JavaLine 58 ==> SourceLine 71
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("Expected Output:"));
        // JavaLine 60 ==> SourceLine 72
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("--------------------------------------------------------"));
        // JavaLine 62 ==> SourceLine 73
        facit.Elt[0-facit.LB[0]]=new TXT$("Before Detach C1 - see fig. 7.1");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[0-facit.LB[0]]);
        // JavaLine 65 ==> SourceLine 74
        facit.Elt[1-facit.LB[0]]=new TXT$("After  Detach C1 - see fig. 7.2");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[1-facit.LB[0]]);
        // JavaLine 68 ==> SourceLine 75
        facit.Elt[2-facit.LB[0]]=new TXT$("Before Detach C3 - see fig. 7.3");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[2-facit.LB[0]]);
        // JavaLine 71 ==> SourceLine 76
        facit.Elt[3-facit.LB[0]]=new TXT$("After  Detach C3 - see fig. 7.4");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[3-facit.LB[0]]);
        // JavaLine 74 ==> SourceLine 77
        facit.Elt[4-facit.LB[0]]=new TXT$("After  Resume X3 - see fig. 7.5");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[4-facit.LB[0]]);
        // JavaLine 77 ==> SourceLine 78
        facit.Elt[5-facit.LB[0]]=new TXT$("Before Detach C2 - see fig. 7.6");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[5-facit.LB[0]]);
        // JavaLine 80 ==> SourceLine 79
        facit.Elt[6-facit.LB[0]]=new TXT$("After  Detach C2 - see fig. 7.7");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[6-facit.LB[0]]);
        // JavaLine 83 ==> SourceLine 80
        facit.Elt[7-facit.LB[0]]=new TXT$("After  Detach C2 - see fig. 7.6 again");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[7-facit.LB[0]]);
        // JavaLine 86 ==> SourceLine 81
        facit.Elt[8-facit.LB[0]]=new TXT$("Final END of Example");
        new QPSample2$prt(((QPSample2)CUR$),facit.Elt[8-facit.LB[0]]);
        // JavaLine 89 ==> SourceLine 82
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("--------------------------------------------------------"));
        // JavaLine 91 ==> SourceLine 83
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("Actual Output:"));
        // JavaLine 93 ==> SourceLine 84
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("--------------------------------------------------------"));
        // JavaLine 95 ==> SourceLine 86
        X1=new QPSample2$C1(((QPSample2)CUR$)).START();
        // JavaLine 97 ==> SourceLine 87
        new QPSample2$note(((QPSample2)CUR$),new TXT$("After  Detach C1 - see fig. 7.2"));
        // JavaLine 99 ==> SourceLine 88
        X2=new QPSample2$C2(((QPSample2)CUR$)).START();
        // JavaLine 101 ==> SourceLine 89
        new QPSample2$note(((QPSample2)CUR$),new TXT$("After  Detach C2 - see fig. 7.7"));
        // JavaLine 103 ==> SourceLine 90
        call(X2);
        // JavaLine 105 ==> SourceLine 91
        new QPSample2$note(((QPSample2)CUR$),new TXT$("Final END of Example"));
        // JavaLine 107 ==> SourceLine 92
        new QPSample2$prt(((QPSample2)CUR$),new TXT$("--------------------------------------------------------"));
        // JavaLine 109 ==> SourceLine 94
        if(VALUE$(found_error)) {
            // JavaLine 111 ==> SourceLine 96
            {
                TRACE_BEGIN_STM$("CompoundStatement96",96);
                sysout().outtext(new TXT$("*** ERROR: Program sequencing. RERUN WITH 'verbose' set TRUE !"));
                TRACE_END_STM$("CompoundStatement96",96);
            }
        } else
        // JavaLine 118 ==> SourceLine 98
        {
            TRACE_BEGIN_STM$("CompoundStatement98",98);
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN THIS TEST"));
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement98",98);
        }
        // JavaLine 125 ==> SourceLine 100
        sysout().outtext(new TXT$("--- END Simula a.s. TEST 69"));
        // JavaLine 127 ==> SourceLine 102
        sysout().outimage();
        TRACE_END_STM$("QPSample2",102);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new QPSample2(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","SimulaProgram QPSample2",1,11,12,12,14,14,16,15,19,31,21,37,30,15,43,62,45,63,47,64,49,65,52,68,54,69,56,70,58,71,60,72,62,73,65,74,68,75,71,76,74,77,77,78,80,79,83,80,86,81,89,82,91,83,93,84,95,86,97,87,99,88,101,89,103,90,105,91,107,92,109,94,111,96,118,98,125,100,127,102,138,102);
}
