package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Apr 29 14:51:19 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst110 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    simtst110$ProducerClass Producer=null;
    simtst110$ConsumerClass Consumer=null;
    public simtst110(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst110");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=11;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 110"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Simple Co-Routine Sample 3: detach - resume - chain"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("Main: Before new Producer");
        facit.Elt[1-facit.LB[0]]=new TXT$("Producer:Init");
        facit.Elt[2-facit.LB[0]]=new TXT$("Main: Before new Consumer");
        facit.Elt[3-facit.LB[0]]=new TXT$("Consumer:Init");
        facit.Elt[4-facit.LB[0]]=new TXT$("Main: Before first resume");
        facit.Elt[5-facit.LB[0]]=new TXT$("Producer:Part 1 - Statements");
        facit.Elt[6-facit.LB[0]]=new TXT$("Consumer:Part 1 - Statements");
        facit.Elt[7-facit.LB[0]]=new TXT$("Producer:Part 2 - Statements");
        facit.Elt[8-facit.LB[0]]=new TXT$("Consumer:Part 2 - Statements");
        facit.Elt[9-facit.LB[0]]=new TXT$("Producer:Part 3 - Statements");
        facit.Elt[10-facit.LB[0]]=new TXT$("Consumer:Part 3 - Statements");
        facit.Elt[11-facit.LB[0]]=new TXT$("Main: End of Program");
        {
            new simtst110$trace(((simtst110)CUR$),new TXT$("Main: Before new Producer"));
            Producer=((simtst110$ProducerClass)new simtst110$ProducerClass(((simtst110)CUR$)).START$());
            new simtst110$trace(((simtst110)CUR$),new TXT$("Main: Before new Consumer"));
            Consumer=((simtst110$ConsumerClass)new simtst110$ConsumerClass(((simtst110)CUR$)).START$());
            new simtst110$trace(((simtst110)CUR$),new TXT$("Main: Before first resume"));
            resume(Producer);
            new simtst110$trace(((simtst110)CUR$),new TXT$("Main: End of Program"));
        }
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 110"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 110"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst110(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst110.sim","SimulaProgram simtst110",1,9,10,10,12,11,14,12,16,13,18,14,24,12,31,54,33,55,37,56,39,57,44,60,46,61,48,62,50,63,52,64,54,65,56,66,58,67,60,68,62,69,64,70,66,71,68,74,71,75,73,76,75,77,77,78,79,79,81,80,84,83,87,86,91,89,93,90,96,91,98,92,109,95);
}
