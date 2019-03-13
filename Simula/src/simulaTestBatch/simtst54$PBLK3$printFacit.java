// JavaLine 1 ==> SourceLine 27
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Mar 12 21:45:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$PBLK3$printFacit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=27, lastLine=32, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 28
    int i=0;
    // Normal Constructor
    public simtst54$PBLK3$printFacit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("printFacit",28);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst54$PBLK3$printFacit STM$() {
        TRACE_BEGIN_STM$("printFacit",28);
        // JavaLine 25 ==> SourceLine 29
        for(boolean CB$29:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(11); }})
           )) { if(!CB$29) continue;
        // JavaLine 29 ==> SourceLine 30
        {
            TRACE_BEGIN_STM$("CompoundStatement30",30);
            sysout().outtext(((simtst54$PBLK3)(CUR$.SL$)).facit.Elt[i-((simtst54$PBLK3)(CUR$.SL$)).facit.LB[0]]);
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement30",30);
        }
    }
    TRACE_END_STM$("printFacit",30);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure printFacit",1,27,11,28,25,29,29,30,40,32);
}
