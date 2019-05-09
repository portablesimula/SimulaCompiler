package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finn_type extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$type;
    int i=0;
    int nr=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$finn_type setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$type=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$finn_type(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$finn_type(RTObject$ SL$,char sp$type) {
        super(SL$);
        this.p$type = sp$type;
        BBLK();
        STM$();
    }
    public HegnaNRK$finn_type STM$() {
        i=nr=0;
        while(((nr==(0))&((i<(((HegnaNRK)(CUR$.SL$)).max_type$1))))) {
            {
                i=(i+(1));
                if(VALUE$((p$type==(((HegnaNRK)(CUR$.SL$)).type_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).type_tabell.LB[0]])))) {
                    nr=i;
                }
            }
        }
        RESULT$=nr;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_type",1,381,11,383,34,384,36,385,38,387,41,388,47,390,51,391);
}
