package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 10:11:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$initFacit extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst54$initFacit(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst54$initFacit STM$() {
        ((simtst54)(CUR$.SL$)).facit.Elt[0-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: START Simtest1");
        ((simtst54)(CUR$.SL$)).facit.Elt[1-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: Bil 1 is scheduled for 4.0");
        ((simtst54)(CUR$.SL$)).facit.Elt[2-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: Bil 2 is scheduled for 6.0");
        ((simtst54)(CUR$.SL$)).facit.Elt[3-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("4.00: Bil 1 is initiating");
        ((simtst54)(CUR$.SL$)).facit.Elt[4-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("4.00: Bil 1 is active 1");
        ((simtst54)(CUR$.SL$)).facit.Elt[5-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("6.00: Bil 2 is initiating");
        ((simtst54)(CUR$.SL$)).facit.Elt[6-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("6.00: Bil 2 is active 1");
        ((simtst54)(CUR$.SL$)).facit.Elt[7-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("8.00: Bil 1 is active 2");
        ((simtst54)(CUR$.SL$)).facit.Elt[8-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("8.00: Bil 1 is active 1");
        ((simtst54)(CUR$.SL$)).facit.Elt[9-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("10.00: Bil 2 is active 2");
        ((simtst54)(CUR$.SL$)).facit.Elt[10-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("10.00: Bil 2 is active 1");
        ((simtst54)(CUR$.SL$)).facit.Elt[11-((simtst54)(CUR$.SL$)).facit.LB[0]]=new TXT$("12.00: Final END of Simulation");
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure initFacit",1,12,14,13,16,14,18,15,20,16,22,17,24,18,26,19,28,20,30,21,32,22,34,23,36,24,40,25);
}
