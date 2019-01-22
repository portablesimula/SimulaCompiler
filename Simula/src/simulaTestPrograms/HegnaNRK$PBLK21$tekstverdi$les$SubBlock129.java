// JavaLine 1 ==> SourceLine 129
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$les$SubBlock129 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=129, lastLine=143, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    char c=0;
    // JavaLine 12 ==> SourceLine 130
    TXT$ t=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$les$SubBlock129(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock129",130);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock129",130);
        // JavaLine 24 ==> SourceLine 131
        t=blanks(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).tekst_lengde);
        // JavaLine 26 ==> SourceLine 132
        c=new HegnaNRK$PBLK21$tekstverdi$les_tegn(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)),((char)32)).RESULT$;
        // JavaLine 28 ==> SourceLine 133
        i=0;
        // JavaLine 30 ==> SourceLine 134
        while(((c!=(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).eot))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).tekst_lengde))))) {
            // JavaLine 32 ==> SourceLine 136
            {
                TRACE_BEGIN_STM$("CompoundStatement136",136);
                i=(i+(1));
                // JavaLine 36 ==> SourceLine 137
                TXT$.putchar(t,c);
                // JavaLine 38 ==> SourceLine 138
                c=new HegnaNRK$PBLK21$tekstverdi$les_tegn(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)),c).RESULT$;
                TRACE_END_STM$("CompoundStatement136",138);
            }
        }
        // JavaLine 43 ==> SourceLine 140
        while((c!=(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).eot))) {
            c=new HegnaNRK$PBLK21$tekstverdi$les_tegn(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)),c).RESULT$;
        }
        // JavaLine 47 ==> SourceLine 141
        ((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).tekst=copy(copy(TXT$.strip(TXT$.sub(t,1,i))));
        // JavaLine 49 ==> SourceLine 142
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]=((HegnaNRK$PBLK21$verdi)(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).kopi$0().CPF().RESULT$()));
        TRACE_END_STM$("SubBlock129",142);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock129",1,129,12,130,24,131,26,132,28,133,30,134,32,136,36,137,38,138,43,140,47,141,49,142,54,143);
}
