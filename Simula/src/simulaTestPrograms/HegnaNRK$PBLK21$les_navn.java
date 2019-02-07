// JavaLine 1 ==> SourceLine 341
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_navn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=341, lastLine=354, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 343
    char char$=0;
    // JavaLine 16 ==> SourceLine 344
    TXT$ navn=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_navn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_navn",344);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_navn STM$() {
        TRACE_BEGIN_STM$("les_navn",344);
        // JavaLine 30 ==> SourceLine 345
        navn=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde);
        // JavaLine 32 ==> SourceLine 346
        char$=sysin().inchar();
        // JavaLine 34 ==> SourceLine 347
        while((char$==(((char)32)))) {
            char$=sysin().inchar();
        }
        // JavaLine 38 ==> SourceLine 348
        while(((char$!=(((char)32)))&((TXT$.pos(navn)<=(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde))))) {
            // JavaLine 40 ==> SourceLine 350
            {
                TRACE_BEGIN_STM$("CompoundStatement350",350);
                TXT$.putchar(navn,char$);
                // JavaLine 44 ==> SourceLine 351
                char$=sysin().inchar();
                TRACE_END_STM$("CompoundStatement350",351);
            }
        }
        // JavaLine 49 ==> SourceLine 353
        RESULT$=copy(copy(TXT$.strip(navn)));
        TRACE_END_STM$("les_navn",353);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_navn",1,341,14,343,16,344,30,345,32,346,34,347,38,348,40,350,44,351,49,353,54,354);
}
