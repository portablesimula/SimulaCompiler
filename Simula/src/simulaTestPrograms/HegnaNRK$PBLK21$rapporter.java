package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$rapporter extends BASICIO$ {
    public int prefixLevel() { return(0); }
    boolean mer=false;
    int funn=0;
    public HegnaNRK$PBLK21$rapporter(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$rapporter STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn$1=new HegnaNRK$PBLK21$les_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        new HegnaNRK$PBLK21$les_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
        sysout().outimage();
        mer=true;
        funn=0;
        while(mer) {
            {
                funn=new HegnaNRK$PBLK21$finn_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn).RESULT$;
                if(VALUE$((funn!=(0)))) {
                    {
                        new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn);
                        new HegnaNRK$PBLK21$trykk_rapport(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr$1);
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
