// JavaLine 1 ==> SourceLine 333
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_type extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=333, lastLine=339, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 335
    char char$=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_type(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_type",335);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_type STM$() {
        TRACE_BEGIN_STM$("les_type",335);
        // JavaLine 28 ==> SourceLine 336
        char$=sysin().inchar();
        // JavaLine 30 ==> SourceLine 337
        while((char$==(((char)32)))) {
            char$=sysin().inchar();
        }
        // JavaLine 34 ==> SourceLine 338
        RESULT$=char$;
        TRACE_END_STM$("les_type",338);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_type",1,333,14,335,28,336,30,337,34,338,39,339);
}
