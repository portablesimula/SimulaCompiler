// JavaLine 1 ==> SourceLine 695
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$directive$bytefield extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=695, lastLine=702, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 696
    TXT$ t=null;
    int result=0;
    // Normal Constructor
    public SCANNER$recognizer$directive$bytefield(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("bytefield",696);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$directive$bytefield STM$() {
        TRACE_BEGIN_STM$("bytefield",696);
        // JavaLine 29 ==> SourceLine 697
        t=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)(CUR$.SL$))).RESULT$;
        // JavaLine 31 ==> SourceLine 698
        result=(((digit(TXT$.getchar(t))&&((TXT$.length(t)<=(3)))))?(TXT$.getint(t)):((-(1))));
        // JavaLine 33 ==> SourceLine 700
        if(((result<(0))|((result>(255))))) {
            GOTO$(((SCANNER$recognizer$directive)(CUR$.SL$)).DIRWARN); // GOTO EVALUATED LABEL
        }
        // JavaLine 37 ==> SourceLine 701
        RESULT$=result;
        TRACE_END_STM$("bytefield",701);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure bytefield",1,695,14,696,29,697,31,698,33,700,37,701,42,702);
}
