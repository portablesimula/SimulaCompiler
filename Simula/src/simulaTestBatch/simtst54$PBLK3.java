// JavaLine 1 ==> SourceLine 3
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Mar 12 21:45:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$PBLK3 extends Simulation$ {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=3, lastLine=91, hasLocalClasses=true, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 14 ==> SourceLine 4
    final boolean verbose=false;
    // JavaLine 16 ==> SourceLine 6
    int u=0;
    // JavaLine 18 ==> SourceLine 7
    simtst54$PBLK3$Car bil1=null;
    simtst54$PBLK3$Car bil2=null;
    // JavaLine 21 ==> SourceLine 9
    int testCase=0;
    // JavaLine 23 ==> SourceLine 10
    public ARRAY$<TXT$[]>facit=null;
    // Normal Constructor
    public simtst54$PBLK3(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("simtst54$PBLK3");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst54$PBLK3",47);
        // JavaLine 32 ==> SourceLine 10
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=33;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simtst54$PBLK3",10,inner);
                // JavaLine 41 ==> SourceLine 56
                new simtst54$PBLK3$initFacit(((simtst54$PBLK3)CUR$));
                // JavaLine 43 ==> SourceLine 57
                if(VALUE$(verbose)) {
                    // JavaLine 45 ==> SourceLine 58
                    {
                        TRACE_BEGIN_STM$("CompoundStatement58",58);
                        sysout().outtext(new TXT$("--- START Simula a.s. TEST 54"));
                        sysout().outimage();
                        // JavaLine 50 ==> SourceLine 59
                        sysout().outtext(new TXT$("--- A VERY Simple Simulation"));
                        sysout().outimage();
                        // JavaLine 53 ==> SourceLine 60
                        sysout().outtext(new TXT$("--------------------------------"));
                        sysout().outimage();
                        // JavaLine 56 ==> SourceLine 61
                        sysout().outtext(new TXT$("Expected output:"));
                        sysout().outimage();
                        // JavaLine 59 ==> SourceLine 62
                        sysout().outtext(new TXT$("--------------------------------"));
                        sysout().outimage();
                        // JavaLine 62 ==> SourceLine 63
                        new simtst54$PBLK3$printFacit(((simtst54$PBLK3)CUR$));
                        // JavaLine 64 ==> SourceLine 64
                        sysout().outtext(new TXT$("--------------------------------"));
                        sysout().outimage();
                        // JavaLine 67 ==> SourceLine 65
                        sysout().outtext(new TXT$("Actual output:"));
                        sysout().outimage();
                        // JavaLine 70 ==> SourceLine 66
                        sysout().outtext(new TXT$("--------------------------------"));
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement58",66);
                    }
                }
                // JavaLine 76 ==> SourceLine 69
                new simtst54$PBLK3$report(((simtst54$PBLK3)CUR$),new TXT$("START Simtest1"));
                // JavaLine 78 ==> SourceLine 70
                bil1=new simtst54$PBLK3$Car(((simtst54$PBLK3)CUR$),new TXT$("Bil 1")).START();
                // JavaLine 80 ==> SourceLine 71
                bil2=new simtst54$PBLK3$Car(((simtst54$PBLK3)CUR$),new TXT$("Bil 2")).START();
                // JavaLine 82 ==> SourceLine 72
                new simtst54$PBLK3$report(((simtst54$PBLK3)CUR$),CONC(bil1.p3$pname,new TXT$(" is scheduled for 4.0")));
                // JavaLine 84 ==> SourceLine 73
                ((simtst54$PBLK3)CUR$).ActivateAt(false,bil1,4.0f,false);
                // JavaLine 86 ==> SourceLine 74
                new simtst54$PBLK3$report(((simtst54$PBLK3)CUR$),CONC(bil2.p3$pname,new TXT$(" is scheduled for 6.0")));
                // JavaLine 88 ==> SourceLine 75
                ((simtst54$PBLK3)CUR$).ActivateAt(false,bil2,6.0f,false);
                // JavaLine 90 ==> SourceLine 76
                hold(((double)(12)));
                // JavaLine 92 ==> SourceLine 78
                new simtst54$PBLK3$report(((simtst54$PBLK3)CUR$),new TXT$("Final END of Simulation"));
                // JavaLine 94 ==> SourceLine 79
                if(VALUE$(verbose)) {
                    // JavaLine 96 ==> SourceLine 80
                    {
                        TRACE_BEGIN_STM$("CompoundStatement80",80);
                        sysout().outtext(new TXT$("--------------------------------"));
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement80",80);
                    }
                }
                // JavaLine 104 ==> SourceLine 83
                if(VALUE$(found_error)) {
                    // JavaLine 106 ==> SourceLine 85
                    sysout().outtext(new TXT$("--- ERRORS FOUND IN TEST 54 - Re-Run with verbose = true"));
                } else
                sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 54"));
                // JavaLine 110 ==> SourceLine 87
                if(VALUE$(verbose)) {
                    // JavaLine 112 ==> SourceLine 88
                    {
                        TRACE_BEGIN_STM$("CompoundStatement88",88);
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- END Simula TEST 54"));
                        // JavaLine 117 ==> SourceLine 91
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement88",91);
                    }
                }
                TRACE_END_STM$("simtst54$PBLK3",91);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simtst54$PBLK3(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","PrefixedBlock simtst54$PBLK3",1,3,14,4,16,6,18,7,21,9,23,10,32,10,41,56,43,57,45,58,50,59,53,60,56,61,59,62,62,63,64,64,67,65,70,66,76,69,78,70,80,71,82,72,84,73,86,74,88,75,90,76,92,78,94,79,96,80,104,83,106,85,110,87,112,88,117,91,131,91);
}
