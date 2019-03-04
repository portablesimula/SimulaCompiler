// JavaLine 1 ==> SourceLine 22
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Player$Done extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=22, lastLine=37, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 23
    char winner=0;
    // Normal Constructor
    public NoughtsAndCrosses$Player$Done(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Done",23);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public NoughtsAndCrosses$Player$Done STM$() {
        TRACE_BEGIN_STM$("Done",23);
        // JavaLine 28 ==> SourceLine 24
        if(VALUE$((((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))))|(((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]])))))))) {
            // JavaLine 30 ==> SourceLine 26
            winner=((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]];
        } else
        // JavaLine 33 ==> SourceLine 27
        for(boolean CB$27:new ForList(
            new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }})
           ,new WhileElt<Number>(new NAME$<Number>(){ public Number put(Number x$){((NoughtsAndCrosses$Player)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((NoughtsAndCrosses$Player)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(((NoughtsAndCrosses$Player)(CUR$.SL$)).i+(1)); }},new NAME$<Boolean>() { public Boolean get(){return((((NoughtsAndCrosses$Player)(CUR$.SL$)).i<=(3))&((winner==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$)))); }})
           )) { if(!CB$27) continue;
        // JavaLine 38 ==> SourceLine 28
        if(VALUE$(((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]])))))) {
            // JavaLine 40 ==> SourceLine 29
            winner=((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]];
        } else
        // JavaLine 43 ==> SourceLine 31
        if(VALUE$(((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[1-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]))&((((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[3-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]])))))) {
            // JavaLine 45 ==> SourceLine 32
            winner=((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[2-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Player)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]];
        }
    }
    // JavaLine 49 ==> SourceLine 33
    if(VALUE$((winner!=(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$)))) {
        // JavaLine 51 ==> SourceLine 34
        {
            TRACE_BEGIN_STM$("CompoundStatement34",34);
            sysout().outtext(new TXT$("The winner is "));
            sysout().outchar(winner);
            sysout().outimage();
            // JavaLine 57 ==> SourceLine 35
            RESULT$=true;
            TRACE_END_STM$("CompoundStatement34",35);
        }
    }
    TRACE_END_STM$("Done",35);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Done",1,22,14,23,28,24,30,26,33,27,38,28,40,29,43,31,45,32,49,33,51,34,57,35,65,37);
}
