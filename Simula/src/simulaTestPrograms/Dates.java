// JavaLine 1 ==> SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Dates extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=0, firstLine=1, lastLine=277, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 4
    public ARRAY$<TXT$[]>WE_tab=null;
    public ARRAY$<TXT$[]>WN_tab=null;
    // JavaLine 14 ==> SourceLine 5
    public ARRAY$<int[]>M_tab=null;
    // JavaLine 16 ==> SourceLine 7
    public final double Lunar_period=29.5305883d;
    // JavaLine 18 ==> SourceLine 9
    public final int Sunday=0;
    public final int Monday=1;
    public final int Tuesday=2;
    public final int Wednesday=3;
    // JavaLine 23 ==> SourceLine 10
    public final int Thursday=4;
    public final int Friday=5;
    public final int Saturday=6;
    // Normal Constructor
    public Dates(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Dates",259);
        // JavaLine 34 ==> SourceLine 4
        int[] WE_tab$LB=new int[1]; int[] WE_tab$UB=new int[1];
        WE_tab$LB[0]=0; WE_tab$UB[0]=6;
        BOUND_CHECK$(WE_tab$LB[0],WE_tab$UB[0]);
        WE_tab=new ARRAY$<TXT$[]>(new TXT$[WE_tab$UB[0]-WE_tab$LB[0]+1],WE_tab$LB,WE_tab$UB);
        int[] WN_tab$LB=new int[1]; int[] WN_tab$UB=new int[1];
        WN_tab$LB[0]=0; WN_tab$UB[0]=6;
        BOUND_CHECK$(WN_tab$LB[0],WN_tab$UB[0]);
        WN_tab=new ARRAY$<TXT$[]>(new TXT$[WN_tab$UB[0]-WN_tab$LB[0]+1],WN_tab$LB,WN_tab$UB);
        // JavaLine 43 ==> SourceLine 5
        int[] M_tab$LB=new int[1]; int[] M_tab$UB=new int[1];
        M_tab$LB[0]=1; M_tab$UB[0]=12;
        BOUND_CHECK$(M_tab$LB[0],M_tab$UB[0]);
        M_tab=new ARRAY$<int[]>(new int[M_tab$UB[0]-M_tab$LB[0]+1],M_tab$LB,M_tab$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Dates",5,inner);
                // JavaLine 52 ==> SourceLine 265
                M_tab.Elt[1-M_tab.LB[0]]=M_tab.Elt[3-M_tab.LB[0]]=M_tab.Elt[5-M_tab.LB[0]]=M_tab.Elt[7-M_tab.LB[0]]=31;
                // JavaLine 54 ==> SourceLine 266
                M_tab.Elt[8-M_tab.LB[0]]=M_tab.Elt[10-M_tab.LB[0]]=M_tab.Elt[12-M_tab.LB[0]]=31;
                // JavaLine 56 ==> SourceLine 267
                M_tab.Elt[4-M_tab.LB[0]]=M_tab.Elt[6-M_tab.LB[0]]=M_tab.Elt[9-M_tab.LB[0]]=M_tab.Elt[11-M_tab.LB[0]]=30;
                // JavaLine 58 ==> SourceLine 268
                M_tab.Elt[2-M_tab.LB[0]]=28;
                // JavaLine 60 ==> SourceLine 270
                WE_tab.Elt[0-WE_tab.LB[0]]=new TXT$("Sunday");
                WN_tab.Elt[0-WN_tab.LB[0]]=new TXT$("s�ndag");
                // JavaLine 63 ==> SourceLine 271
                WE_tab.Elt[1-WE_tab.LB[0]]=new TXT$("Monday");
                WN_tab.Elt[1-WN_tab.LB[0]]=new TXT$("mandag");
                // JavaLine 66 ==> SourceLine 272
                WE_tab.Elt[2-WE_tab.LB[0]]=new TXT$("Tuesday");
                WN_tab.Elt[2-WN_tab.LB[0]]=new TXT$("tirsdag");
                // JavaLine 69 ==> SourceLine 273
                WE_tab.Elt[3-WE_tab.LB[0]]=new TXT$("Wednesday");
                WN_tab.Elt[3-WN_tab.LB[0]]=new TXT$("onsdag");
                // JavaLine 72 ==> SourceLine 274
                WE_tab.Elt[4-WE_tab.LB[0]]=new TXT$("Thursday");
                WN_tab.Elt[4-WN_tab.LB[0]]=new TXT$("torsdag");
                // JavaLine 75 ==> SourceLine 275
                WE_tab.Elt[5-WE_tab.LB[0]]=new TXT$("Friday");
                WN_tab.Elt[5-WN_tab.LB[0]]=new TXT$("fredag");
                // JavaLine 78 ==> SourceLine 276
                WE_tab.Elt[6-WE_tab.LB[0]]=new TXT$("Saturday");
                WN_tab.Elt[6-WN_tab.LB[0]]=new TXT$("l�rdag");
                // JavaLine 81 ==> SourceLine 265
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Dates",265);
                }
                TRACE_END_STM$("Dates",265);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public Dates STM$() { return((Dates)CODE$.EXEC$()); }
    public Dates START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Class Dates",1,1,11,4,14,5,16,7,18,9,23,10,34,4,43,5,52,265,54,266,56,267,58,268,60,270,63,271,66,272,69,273,72,274,75,275,78,276,81,265,93,277);
}
