package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$rapporter extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean mer=false;
    int funn=0;
    public HegnaNRK$rapporter(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$rapporter STM$() {
        ((HegnaNRK)(CUR$.SL$)).formatnavn$1=new HegnaNRK$les_formatnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
        new HegnaNRK$les_finne_regel(((HegnaNRK)(CUR$.SL$)));
        sysout().outimage();
        mer=true;
        funn=0;
        while(mer) {
            {
                funn=new HegnaNRK$finn_post(((HegnaNRK)(CUR$.SL$)),funn).RESULT$;
                if(VALUE$((funn!=(0)))) {
                    {
                        new HegnaNRK$hent_post(((HegnaNRK)(CUR$.SL$)),funn);
                        new HegnaNRK$trykk_rapport(((HegnaNRK)(CUR$.SL$)),((HegnaNRK)(CUR$.SL$)).formatnr$1);
                    }
                }
                mer=(funn!=(0));
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure rapporter",1,1072,8,1074,17,1075,19,1076,21,1077,23,1078,26,1079,28,1081,31,1082,33,1084,36,1085,40,1087,46,1089);
}
