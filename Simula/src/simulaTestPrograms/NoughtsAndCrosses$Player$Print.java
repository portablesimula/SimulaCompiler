// JavaLine 1 ==> SourceLine 12
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Player$Print extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=12, lastLine=20, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public NoughtsAndCrosses$Player$Print(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Print",12);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public NoughtsAndCrosses$Player$Print STM$() {
        TRACE_BEGIN_STM$("Print",12);
        // JavaLine 23 ==> SourceLine 14
        for(boolean CB$14:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
           )) { if(!CB$14) continue;
        // JavaLine 27 ==> SourceLine 15
        {
            TRACE_BEGIN_STM$("CompoundStatement15",15);
            for(boolean CB$15:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
               )) { if(!CB$15) continue;
            // JavaLine 33 ==> SourceLine 16
            sysout().outchar(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).j-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]);
        }
        // JavaLine 36 ==> SourceLine 17
        sysout().outimage();
        TRACE_END_STM$("CompoundStatement15",17);
    }
}
// JavaLine 41 ==> SourceLine 19
sysout().outimage();
TRACE_END_STM$("Print",19);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Print",1,12,23,14,27,15,33,16,36,17,41,19,46,20);
}
