package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat May 04 11:45:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Separat extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$i;
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
    public Separat$A x=null;
    public Separat$B y=null;
    public PRCQNT$ EXIT$0(){ throw new RuntimeException("No Virtual Match: EXIT"); }
    public Separat(RTObject$ staticLink,int sp$i) {
        super(staticLink);
        this.p$i = sp$i;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("Separat",59);
        rr=((float)((((double)(IINT))+(sqrt(((double)(4)))))));
        int[] iA$LB=new int[1]; int[] iA$UB=new int[1];
        iA$LB[0]=1; iA$UB[0]=6;
        BOUND_CHECK$(iA$LB[0],iA$UB[0]);
        iA=new ARRAY$<int[]>(new int[iA$UB[0]-iA$LB[0]+1],iA$LB,iA$UB);
    }
    public Separat STM$() {
        new Separat$Print(((Separat)CUR$),new TXT$("--- Start Statements of Class Separat"));
        nA=0;
        nB=0;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass1.sim","Class Separat",1,2,9,4,11,5,13,6,15,7,17,8,19,9,21,11,23,12,27,23,29,24,38,12,45,63,47,64,50,63,53,66);
}
