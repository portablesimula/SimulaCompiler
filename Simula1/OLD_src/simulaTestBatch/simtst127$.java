package simulaTestBatch;
// Simula-1.0 Compiled at Sun Jul 31 17:52:41 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst127$ extends BASICIO$ {
    final LABQNT$ NOMORE=new LABQNT$(this,1,"NOMORE");
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst127$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst127$");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=5;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        simtst127$ THIS$=(simtst127$)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START SIMULA TEST 127"));
                        ;
                        sysout().outimage();
                        ;
                        sysout().outtext(new TXT$("--- Switch Statement"));
                        ;
                        sysout().outimage();
                        ;
                        sysout().outimage();
                        ;
                    }
                }
                ;
                facit.Elt[0-facit.LB[0]]=new TXT$("Test 1 selected case 2");
                ;
                facit.Elt[1-facit.LB[0]]=new TXT$("Test 2 selected case 1");
                ;
                facit.Elt[2-facit.LB[0]]=new TXT$("Test 3 selected case 3");
                ;
                facit.Elt[3-facit.LB[0]]=new TXT$("Test 4 selected case NONE");
                ;
                facit.Elt[4-facit.LB[0]]=new TXT$("In MAIN after NOMORE");
                ;
                new simtst127$$test((CUR$),'B',new TXT$("Test 1"));
                ;
                new simtst127$$test((CUR$),'A',new TXT$("Test 2"));
                ;
                new simtst127$$test((CUR$),'C',new TXT$("Test 3"));
                ;
                new simtst127$$test((CUR$),'Z',new TXT$("Test 4"));
                ;
                new simtst127$$trace((CUR$),new TXT$("Should never come here"));
                ;
                LABEL$(1,"NOMORE");
                new simtst127$$trace((CUR$),new TXT$("In MAIN after NOMORE"));
                ;
                if(VALUE$(found_error)) {
                    ;
                } else
                {
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 127"));
                    ;
                }
                ;
                if(VALUE$(verbose)) {
                    {
                        sysout().outimage();
                        ;
                        sysout().outtext(new TXT$("--- END SIMULA TEST 127"));
                        ;
                        sysout().outimage();
                        ;
                    }
                }
                ;
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
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst127$(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst127.sim","SimulaProgram simtst127$",1,9,7,77,9,9,11,10,13,11,15,12,21,12,32,59,34,60,40,61,43,62,51,65,54,66,57,67,60,68,63,69,66,71,69,72,72,73,75,74,78,75,81,77,85,79,89,82,95,85,97,86,101,87,104,88,128,91);
}
