// JavaLine 1 ==> SourceLine 69
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst107$PBLK12$createobjects extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=69, lastLine=76, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 70
    int i=0;
    // Normal Constructor
    public simtst107$PBLK12$createobjects(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("createobjects",70);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst107$PBLK12$createobjects STM$() {
        TRACE_BEGIN_STM$("createobjects",70);
        // JavaLine 25 ==> SourceLine 71
        for(boolean CB$71:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(10); }})
           )) { if(!CB$71) continue;
        // JavaLine 29 ==> SourceLine 72
        {
            TRACE_BEGIN_STM$("CompoundStatement72",72);
            ((simtst107$PBLK12)(CUR$.SL$)).pa.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).pa.LB[0]]=new simtst107$PBLK12$p(((simtst107$PBLK12)(CUR$.SL$)),i).START();
            // JavaLine 33 ==> SourceLine 73
            ((simtst107$PBLK12)(CUR$.SL$)).terminatd.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).terminatd.LB[0]]=false;
            ((simtst107$PBLK12)(CUR$.SL$)).active.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).active.LB[0]]=false;
            ((simtst107$PBLK12)(CUR$.SL$)).passive.Elt[i-((simtst107$PBLK12)(CUR$.SL$)).passive.LB[0]]=true;
            TRACE_END_STM$("CompoundStatement72",73);
        }
    }
    // JavaLine 40 ==> SourceLine 75
    ((simtst107$PBLK12)(CUR$.SL$)).testno=(((simtst107$PBLK12)(CUR$.SL$)).testno+(1));
    TRACE_END_STM$("createobjects",75);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","Procedure createobjects",1,69,11,70,25,71,29,72,33,73,40,75,45,76);
}
