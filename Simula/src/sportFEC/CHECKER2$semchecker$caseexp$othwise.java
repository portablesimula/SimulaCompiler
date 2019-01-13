// JavaLine 1 ==> SourceLine 310
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$caseexp$othwise extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=310, lastLine=316, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 311
    int i=0;
    // Normal Constructor
    public CHECKER2$semchecker$caseexp$othwise(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("othwise",311);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$caseexp$othwise STM$() {
        TRACE_BEGIN_STM$("othwise",311);
        // JavaLine 25 ==> SourceLine 312
        i=(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$ub-(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).p1$lb));
        // JavaLine 27 ==> SourceLine 313
        while((i>=(0))) {
            // JavaLine 29 ==> SourceLine 314
            {
                TRACE_BEGIN_STM$("CompoundStatement314",314);
                if((!(((CHECKER2$semchecker$caseexp)(CUR$.SL$)).seen.Elt[i-((CHECKER2$semchecker$caseexp)(CUR$.SL$)).seen.LB[0]]))) {
                    new CHECKER2$semchecker$caseexp$outsdest(((CHECKER2$semchecker$caseexp)(CUR$.SL$)),i);
                }
                i=(i-(1));
                TRACE_END_STM$("CompoundStatement314",314);
            }
        }
        TRACE_END_STM$("othwise",314);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure othwise",1,310,11,311,25,312,27,313,29,314,42,316);
}
