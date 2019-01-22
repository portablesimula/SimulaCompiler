// JavaLine 1 ==> SourceLine 468
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_register extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=468, lastLine=478, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 470
    TXT$ felt=null;
    TXT$ pass=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_register(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_register",470);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_register STM$() {
        TRACE_BEGIN_STM$("les_register",470);
        // JavaLine 29 ==> SourceLine 471
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Registernavn:"));
        // JavaLine 31 ==> SourceLine 472
        felt=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 33 ==> SourceLine 473
        sysout().outtext(new TXT$("Henter database "));
        sysout().outtext(felt);
        sysout().outimage();
        // JavaLine 37 ==> SourceLine 474
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Angi passord:"));
        // JavaLine 39 ==> SourceLine 475
        pass=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 41 ==> SourceLine 476
        sysout().outtext(new TXT$("Database "));
        sysout().outtext(felt);
        sysout().outtext(new TXT$(" tilkoblet"));
        // JavaLine 45 ==> SourceLine 477
        sysout().outimage();
        TRACE_END_STM$("les_register",477);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_register",1,468,14,470,29,471,31,472,33,473,37,474,39,475,41,476,45,477,50,478);
}
