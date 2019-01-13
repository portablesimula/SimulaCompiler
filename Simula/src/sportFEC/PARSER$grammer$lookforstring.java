// JavaLine 1 ==> SourceLine 311
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$lookforstring extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=311, lastLine=319, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$lookforstring(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("lookforstring",311);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$lookforstring STM$() {
        TRACE_BEGIN_STM$("lookforstring",311);
        // JavaLine 23 ==> SourceLine 313
        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IRFEQ))) {
            // JavaLine 25 ==> SourceLine 314
            {
                TRACE_BEGIN_STM$("CompoundStatement314",314);
                ((PARSER$grammer)(CUR$.SL$)).detach();
                // JavaLine 29 ==> SourceLine 315
                if(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICONS))&&((((PARSER)(CUR$.SL$.SL$)).optx==(((PARSER)(CUR$.SL$.SL$)).ITEXT))))) {
                    // JavaLine 31 ==> SourceLine 316
                    {
                        TRACE_BEGIN_STM$("CompoundStatement316",316);
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEXNM;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 36 ==> SourceLine 317
                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                        TRACE_END_STM$("CompoundStatement316",317);
                    }
                }
                TRACE_END_STM$("CompoundStatement314",317);
            }
        }
        TRACE_END_STM$("lookforstring",317);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure lookforstring",1,311,23,313,25,314,29,315,31,316,36,317,48,319);
}
