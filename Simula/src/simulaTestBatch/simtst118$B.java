package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:20 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst118$B extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public ARRAY$<float[]>X=null;
    public int ord=0;
    public simtst118$B(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("B",34);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new simtst118$P(((simtst118)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public simtst118$B STM$() {
        ord=((simtst118)(CUR$.SL$)).nB=(((simtst118)(CUR$.SL$)).nB+(1));
        new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event B-1: Just Before First Detach in "),new simtst118$B$id(((simtst118$B)CUR$)).RESULT$));
        detach();
        new simtst118$Print(((simtst118)(CUR$.SL$)),new TXT$("G"));
        new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event B-2: Just Before Second Detach in "),new simtst118$edIdent(((simtst118)(CUR$.SL$)),'B',ord).RESULT$));
        detach();
        new simtst118$Print(((simtst118)(CUR$.SL$)),new TXT$("H"));
        new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event B-3: Just Before Final-END in "),new simtst118$edIdent(((simtst118)(CUR$.SL$)),'B',ord).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst118.sim","Class B",1,31,9,32,11,33,17,32,24,35,26,36,28,37,31,38,33,39,36,40,38,35,41,41);
}
