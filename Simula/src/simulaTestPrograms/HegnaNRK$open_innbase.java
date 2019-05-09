package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$open_innbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ filnavn=null;
    boolean oppe=false;
    public HegnaNRK$open_innbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$open_innbase STM$() {
        ((HegnaNRK)(CUR$.SL$)).fil_image$1=blanks(((HegnaNRK)(CUR$.SL$)).fil_image_lengde$1);
        ASGTXT$(TXT$.sub(((HegnaNRK)(CUR$.SL$)).fil_image$1,1,5),((HegnaNRK)(CUR$.SL$)).default_file_type$1);
        oppe=false;
        while((!(oppe))) {
            {
                filnavn=new HegnaNRK$les_filnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                ((HegnaNRK)(CUR$.SL$)).innbase$1=new InFile$(((BASICIO$)CTX$),filnavn).STM$();
                oppe=((HegnaNRK)(CUR$.SL$)).innbase$1.open(((HegnaNRK)(CUR$.SL$)).fil_image$1);
                if(VALUE$((!(oppe)))) {
                    new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),11);
                }
            }
        }
        ASGTXT$(TXT$.sub(((HegnaNRK)(CUR$.SL$)).fil_image$1,1,5),blanks(5));
        RESULT$=filnavn;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure open_innbase",1,1145,10,1147,12,1148,20,1149,22,1150,24,1151,26,1152,28,1154,31,1155,33,1156,35,1157,41,1159,43,1160,47,1161);
}
