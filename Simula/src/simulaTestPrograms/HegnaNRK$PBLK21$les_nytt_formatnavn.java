// JavaLine 1 ==> SourceLine 952
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_nytt_formatnavn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=952, lastLine=965, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 954
    TXT$ form=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_nytt_formatnavn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_nytt_formatnavn",954);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_nytt_formatnavn STM$() {
        TRACE_BEGIN_STM$("les_nytt_formatnavn",954);
        // JavaLine 28 ==> SourceLine 955
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Nytt format:"));
        // JavaLine 30 ==> SourceLine 956
        form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 32 ==> SourceLine 957
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
        // JavaLine 34 ==> SourceLine 958
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr!=(0))) {
            // JavaLine 36 ==> SourceLine 960
            {
                TRACE_BEGIN_STM$("CompoundStatement960",960);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),17);
                // JavaLine 40 ==> SourceLine 961
                form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 42 ==> SourceLine 962
                ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
                TRACE_END_STM$("CompoundStatement960",962);
            }
        }
        // JavaLine 47 ==> SourceLine 964
        RESULT$=form;
        TRACE_END_STM$("les_nytt_formatnavn",964);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_nytt_formatnavn",1,952,14,954,28,955,30,956,32,957,34,958,36,960,40,961,42,962,47,964,52,965);
}
