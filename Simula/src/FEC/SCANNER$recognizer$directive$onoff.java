// JavaLine 1 ==> SourceLine 709
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$directive$onoff extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=709, lastLine=713, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 710
    TXT$ t=null;
    // Normal Constructor
    public SCANNER$recognizer$directive$onoff(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("onoff",710);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$directive$onoff STM$() {
        TRACE_BEGIN_STM$("onoff",710);
        t=new SCANNER$recognizer$directive$linefield(((SCANNER$recognizer$directive)(CUR$.SL$))).RESULT$;
        lowcase(t);
        // JavaLine 30 ==> SourceLine 711
        if(TXTREL$EQ(t,new TXT$("on"))) {
            RESULT$=true;
        } else
        // JavaLine 34 ==> SourceLine 712
        if(TXTREL$NE(t,new TXT$("off"))) {
            GOTO$(((SCANNER$recognizer$directive)(CUR$.SL$)).DIRWARN); // GOTO EVALUATED LABEL
        }
        TRACE_END_STM$("onoff",712);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure onoff",1,709,14,710,30,711,34,712,41,713);
}
