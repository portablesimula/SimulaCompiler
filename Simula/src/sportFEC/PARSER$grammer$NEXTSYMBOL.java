// JavaLine 1 ==> SourceLine 302
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$NEXTSYMBOL extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=302, lastLine=309, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$NEXTSYMBOL(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("NEXTSYMBOL",302);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$NEXTSYMBOL STM$() {
        TRACE_BEGIN_STM$("NEXTSYMBOL",302);
        // JavaLine 23 ==> SourceLine 303
        if(((PARSER$grammer)(CUR$.SL$)).getopt) {
            {
                TRACE_BEGIN_STM$("CompoundStatement303",303);
                ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                TRACE_END_STM$("CompoundStatement303",303);
            }
        } else
        // JavaLine 32 ==> SourceLine 307
        ((PARSER$grammer)(CUR$.SL$)).detach();
        TRACE_END_STM$("NEXTSYMBOL",307);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure NEXTSYMBOL",1,302,23,303,32,307,37,309);
}
