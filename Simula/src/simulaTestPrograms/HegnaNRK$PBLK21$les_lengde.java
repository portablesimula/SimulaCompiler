// JavaLine 1 ==> SourceLine 992
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_lengde extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=992, lastLine=1002, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 993
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_lengde(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_lengde",993);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_lengde STM$() {
        TRACE_BEGIN_STM$("les_lengde",993);
        // JavaLine 28 ==> SourceLine 994
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Ark-lengde:"));
        // JavaLine 30 ==> SourceLine 995
        i=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 32 ==> SourceLine 996
        while(((i<(0))&((i>(100))))) {
            // JavaLine 34 ==> SourceLine 998
            {
                TRACE_BEGIN_STM$("CompoundStatement998",998);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),14);
                // JavaLine 38 ==> SourceLine 999
                i=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                TRACE_END_STM$("CompoundStatement998",999);
            }
        }
        // JavaLine 43 ==> SourceLine 1001
        RESULT$=i;
        TRACE_END_STM$("les_lengde",1001);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_lengde",1,992,14,993,28,994,30,995,32,996,34,998,38,999,43,1001,48,1002);
}
