package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_felttype extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    char type=0;
    int typenr=0;
    public HegnaNRK$PBLK21$les_felttype(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_felttype STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Type:"));
        type=new HegnaNRK$PBLK21$les_type(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        typenr=new HegnaNRK$PBLK21$finn_type(((HegnaNRK$PBLK21)(CUR$.SL$)),type).RESULT$;
        while((typenr==(0))) {
            {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),3);
                type=new HegnaNRK$PBLK21$les_type(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
                typenr=new HegnaNRK$PBLK21$finn_type(((HegnaNRK$PBLK21)(CUR$.SL$)),type).RESULT$;
            }
        }
        RESULT$=typenr;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_felttype",1,507,10,509,19,510,21,511,23,512,25,513,27,515,30,516,32,517,36,519,40,520);
}
