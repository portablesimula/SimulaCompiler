package simulaTestBatch;
// Simula-2.0 Compiled at Mon Jul 04 17:55:02 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst132$ extends BASICIO$ {
    public final boolean verbose=(boolean)(false);
    public boolean found_error=false;
    public int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst132$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst132$");
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=3;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(false)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 132"));
                ;
                sysout().outimage();
                ;
                sysout().outtext(new TXT$("--- SPORT Options"));
                ;
                sysout().outimage();
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        facit.Elt[0-facit.LB[0]]=new TXT$("BEGIN PROGRAM");
        ;
        facit.Elt[1-facit.LB[0]]=new TXT$("C:/WorkSpaces/SPort-System/S-Port/src/sport/rts/temp/knwn.atr");
        ;
        facit.Elt[2-facit.LB[0]]=new TXT$("C:/WorkSpaces/SPort-System/S-Port/src/sport/rts/temp/cent.atr");
        ;
        facit.Elt[3-facit.LB[0]]=new TXT$("END PROGRAM");
        ;
        new simtst132$$trace((CUR$),new TXT$("BEGIN PROGRAM"));
        ;
        ENVIRONMENT$.giveTextInfo(4,new TXT$("C:/WorkSpaces/SPort-System/S-Port/src/sport/rts"));
        ;
        ENVIRONMENT$.giveTextInfo(2,new TXT$("knwn"));
        ;
        new simtst132$$trace((CUR$),ENVIRONMENT$.getTextInfo(12));
        ;
        ENVIRONMENT$.giveTextInfo(2,new TXT$("cent"));
        ;
        new simtst132$$trace((CUR$),ENVIRONMENT$.getTextInfo(12));
        ;
        new simtst132$$trace((CUR$),new TXT$("END PROGRAM"));
        ;
        if(VALUE$(found_error)) {
            ;
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 132"));
            ;
        }
        ;
        if(VALUE$(false)) {
            {
                sysout().outimage();
                ;
                sysout().outtext(new TXT$("--- END SIMULA TEST 132"));
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst132$(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst132.sim","SimulaProgram simtst132$",1,9,8,10,10,11,12,12,18,12,25,28,27,29,33,30,36,31,44,34,47,35,50,36,53,37,56,39,59,40,62,42,67,43,72,45,75,48,79,51,85,54,87,55,91,56,94,57,107,61);
}
