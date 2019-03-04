// JavaLine 1 ==> SourceLine 52
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses$Noughter$Move extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=52, lastLine=58, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 53
    boolean ok=false;
    // Normal Constructor
    public NoughtsAndCrosses$Noughter$Move(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Move",53);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public NoughtsAndCrosses$Noughter$Move STM$() {
        TRACE_BEGIN_STM$("Move",53);
        // JavaLine 25 ==> SourceLine 54
        while((!(ok))) {
            // JavaLine 27 ==> SourceLine 55
            {
                TRACE_BEGIN_STM$("CompoundStatement55",55);
                sysout().outtext(new TXT$("Give position for nought as i,j : "));
                sysout().breakoutimage();
                // JavaLine 32 ==> SourceLine 56
                ((NoughtsAndCrosses$Noughter)(CUR$.SL$)).i=sysin().inint();
                sysin().inchar();
                ((NoughtsAndCrosses$Noughter)(CUR$.SL$)).j=sysin().inint();
                ok=(((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.Elt[((NoughtsAndCrosses$Noughter)(CUR$.SL$)).i-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[0]][((NoughtsAndCrosses$Noughter)(CUR$.SL$)).j-((NoughtsAndCrosses)(CUR$.SL$.SL$)).board.LB[1]]==(((NoughtsAndCrosses)(CUR$.SL$.SL$)).null$));
                TRACE_END_STM$("CompoundStatement55",56);
            }
        }
        TRACE_END_STM$("Move",56);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Procedure Move",1,52,11,53,25,54,27,55,32,56,43,58);
}
