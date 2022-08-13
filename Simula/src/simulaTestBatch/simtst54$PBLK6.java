package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$PBLK6 extends simulation$ {
    public boolean isQPSystemBlock() { return(true); }
    public boolean isDetachUsed() { return(true); }
    public int u$2=0;
    public simtst54$simtst54$PBLK6$Car bil1$2=null;
    public simtst54$simtst54$PBLK6$Car bil2$2=null;
    public int testCase$2=0;
    public ARRAY$<TXT$[]>facit=null;
    public simtst54$PBLK6(RTObject$ staticLink) {
        super(staticLink);
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=0; facit$UB[0]=33;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    }
    public simtst54$PBLK6 STM$() {
        new simtst54$simtst54$PBLK6$initFacit((CUR$));
        ;
        new simtst54$simtst54$PBLK6$report((CUR$),new TXT$("START Simtest1"));
        ;
        bil1$2=((simtst54$simtst54$PBLK6$Car)new simtst54$simtst54$PBLK6$Car((CUR$),new TXT$("Bil 1")).START$());
        ;
        bil2$2=((simtst54$simtst54$PBLK6$Car)new simtst54$simtst54$PBLK6$Car((CUR$),new TXT$("Bil 2")).START$());
        ;
        new simtst54$simtst54$PBLK6$report((CUR$),CONC(bil1$2.p3$pname,new TXT$(" is scheduled for 4.0")));
        ;
        ((simtst54$PBLK6)(CUR$)).ActivateAt(false,(process$)bil1$2,4.0f,false);
        ;
        new simtst54$simtst54$PBLK6$report((CUR$),CONC(bil2$2.p3$pname,new TXT$(" is scheduled for 6.0")));
        ;
        ((simtst54$PBLK6)(CUR$)).ActivateAt(false,(process$)bil2$2,6.0f,false);
        ;
        hold(12.0d);
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","PrefixedBlock simtst54$PBLK6",1,6,10,7,13,9,15,10,19,10,26,51,29,53,32,54,35,55,38,56,41,57,44,58,47,59,50,60,55,62);
}
