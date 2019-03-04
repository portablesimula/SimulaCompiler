// JavaLine 1 ==> SourceLine 162
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$test_verdilikhet$SubBlock162 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=162, lastLine=177, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    int k=0;
    // JavaLine 13 ==> SourceLine 163
    boolean funnet=false;
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet$SubBlock162(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock162",163);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock162",163);
        // JavaLine 25 ==> SourceLine 164
        k=TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).tekst);
        // JavaLine 27 ==> SourceLine 165
        j=((TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).p$v)).tekst)-(k))+(1));
        // JavaLine 29 ==> SourceLine 166
        if(VALUE$((j<(0)))) {
            ((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).RESULT$=false;
        } else
        // JavaLine 33 ==> SourceLine 169
        {
            TRACE_BEGIN_STM$("CompoundStatement169",169);
            i=0;
            funnet=false;
            // JavaLine 38 ==> SourceLine 170
            while(((!(funnet))&((i<(j))))) {
                // JavaLine 40 ==> SourceLine 172
                {
                    TRACE_BEGIN_STM$("CompoundStatement172",172);
                    i=(i+(1));
                    // JavaLine 44 ==> SourceLine 173
                    funnet=TXTREL$EQ(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).tekst,TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).p$v)).tekst,i,k));
                    TRACE_END_STM$("CompoundStatement172",173);
                }
            }
            // JavaLine 49 ==> SourceLine 175
            ((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).RESULT$=funnet;
            TRACE_END_STM$("CompoundStatement169",175);
        }
        TRACE_END_STM$("SubBlock162",175);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock162",1,162,13,163,25,164,27,165,29,166,33,169,38,170,40,172,44,173,49,175,56,177);
}
