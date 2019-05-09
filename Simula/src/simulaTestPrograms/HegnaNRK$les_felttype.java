package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_felttype extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    char type=0;
    int typenr=0;
    public HegnaNRK$les_felttype(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_felttype STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Type:"));
        type=new HegnaNRK$les_type(((HegnaNRK)(CUR$.SL$))).RESULT$;
        typenr=new HegnaNRK$finn_type(((HegnaNRK)(CUR$.SL$)),type).RESULT$;
        while((typenr==(0))) {
            {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),3);
                type=new HegnaNRK$les_type(((HegnaNRK)(CUR$.SL$))).RESULT$;
                typenr=new HegnaNRK$finn_type(((HegnaNRK)(CUR$.SL$)),type).RESULT$;
            }
        }
        RESULT$=typenr;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_felttype",1,507,10,509,19,510,21,511,23,512,25,513,27,515,30,516,32,517,36,519,40,520);
}
