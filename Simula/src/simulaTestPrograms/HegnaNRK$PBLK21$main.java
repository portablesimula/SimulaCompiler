// JavaLine 1 ==> SourceLine 265
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$main extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=265, lastLine=276, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 267
    int kommandonr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$main(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("main",267);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$main STM$() {
        TRACE_BEGIN_STM$("main",267);
        // JavaLine 25 ==> SourceLine 268
        new HegnaNRK$PBLK21$start_databasen(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 27 ==> SourceLine 269
        kommandonr=new HegnaNRK$PBLK21$les_kommando(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 29 ==> SourceLine 270
        while((kommandonr!=(((HegnaNRK$PBLK21)(CUR$.SL$)).quit_kommando))) {
            // JavaLine 31 ==> SourceLine 272
            {
                TRACE_BEGIN_STM$("CompoundStatement272",272);
                new HegnaNRK$PBLK21$do_kommando(((HegnaNRK$PBLK21)(CUR$.SL$)),kommandonr);
                // JavaLine 35 ==> SourceLine 273
                kommandonr=new HegnaNRK$PBLK21$les_kommando(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                TRACE_END_STM$("CompoundStatement272",273);
            }
        }
        // JavaLine 40 ==> SourceLine 275
        new HegnaNRK$PBLK21$avslutt_databasen(((HegnaNRK$PBLK21)(CUR$.SL$)));
        TRACE_END_STM$("main",275);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure main",1,265,11,267,25,268,27,269,29,270,31,272,35,273,40,275,45,276);
}
