package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$open_utbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ filnavn=null;
    boolean oppe=false;
    public HegnaNRK$PBLK21$open_utbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$open_utbase STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image_lengde$1);
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1,1,5),((HegnaNRK$PBLK21)(CUR$.SL$)).default_file_type$1);
        oppe=false;
        while((!(oppe))) {
            {
                filnavn=new HegnaNRK$PBLK21$les_filnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).utbase$1=new OutFile$(((BASICIO$)CTX$),filnavn).STM$();
                oppe=((HegnaNRK$PBLK21)(CUR$.SL$)).utbase$1.open(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1);
                if(VALUE$((!(oppe)))) {
                    new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),11);
                }
            }
        }
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1,1,5),blanks(5));
        RESULT$=filnavn;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure open_utbase",1,1163,10,1165,12,1166,20,1167,22,1168,24,1169,26,1170,28,1172,31,1173,33,1174,35,1175,41,1177,43,1178,47,1179);
}
