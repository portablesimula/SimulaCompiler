package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Dates extends CLASS$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<TXT$[]>WE_tab=null;
    public ARRAY$<TXT$[]>WN_tab=null;
    public ARRAY$<int[]>M_tab=null;
    public final double Lunar_period=(double)(29.5305883d);
    public final int Sunday=(int)(0);
    public final int Monday=(int)(1);
    public final int Tuesday=(int)(2);
    public final int Wednesday=(int)(3);
    public final int Thursday=(int)(4);
    public final int Friday=(int)(5);
    public final int Saturday=(int)(6);
    public Dates(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("Dates",259);
        int[] WE_tab$LB=new int[1]; int[] WE_tab$UB=new int[1];
        WE_tab$LB[0]=0; WE_tab$UB[0]=6;
        BOUND_CHECK$(WE_tab$LB[0],WE_tab$UB[0]);
        WE_tab=new ARRAY$<TXT$[]>(new TXT$[WE_tab$UB[0]-WE_tab$LB[0]+1],WE_tab$LB,WE_tab$UB);
        int[] WN_tab$LB=new int[1]; int[] WN_tab$UB=new int[1];
        WN_tab$LB[0]=0; WN_tab$UB[0]=6;
        BOUND_CHECK$(WN_tab$LB[0],WN_tab$UB[0]);
        WN_tab=new ARRAY$<TXT$[]>(new TXT$[WN_tab$UB[0]-WN_tab$LB[0]+1],WN_tab$LB,WN_tab$UB);
        int[] M_tab$LB=new int[1]; int[] M_tab$UB=new int[1];
        M_tab$LB[0]=1; M_tab$UB[0]=12;
        BOUND_CHECK$(M_tab$LB[0],M_tab$UB[0]);
        M_tab=new ARRAY$<int[]>(new int[M_tab$UB[0]-M_tab$LB[0]+1],M_tab$LB,M_tab$UB);
    }
    public Dates STM$() {
        M_tab.Elt[1-M_tab.LB[0]]=M_tab.Elt[3-M_tab.LB[0]]=M_tab.Elt[5-M_tab.LB[0]]=M_tab.Elt[7-M_tab.LB[0]]=31;
        M_tab.Elt[8-M_tab.LB[0]]=M_tab.Elt[10-M_tab.LB[0]]=M_tab.Elt[12-M_tab.LB[0]]=31;
        M_tab.Elt[4-M_tab.LB[0]]=M_tab.Elt[6-M_tab.LB[0]]=M_tab.Elt[9-M_tab.LB[0]]=M_tab.Elt[11-M_tab.LB[0]]=30;
        M_tab.Elt[2-M_tab.LB[0]]=28;
        WE_tab.Elt[0-WE_tab.LB[0]]=new TXT$("Sunday");
        WN_tab.Elt[0-WN_tab.LB[0]]=new TXT$("s�ndag");
        WE_tab.Elt[1-WE_tab.LB[0]]=new TXT$("Monday");
        WN_tab.Elt[1-WN_tab.LB[0]]=new TXT$("mandag");
        WE_tab.Elt[2-WE_tab.LB[0]]=new TXT$("Tuesday");
        WN_tab.Elt[2-WN_tab.LB[0]]=new TXT$("tirsdag");
        WE_tab.Elt[3-WE_tab.LB[0]]=new TXT$("Wednesday");
        WN_tab.Elt[3-WN_tab.LB[0]]=new TXT$("onsdag");
        WE_tab.Elt[4-WE_tab.LB[0]]=new TXT$("Thursday");
        WN_tab.Elt[4-WN_tab.LB[0]]=new TXT$("torsdag");
        WE_tab.Elt[5-WE_tab.LB[0]]=new TXT$("Friday");
        WN_tab.Elt[5-WN_tab.LB[0]]=new TXT$("fredag");
        WE_tab.Elt[6-WE_tab.LB[0]]=new TXT$("Saturday");
        WN_tab.Elt[6-WN_tab.LB[0]]=new TXT$("l�rdag");
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Class Dates",1,1,8,4,11,5,13,7,15,9,20,10,28,4,37,5,44,265,46,266,48,267,50,268,52,270,55,271,58,272,61,273,64,274,67,275,70,276,73,265,76,277);
}
