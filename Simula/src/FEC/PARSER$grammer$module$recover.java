// JavaLine 1 ==> SourceLine 722
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$module$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=722, lastLine=727, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$module$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",722);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$module$recover STM$() {
        TRACE_BEGIN_STM$("recover",722);
        // JavaLine 26 ==> SourceLine 723
        ((PARSER$grammer$module)(CUR$.SL$)).recovered=RESULT$=true;
        // JavaLine 28 ==> SourceLine 724
        ((PARSER$grammer$module)(CUR$.SL$)).rp=(((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ISMCL)))?(((char)3)):((((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IBEGI)))?(((char)4)):((((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEOP)))?(((char)6)):(((char)5)))))));
        TRACE_END_STM$("recover",724);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,722,26,723,28,724,33,727);
}
