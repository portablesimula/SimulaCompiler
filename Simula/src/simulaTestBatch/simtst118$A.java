package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:20 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst118$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public ARRAY$<float[]>X=null;
    public int ord=0;
    public simtst118$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",20);
        int[] X$LB=new int[1]; int[] X$UB=new int[1];
        X$LB[0]=((int)((int)Math.round(new simtst118$P(((simtst118)(CUR$.SL$))).RESULT$))); X$UB[0]=1;
        BOUND_CHECK$(X$LB[0],X$UB[0]);
        X=new ARRAY$<float[]>(new float[X$UB[0]-X$LB[0]+1],X$LB,X$UB);
    }
    public simtst118$A STM$() {
        ord=((simtst118)(CUR$.SL$)).nA=(((simtst118)(CUR$.SL$)).nA+(1));
        new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event A-1: Just Before First Detach in "),new simtst118$A$id(((simtst118$A)CUR$)).RESULT$));
        detach();
        new simtst118$Print(((simtst118)(CUR$.SL$)),new TXT$("B"));
        new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event A-2: Just Before Second Detach in "),new simtst118$edIdent(((simtst118)(CUR$.SL$)),'A',ord).RESULT$));
        detach();
        new simtst118$Print(((simtst118)(CUR$.SL$)),new TXT$("F"));
        new simtst118$Print(((simtst118)(CUR$.SL$)),CONC(new TXT$("Event A-3: Just Before Final-END in "),new simtst118$edIdent(((simtst118)(CUR$.SL$)),'A',ord).RESULT$));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst118.sim","Class A",1,17,9,18,11,19,17,18,24,21,26,22,28,23,30,24,32,25,34,26,36,27,38,28,40,21,43,29);
}
