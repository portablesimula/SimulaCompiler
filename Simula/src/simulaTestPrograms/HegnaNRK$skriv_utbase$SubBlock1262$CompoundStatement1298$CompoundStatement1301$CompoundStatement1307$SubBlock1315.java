package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int rom=0;
    int tpos=0;
    int rest=0;
    public HegnaNRK$skriv_utbase$SubBlock1262$CompoundStatement1298$CompoundStatement1301$CompoundStatement1307$SubBlock1315(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        tpos=1;
        rest=TXT$.length(((HegnaNRK$tekstverdi)(((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.Elt[((HegnaNRK$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.LB[0]])).tekst$1);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outint(rest,5);
        ((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outchar(((char)32));
        rom=((TXT$.length(((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.image)-(TXT$.pos(((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.image)))+(1));
        while((rest!=(0))) {
            {
                if(VALUE$((rest<=(rom)))) {
                    {
                        ((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outtext(TXT$.sub(((HegnaNRK$tekstverdi)(((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.Elt[((HegnaNRK$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.LB[0]])).tekst$1,tpos,rest));
                        rest=0;
                    }
                } else
                {
                    ((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outtext(TXT$.sub(((HegnaNRK$tekstverdi)(((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.Elt[((HegnaNRK$skriv_utbase$SubBlock1262)(CUR$.SL$)).j-((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1299$11.felt.LB[0]])).tekst$1,tpos,rom));
                    tpos=(tpos+(rom));
                    rest=(rest-(rom));
                    rom=TXT$.length(((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.image);
                }
                ((HegnaNRK$skriv_utbase)(CUR$.SL$.SL$)).inspect$1261$9.outimage();
            }
        }
        EBLK();
        return(null);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1315",1,1315,16,1316,18,1317,20,1318,22,1319,24,1320,26,1321,28,1323,31,1325,33,1326,35,1327,39,1331,41,1332,43,1333,45,1334,47,1335,50,1337,56,1339);
}
