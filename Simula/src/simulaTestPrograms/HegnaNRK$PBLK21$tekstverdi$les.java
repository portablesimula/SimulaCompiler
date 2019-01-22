// JavaLine 1 ==> SourceLine 114
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$les extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=114, lastLine=144, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$les(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les",114);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$tekstverdi$les STM$() {
        TRACE_BEGIN_STM$("les",114);
        // JavaLine 23 ==> SourceLine 115
        if((!(TXT$.more(sysin().image)))) {
            sysin().inimage();
        }
        // JavaLine 27 ==> SourceLine 116
        while(TXTREL$EQ(TXT$.sub(sysin().image,TXT$.pos(sysin().image),1),new TXT$(" "))) {
            // JavaLine 29 ==> SourceLine 117
            {
                TRACE_BEGIN_STM$("CompoundStatement117",117);
                sysin().inchar();
                // JavaLine 33 ==> SourceLine 118
                if((!(TXT$.more(sysin().image)))) {
                    sysin().inimage();
                }
                TRACE_END_STM$("CompoundStatement117",118);
            }
        }
        // JavaLine 40 ==> SourceLine 120
        if(TXTREL$EQ(TXT$.sub(sysin().image,TXT$.pos(sysin().image),1),new TXT$("="))) {
            // JavaLine 42 ==> SourceLine 122
            {
                TRACE_BEGIN_STM$("CompoundStatement122",122);
                sysin().inchar();
                // JavaLine 46 ==> SourceLine 123
                if((((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]!=(null))) {
                    // JavaLine 48 ==> SourceLine 124
                    ((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst=copy(copy(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]])).tekst));
                } else
                // JavaLine 51 ==> SourceLine 126
                ((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst=null;
                TRACE_END_STM$("CompoundStatement122",126);
            }
        } else
        // JavaLine 56 ==> SourceLine 143
        new HegnaNRK$PBLK21$tekstverdi$les$SubBlock129(CUR$).STM$();
        TRACE_END_STM$("les",142);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les",1,114,23,115,27,116,29,117,33,118,40,120,42,122,46,123,48,124,51,126,56,143,61,144);
}
