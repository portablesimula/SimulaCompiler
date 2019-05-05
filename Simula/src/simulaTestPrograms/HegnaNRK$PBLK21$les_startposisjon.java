// JavaLine 1 <== SourceLine 980
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_startposisjon extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=980, lastLine=990, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 981
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_startposisjon(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_startposisjon",981);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$les_startposisjon STM$() {
        TRACE_BEGIN_STM$("les_startposisjon",981);
        // JavaLine 28 <== SourceLine 982
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Start-posisjon:"));
        // JavaLine 30 <== SourceLine 983
        i=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 32 <== SourceLine 984
        while(((i<(0))&((i>(128))))) {
            // JavaLine 34 <== SourceLine 986
            {
                TRACE_BEGIN_STM$("CompoundStatement986",986);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),8);
                // JavaLine 38 <== SourceLine 987
                i=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                TRACE_END_STM$("CompoundStatement986",987);
            }
        }
        // JavaLine 43 <== SourceLine 989
        RESULT$=i;
        TRACE_END_STM$("les_startposisjon",989);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_startposisjon",1,980,14,981,28,982,30,983,32,984,34,986,38,987,43,989,48,990);
} // End of Procedure
