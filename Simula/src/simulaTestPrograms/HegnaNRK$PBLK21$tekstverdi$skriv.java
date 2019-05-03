package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$skriv extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    int m=0;
    char c=0;
    public HegnaNRK$PBLK21$tekstverdi$skriv(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$tekstverdi$skriv STM$() {
        m=TXT$.pos(sysout().image);
        j=TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1);
        i=0;
        while((i<(j))) {
            {
                i=(i+(1));
                k=i;
                TXT$.setpos(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1,k);
                c=TXT$.getchar(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1);
                while(((c!=(((char)32)))&((k<(j))))) {
                    {
                        k=(k+(1));
                        c=TXT$.getchar(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1);
                    }
                }
                l=(k-(i));
                if(VALUE$((k==(j)))) {
                    l=(l+(1));
                }
                if(VALUE$(((TXT$.pos(sysout().image)+(l))>(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).skjerm_image_lengde$1)))) {
                    {
                        sysout().outimage();
                        TXT$.setpos(sysout().image,m);
                    }
                }
                sysout().outtext(TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$)).tekst$1,i,l));
                if(VALUE$((k<(j)))) {
                    sysout().outchar(((char)32));
                }
                i=k;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv",1,185,8,186,21,187,23,188,25,189,27,190,29,192,32,193,34,194,36,195,38,196,40,198,43,199,47,201,49,202,53,203,55,205,58,206,62,208,64,209,68,210,74,212);
}
