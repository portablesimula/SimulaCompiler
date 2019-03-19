// JavaLine 1 ==> SourceLine 937
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_formatnavn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=937, lastLine=950, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 939
    TXT$ form=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_formatnavn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_formatnavn",939);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_formatnavn STM$() {
        TRACE_BEGIN_STM$("les_formatnavn",939);
        // JavaLine 28 ==> SourceLine 940
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Format:"));
        // JavaLine 30 ==> SourceLine 941
        form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 32 ==> SourceLine 942
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
        // JavaLine 34 ==> SourceLine 943
        while((((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr==(0))) {
            // JavaLine 36 ==> SourceLine 945
            {
                TRACE_BEGIN_STM$("CompoundStatement945",945);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),16);
                // JavaLine 40 ==> SourceLine 946
                form=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 42 ==> SourceLine 947
                ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr=new HegnaNRK$PBLK21$finn_format(((HegnaNRK$PBLK21)(CUR$.SL$)),form).RESULT$;
                TRACE_END_STM$("CompoundStatement945",947);
            }
        }
        // JavaLine 47 ==> SourceLine 949
        RESULT$=form;
        TRACE_END_STM$("les_formatnavn",949);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_formatnavn",1,937,14,939,28,940,30,941,32,942,34,943,36,945,40,946,42,947,47,949,52,950);
}
