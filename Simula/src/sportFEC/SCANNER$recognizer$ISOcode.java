// JavaLine 1 ==> SourceLine 910
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$ISOcode extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=910, lastLine=924, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 911
    int oldpos=0;
    int i=0;
    int j=0;
    // Normal Constructor
    public SCANNER$recognizer$ISOcode(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ISOcode",915);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$ISOcode STM$() {
        TRACE_BEGIN_STM$("ISOcode",915);
        // JavaLine 27 ==> SourceLine 918
        oldpos=((SCANNER$recognizer)(CUR$.SL$)).linepos;
        new SCANNER$recognizer$scanahead(((SCANNER$recognizer)(CUR$.SL$)));
        // JavaLine 30 ==> SourceLine 920
        new SCANNER$recognizer$ISOcode$getDigit(((SCANNER$recognizer$ISOcode)CUR$));
        new SCANNER$recognizer$ISOcode$getDigit(((SCANNER$recognizer$ISOcode)CUR$));
        new SCANNER$recognizer$ISOcode$getDigit(((SCANNER$recognizer$ISOcode)CUR$));
        // JavaLine 34 ==> SourceLine 921
        if((((j==(0))||((i>(255))))||((((SCANNER$recognizer)(CUR$.SL$)).atom!=('!'))))) {
            // JavaLine 36 ==> SourceLine 922
            {
                TRACE_BEGIN_STM$("CompoundStatement922",922);
                ((SCANNER$recognizer)(CUR$.SL$)).atom='!';
                ((SCANNER$recognizer)(CUR$.SL$)).linepos=oldpos;
                TRACE_END_STM$("CompoundStatement922",922);
            }
        } else
        // JavaLine 44 ==> SourceLine 923
        ((SCANNER$recognizer)(CUR$.SL$)).atom=isochar(i);
        TRACE_END_STM$("ISOcode",923);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure ISOcode",1,910,11,911,27,918,30,920,34,921,36,922,44,923,49,924);
}
