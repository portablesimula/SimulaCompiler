package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 13 10:19:31 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst125 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ L3=new LABQNT$(this,1,"L3");
    final LABQNT$ L2=new LABQNT$(this,2,"L2");
    final LABQNT$ L1=new LABQNT$(this,3,"L1");
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    int n=0;
    public simtst125(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst125");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=3;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        simtst125 THIS$=(simtst125)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START SIMULA TEST 125"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- GOTO VIRTUAL LABEL"));
                        sysout().outimage();
                        sysout().outimage();
                    }
                }
                facit.Elt[0-facit.LB[0]]=new TXT$("BEGIN PROGRAM");
                facit.Elt[1-facit.LB[0]]=new TXT$("At L3");
                facit.Elt[2-facit.LB[0]]=new TXT$("At L1");
                facit.Elt[3-facit.LB[0]]=new TXT$("END PROGRAM");
                new simtst125$trace(((simtst125)CUR$),new TXT$("BEGIN PROGRAM"));
                GOTO$(L3);
                {
                    {
                        {
                            LABEL$(1,"L3");
                            new simtst125$trace(((simtst125)CUR$),new TXT$("At L3"));
                        }
                        GOTO$(L1);
                        LABEL$(2,"L2");
                        new simtst125$trace(((simtst125)CUR$),new TXT$("At L2"));
                    }
                    LABEL$(3,"L1");
                    new simtst125$trace(((simtst125)CUR$),new TXT$("At L1"));
                }
                new simtst125$trace(((simtst125)CUR$),new TXT$("END PROGRAM"));
                if(VALUE$(found_error)) {
                } else
                {
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 125"));
                }
                if(VALUE$(verbose)) {
                    {
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- END SIMULA TEST 125"));
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
        new simtst125(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst125.sim","SimulaProgram simtst125",1,15,8,53,10,56,12,58,14,15,16,16,18,17,20,18,22,19,28,18,39,35,41,36,45,37,47,38,52,41,54,42,56,43,58,44,60,46,62,48,64,51,66,52,68,53,73,55,75,56,79,58,83,61,85,64,88,67,92,70,94,71,97,72,99,73,121,77);
}
