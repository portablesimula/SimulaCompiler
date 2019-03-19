// JavaLine 1 ==> SourceLine 10
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:20:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst102 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=10, lastLine=93, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 79
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,0,1); // Local Label #1=EXIT_LABEL
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 10
    final boolean verbose=true;
    // JavaLine 15 ==> SourceLine 11
    boolean found_error=false;
    // JavaLine 17 ==> SourceLine 13
    int traceCase=0;
    // JavaLine 19 ==> SourceLine 14
    public ARRAY$<TXT$[]>facit=null;
    // Normal Constructor
    public simtst102(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst102");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst102",56);
        // JavaLine 28 ==> SourceLine 14
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=5;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst102",14);
        simtst102 THIS$=(simtst102)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 41 ==> SourceLine 62
                if(VALUE$(verbose)) {
                    // JavaLine 43 ==> SourceLine 63
                    {
                        TRACE_BEGIN_STM$("CompoundStatement63",63);
                        sysout().outtext(new TXT$("--- START SIMULA TEST 102"));
                        sysout().outimage();
                        // JavaLine 48 ==> SourceLine 64
                        sysout().outtext(new TXT$("--- Test Standard Procedure 'sourceline'."));
                        // JavaLine 50 ==> SourceLine 65
                        sysout().outimage();
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement63",65);
                    }
                }
                // JavaLine 56 ==> SourceLine 68
                facit.Elt[0-facit.LB[0]]=new TXT$("LINE 52: START SIMULATION");
                // JavaLine 58 ==> SourceLine 69
                facit.Elt[1-facit.LB[0]]=new TXT$("LINE 54: Bil 1 is scheduled for 4.0");
                // JavaLine 60 ==> SourceLine 70
                facit.Elt[2-facit.LB[0]]=new TXT$("LINE 42: Bil 1 is initiating");
                // JavaLine 62 ==> SourceLine 71
                facit.Elt[3-facit.LB[0]]=new TXT$("LINE 45: Bil 1 is active 1");
                // JavaLine 64 ==> SourceLine 72
                facit.Elt[4-facit.LB[0]]=new TXT$("LINE 47: Bil 1 is active 2");
                // JavaLine 66 ==> SourceLine 73
                facit.Elt[5-facit.LB[0]]=new TXT$("LINE 79: At OUT");
                // JavaLine 68 ==> SourceLine 75
                new simtst102$p(((simtst102)CUR$));
                // JavaLine 70 ==> SourceLine 77
                sysout().outtext(new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
                sysout().outimage();
                // JavaLine 73 ==> SourceLine 79
                LABEL$(1,"EXIT_LABEL");
                new simtst102$trace(((simtst102)CUR$),79,new TXT$("At OUT"));
                // JavaLine 76 ==> SourceLine 81
                if(VALUE$(found_error)) {
                } else
                // JavaLine 79 ==> SourceLine 84
                {
                    TRACE_BEGIN_STM$("CompoundStatement84",84);
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 102"));
                    TRACE_END_STM$("CompoundStatement84",84);
                }
                // JavaLine 85 ==> SourceLine 87
                if(VALUE$(verbose)) {
                    // JavaLine 87 ==> SourceLine 88
                    {
                        TRACE_BEGIN_STM$("CompoundStatement88",88);
                        sysout().outtext(new TXT$("--- END SIMULA TEST 102"));
                        // JavaLine 91 ==> SourceLine 89
                        sysout().outimage();
                        TRACE_END_STM$("CompoundStatement88",89);
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("simtst102",89);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simtst102(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","SimulaProgram simtst102",1,10,10,79,13,10,15,11,17,13,19,14,28,14,41,62,43,63,48,64,50,65,56,68,58,69,60,70,62,71,64,72,66,73,68,75,70,77,73,79,76,81,79,84,85,87,87,88,91,89,118,93);
}
