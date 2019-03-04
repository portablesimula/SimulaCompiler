// JavaLine 1 ==> SourceLine 63
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Crosser$Move extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=63, lastLine=69, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 68
    final LABQNT$ exit=new LABQNT$(this,0,1); // Local Label #1=exit
    // Declare locals as attributes
    // Normal Constructor
    public NoughtsAndCrosses$Crosser$Move(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Move",68);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public NoughtsAndCrosses$Crosser$Move STM$() {
        TRACE_BEGIN_STM$("Move",68);
        NoughtsAndCrosses$Crosser$Move THIS$=(NoughtsAndCrosses$Crosser$Move)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 65
                for(boolean CB$65:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Crosser)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Crosser)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
                   )) { if(!CB$65) continue;
                // JavaLine 34 ==> SourceLine 66
                for(boolean CB$66:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Crosser)(CUR$.SL$)).j=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Crosser)(CUR$.SL$)).j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(3); }})
                   )) { if(!CB$66) continue;
                // JavaLine 38 ==> SourceLine 67
                if(VALUE$((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Crosser)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Crosser)(CUR$.SL$)).j-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$)))) {
                    GOTO$(exit); // GOTO EVALUATED LABEL
                }
            }
        }
        // JavaLine 44 ==> SourceLine 68
        LABEL$(1,"exit");
        sysout().outtext(new TXT$("Crosser's turn:"));
        sysout().outimage();
        break LOOP$;
    }
    catch(LABQNT$ q) {
        CUR$=THIS$;
        if(q.SL$!=CUR$ || q.prefixLevel!=0) {
            CUR$.STATE$=OperationalState.terminated;
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
            throw(q);
        }
        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
    }
}
TRACE_END_STM$("Move",68);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Move",1,63,11,68,30,65,34,66,38,67,44,68,64,69);
}
