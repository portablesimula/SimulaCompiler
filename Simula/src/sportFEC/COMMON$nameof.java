package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$nameof extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$hi;
    public char p$lo;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$nameof setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$hi=(char)objectValue(param); break;
                case 1: p$lo=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public COMMON$nameof(RTObject$ SL$)
    { super(SL$); }
    public COMMON$nameof(RTObject$ SL$,char sp$hi,char sp$lo) {
        super(SL$);
        this.p$hi = sp$hi;
        this.p$lo = sp$lo;
        BBLK();
        STM$();
    }
    public COMMON$nameof STM$() {
        RESULT$=((ARRAY$<COMMON$symbolbox[]>)((COMMON)(CUR$.SL$)).symtab.Elt[rank(p$hi)-((COMMON)(CUR$.SL$)).symtab.LB[0]].val).Elt[rank(p$lo)-((COMMON)(CUR$.SL$)).symtab.Elt[rank(p$hi)-((COMMON)(CUR$.SL$)).symtab.LB[0]].val.LB[0]].symbol;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nameof",1,131,34,132,38,132);
}
