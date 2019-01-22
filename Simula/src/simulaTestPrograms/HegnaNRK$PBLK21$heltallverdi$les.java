// JavaLine 1 ==> SourceLine 84
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$les extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=84, lastLine=103, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HegnaNRK$PBLK21$heltallverdi$les(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les",84);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$heltallverdi$les STM$() {
        TRACE_BEGIN_STM$("les",84);
        // JavaLine 23 ==> SourceLine 85
        if((!(TXT$.more(sysin().image)))) {
            sysin().inimage();
        }
        // JavaLine 27 ==> SourceLine 86
        while(TXTREL$EQ(TXT$.sub(sysin().image,TXT$.pos(sysin().image),1),new TXT$(" "))) {
            // JavaLine 29 ==> SourceLine 87
            {
                TRACE_BEGIN_STM$("CompoundStatement87",87);
                sysin().inchar();
                // JavaLine 33 ==> SourceLine 88
                if((!(TXT$.more(sysin().image)))) {
                    sysin().inimage();
                }
                TRACE_END_STM$("CompoundStatement87",88);
            }
        }
        // JavaLine 40 ==> SourceLine 90
        if(TXTREL$EQ(TXT$.sub(sysin().image,TXT$.pos(sysin().image),1),new TXT$("="))) {
            // JavaLine 42 ==> SourceLine 92
            {
                TRACE_BEGIN_STM$("CompoundStatement92",92);
                sysin().inchar();
                // JavaLine 46 ==> SourceLine 93
                if((((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]!=(null))) {
                    // JavaLine 48 ==> SourceLine 94
                    ((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall=((HegnaNRK$PBLK21$heltallverdi)(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]])).tall;
                } else
                // JavaLine 51 ==> SourceLine 96
                ((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall=0;
                TRACE_END_STM$("CompoundStatement92",96);
            }
        } else
        // JavaLine 56 ==> SourceLine 100
        {
            TRACE_BEGIN_STM$("CompoundStatement100",100);
            ((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall=new HegnaNRK$PBLK21$sikker_inint(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).RESULT$;
            // JavaLine 60 ==> SourceLine 101
            ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]=((HegnaNRK$PBLK21$verdi)(((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).kopi$0().CPF().RESULT$()));
            TRACE_END_STM$("CompoundStatement100",101);
        }
        TRACE_END_STM$("les",101);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les",1,84,23,85,27,86,29,87,33,88,40,90,42,92,46,93,48,94,51,96,56,100,60,101,67,103);
}
