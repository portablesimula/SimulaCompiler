// JavaLine 1 ==> SourceLine 592
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_feltverdi extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=592, lastLine=599, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$les_feltverdi(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_feltverdi",592);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_feltverdi STM$() {
        TRACE_BEGIN_STM$("les_feltverdi",592);
        // JavaLine 23 ==> SourceLine 595
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Verdi:"));
        // JavaLine 25 ==> SourceLine 596
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).felttype==(1)))) {
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi=new HegnaNRK$PBLK21$heltallverdi(((HegnaNRK$PBLK21)(CUR$.SL$))).STM$();
        }
        // JavaLine 29 ==> SourceLine 597
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).felttype==(2)))) {
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi=new HegnaNRK$PBLK21$tekstverdi(((HegnaNRK$PBLK21)(CUR$.SL$))).STM$();
        }
        // JavaLine 33 ==> SourceLine 598
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi.les$0().CPF();
        TRACE_END_STM$("les_feltverdi",598);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_feltverdi",1,592,23,595,25,596,29,597,33,598,38,599);
}
