package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 10:27:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst114 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ NOMORE=new LABQNT$(this,1,"NOMORE");
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst114(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst114");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=5;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        simtst114 THIS$=(simtst114)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START SIMULA TEST 114"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- Switch Statement"));
                        sysout().outimage();
                        sysout().outimage();
                    }
                }
                facit.Elt[0-facit.LB[0]]=new TXT$("Test 1 selected case 2");
                facit.Elt[1-facit.LB[0]]=new TXT$("Test 2 selected case 1");
                facit.Elt[2-facit.LB[0]]=new TXT$("Test 3 selected case 3");
                facit.Elt[3-facit.LB[0]]=new TXT$("Test 4 selected case NONE");
                facit.Elt[4-facit.LB[0]]=new TXT$("In MAIN after NOMORE");
                new simtst114$test(((simtst114)CUR$),2,new TXT$("Test 1"));
                new simtst114$test(((simtst114)CUR$),1,new TXT$("Test 2"));
                new simtst114$test(((simtst114)CUR$),3,new TXT$("Test 3"));
                new simtst114$test(((simtst114)CUR$),200,new TXT$("Test 4"));
                new simtst114$trace(((simtst114)CUR$),new TXT$("Should never come here"));
                LABEL$(1,"NOMORE");
                new simtst114$trace(((simtst114)CUR$),new TXT$("In MAIN after NOMORE"));
                if(VALUE$(found_error)) {
                } else
                {
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 114"));
                }
                if(VALUE$(verbose)) {
                    {
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- END SIMULA TEST 114"));
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
        new simtst114(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst114.sim","SimulaProgram simtst114",1,9,8,77,10,9,12,10,14,11,16,12,22,12,33,59,35,60,39,61,41,62,46,65,48,66,50,67,52,68,54,69,56,71,58,72,60,73,62,74,64,75,66,77,69,79,72,82,76,85,78,86,81,87,83,88,105,91);
}
