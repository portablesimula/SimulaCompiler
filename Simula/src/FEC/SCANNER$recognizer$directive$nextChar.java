// JavaLine 1 ==> SourceLine 704
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$directive$nextChar extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=704, lastLine=707, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$recognizer$directive$nextChar(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("nextChar",704);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$directive$nextChar STM$() {
        TRACE_BEGIN_STM$("nextChar",704);
        // JavaLine 23 ==> SourceLine 705
        ((SCANNER$recognizer)(CUR$.SL$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$.SL$)).line,((SCANNER$recognizer)(CUR$.SL$.SL$)).linepos);
        ((SCANNER$recognizer)(CUR$.SL$.SL$)).linepos=(((SCANNER$recognizer)(CUR$.SL$.SL$)).linepos+(1));
        // JavaLine 26 ==> SourceLine 706
        if((((SCANNER$recognizer)(CUR$.SL$.SL$)).atom==(((char)9)))) {
            ((SCANNER$recognizer)(CUR$.SL$.SL$)).atom=((char)32);
        } else
        // JavaLine 30 ==> SourceLine 707
        if((((SCANNER$recognizer)(CUR$.SL$.SL$)).atom>(((char)127)))) {
            ((SCANNER$recognizer)(CUR$.SL$.SL$)).atom=char$((rank(((SCANNER$recognizer)(CUR$.SL$.SL$)).atom)-(127)));
        }
        TRACE_END_STM$("nextChar",707);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure nextChar",1,704,23,705,26,706,30,707,37,707);
}
