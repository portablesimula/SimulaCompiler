package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 12:44:15 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst103 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    final boolean verbose$2=(boolean)(true);
    boolean found_error$2=false;
    simtst103$Car bil1$2=null;
    simtst103$Car bil2$2=null;
    simtst103$Car bil3$2=null;
    TXT$ t$2=null;
    int traceCase$2=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst103(RTObject$ staticLink) {
        super(staticLink);
        BPRG("simtst103");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public simtst103 STM$() {
        if(VALUE$(verbose$2)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 103"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test Activation Statements"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        facit.Elt[0-facit.LB[0]]=new TXT$("  0.00: Bil-1: Run Fase-1");
        facit.Elt[1-facit.LB[0]]=new TXT$("  4.00: Bil-1: Run Fase-2");
        facit.Elt[2-facit.LB[0]]=new TXT$("  7.45: Bil-3: Run Fase-1");
        facit.Elt[3-facit.LB[0]]=new TXT$("  7.45: Bil-2: Run Fase-1");
        facit.Elt[4-facit.LB[0]]=new TXT$(" 11.45: Bil-3: Run Fase-2");
        facit.Elt[5-facit.LB[0]]=new TXT$(" 11.45: Bil-2: Run Fase-2");
        facit.Elt[6-facit.LB[0]]=new TXT$(" 16.00: Bil-1: Terminates");
        facit.Elt[7-facit.LB[0]]=new TXT$(" 23.45: Bil-3: Terminates");
        facit.Elt[8-facit.LB[0]]=new TXT$(" 23.45: Bil-2: Terminates");
        ((simtst103)(CUR$)).ActivateDirect(false,bil1$2);
        bil1$2=((simtst103$Car)new simtst103$Car(((simtst103)(CUR$)),new TXT$("Bil-1")).START$());
        ((simtst103)(CUR$)).ActivateDirect(false,bil1$2);
        bil2$2=((simtst103$Car)new simtst103$Car(((simtst103)(CUR$)),new TXT$("Bil-2")).START$());
        bil3$2=((simtst103$Car)new simtst103$Car(((simtst103)(CUR$)),new TXT$("Bil-3")).START$());
        ((simtst103)(CUR$)).ActivateAt(false,bil2$2,7.45f,false);
        ((simtst103)(CUR$)).ActivateAt(false,bil3$2,7.45f,true);
        ((simtst103)(CUR$)).ActivateDelay(false,bil2$2,1.23f,false);
        ((simtst103)(CUR$)).ActivateDelay(false,bil3$2,1.23f,true);
        ((simtst103)(CUR$)).ActivateBefore(false,bil2$2,bil1$2);
        ((simtst103)(CUR$)).ActivateAfter(false,bil3$2,bil1$2);
        hold(((double)(100)));
        if(VALUE$(found_error$2)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 103"));
        }
        if(VALUE$(verbose$2)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 103"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst103(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst103.sim","PrefixedBlock simtst103",1,10,11,11,13,13,17,14,19,16,21,17,26,17,33,47,35,48,39,49,41,50,46,53,48,54,50,55,52,56,54,57,56,58,58,59,60,60,62,61,64,63,66,65,68,66,70,67,72,68,74,69,76,70,78,71,80,72,82,73,84,74,86,75,88,77,91,80,95,83,97,84,100,85,102,86,113,89);
}
