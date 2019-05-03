package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$test_verdilikhet$SubBlock162 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int k=0;
    boolean funnet=false;
    public HegnaNRK$PBLK21$tekstverdi$test_verdilikhet$SubBlock162(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
    }
    public RTObject$ STM$() {
        k=TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).tekst$1);
        j=((TXT$.length(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).p$v)).tekst$1)-(k))+(1));
        if(VALUE$((j<(0)))) {
            ((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).RESULT$=false;
        } else
        {
            i=0;
            funnet=false;
            while(((!(funnet))&((i<(j))))) {
                {
                    i=(i+(1));
                    funnet=TXTREL$EQ(((HegnaNRK$PBLK21$tekstverdi)(CUR$.SL$.SL$)).tekst$1,TXT$.sub(((HegnaNRK$PBLK21$tekstverdi)(((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).p$v)).tekst$1,i,k));
                }
            }
            ((HegnaNRK$PBLK21$tekstverdi$test_verdilikhet)(CUR$.SL$)).RESULT$=funnet;
        }
        EBLK();
        return(null);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock162",1,162,11,163,18,164,20,165,22,166,26,169,30,170,32,172,35,173,39,175,44,177);
}
