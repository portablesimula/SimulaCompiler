package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SubSep$PP$SubSep2 extends MainSeparat {
    public int prefixLevel() { return(1); }
    public SubSep$PP$SubSep2(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
        TRACE_BEGIN_DCL$("SubSep2",11);
    }
    public SubSep$PP$SubSep2 STM$() {
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
        new MainSeparat$trace(((SubSep$PP$SubSep2)CUR$),new TXT$("--- Start Statements of Class SubSep2"));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass2.sim","Class SubSep2",1,11,13,78,15,80,18,81,22,82,24,83,29,86,31,87,33,88,35,89,37,90,39,91,41,92,43,93,45,94,47,95,49,96,51,97,53,98,57,100,59,102,62,103,66,106,68,107,74,15);
}
