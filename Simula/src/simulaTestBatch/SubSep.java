package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SubSep extends MainSeparat {
    public int prefixLevel() { return(1); }
    public final int ICHR$1=(int)(49);
    public SubSep(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        TRACE_BEGIN_DCL$("SubSep",16);
    }
    public SubSep STM$() {
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
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass2.sim","Class SubSep",1,3,8,5,15,78,17,80,20,81,24,82,26,83,31,86,33,87,35,88,37,89,39,90,41,91,43,92,45,93,47,94,49,95,51,96,53,97,55,98,59,100,61,102,64,103,68,106,70,107,73,18,75,19,77,18,80,21);
}
