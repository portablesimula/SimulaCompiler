package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$les$SubBlock129 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    char c=0;
    TXT$ t=null;
    public HegnaNRK$PBLK21$tekstverdi$les$SubBlock129(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        t=blanks(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).tekst_lengde$1);
        c=new HegnaNRK$PBLK21$tekstverdi$les_tegn(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)),((char)32)).RESULT$;
        i=0;
        while(((c!=(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).eot$1))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).tekst_lengde$1))))) {
            {
                i=(i+(1));
                TXT$.putchar(t,c);
                c=new HegnaNRK$PBLK21$tekstverdi$les_tegn(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)),c).RESULT$;
            }
        }
        while((c!=(((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).eot$1))) {
            c=new HegnaNRK$PBLK21$tekstverdi$les_tegn(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)),c).RESULT$;
        }
        ((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).tekst$1=copy(copy(TXT$.strip(TXT$.sub(t,1,i))));
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).siste_felt_verdi_lest.Elt[((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).feltnr$1-((HegnaNRK$PBLK21)(CUR$.SL$.SL$.SL$)).siste_felt_verdi_lest.LB[0]]=((HegnaNRK$PBLK21$verdi)(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).kopi$0().CPF().RESULT$()));
        EBLK();
        return(null);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock129",1,129,10,130,17,131,19,132,21,133,23,134,25,136,28,137,30,138,34,140,38,141,40,142,44,143);
}
