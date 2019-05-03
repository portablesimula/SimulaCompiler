package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$open_innbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ filnavn=null;
    boolean oppe=false;
    public HegnaNRK$PBLK21$open_innbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$open_innbase STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1=blanks(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image_lengde$1);
        ASGTXT$(TXT$.sub(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1,1,5),((HegnaNRK$PBLK21)(CUR$.SL$)).default_file_type$1);
        oppe=false;
        while((!(oppe))) {
            {
                filnavn=new HegnaNRK$PBLK21$les_filnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                ((HegnaNRK$PBLK21)(CUR$.SL$)).innbase$1=new InFile$(((BASICIO$)CTX$),filnavn).STM$();
                oppe=((HegnaNRK$PBLK21)(CUR$.SL$)).innbase$1.open(((HegnaNRK$PBLK21)(CUR$.SL$)).fil_image$1);
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
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure open_innbase",1,1145,10,1147,12,1148,20,1149,22,1150,24,1151,26,1152,28,1154,31,1155,33,1156,35,1157,41,1159,43,1160,47,1161);
}
