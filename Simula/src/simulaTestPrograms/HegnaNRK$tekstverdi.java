package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$tekstverdi extends HegnaNRK$verdi {
    public int prefixLevel() { return(1); }
    public TXT$ tekst$1=null;
    public PRCQNT$ kopi$0() { return(new PRCQNT$(this,HegnaNRK$tekstverdi$kopi.class)); }
    public PRCQNT$ les$0() { return(new PRCQNT$(this,HegnaNRK$tekstverdi$les.class)); }
    public PRCQNT$ test_verdilikhet$0() { return(new PRCQNT$(this,HegnaNRK$tekstverdi$test_verdilikhet.class)); }
    public PRCQNT$ test_verdi_mindre$0() { return(new PRCQNT$(this,HegnaNRK$tekstverdi$test_verdi_mindre.class)); }
    public PRCQNT$ skriv$0() { return(new PRCQNT$(this,HegnaNRK$tekstverdi$skriv.class)); }
    public HegnaNRK$tekstverdi(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("tekstverdi",210);
    }
    public HegnaNRK$tekstverdi STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class tekstverdi",1,106,8,107,20,213,23,213);
}
