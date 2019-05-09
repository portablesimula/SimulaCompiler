package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finn_format extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$form;
    int i=0;
    int nr=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$finn_format setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$form=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$finn_format(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$finn_format(RTObject$ SL$,TXT$ sp$form) {
        super(SL$);
        this.p$form = sp$form;
        BBLK();
        STM$();
    }
    public HegnaNRK$finn_format STM$() {
        i=nr=0;
        while(((nr==(0))&((i<(((HegnaNRK)(CUR$.SL$)).antall_format_def$1))))) {
            {
                i=(i+(1));
                if(VALUE$(TXTREL$EQ(p$form,((HegnaNRK)(CUR$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).formatnavn_tabell.LB[0]]))) {
                    nr=i;
                }
            }
        }
        RESULT$=nr;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_format",1,967,11,969,34,970,36,971,38,973,41,974,43,975,48,977,52,978);
}
