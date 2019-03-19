// JavaLine 1 ==> SourceLine 12
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Mar 13 15:32:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$PBLK3$initFacit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=12, lastLine=25, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst54$PBLK3$initFacit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("initFacit",12);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst54$PBLK3$initFacit STM$() {
        TRACE_BEGIN_STM$("initFacit",12);
        // JavaLine 23 ==> SourceLine 13
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[0-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: START Simtest1");
        // JavaLine 25 ==> SourceLine 14
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[1-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: Bil 1 is scheduled for 4.0");
        // JavaLine 27 ==> SourceLine 15
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[2-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("0.00: Bil 2 is scheduled for 6.0");
        // JavaLine 29 ==> SourceLine 16
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[3-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("4.00: Bil 1 is initiating");
        // JavaLine 31 ==> SourceLine 17
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[4-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("4.00: Bil 1 is active 1");
        // JavaLine 33 ==> SourceLine 18
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[5-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("6.00: Bil 2 is initiating");
        // JavaLine 35 ==> SourceLine 19
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[6-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("6.00: Bil 2 is active 1");
        // JavaLine 37 ==> SourceLine 20
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[7-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("8.00: Bil 1 is active 2");
        // JavaLine 39 ==> SourceLine 21
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[8-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("8.00: Bil 1 is active 1");
        // JavaLine 41 ==> SourceLine 22
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[9-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("10.00: Bil 2 is active 2");
        // JavaLine 43 ==> SourceLine 23
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[10-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("10.00: Bil 2 is active 1");
        // JavaLine 45 ==> SourceLine 24
        ((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[11-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]=new TXT$("12.00: Final END of Simulation");
        TRACE_END_STM$("initFacit",24);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure initFacit",1,12,23,13,25,14,27,15,29,16,31,17,33,18,35,19,37,20,39,21,41,22,43,23,45,24,50,25);
}
