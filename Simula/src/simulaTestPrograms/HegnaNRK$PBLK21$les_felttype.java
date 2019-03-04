// JavaLine 1 ==> SourceLine 507
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_felttype extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=507, lastLine=520, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 509
    char type=0;
    int typenr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$les_felttype(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_felttype",509);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$les_felttype STM$() {
        TRACE_BEGIN_STM$("les_felttype",509);
        // JavaLine 29 ==> SourceLine 510
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Type:"));
        // JavaLine 31 ==> SourceLine 511
        type=new HegnaNRK$PBLK21$les_type(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 33 ==> SourceLine 512
        typenr=new HegnaNRK$PBLK21$finn_type(((HegnaNRK$PBLK21)(CUR$.SL$)),type).RESULT$;
        // JavaLine 35 ==> SourceLine 513
        while((typenr==(0))) {
            // JavaLine 37 ==> SourceLine 515
            {
                TRACE_BEGIN_STM$("CompoundStatement515",515);
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),3);
                // JavaLine 41 ==> SourceLine 516
                type=new HegnaNRK$PBLK21$les_type(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                // JavaLine 43 ==> SourceLine 517
                typenr=new HegnaNRK$PBLK21$finn_type(((HegnaNRK$PBLK21)(CUR$.SL$)),type).RESULT$;
                TRACE_END_STM$("CompoundStatement515",517);
            }
        }
        // JavaLine 48 ==> SourceLine 519
        RESULT$=typenr;
        TRACE_END_STM$("les_felttype",519);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_felttype",1,507,14,509,29,510,31,511,33,512,35,513,37,515,41,516,43,517,48,519,53,520);
}
