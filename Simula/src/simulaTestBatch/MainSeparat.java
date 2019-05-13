package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:53 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class MainSeparat extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$i;
    public final boolean verbose=(boolean)(false);
    public final boolean TESTING=(boolean)(true);
    public boolean found_error=false;
    public int traceCase=0;
    public ARRAY$<TXT$[]>facit=null;
    public final int IINT=(int)(45);
    public final int IREA=(int)(46);
    public final char cc=(char)('a');
    public final TXT$ ttt=(TXT$)(new TXT$("Abracadabra"));
    public final boolean bb=(boolean)(true);
    public final float rr;
    public TXT$ t=null;
    public int nA=0;
    public int nB=0;
    public ARRAY$<int[]>iA=null;
    public MainSeparat$A x=null;
    public MainSeparat$B y=null;
    public PRCQNT$ EXIT$0(){ throw new RuntimeException("No Virtual Match: EXIT"); }
    public MainSeparat(RTObject$ staticLink,int sp$i) {
        super(staticLink);
        this.p$i = sp$i;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("MainSeparat",75);
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=14;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
        rr=((float)((((double)(IINT))+(sqrt(((double)(4)))))));
        int[] iA$LB=new int[1]; int[] iA$UB=new int[1];
        iA$LB[0]=1; iA$UB[0]=6;
        BOUND_CHECK$(iA$LB[0],iA$UB[0]);
        iA=new ARRAY$<int[]>(new int[iA$UB[0]-iA$LB[0]+1],iA$LB,iA$UB);
    }
    public MainSeparat STM$() {
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
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Class MainSeparat",1,2,9,4,11,5,13,6,15,7,17,8,19,10,21,11,23,12,25,13,27,14,29,15,31,17,33,18,37,19,39,20,47,8,53,18,60,78,62,80,65,81,69,82,71,83,76,86,78,87,80,88,82,89,84,90,86,91,88,92,90,93,92,94,94,95,96,96,98,97,100,98,104,100,106,102,109,103,113,106,115,107,118,78,121,109);
}
