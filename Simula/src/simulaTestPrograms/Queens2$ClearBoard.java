// JavaLine 1 ==> SourceLine 42
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Jan 23 17:07:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$ClearBoard extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=42, lastLine=47, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Queens2$ClearBoard(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ClearBoard",42);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$ClearBoard STM$() {
        TRACE_BEGIN_STM$("ClearBoard",42);
        // JavaLine 23 ==> SourceLine 43
        for(boolean CB$43:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
           )) { if(!CB$43) continue;
        // JavaLine 27 ==> SourceLine 44
        {
            TRACE_BEGIN_STM$("CompoundStatement44",44);
            for(boolean CB$44:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((Queens2)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((Queens2)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
               )) { if(!CB$44) continue;
            // JavaLine 33 ==> SourceLine 45
            {
                TRACE_BEGIN_STM$("CompoundStatement45",45);
                new Queens2$Setpos(((Queens2)(CUR$.SL$)),(4+((2*(((Queens2)(CUR$.SL$)).i)))),(21+((4*(((Queens2)(CUR$.SL$)).j)))));
                sysout().outchar(((char)32));
                TRACE_END_STM$("CompoundStatement45",45);
            }
        }
        // JavaLine 41 ==> SourceLine 46
        sysout().breakoutimage();
        TRACE_END_STM$("CompoundStatement44",46);
    }
}
TRACE_END_STM$("ClearBoard",46);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure ClearBoard",1,42,23,43,27,44,33,45,41,46,49,47);
}
