package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_felt extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public TXT$ p$felt;
    int i=0;
    int nr=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_felt setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$felt=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$finn_felt(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$finn_felt(RTObject$ SL$,TXT$ sp$felt) {
        super(SL$);
        this.p$felt = sp$felt;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$finn_felt STM$() {
        i=nr=0;
        while(((nr==(0))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def$1))))) {
            {
                i=(i+(1));
                if(VALUE$(TXTREL$EQ(p$felt,((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]]))) {
                    nr=i;
                }
            }
        }
        RESULT$=nr;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_felt",1,368,11,370,34,371,36,372,38,374,41,375,43,376,48,378,52,379);
}
