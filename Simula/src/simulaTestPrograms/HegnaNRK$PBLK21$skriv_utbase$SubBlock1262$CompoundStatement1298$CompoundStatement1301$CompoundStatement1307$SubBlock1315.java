// JavaLine 1 ==> SourceLine 1315
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=1315, lastLine=1339, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int rom=0;
    int tpos=0;
    int rest=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1315",1315);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1315",1315);
        // JavaLine 23 ==> SourceLine 1316
        tpos=1;
        // JavaLine 25 ==> SourceLine 1317
        rest=TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.Elt[((HegnaNRK$PBLK21$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.LB[0]])).tekst);
        // JavaLine 27 ==> SourceLine 1318
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outint(rest,5);
        // JavaLine 29 ==> SourceLine 1319
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outchar(((char)32));
        // JavaLine 31 ==> SourceLine 1320
        rom=((TXT$.length(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.image)-(TXT$.pos(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.image)))+(1));
        // JavaLine 33 ==> SourceLine 1321
        while((rest!=(0))) {
            // JavaLine 35 ==> SourceLine 1323
            {
                TRACE_BEGIN_STM$("CompoundStatement1323",1323);
                if((rest<=(rom))) {
                    // JavaLine 39 ==> SourceLine 1325
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1325",1325);
                        // JavaLine 42 ==> SourceLine 1326
                        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outtext(TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.Elt[((HegnaNRK$PBLK21$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.LB[0]])).tekst,tpos,rest));
                        // JavaLine 44 ==> SourceLine 1327
                        rest=0;
                        TRACE_END_STM$("CompoundStatement1325",1327);
                    }
                } else
                // JavaLine 49 ==> SourceLine 1331
                {
                    TRACE_BEGIN_STM$("CompoundStatement1331",1331);
                    // JavaLine 52 ==> SourceLine 1332
                    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outtext(TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.Elt[((HegnaNRK$PBLK21$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.LB[0]])).tekst,tpos,rom));
                    // JavaLine 54 ==> SourceLine 1333
                    tpos=(tpos+(rom));
                    // JavaLine 56 ==> SourceLine 1334
                    rest=(rest-(rom));
                    // JavaLine 58 ==> SourceLine 1335
                    rom=TXT$.length(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.image);
                    TRACE_END_STM$("CompoundStatement1331",1335);
                }
                // JavaLine 62 ==> SourceLine 1337
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outimage();
                TRACE_END_STM$("CompoundStatement1323",1337);
            }
        }
        TRACE_END_STM$("SubBlock1315",1337);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1315",1,1315,23,1316,25,1317,27,1318,29,1319,31,1320,33,1321,35,1323,39,1325,42,1326,44,1327,49,1331,52,1332,54,1333,56,1334,58,1335,62,1337,70,1339);
}
