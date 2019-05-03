package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int rom=0;
    int tpos=0;
    int rest=0;
    public HegnaNRK$PBLK21$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        tpos=1;
        rest=TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$12.felt.Elt[((HegnaNRK$PBLK21$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$12.felt.LB[0]])).tekst$1);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.outint(rest,5);
        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.outchar(((char)32));
        rom=((TXT$.length(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.image)-(TXT$.pos(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.image)))+(1));
        while((rest!=(0))) {
            {
                if(VALUE$((rest<=(rom)))) {
                    {
                        ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.outtext(TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$12.felt.Elt[((HegnaNRK$PBLK21$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$12.felt.LB[0]])).tekst$1,tpos,rest));
                        rest=0;
                    }
                } else
                {
                    ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.outtext(TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$12.felt.Elt[((HegnaNRK$PBLK21$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$12.felt.LB[0]])).tekst$1,tpos,rom));
                    tpos=(tpos+(rom));
                    rest=(rest-(rom));
                    rom=TXT$.length(((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.image);
                }
                ((HegnaNRK$PBLK21$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$10.outimage();
            }
        }
        EBLK();
        return(null);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1315",1,1315,16,1316,18,1317,20,1318,22,1319,24,1320,26,1321,28,1323,31,1325,33,1326,35,1327,39,1331,41,1332,43,1333,45,1334,47,1335,50,1337,56,1339);
}
