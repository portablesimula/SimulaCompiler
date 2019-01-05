// JavaLine 1 ==> SourceLine 649
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$markStmt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=649, lastLine=661, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$markStmt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("markStmt",649);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$markStmt STM$() {
        TRACE_BEGIN_STM$("markStmt",649);
        // JavaLine 23 ==> SourceLine 651
        if((((((PARSER$grammer)(CUR$.SL$)).last.blockstatus==(((PARSER$grammer)(CUR$.SL$)).stmtnotseen))||((((PARSER$grammer)(CUR$.SL$)).stmtwnt==(((PARSER$grammer)(CUR$.SL$)).classbody))))||((((PARSER$grammer)(CUR$.SL$)).stmtwnt==(((PARSER$grammer)(CUR$.SL$)).procbody))))) {
            // JavaLine 25 ==> SourceLine 654
            {
                TRACE_BEGIN_STM$("CompoundStatement654",654);
                ((PARSER$grammer)(CUR$.SL$)).last.blockstatus=((PARSER$grammer)(CUR$.SL$)).lastwasdecl;
                // JavaLine 29 ==> SourceLine 655
                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                call(((PARSER)(CUR$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement654",655);
            }
        }
        // JavaLine 35 ==> SourceLine 658
        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IROPD;
        call(((PARSER)(CUR$.SL$.SL$)).coder);
        TRACE_END_STM$("markStmt",658);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure markStmt",1,649,23,651,25,654,29,655,35,658,41,661);
}
