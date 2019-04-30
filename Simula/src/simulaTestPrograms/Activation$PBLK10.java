package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 28 21:54:05 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Activation$PBLK10 extends Simulation$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    final boolean verbose$2=(boolean)(false);
    boolean found_error$2=false;
    Activation$PBLK10$Car bil1$2=null;
    Activation$PBLK10$Car bil2$2=null;
    Activation$PBLK10$Car bil3$2=null;
    TXT$ t$2=null;
    int traceCase$2=0;
    public ARRAY$<TXT$[]>facit=null;
    public Activation$PBLK10(RTObject$ staticLink) {
        super(staticLink);
        BPRG("Activation$PBLK10");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=8;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public Activation$PBLK10 STM$() {
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
        ((Activation$PBLK10)CUR$).ActivateDirect(false,bil1$2);
        bil1$2=((Activation$PBLK10$Car)new Activation$PBLK10$Car(((Activation$PBLK10)CUR$),new TXT$("Bil-1")).START$());
        ((Activation$PBLK10)CUR$).ActivateDirect(false,bil1$2);
        bil2$2=((Activation$PBLK10$Car)new Activation$PBLK10$Car(((Activation$PBLK10)CUR$),new TXT$("Bil-2")).START$());
        bil3$2=((Activation$PBLK10$Car)new Activation$PBLK10$Car(((Activation$PBLK10)CUR$),new TXT$("Bil-3")).START$());
        ((Activation$PBLK10)CUR$).ActivateAt(false,bil2$2,7.45f,false);
        ((Activation$PBLK10)CUR$).ActivateAt(false,bil3$2,7.45f,true);
        ((Activation$PBLK10)CUR$).ActivateDelay(false,bil2$2,1.23f,false);
        ((Activation$PBLK10)CUR$).ActivateDelay(false,bil3$2,1.23f,true);
        ((Activation$PBLK10)CUR$).ActivateBefore(false,bil2$2,bil1$2);
        ((Activation$PBLK10)CUR$).ActivateAfter(false,bil3$2,bil1$2);
        hold(((double)(100)));
        if(VALUE$(found_error$2)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 103"));
            sysout().outimage();
        }
        if(VALUE$(verbose$2)) {
            {
                sysout().outtext(new TXT$("--- END SIMULA TEST 103"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new Activation$PBLK10(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Activation.sim","PrefixedBlock Activation$PBLK10",1,10,11,11,13,13,17,14,19,16,21,17,26,17,33,50,35,51,39,52,41,53,46,56,48,57,50,58,52,59,54,60,56,61,58,62,60,63,62,64,64,66,66,68,68,69,70,70,72,71,74,72,76,73,78,74,80,75,82,76,84,77,86,78,88,80,91,83,94,84,97,87,99,88,102,89,113,92);
}
