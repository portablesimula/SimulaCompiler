package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$simtst54$PBLK6$printFacit extends PROC$ {
    public int i=0;
    public simtst54$simtst54$PBLK6$printFacit(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst54$simtst54$PBLK6$printFacit STM$() {
        for(i=0;i<=11;i++) {
            {
                sysout().outtext(((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[i-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]);
                ;
                sysout().outimage();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure printFacit",1,27,7,28,16,30,27,32);
}
