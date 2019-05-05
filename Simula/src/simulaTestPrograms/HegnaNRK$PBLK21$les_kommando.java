// JavaLine 1 <== SourceLine 278
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_kommando extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=278, lastLine=292, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 280
    int kommando=0;
    // JavaLine 16 <== SourceLine 281
    TXT$ kommando_navn=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_kommando(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_kommando",281);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$les_kommando STM$() {
        TRACE_BEGIN_STM$("les_kommando",281);
        // JavaLine 30 <== SourceLine 282
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Kommando:"));
        // JavaLine 32 <== SourceLine 283
        kommando_navn=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 34 <== SourceLine 284
        kommando=new HegnaNRK$PBLK21$finn_kommando(((HegnaNRK$PBLK21)(CUR$.SL$)),kommando_navn).RESULT$;
        // JavaLine 36 <== SourceLine 285
        while((kommando==(0))) {
            // JavaLine 38 <== SourceLine 287
            {
                TRACE_BEGIN_STM$("CompoundStatement287",287);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),1);
                // JavaLine 42 <== SourceLine 288
                kommando_navn=new HegnaNRK$PBLK21$les_navn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 44 <== SourceLine 289
                kommando=new HegnaNRK$PBLK21$finn_kommando(((HegnaNRK$PBLK21)(CUR$.SL$)),kommando_navn).RESULT$;
                TRACE_END_STM$("CompoundStatement287",289);
            }
        }
        // JavaLine 49 <== SourceLine 291
        RESULT$=kommando;
        TRACE_END_STM$("les_kommando",291);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_kommando",1,278,14,280,16,281,30,282,32,283,34,284,36,285,38,287,42,288,44,289,49,291,54,292);
} // End of Procedure
