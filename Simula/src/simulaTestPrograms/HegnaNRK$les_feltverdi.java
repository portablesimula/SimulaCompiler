package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$les_feltverdi extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public HegnaNRK$les_feltverdi(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$les_feltverdi STM$() {
        new HegnaNRK$lede_tekst(((HegnaNRK)(CUR$.SL$)),new TXT$("Verdi:"));
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).felttype$1==(1)))) {
            ((HegnaNRK)(CUR$.SL$)).feltverdi$1=new HegnaNRK$heltallverdi(((HegnaNRK)(CUR$.SL$))).STM$();
        }
        if(VALUE$((((HegnaNRK)(CUR$.SL$)).felttype$1==(2)))) {
            ((HegnaNRK)(CUR$.SL$)).feltverdi$1=new HegnaNRK$tekstverdi(((HegnaNRK)(CUR$.SL$))).STM$();
        }
        ((HegnaNRK)(CUR$.SL$)).feltverdi$1.les$0().CPF();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_feltverdi",1,592,14,595,16,596,20,597,24,598,28,599);
}
