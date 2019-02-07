// JavaLine 1 ==> SourceLine 760
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_finne_regel extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=760, lastLine=772, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$les_finne_regel(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_finne_regel",760);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_finne_regel STM$() {
        TRACE_BEGIN_STM$("les_finne_regel",760);
        // JavaLine 23 ==> SourceLine 763
        new HegnaNRK$PBLK21$stryk_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 25 ==> SourceLine 764
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 27 ==> SourceLine 765
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_felt))) {
            // JavaLine 29 ==> SourceLine 767
            {
                TRACE_BEGIN_STM$("CompoundStatement767",767);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
                // JavaLine 33 ==> SourceLine 768
                new HegnaNRK$PBLK21$les_feltverdi(((HegnaNRK$PBLK21)(CUR$.SL$)));
                // JavaLine 35 ==> SourceLine 769
                new HegnaNRK$PBLK21$sett_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
                // JavaLine 37 ==> SourceLine 770
                ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                TRACE_END_STM$("CompoundStatement767",770);
            }
        }
        TRACE_END_STM$("les_finne_regel",770);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_finne_regel",1,760,23,763,25,764,27,765,29,767,33,768,35,769,37,770,45,772);
}
