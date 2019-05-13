package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$boxof extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public COMMON$symbolbox RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public char p$hi;
    public char p$lo;
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$boxof setPar(Object param) {
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
    public COMMON$boxof(RTObject$ SL$)
    { super(SL$); }
    public COMMON$boxof(RTObject$ SL$,char sp$hi,char sp$lo) {
        super(SL$);
        this.p$hi = sp$hi;
        this.p$lo = sp$lo;
        BBLK();
        STM$();
    }
    public COMMON$boxof STM$() {
        RESULT$=((ARRAY$<COMMON$symbolbox[]>)((COMMON)(CUR$.SL$)).symtab.Elt[rank(p$hi)-((COMMON)(CUR$.SL$)).symtab.LB[0]].val).Elt[rank(p$lo)-((COMMON)(CUR$.SL$)).symtab.Elt[rank(p$hi)-((COMMON)(CUR$.SL$)).symtab.LB[0]].val.LB[0]];
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure boxof",1,134,34,135,38,135);
}
