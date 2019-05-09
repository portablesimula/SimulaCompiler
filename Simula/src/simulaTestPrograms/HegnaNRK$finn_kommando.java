package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finn_kommando extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$kommando;
    int i=0;
    int nr=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$finn_kommando setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$kommando=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$finn_kommando(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$finn_kommando(RTObject$ SL$,TXT$ sp$kommando) {
        super(SL$);
        this.p$kommando = sp$kommando;
        BBLK();
        STM$();
    }
    public HegnaNRK$finn_kommando STM$() {
        i=nr=0;
        while(((nr==(0))&((i<(((HegnaNRK)(CUR$.SL$)).max_kommando$1))))) {
            {
                i=(i+(1));
                if(VALUE$(TXTREL$EQ(p$kommando,((HegnaNRK)(CUR$.SL$)).kommando_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).kommando_tabell.LB[0]]))) {
                    nr=i;
                }
            }
        }
        RESULT$=nr;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_kommando",1,356,11,358,34,359,36,360,38,362,41,363,47,365,51,366);
}
