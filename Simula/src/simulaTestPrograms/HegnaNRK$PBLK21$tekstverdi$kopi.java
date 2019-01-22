// JavaLine 1 ==> SourceLine 108
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$kopi extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=108, lastLine=113, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public HegnaNRK$PBLK21$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 109
    HegnaNRK$PBLK21$tekstverdi k=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$kopi(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("kopi",109);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$tekstverdi$kopi STM$() {
        TRACE_BEGIN_STM$("kopi",109);
        // JavaLine 28 ==> SourceLine 110
        k=new HegnaNRK$PBLK21$tekstverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        // JavaLine 30 ==> SourceLine 111
        k.tekst=copy(copy(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst));
        // JavaLine 32 ==> SourceLine 112
        RESULT$=k;
        TRACE_END_STM$("kopi",112);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure kopi",1,108,14,109,28,110,30,111,32,112,37,113);
}
