// JavaLine 1 ==> SourceLine 712
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=712, lastLine=724, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 714
    int pnr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$hent(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("hent",714);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$hent STM$() {
        TRACE_BEGIN_STM$("hent",714);
        // JavaLine 25 ==> SourceLine 715
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Post nummer:"));
        // JavaLine 27 ==> SourceLine 716
        pnr=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 29 ==> SourceLine 717
        if(VALUE$(((pnr<=(0))|((pnr>(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster)))))) {
            // JavaLine 31 ==> SourceLine 718
            new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),11);
        } else
        // JavaLine 34 ==> SourceLine 720
        {
            TRACE_BEGIN_STM$("CompoundStatement720",720);
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),pnr);
            // JavaLine 38 ==> SourceLine 721
            if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell!=(pnr)))) {
                // JavaLine 40 ==> SourceLine 722
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),12);
            } else
            new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
            TRACE_END_STM$("CompoundStatement720",722);
        }
        TRACE_END_STM$("hent",722);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent",1,712,11,714,25,715,27,716,29,717,31,718,34,720,38,721,40,722,49,724);
}
