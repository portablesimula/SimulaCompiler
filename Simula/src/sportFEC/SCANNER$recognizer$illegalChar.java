// JavaLine 1 ==> SourceLine 663
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 20:41:32 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$illegalChar extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=663, lastLine=664, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$recognizer$illegalChar(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("illegalChar",663);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$illegalChar STM$() {
        TRACE_BEGIN_STM$("illegalChar",663);
        // JavaLine 23 ==> SourceLine 664
        ((SCANNER)(CUR$.SL$.SL$)).diag.Elt[0-((SCANNER)(CUR$.SL$.SL$)).diag.LB[0]]=new COMMON$leftint(((SCANNER)(CUR$.SL$.SL$)),isorank(((SCANNER$recognizer)(CUR$.SL$)).atom)).RESULT$;
        new SCANNER$P1warn(((SCANNER)(CUR$.SL$.SL$)),276);
        TRACE_END_STM$("illegalChar",664);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure illegalChar",1,663,23,664,29,664);
}
