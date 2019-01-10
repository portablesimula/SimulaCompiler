// JavaLine 1 ==> SourceLine 480
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_feltnavn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=480, lastLine=493, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 482
    TXT$ felt=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_feltnavn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_feltnavn",482);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_feltnavn STM$() {
        TRACE_BEGIN_STM$("les_feltnavn",482);
        // JavaLine 28 ==> SourceLine 483
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Felt:"));
        // JavaLine 30 ==> SourceLine 484
        felt=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 32 ==> SourceLine 485
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr=new HegnaNRK$PBLK21$finn_felt(((HegnaNRK$PBLK21)(CUR$.SL$)),felt).RESULT$;
        // JavaLine 34 ==> SourceLine 486
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr==(0))) {
            // JavaLine 36 ==> SourceLine 488
            {
                TRACE_BEGIN_STM$("CompoundStatement488",488);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),6);
                // JavaLine 40 ==> SourceLine 489
                felt=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 42 ==> SourceLine 490
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr=new HegnaNRK$PBLK21$finn_felt(((HegnaNRK$PBLK21)(CUR$.SL$)),felt).RESULT$;
                TRACE_END_STM$("CompoundStatement488",490);
            }
        }
        // JavaLine 47 ==> SourceLine 492
        RESULT$=felt;
        TRACE_END_STM$("les_feltnavn",492);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_feltnavn",1,480,14,482,28,483,30,484,32,485,34,486,36,488,40,489,42,490,47,492,52,493);
}
