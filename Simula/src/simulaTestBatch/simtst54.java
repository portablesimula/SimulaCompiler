package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 10:11:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    boolean found_error$2=false;
    final boolean verbose$2=(boolean)(false);
    int u$2=0;
    simtst54$Car bil1$2=null;
    simtst54$Car bil2$2=null;
    int testCase$2=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst54(RTObject$ staticLink) {
        super(staticLink);
        BPRG("simtst54");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=33;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public simtst54 STM$() {
        new simtst54$initFacit(((simtst54)(CUR$)));
        if(VALUE$(verbose$2)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 54"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- A VERY Simple Simulation"));
                sysout().outimage();
                sysout().outtext(new TXT$("--------------------------------"));
                sysout().outimage();
                sysout().outtext(new TXT$("Expected output:"));
                sysout().outimage();
                sysout().outtext(new TXT$("--------------------------------"));
                sysout().outimage();
                new simtst54$printFacit(((simtst54)(CUR$)));
                sysout().outtext(new TXT$("--------------------------------"));
                sysout().outimage();
                sysout().outtext(new TXT$("Actual output:"));
                sysout().outimage();
                sysout().outtext(new TXT$("--------------------------------"));
                sysout().outimage();
            }
        }
        new simtst54$report(((simtst54)(CUR$)),new TXT$("START Simtest1"));
        bil1$2=((simtst54$Car)new simtst54$Car(((simtst54)(CUR$)),new TXT$("Bil 1")).START$());
        bil2$2=((simtst54$Car)new simtst54$Car(((simtst54)(CUR$)),new TXT$("Bil 2")).START$());
        new simtst54$report(((simtst54)(CUR$)),CONC(bil1$2.p3$pname,new TXT$(" is scheduled for 4.0")));
        ((simtst54)(CUR$)).ActivateAt(false,bil1$2,4.0f,false);
        new simtst54$report(((simtst54)(CUR$)),CONC(bil2$2.p3$pname,new TXT$(" is scheduled for 6.0")));
        ((simtst54)(CUR$)).ActivateAt(false,bil2$2,6.0f,false);
        hold(((double)(12)));
        new simtst54$report(((simtst54)(CUR$)),new TXT$("Final END of Simulation"));
        if(VALUE$(verbose$2)) {
            {
                sysout().outtext(new TXT$("--------------------------------"));
                sysout().outimage();
            }
        }
        if(VALUE$(found_error$2)) {
            sysout().outtext(new TXT$("--- ERRORS FOUND IN TEST 54 - Re-Run with verbose = true"));
        } else
        sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 54"));
        if(VALUE$(verbose$2)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END Simula TEST 54"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst54(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","PrefixedBlock simtst54",1,3,11,4,13,6,15,7,18,9,20,10,25,10,32,56,34,57,36,58,40,59,43,60,46,61,49,62,52,63,54,64,57,65,60,66,65,69,67,70,69,71,71,72,73,73,75,74,77,75,79,76,81,78,83,79,85,80,91,83,93,85,97,87,99,88,103,91,114,91);
}
