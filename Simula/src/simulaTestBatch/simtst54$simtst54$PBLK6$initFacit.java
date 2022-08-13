package simulaTestBatch;
// Simula-2.0 Compiled at Fri Aug 12 13:52:55 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$simtst54$PBLK6$initFacit extends PROC$ {
    public simtst54$simtst54$PBLK6$initFacit(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst54$simtst54$PBLK6$initFacit STM$() {
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[0-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: START Simtest1");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[1-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: Bil 1 is scheduled for 4.0");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[2-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: Bil 2 is scheduled for 6.0");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[3-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("4.00: Bil 1 is initiating");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[4-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("4.00: Bil 1 is active 1");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[5-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("6.00: Bil 2 is initiating");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[6-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("6.00: Bil 2 is active 1");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[7-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("8.00: Bil 1 is active 2");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[8-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("8.00: Bil 1 is active 1");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[9-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("10.00: Bil 2 is active 2");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[10-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("10.00: Bil 2 is active 1");
        ;
        ((simtst54$PBLK6)(CUR$.SL$)).facit.Elt[11-((simtst54$PBLK6)(CUR$.SL$)).facit.LB[0]]=new TXT$("12.00: Final END of Simulation");
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure initFacit",1,12,13,13,16,14,19,15,22,16,25,17,28,18,31,19,34,20,37,21,40,22,43,23,46,24,51,25);
}
