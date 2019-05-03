package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$les_feltverdi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$PBLK21$les_feltverdi(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$les_feltverdi STM$() {
        new HegnaNRK$PBLK21$lede_tekst(((HegnaNRK$PBLK21)(CUR$.SL$)),new TXT$("Verdi:"));
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).felttype$1==(1)))) {
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi$1=new HegnaNRK$PBLK21$heltallverdi(((HegnaNRK$PBLK21)(CUR$.SL$))).STM$();
        }
        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).felttype$1==(2)))) {
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi$1=new HegnaNRK$PBLK21$tekstverdi(((HegnaNRK$PBLK21)(CUR$.SL$))).STM$();
        }
        ((HegnaNRK$PBLK21)(CUR$.SL$)).feltverdi$1.les$0().CPF();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_feltverdi",1,592,14,595,16,596,20,597,24,598,28,599);
}
