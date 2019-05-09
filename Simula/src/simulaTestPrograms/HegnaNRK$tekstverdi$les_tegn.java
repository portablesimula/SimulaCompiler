package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$tekstverdi$les_tegn extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$forrige_tegn;
    char c=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$tekstverdi$les_tegn setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$forrige_tegn=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$tekstverdi$les_tegn(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$tekstverdi$les_tegn(RTObject$ SL$,char sp$forrige_tegn) {
        super(SL$);
        this.p$forrige_tegn = sp$forrige_tegn;
        BBLK();
        STM$();
    }
    public HegnaNRK$tekstverdi$les_tegn STM$() {
        c=p$forrige_tegn;
        if(VALUE$((c==(((char)32))))) {
            while((c==(((char)32)))) {
                c=sysin().inchar();
            }
        } else
        if(VALUE$((!(TXT$.more(sysin().image))))) {
            c=((char)32);
        } else
        c=sysin().inchar();
        RESULT$=c;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_tegn",1,146,11,148,33,149,35,150,37,151,42,153,46,154,48,155,52,156);
}
