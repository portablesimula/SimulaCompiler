package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:55 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst119$PBLK12 extends SubSep {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final float rrr$2;
    TXT$ fname$2=null;
    public simtst119$PBLK12(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        rrr$2=rr+(3.14f);
    }
    public simtst119$PBLK12 STM$() {
        if(VALUE$((p$i==(5)))) {
            {
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START SIMULA TEST 119"));
                        sysout().outimage();
                        sysout().outtext(new TXT$("--- Use of Precompiled classes"));
                        sysout().outimage();
                        sysout().outimage();
                    }
                }
                facit.Elt[0-facit.LB[0]]=new TXT$("--- Start Statements of Class MainSeparat");
                facit.Elt[1-facit.LB[0]]=new TXT$("--- Start Statements of Class SubSep");
                facit.Elt[2-facit.LB[0]]=new TXT$("In Procedure P");
                facit.Elt[3-facit.LB[0]]=new TXT$("In Procedure P");
                facit.Elt[4-facit.LB[0]]=new TXT$("Event A-1: (A1)");
                facit.Elt[5-facit.LB[0]]=new TXT$("Event B-1: (B1)");
                facit.Elt[6-facit.LB[0]]=new TXT$("--- Start Statements of SubSep(5) begin");
                facit.Elt[7-facit.LB[0]]=new TXT$("In Procedure P");
                facit.Elt[8-facit.LB[0]]=new TXT$("In Procedure P");
                facit.Elt[9-facit.LB[0]]=new TXT$("Event A-1: (A2)");
                facit.Elt[10-facit.LB[0]]=new TXT$("Event B-1: (B2)");
                facit.Elt[11-facit.LB[0]]=new TXT$("OK");
                facit.Elt[12-facit.LB[0]]=new TXT$("--- NORMAL END OF PROGRAM");
            }
        } else
        if(VALUE$((p$i==(15)))) {
            {
                facit.Elt[0-facit.LB[0]]=new TXT$("--- Start Statements of Class MainSeparat");
                facit.Elt[1-facit.LB[0]]=new TXT$("--- Start Statements of Class SubSep2");
            }
        }
        new MainSeparat$trace(((MainSeparat)CUR$),new TXT$("--- Start Statements of Class MainSeparat"));
        nA=0;
        nB=0;
        new MainSeparat$trace(((SubSep)CUR$),new TXT$("--- Start Statements of Class SubSep"));
        x=new MainSeparat$B(((SubSep)CUR$)).STM$();
        new MainSeparat$trace(((simtst119$PBLK12)CUR$),new TXT$("--- Start Statements of SubSep(5) begin"));
        x=new MainSeparat$B(((simtst119$PBLK12)CUR$)).STM$();
        iA.Elt[3-iA.LB[0]]=5;
        if(VALUE$(((ICHR$1==(49))&((IINT==(45)))))) {
            {
                new MainSeparat$trace(((simtst119$PBLK12)CUR$),new TXT$("OK"));
            }
        }
        fname$2=sysout().filename();
        new SubSep$PP(((simtst119$PBLK12)CUR$));
        new MainSeparat$trace(((simtst119$PBLK12)CUR$),new TXT$("--- NORMAL END OF PROGRAM"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 119"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 119"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst119.sim","PrefixedBlock simtst119$PBLK12",1,12,10,13,17,78,19,80,22,81,26,82,28,83,33,86,35,87,37,88,39,89,41,90,43,91,45,92,47,93,49,94,51,95,53,96,55,97,57,98,61,100,63,102,66,103,70,106,72,107,75,18,77,19,79,15,81,16,83,17,85,18,87,19,92,21,94,22,96,23,98,26,101,29,105,32,107,33,110,34,112,35,118,38);
}
