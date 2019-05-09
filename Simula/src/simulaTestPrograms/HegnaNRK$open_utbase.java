package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$open_utbase extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    TXT$ filnavn=null;
    boolean oppe=false;
    public HegnaNRK$open_utbase(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$open_utbase STM$() {
        ((HegnaNRK)(CUR$.SL$)).fil_image$1=blanks(((HegnaNRK)(CUR$.SL$)).fil_image_lengde$1);
        ASGTXT$(TXT$.sub(((HegnaNRK)(CUR$.SL$)).fil_image$1,1,5),((HegnaNRK)(CUR$.SL$)).default_file_type$1);
        oppe=false;
        while((!(oppe))) {
            {
                filnavn=new HegnaNRK$les_filnavn(((HegnaNRK)(CUR$.SL$))).RESULT$;
                ((HegnaNRK)(CUR$.SL$)).utbase$1=new OutFile$(((BASICIO$)CTX$),filnavn).STM$();
                oppe=((HegnaNRK)(CUR$.SL$)).utbase$1.open(((HegnaNRK)(CUR$.SL$)).fil_image$1);
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
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure open_utbase",1,1163,10,1165,12,1166,20,1167,22,1168,24,1169,26,1170,28,1172,31,1173,33,1174,35,1175,41,1177,43,1178,47,1179);
}
