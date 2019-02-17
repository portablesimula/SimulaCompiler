// JavaLine 1 ==> SourceLine 1181
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_filnavn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1181, lastLine=1182, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$les_filnavn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_filnavn",1181);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_filnavn STM$() {
        TRACE_BEGIN_STM$("les_filnavn",1181);
        // JavaLine 26 ==> SourceLine 1182
        RESULT$=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        TRACE_END_STM$("les_filnavn",1182);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_filnavn",1,1181,26,1182,31,1182);
}
