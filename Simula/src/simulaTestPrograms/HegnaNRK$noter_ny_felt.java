package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$noter_ny_felt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$noter_ny_felt(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$noter_ny_felt STM$() {
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).antall_felt_def$1<(((HegnaNRK)(CUR$.SL$)).max_felt_def$1)))) {
            {
                ((HegnaNRK)(CUR$.SL$)).antall_felt_def$1=(((HegnaNRK)(CUR$.SL$)).antall_felt_def$1+(1));
                ((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK)(CUR$.SL$)).antall_felt_def$1-((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.LB[0]]=((HegnaNRK)(CUR$.SL$)).feltnavn$1;
                ((HegnaNRK)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK)(CUR$.SL$)).antall_felt_def$1-((HegnaNRK)(CUR$.SL$)).felttype_tabell.LB[0]]=((HegnaNRK)(CUR$.SL$)).felttype$1;
            }
        } else
        new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),7);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure noter_ny_felt",1,495,14,498,16,500,19,501,21,502,25,504,29,505);
}
