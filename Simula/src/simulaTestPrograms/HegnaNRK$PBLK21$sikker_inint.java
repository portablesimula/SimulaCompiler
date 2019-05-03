package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sikker_inint extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ temp=null;
    char c=0;
    boolean ok=false;
    boolean tegn=false;
    int i=0;
    public HegnaNRK$PBLK21$sikker_inint(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$sikker_inint STM$() {
        ok=false;
        while((!(ok))) {
            {
                temp=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde$1);
                i=0;
                c=sysin().inchar();
                while((c==(((char)32)))) {
                    c=sysin().inchar();
                }
                tegn=true;
                while(((c==('+'))|((c==('-'))))) {
                    {
                        if(VALUE$((c==('-')))) {
                            tegn=(!(tegn));
                        }
                        c=sysin().inchar();
                    }
                }
                if(VALUE$((!(tegn)))) {
                    {
                        TXT$.putchar(temp,'-');
                        i=(i+(1));
                    }
                }
                while(new HegnaNRK$PBLK21$number(((HegnaNRK$PBLK21)(CUR$.SL$)),c).RESULT$) {
                    {
                        if(VALUE$((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde$1)))) {
                            TXT$.putchar(temp,c);
                        }
                        i=(i+(1));
                        c=sysin().inchar();
                    }
                }
                ok=((c==(((char)32)))&((((i<(6))&(tegn))|(((i<(7))&((!(tegn))))))));
                if(VALUE$((!(ok)))) {
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),20);
                }
            }
        }
        RESULT$=TXT$.getint(temp);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sikker_inint",1,1004,10,1006,22,1007,24,1008,26,1010,29,1011,31,1012,33,1013,37,1014,39,1015,41,1017,46,1018,50,1020,52,1022,55,1023,59,1025,61,1027,66,1028,68,1029,72,1031,74,1032,80,1034,84,1035);
}
