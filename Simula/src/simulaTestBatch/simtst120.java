package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:28:33 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst120 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ STARTING=new LABQNT$(this,1,"STARTING");
    final LABQNT$ LAB1=new LABQNT$(this,2,"LAB1");
    final LABQNT$ LAB2=new LABQNT$(this,3,"LAB2");
    final LABQNT$ LAB3=new LABQNT$(this,4,"LAB3");
    final LABQNT$ LAB4=new LABQNT$(this,5,"LAB4");
    final LABQNT$ LAB5=new LABQNT$(this,6,"LAB5");
    final LABQNT$ LAB6=new LABQNT$(this,7,"LAB6");
    final LABQNT$ LAB7=new LABQNT$(this,8,"LAB7");
    final LABQNT$ LAB8=new LABQNT$(this,9,"LAB8");
    final LABQNT$ LAB9=new LABQNT$(this,10,"LAB9");
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    boolean b=false;
    int i=0;
    public simtst120(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst120");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=9;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        simtst120 THIS$=(simtst120)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START SIMULA TEST 120"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- VERY LOCAL GOTO SAMPLE"));
                        sysout().outimage();
                        sysout().outimage();
                    }
                }
                facit.Elt[0-facit.LB[0]]=new TXT$("At START");
                facit.Elt[1-facit.LB[0]]=new TXT$("At START");
                facit.Elt[2-facit.LB[0]]=new TXT$("Before GOTO LAB2");
                facit.Elt[3-facit.LB[0]]=new TXT$("At LAB2");
                facit.Elt[4-facit.LB[0]]=new TXT$("At LAB3");
                facit.Elt[5-facit.LB[0]]=new TXT$("At LAB4");
                facit.Elt[6-facit.LB[0]]=new TXT$("At LAB5");
                facit.Elt[7-facit.LB[0]]=new TXT$("At LAB8");
                facit.Elt[8-facit.LB[0]]=new TXT$("At LAB9");
                facit.Elt[9-facit.LB[0]]=new TXT$("At END OF TEST");
                i=2;
                LABEL$(1,"STARTING");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At START"));
                b=(!(b));
                if(VALUE$(b)) {
                    GOTO$(STARTING);
                }
                new simtst120$trace(((simtst120)CUR$),new TXT$("Before GOTO LAB2"));
                GOTO$(LAB2);
                LABEL$(2,"LAB1");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB1"));
                LABEL$(3,"LAB2");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB2"));
                LABEL$(4,"LAB3");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB3"));
                LABEL$(5,"LAB4");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB4"));
                LABEL$(6,"LAB5");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB5"));
                GOTO$(LAB8);
                LABEL$(7,"LAB6");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB6"));
                LABEL$(8,"LAB7");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB7"));
                LABEL$(9,"LAB8");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB8"));
                LABEL$(10,"LAB9");
                new simtst120$trace(((simtst120)CUR$),new TXT$("At LAB9"));
                new simtst120$trace(((simtst120)CUR$),new TXT$("At END OF TEST"));
                if(VALUE$(found_error)) {
                } else
                {
                    sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 120"));
                }
                if(VALUE$(verbose)) {
                    {
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- END SIMULA TEST 120"));
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
        new simtst120(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst120.sim","SimulaProgram simtst120",1,9,8,49,10,59,12,60,14,61,16,62,18,63,20,65,22,66,24,67,26,68,28,9,30,10,32,11,34,12,36,13,38,14,44,12,55,30,57,31,61,32,63,33,68,36,70,37,72,38,74,39,76,40,78,41,80,42,82,43,84,44,86,45,88,47,90,49,93,51,95,53,99,56,101,57,103,59,106,60,109,61,112,62,115,63,118,64,120,65,123,66,126,67,129,68,132,70,134,72,137,75,141,78,143,79,146,80,148,81,170,86);
}
