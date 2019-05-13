package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 17:37:32 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst121 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ EXIT_LABEL=new LABQNT$(this,1,"EXIT_LABEL");
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst121(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst121");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=9;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        simtst121 THIS$=(simtst121)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START SIMULA TEST 121"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- LEGAL GOTO out of an operating Process and the enclosing System."));
                        sysout().outimage();
                        sysout().outimage();
                    }
                }
                facit.Elt[0-facit.LB[0]]=new TXT$("--- START GOTO SAMPLE");
                facit.Elt[1-facit.LB[0]]=new TXT$("START SIMULATION");
                facit.Elt[2-facit.LB[0]]=new TXT$("Bil 1 is scheduled for 4.0");
                facit.Elt[3-facit.LB[0]]=new TXT$("Bil 1 is initiating");
                facit.Elt[4-facit.LB[0]]=new TXT$("Bil 1 is active 1");
                facit.Elt[5-facit.LB[0]]=new TXT$("Bil 1 is active 2");
                facit.Elt[6-facit.LB[0]]=new TXT$("At END OF TEST");
                new simtst121$trace(((simtst121)CUR$),new TXT$("--- START GOTO SAMPLE"));
                new simtst121$p(((simtst121)CUR$));
                new simtst121$trace(((simtst121)CUR$),new TXT$("THIS LINE SHOULD NEVER BE EXECUTED"));
                LABEL$(1,"EXIT_LABEL");
                new simtst121$trace(((simtst121)CUR$),new TXT$("At END OF TEST"));
                if(VALUE$(found_error)) {
                } else
                {
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 121"));
                }
                if(VALUE$(verbose)) {
                    {
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- END SIMULA TEST 121"));
                        sysout().outimage();
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst121(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst121.sim","SimulaProgram simtst121",1,12,8,78,10,12,12,13,14,14,16,15,22,15,33,61,35,62,39,63,41,64,46,67,48,68,50,69,52,70,54,71,56,72,58,73,60,75,62,76,64,77,66,78,69,80,72,83,76,86,78,87,81,88,83,89,105,94);
}
